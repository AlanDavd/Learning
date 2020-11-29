# Real World Software Development

Mastering software development involves learning a disparate set of concepts. Understanding common problems and solutions that have been solved by developers keeps you from reinventing the wheel in a new software project and enables you to deliver software faster and more reliably.

## KISS Principle

You can “Keep It Short and Simple” (KISS)

### Code Maintainability and Anti-Patterns

When you write code, you should strive for providing good code maintainability, but what does maintainability mean? It is described by a wish list of properties about the code you write:

- It should be simple to locate code responsible for a particular feature.
- It should be simple to understand what the code does.
- It should be simple to add or remove a new feature.
- It should provide good encapsulation. In other words, implementation details should be hidden from a user of your code so is easier to understand and make changes.

Ultimately your goal is to manage the complexity of the application you are building, however if you keep on copy pasting the same code as new requirements come in, you will end up with anti-patterns, they are common ineffective solutions because:

- Hard to understand code because you have one gigant "God Class".
- Code that is brittle and easily broken by changes because of _code duplication_.

### God Class

By putting all of your code in one file, you end up with one giant class making it harder to understand its purpose because that class is responsible for everything. This problem is referred to as the anti-pattern “God Class.” Essentially you have one class that does everything. You should avoid this.

### Code Duplication

For each query, you are duplicating the logic. Adding a new feature will be a painful change because your code has hardcoded one specific solution and duplicated that behavior in multiple places. Consequently, all the places will all have to change and you will potentially introduce new bugs.

### Conclusion

It is good to keep things simple when possible, but do not abuse the KISS principle. Instead, you need to reflect on the design of your whole application and have an understanding of how to break down the problem into separate sub-problems that are easier to manage individually. The result is that you will have code that is easier to understand, maintain, and adapt to new requirements.

## Single Responsibility Principle

The Single Responsibility Principle (SRP) is a general software development guideline to follow that contributes to writing code that is easier to manage and maintain.

You can think about SRP in two complementary ways:

- A class has responsibility over a single functionality.
- There is only one single reason for a class to change.

The SRP is usually applied to classes and methods. SRP is concerned with one particular behavior, concept, or category. It leads to code that is more robust because there is one specific reason why it should change rather than multiple concerns.

## Cohesion

In software engineering you will often hear about cohesion as an important characteristic of different parts of the code you write. It sounds fancy, but it is a really useful concept to give you an indication about the maintainability of your code. Cohesion is concerned with how related things are. To be more precise, cohesion measures how strongly related responsibilities of a class or method are. In other words, how much do things belong together? It is a way to help you reason about the complexity of your software. What you want to achieve is high cohesion, which means that the code is easier for others to locate, understand, and use.

Generally, the concept of cohesion is applied to classes (class-level cohesion), but it can also be applied to methods (method-level cohesion).

### Class-Level Cohesion

In practice, you will come across at least six common ways to group methods:

- Functional
- Informational
- Utility
- Logical
- Sequential
- Temporal

Keep in mind that if the methods you are grouping are weakly related, you have low cohesion.

#### Functional

The danger with functional cohesion is that it may be tempting to have a profusion of overly simplistic classes grouping only a single method. Going down the road of overly simplistic classes adds unnecessary verbosity and complexity because there are many more classes to think about.

#### Informational

Another reason to group methods is because they work on the same data or domain object. Performs a number of functions, each with its own entry point, with independent code for each function, all performed on same data structure. Different than logical cohesion because functions not intertwined. The downside of this approach is that this kind of cohesion can group multiple concerns together, which introduces additional dependencies for a class that only uses and requires some of the operations.

#### Utility

You may be tempted to group different unrelated methods inside a class. This happens when it is not obvious where the methods belong so you end up with a utility class that is a bit like a jack of all trades. This is generally to be avoided because you end up with low cohesion. The methods are not related, so the class as a whole is harder to reason about. In addition, utility classes exhibit a poor discoverability characteristic. You want your code to be easy to find and easy to understand how it is supposed to be used. Utility classes go against this principle because they contain different methods that are unrelated without a clear categorization.

#### Logical

Say you needed to provide implementations for parsing from CSV, JSON, and XML. You may be tempted to group the methods responsible for parsing the different format inside one class. In fact, the methods are logically categorized to do “parsing.” However, they are different by nature and each of the methods would be unrelated. Grouping them would also break the SRP, which you learned about earlier, because the class is responsible for multiple concerns. Consequently, this approach is not recommended. However, there exist techniques to solve the problem of providing different implementations for parsing while also keeping high cohesion, that's called "Coupling".

#### Sequential

Say you need to read a file, parse it, process it, and save the information. You may group all of the methods in one single class. After all the output of reading the file becomes the input to the parsing, the output of parsing becomes the input to the processing step, and so on. This is called sequential cohesion because you are grouping the methods so that they follow a sequence of input to output. It makes it easy to understand how the operations work together. Unfortunately, in practice this means that the class grouping the methods has multiple reasons to change and is therefore breaking the SRP. In addition, there may be many different ways of processing, summarizing, and saving, so this technique quickly leads to complex classes. A better approach is to break down each responsibility inside individual, cohesive classes.

#### Temporal

A temporally cohesive class is one that performs several operations that are only related in time. A typical example is a class that declares some sort of initialization and clean-up operations (e.g., connecting and closing a database connection) that is called before or after other processing operations. The initialization and the other operations are unrelated, but they have to be called in a specific order in time.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bf8afabe-d865-47b8-a60e-274ce8b1a38f/Screen_Shot_2020-11-11_at_23.59.04.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bf8afabe-d865-47b8-a60e-274ce8b1a38f/Screen_Shot_2020-11-11_at_23.59.04.png)

> Summary of pros and cons for different levels of cohesion.

### Method-Level Cohesion

The same principle of cohesion can be applied to methods. The more different functionalities a method performs, the harder it becomes to understand what that method actually does. In other words, your method has low cohesion if it is handling multiple unrelated concerns. Methods that display low cohesion are also harder to test because they have multiple responsibilities within one method, which makes it difficult to test the responsibilities individually! Typically, if you find yourself with a method that contains a series of if/else blocks that make modifications to many different fields of a class or parameters to the method, then it is a sign you should break down the method in more cohesive parts.

## Coupling

Another important characteristic about the code you write is coupling. Where cohesion is about how related things are in a class, package, or method, coupling is about how dependent you are on other classes. Another way to think about coupling is how much knowledge (i.e., specific implementation) you rely on about certain classes. This is important because the more classes you rely on, the less flexible you become when introducing changes. In fact, the class affected by a change may affect all the classes depending on it.

To understand what coupling is, think about a clock. There is no need to know how a clock works to read the time, so you are not dependent on the clock internals. This means you could change the clock internals without affecting how to read the time. Those two concerns (interface and implementation) are decoupled from one another. Coupling is concerned with how dependent things are. You can decouple different components by using an interface, which is the tool of choice for providing flexibility for changing requirements.

Generally, when writing code you will aim for low coupling. This means that different components in your code are not relying on internal/implementation details. The opposite of low coupling is called high coupling, which is what you definitely want to avoid!

## Testing

Testing is the process of evaluating a system or its component(s) with the intent to find whether it satisfies the specified requirements or not. Testing is executing a system in order to identify any gaps, errors, or missing requirements in contrary to the actual requirements. This tutorial will give you a basic understanding on software testing, its types, methods, levels, and other related terminologies.

### Automated Testing

Testing does not have to be a manual operation, though. In automated testing you have a suite of tests that runs automatically without human intervention. This means the tests can be executed quickly when you are introducing changes in the code and you want to increase confidence that the behavior of your software is correct and has not suddenly become unexpected.

#### Confidence

First, performing tests on the software to validate whether the behavior matches the specification gives you confidence that you have met the requirements of your client. You can present the test specifications and results to your client as a guarantee. In a sense, the tests become the specification from your client.

#### Robustness to changes

Second, if you introduce changes to your code, how do you know that you have not accidentally broken something? If the code is small you may think problems will be obvious. However, what if you are working on a codebase with millions of lines of code? How confident would you feel about making changes to a colleague’s code?. Having a suite of automated tests is very useful to check that you have not introduced new bugs.

#### Program comprehension

Third, automated tests can be useful to help you understand how the different components inside the source code project works. In fact, tests make explicit the dependencies of different components and how they interact together. This can be extremely useful for quickly getting an overview of your software. Say you are assigned to a new project. Where would you start to get an overview of different components? The tests are a great place to start.

### Defining a test method

The first question is where do you write your test? In Java, the standard convention from the Maven and Gradle build tools is to include your code in src/main/java and the test classes inside src/test/java.

- It is a common convention to use the Test suffix at the end of test class names.
- It is recommended to always come up with a descriptive name so it is immediately obvious what the unit test does without looking at the implementation of the test method.
- You can declare private helper methods with a test class, but they won’t be executed by the test runner.

### Assert Statements

They let you provide an expected result and compare it with the result of
some operation.

1. You set up the context for your test.
2. You carry out an action.
3. You specify assertions of the expected output. For example, you check that the date, amount, and description were parsed correctly.

This three-stage pattern for setting up a unit test is often referred to as the Given-When-en formula. It is a good idea to follow the pattern and split up the different parts because it helps to clearly understand what the test is actually doing.

### Code Coverage

After writing tests, how can you tell they are sufficient? Code coverage refers to how much of the source code of your software (i.e., how many
lines or blocks) is tested by a set of tests. It is generally a good idea to aim for high coverage because it reduces the chance of unexpected bugs. There isn’t a specific percentage that is considered sufficient, but we recommend aiming for 70%–90%. In practice, it is hard and less practical to actually reach 100% of code coverage because you may, for example, start testing getter and setter methods, which provides less value. However, code coverage is not necessarily a good metric of how well you are testing your software. In fact, code coverage only tells you what you definitely have not tested. Code coverage does not say anything about the quality of your tests. You may cover parts of your code with a simplistic test case, but not necessarily for edge cases, which usually lead to problematic issues.

## Open/Closed Principle

Open for extension and closed for modification.

It promotes the idea of being able to change the behavior of a method or class without having to modify the code. This reduces the scope for introducing new bugs because it minimizes cascading changes required to parts of code that have already been implemented and tested. In other words, old code still works and is untouched.

To summarize, the Open/Closed Principle is a useful principle to follow because it:

- Reduces fragility of code by not changing existing code
- Promotes reusability of existing code and as a result avoids code duplication
- Promotes decoupling, which leads to better code maintenance

## Exceptions

Do not use exceptions for control flow.

Back in the old days, you would add a lot of if-condition checks that would return a cryptic error code. This approach had several drawbacks. First, it relied on global shared mutable state to look up the most recent error. This made it harder to understand individual parts of your code in isolation. As a result, your code became harder to maintain. Second, this approach was error prone as you needed to distinguish between real values and errors encoded as values. The type system in this case was weak and could be more helpful to the programmer. Finally, the control flow was mixed with the business logic, which contributed to making the code harder to maintain and test in isolation.

Talking specifically about Java. Java exception classes are organized in a well-defined hierarchy. The Error and RuntimeException classes are unchecked exceptions and are subclasses of Throwable. You shouldn’t expect to catch and recover from them. The class Exception typically represents errors that a program should be able to recover from.

- **Do not ignore an exception**: It’s never a good idea to ignore an exception as you won’t be able to diagnose the root of the problem. If there isn’t an obvious handling mechanism, then throw an unchecked exception instead. This way if you really need to handle the checked exception, you’ll be forced to come back and deal with it after seeing the problem at runtime.
- **Do not catch the generic Exception**: Catch a specific exception as much as you can to improve readability and support more specific exception handling. If you catch the generic Exception, it also includes a RuntimeException.
- **Document exceptions:** Document exceptions at your API-level including unchecked exceptions to facilitate troubleshooting. In fact, unchecked exceptions report the root of an issue that should be addressed.

## Building Tools

There are several elements you need to take care of when executing an application. First, once you have written the code for your project, you will need to compile it. To automate all the commands required, you will need to create a script so you don’t have to repeat the commands every time. Introducing a new script means that all your current and future teammates will need to be familiar with your way of thinking to be able to maintain and change the script as requirements evolve. Second, the software development life cycle needs to be taken into consideration. It’s not just about developing and compiling the code. We also need to consider testing and deploying.

The solution to these problems is using a build tool. You can think of a build tool as an assistant that can automate the repetitive tasks in the software development life cycle, including building, testing, and deploying your application. A build tool has many benefits:

- It provides you with a common structure to think about a project so your colleagues feel immediately at home with the project.
- It sets you up with a repeatable and standardized process to build and run an application.
- You spend more time on development, and less time on low-level configurations and setup.
- You are reducing the scope for introducing errors due to bad configurations or missing steps in the build.
- You save time by reusing common build tasks instead of reimplementing them.

## The Liskov Substitution Principle

It helps us understand how to subclass and implement interfaces correctly. So informally you can think of it as meaning that child classes should maintain the behavior they inherit from their parents.

```bash
Let q(x) be a property provable about objects x of type T.
Then q(y) should be true for objects y of type S where S is
a subtype of T.
```

LSP into four distinct parts:

#### Preconditions cannot be strengthened in a subtype

A precondition establishes the conditions under which some code will work. You can’t just assume what you’ve written will work anyway, anyhow, anywhere. LSP means that you can’t require any more restrictive preconditions than your parent required.

#### Postconditions cannot be weakened in a subtype

This might sound a bit confusing because it reads a lot like the first rule. Postconditions are things that have to be true after some code has run. If the parent has some kind of side effect or returns some value, then the child must do so as well.

#### Invariants of the supertype must be preserved in a subtype

An invariant is something that never changes, like the ebb and flow of the tides. In the context of inheritance, we want to make sure that any invariants that are expected to be maintained by the parent class should also be maintained by the children.

#### The History Rule

This is the hardest aspect of LSP to understand. In essence, the child class shouldn’t allow state changes that your parent disallowed. In other words, once it has been instantiated you can’t remove, add, or alter any of the attributes. If the child were mutable, it could violate callers’ expectations about what calling those methods does.

### Extending and Reusing Code

Over time you may want to add features to your product, customer requirements may change, and regulations could force you alter your software. We want to be able to reuse this code across the three importers. In order to reuse the code we need to actually have it live in some class. You have essentially three options to consider, each with pros and cons:

- Use a utility class
- Use inheritance
- Use a domain class

The simplest option to start with is to create a utility class. Then every time you wanted to have a method that needs to be shared between different importers it could go in this utility class. Your utility class would end up being a bag of static methods. Utility classes often end up turning into bundles of procedural code with no single responsibility or concept. Over time, this can often lead to the appearance of a God Class in our codebase; in other words, a single large class that ends up hogging a lot of responsibility.

So what should you do if you want to associate this behavior to a concept? Well, the next most obvious approach might be to use inheritance. You could then place all the common functionality on that class and reuse it in subclasses. You’ve already seen the Liskov Substitution Principle and how it puts constraints on the correctness of our inheritance relationship. In practice, inheritance is often a poor choice when the inheritance fails to model some real-world relationship.

The issue with inheritance relationships that don’t correspond to real world relationships is that they tend to be brittle. As your application evolves over time you want abstractions that evolve with the application rather than against it. As a rule of thumb, it’s a bad idea to introduce an inheritance relationship purely to enable code reuse.

Our final choice is to model the text file using a domain class. To use the domain class approach we would model some underlying concept and build out our different importers by invoking methods on top of the underlying concept.

### Test Hygiene

Writing automated tests has a lot of benefits in terms of software maintainability. It enables us to reduce the scope for regressions and understand which commit caused them. It also enables us to refactor our code with confidence. In order to solve the problem of test maintainability you need to get to grips with test hygiene. Test hygiene means to keep your test code clean and ensure that it is maintained and improved along with your codebase under test. If you don’t maintain and treat your tests, over time they will become a burden on your developer productivity.

#### Test Naming

The key driving principles when it comes to test naming are readability, maintainability, and acting as executable documentation. When you see a report of a test class being run, the names should act as statements that document what functionality works and what does not. This allows a developer to easily map from application behavior to a test that asserts that this behavior is implemented. By reducing the impedance mismatch between behavior and code, we make it easier for other developers to understand what is happening in the future. This is a test that confirms that the document management system imports a file.

There are lots of naming anti-patterns, however. The worst anti-pattern is to name a test something completely nondescript—for example, test1. Another common test naming anti-pattern is just named after a concept or a noun—for example, file or document. Test names should describe the behavior under test, not a concept. Another test naming anti-pattern is to simply name the test after a method that is invoked during testing, rather than the behavior.

You should follow three rules of thumb and use them to drive test naming:

- Use domain terminology: Align the vocabulary used in your test names with that used when describing the problem domain or referred by the application itself.
- Use natural language: Every test name should be something that you can easily read as a sentence. It should always describe some behavior in a readable way.
- Be descriptive: Code will be read many times more often than it is written. Don’t skimp on spending more time thinking of a good name that’s descriptive up front and easier to understand later down the line. If you can’t think of a good name, why not ask a colleague? In golf, you win by putting in the fewest shots. Programming isn’t like that; shortest isn’t necessarily best.

You can follow the convention of prefixing test names with the word “should,” or choose not to; that’s merely a matter of personal preference.

#### Behavior Not Implementation

If you’re writing a test for a class, a component, or even a system, then you should only be testing the public behavior of whatever is being tested. Our tests should only invoke these public API methods and not try to inspect the internal state of the objects or the design. This is one of the key mistakes made by developers that leads to hard-to-maintain tests. Relying on specific implementation details results in brittle tests because if you change the implementation detail in question, the test can start to fail even if the behavior is still working. By laying out our tests in this manner, we give ourselves the choice to refactor our internals to a different design without breaking our tests.

A common anti-pattern in this regard is exposing otherwise private state through a getter or setter in order to make testing easier. You should try to avoid doing this wherever possible as it makes your tests brittle. If you have exposed this state to make testing superficially easier, then you end up making maintaining your application harder in the long run. This is because any change to your codebase that involves changing the way this internal state is represented now also requires altering your tests. This is sometimes a good indication that you need to refactor out a new class that can be more easily and effectively tested.

Normally you would have to look up the attribute name for every attribute and assert that it is equal to an expected value.

#### Testing Error Cases

One of the absolute worst and most common mistakes to make when writing software is only to test the good path of your application, the code path that is executed when nothing goes wrong. In practice lots of things can go wrong! If you don’t test how your application behaves in these situations, you’re not going to end up with software that will work reliably in a production setting.

## Test Driven Development

The TDD philosophy is to start writing some tests that are going to let you guide the implementation of the code. In other words, you write tests first before the actual implementation.

There are several benefits of using TDD:

- Writing a test at a time will help you focus and refine the requirements by correctly implementing one thing at a time.
- It’s a way to ensure a relevant organization for your code. For example, by writing a test first, you need to think hard about the public interfaces for your code.
- You are building a comprehensive test suite as you iterate through the requirements, which increases confidence that you are matching the requirements and also reduces the scope of bugs.
- You don’t write code that you don’t need (over-engineer) because you’re just writing code that passes the tests.

### The TDD Cycle

The TDD approach roughly consists of the following steps in a cycle:

1. Write a test that fails
2. Run all tests
3. Make the implementation work
4. Run all tests

In practice, as part of this process, you must continuously refactor your code or it will end up unmaintainable. At this moment you know you have a suite of tests that you can rely on when you introduce changes.

## Interface Segregation Principle

It makes the case that no class should be forced to depend on methods it does not use because this introduces unnecessary coupling. The ISP focuses on the user of an interface rather than its design. In other words, if an interface ends up very large, it may be that the user of that interface sees some behaviors it doesn’t care for, which causes unnecessary coupling. To provide a solution that meets the Interface Segregation Principle, we are encouraged to separate out concepts in smaller interface that can evolve separately. This idea essentially promotes higher cohesion.

## Fluent APIs

Now let's learn about the Builder pattern and how to develop your own Fluent API to address this problem. A Fluent API is an API that is explicitly tailored for a specific domain so that you can solve a specific problem more intuitively. It also embraces the idea of chaining method calls to specify a more complex operation.

### Modeling the Domain

We’d like to help our users specify a simple combination of “when some condition holds,” “then do something” as a rule. There are three concepts in this domain:

- Condition: A condition applied on certain facts that will evaluate to either true or false.
- Action: A specific set of operations or code to execute.
- Rule: This is a condition and an action together. The action only runs if the condition is true.

### Builder Pattern

Let’s introduce what’s called the Builder pattern to improve the process of creating a Rule object with the appropriate condition and action. The purpose of this pattern is to allow the creation of an object in a simpler manner. The Builder pattern essentially deconstructs the parameters of a constructor and instead provides methods to supply each of the parameters. The benefit of this approach is that it allows you to declare methods with names that are suitable to the domain at hand.

```java
public class RuleBuilder {
	private Condition condition;

	private RuleBuilder(final Condition condition) {
		this.condition = condition;
	}

	public static RuleBuilder when(final Condition condition) {
		return new RuleBuilder(condition);
	}

	public Rule then(final Action action) {
		return new DefaultRule(condition, action);
	}
}

final Rule ruleBuilderExample = RuleBuilder
	.when(condition)
	.then(action);
```

## Server Applications

The most common approach taken by software developers trying to approach a system that has many computers communicating together in the same way is to use the client-server model. In this approach to developing distributed applications we group our computers into two main groups. We have clients who request the use of some kind of service and servers who provide the service in question. The server would process the majority of the business logic and send and receive requests from different clients.

There are, in big-picture terms, two different styles of communication that can be used in this kind of systems:

#### Pull Based

In a pull-based communication style the client makes a request to the server and queries it for information. This style of communication is often called a point-to-point style or a request-response style of communication. This is a particularly common communication style, used by most of the web. When you load a website it will make an HTTP request to some server, pulling the page’s data. Pull-based communication styles are useful when the client controls what content to load. The client polls for updates and the server responds with data.

#### Push Based

Another approach is a push-based communication style. This could be referred to as a reactive or event-driven communication approach. In this model, streams of events are emitted by a publisher and many subscribers listen to them. So instead of each communication being 1 to 1, they are 1 to many. This is a really useful model for systems where different components need to talk in terms of ongoing communication patterns of multiple events. For example, if you’re designing a stock market exchange then different companies want to see updated prices, or ticks, constantly rather than having to make a new request every time they want to see a new tick. Here, the data is pushed to the client by the server.

### Communication

Having established the ways to send and receive events, a common next step in our design would be to pick some kind of technology to send those messages to or from our client to our server. There are lots of choices in this area, and here are a few routes that we could go down:

- WebSockets are a modern, lightweight communications protocol to provide duplex (two-way) communication of events over a TCP stream. They are often used for event-driven communication between a web browser and a web server and is supported by recent browser releases.
- Hosted cloud-based message queues such as Amazon Simple Queue Service are an increasingly popular choice for broadcasting and receiving events. A message queue is a way of performing inter-process communication by sending messages that can either be received by a single process of a group of processes. The benefit of being a hosted service is that your company doesn’t have to expend effort on ensuring that they are reliably hosted.
- There are many good open source message transports or message queues, such as Aeron, ZeroMQ, and AMPQ implementations. Many of these open source projects avoid vendor lock-in, though they may limit your choice of client to something that can interact with a message queue. For example, they wouldn’t be appropriate if your client is a web browser.

### Persistence

There are similar concerns at the other side of the application. How should we store data? We have many choices to pick from:

- Plain-text files that we can index and search ourselves. It’s easy to see what has been logged and avoids a dependency on another application.
- A traditional SQL database. It’s well tested and understood, with strong querying support.
- A NoSQL database. There are a variety of different databases here with differing use cases, query languages, and data storage models.

We don’t really know which to pick at the beginning of our software project and our needs may evolve over time. We really want to decouple our choice of storage back-end from the rest of our application. There’s a similarity between these different issues, both are about wanting to avoid coupling yourself to a specific technology.

### The Hexagonal Architecture

In fact, there’s a name for a more general architectural style here that helps us solve this problem. It’s called the Ports and Adapters or Hexagonal architecture and was originally introduced by Alister Cockburn. The idea is that the core of your application is the business logic that you’re writing, and you want to keep different implementation choices separate from this core logic. Whenever you have a technology-specific concern that you want to decouple from the core of your business logic, you introduce a port. Events from the outside world arrive at and depart from your business logic core through a port. An adapter is the technology-specific implementation code that plugs into the port. For example, we may have a port for publishing and subscribing to UI events and a WebSocket adapter that talks to a web browser.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/99422006-8b7f-4282-924f-af6633d65084/Screen_Shot_2020-11-28_at_14.10.19.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/99422006-8b7f-4282-924f-af6633d65084/Screen_Shot_2020-11-28_at_14.10.19.png)

You might be wondering how you separate what should be a port and what should be part of the core domain. At one extreme you could have hundreds or even thousands of ports in your application and nearly everything could be abstracted out of the core domain. At the other extreme you could have none at all. Where you decide your application should live on this sliding scale is a matter of personal judgment and circumstance: there are no rules.

A good principle to help you decide might be to think of anything that is critical to the business problem that you’re solving as living inside the core of the application and anything that is technology specific or involves communicating with the outside world as living outside the core application.

### Security

The simplest approach to storing passwords is to treat them like any other String, known as storing them plain text. This is bad practice in general as it means anyone who has access to your database has access to the passwords of all your users. A malicious person or organization can, and in many cases has, used plain-text passwords in order to log in to your system and pretend to be the users. Additionally, many people use the same password for multiple different services.

In order to avoid anyone with access to your database just reading the passwords, you can apply a cryptographic hash function to the password. This is a function that takes some arbitrarily sized input string and converts it to some output, called a digest. Cryptographic hash functions are deterministic, so that if you want to hash the same input again you can get the same result. This is essential in order to be able to check the hashed password later. Another key property is that while it should be quick to go from input to digest, the reverse function should take so long or use so much memory that it is impractical for an attacker to reverse the digest.

### Types of Design

You can think about designing software in one of two different ways. One of those approaches, called bottom-up, starts with designing the core of the application, data storage models or relationships between core domain objects, works its way up to building the functionality of the system.
The other approach is a top-down approach to software development. This starts with user requirements or stories and tries to develop the behavior or functionality needed to implement these stories, slowly driving down to the concerns of storage or data modeling. For example, we would start with the API for receiving an event to follow another user and then design whatever storage mechanism is needed for this behavior, slowly working from API to business logic to persistence. The downside of a top-down approach is that sometimes as you build out more requirements and stories your initial design can be unsatisfactory. This means that you need to take a vigilant and iterative approach to software design, where you constantly improve it over time.

## Dependency Inversion and Dependency Injection

The Dependency Inversion Principle states that:

- High-level modules should not depend upon low-level modules. Both should depend upon abstractions.
- Abstractions should not depend upon details. Details should depend upon abstractions.

The principle is called an inversion because in traditional imperative, structured programming it is often the case that high-level modules compose down to produce low-level modules. It’s often a side effect of the top-down design. You split up a big problem into different subproblems, write a module to solve each of those subproblems, and then the main problem (the high-level module) depends on the subproblems (the low-level modules).

The Dependency Injection can be thought of as an example of the Hollywood Agent approach—don’t call us, we’ll call you. With DI instead of creating dependencies explicitly or using factories to create them, you simply take a parameter and whatever instantiates your object has the responsibility for passing in the required dependencies.

## Takeaways

- God Classes and code duplication lead to code that is hard to reason about and maintain.
- The Single Responsibility Principle helps you write code that is easier to manage and maintain.
- Cohesion is concerned with how how strongly related the responsibilities of a class or method are.
- Coupling is concerned with how dependent a class is on other parts of your code.
- High cohesion and low coupling are characteristics of maintainable code.
- A suite of automated tests increases confidence that your software is correct, makes it more robust for changes, and helps program comprehension.
- Given-When-Then is a pattern for setting up a test into three parts to help understand the tests you implement.
- The Open/Closed Principle promotes the idea of being able to change the behavior of a method or class without having to modify the code.
- The Open/Closed Principle reduces fragility of code by not changing existing code, promotes reusability of existing code, and promotes decoupling, which leads to better code maintenance.
- God interfaces with many specific methods introduce complexity and coupling.
- An interface that is too granular with single methods can introduce the opposite of cohesion.
- Returning void as a result of an operation makes it difficult to test its behavior.
- Use checked exceptions sparingly rather than the default as they can cause significant clutter.
- Overly specific exceptions can make software development unproductive.
- Do not ignore an exception or catch the generic Exception as you will lose the benefits of diagnosing the root of the problem.
- A build tool automates the repetitive tasks in the software development life cycle including building, testing, and deploying your application.
- The test-driven development philosophy starts with writing some tests that are going to let you guide the implementation of the code.
- The Builder pattern helps design a user-friendly API for instantiating complex objects.
- The Interface Segregation Principle helps promote high cohesion by reducing dependence on unnecessary methods. This is achieved by breaking up large interfaces into smaller cohesive interfaces so that users only see what they need.
