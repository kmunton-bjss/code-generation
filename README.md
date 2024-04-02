# Code Generation Tools Comparison

This repository contains the code generation tools comparison using a simple spring boot java application. 
See below for the prompts and results of the comparison test.

## Tools
- GitHub Copilot
- Sourcegraph Cody

## Application
Each application was created using the spring boot CLI with the following command:

```shell
spring init --build=maven --java-version=21 --dependencies=web <application-name>
```
Then I used the code generation tools to:
  
- Create a REST controller to return the fibonacci sequence
- Create unit tests for that controller
- Explain the architecture of the application


## Prompts / Approach used for code generation

### Controller

Chat prompt: Create a spring boot controller that has an endpoint that takes in a number as a query parameter and returns the fibonnaci sequence in a list. 
When no number is provided it uses a default number of 5. It should throw a bad request for any negative numbers and zero.

Autocomplete comment: Throw bad request if n is greater than 20

### Unit tests

Chat prompt: Create unit tests for the FibnonacciController with positive, negative and edge cases.

Autocomplete: Started writing tests for missing scenarios i.e. greater than 20, to see what the code generation tool would do.

### Architecture
Chat prompt: Based on the codebase here, can you explain the architecture?

### Code explanation

Used the code explanation tool provided by both Github Copilot and Cody to explain the DemoApplication.java file.

## Results

See FibonacciController.java and FibonacciControllerTest.java for the generated code.

### GitHub Copilot

All good things, couldn't fault it.

#### Controller
+ Chat prompt created the controller class with all imports. When that exact controller was used and run, it works with no errors.
+ When autocomplete prompt was used, the code generated was accurate and worked as expected.

#### Unit tests
+ Chat prompt created 3 unit tests to cover the code written by copilot with latest junit5 and included all imports and package name. When that exact test file was run, there were no errors.
+ As soon as I started writing another test, before writing the method name, it generated code for the scenario that was not covered by existing tests.

#### Architecture

+ Chat was able to give an accurate description of the architecture of the directory.
![gh-copilot-architecture-explanantion.png](gh-copilot/gh-copilot-architecture-explanantion.png)

#### Code explanation

+ The copilot /explain command was able to explain the code in the DemoApplication.java file.
![gh-copilot-code-explain.png](gh-copilot%2Fgh-copilot-code-explain.png)

### Sourcegraph Cody

#### Controller

##### Pros
+ Chat generates the code for the class.
+ When autocomplete prompt was used, the code generated was accurate and worked as expected.

##### Cons
- Chat generated code did not include the imports unless asked.
- Chat generated code had an example package name, not the actual package name.
- Chat generated code needed human intervention to fix up the file before running.

#### Unit tests

##### Pros
+ Created 4 unit tests to cover the code written by Cody.
+ When autocomplete was used, it will generate new unit test based on test method name.

##### Cons
- Chat created a file where imports were incorrect, so tests will not run (using junit4 rather than latest junit5).
- Chat also missed the package name at the top.
- Chat code generation needed human intervention to fix up the file before running.
- Autocomplete cannot figure out missing test scenarios based on existing test scenarios in the file.

#### Architecture

- Was not able to give any explanation of the architecture of the directory and the explanation given was incorrect.
![cody-architecture-explain.png](sourcegraph-cody%2Fcody-architecture-explain.png)

#### Code explanation

- Cody's Explain Code action was able to explain the code in the DemoApplication.java file.
![cody-code-explain.png](sourcegraph-cody%2Fcody-code-explain.png)

## Summary of results

- Both Github Copilot and Cody takes into account existing code and generates code based on that. It also generates code based on the prompt given.
- Github Copilot is able to generate code with imports and package names, Cody had trouble with this.
- Github Copilot can start generating new code/ missing test scenarios without any comment or method name, whereas Cody seems to require a method name or comment to generate code.
- Github Copilot Chat is able to generate an accurate description of the architecture of the directory, Cody was not able to do this.
- Both Github Copilot and Cody were able to explain the code in a particular file.
