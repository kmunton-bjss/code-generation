import fetch from 'node-fetch'

class Calculator {
    async request(path: string): Promise<string> {
        try {
            const resp = await fetch(`http://localhost:3000/${path}`)
            const result = await resp.text()
            return result
        } catch(_) {
            return 'Invalid input'
        }
        
    }

    async add(a: number, b: number): Promise<string> {
        return await this.request(`add?a=${a}&b=${b}`)
    }

    async subtract(a: number, b: number): Promise<string> {
        return await this.request(`subtract?a=${a}&b=${b}`)
    }

    async multiply(a: number, b: number): Promise<string> {
        return await this.request(`multiply?a=${a}&b=${b}`)
    }

    async divide(a: number, b: number): Promise<string> {
        return await this.request(`divide?a=${a}&b=${b}`)
    }
}

export default Calculator;