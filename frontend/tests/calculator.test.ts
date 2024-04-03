import {
    describe, 
    expect, 
    test
} from '@jest/globals';

import * as nock from 'nock'
import Calculator from '../src-human/calculator'

describe('test Calculator', () => {

    test.each([['add', '6'], ['subtract', '2'], ['multiply', '8'], ['divide', '2']])('should request %s', async (operation, expected) => {
        nock('http://localhost:3000')
            .get(`/${operation}?a=4&b=2`)
            .reply(200, expected);

        const calculator = new Calculator()
        const result = await calculator[operation](4, 2)
        expect(result).toBe(expected)
    })

    test.each(['add', 'subtract', 'multiply', 'divide'])('should request and error if special character is passed %s', async (operation) => {
        nock('http://localhost:3000')
            .get(`/${operation}?a=4&b=$`)
            .replyWithError('Invalid input')
        
        const calculator = new Calculator()
        const result = await calculator[operation](4, '$')
        expect(result).toBe('Invalid input')
    })

    test.each(['add', 'subtract', 'multiply', 'divide'])('should request and error if alphanumeric value is passed %s', async (operation) => {
        nock('http://localhost:3000')
            .get(`/${operation}?a=4&b=a`)
            .replyWithError('Invalid input')

        const calculator = new Calculator()
        const result = await calculator[operation](4, 'a')
        expect(result).toBe('Invalid input')
    })
})