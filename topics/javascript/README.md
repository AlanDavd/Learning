# JavaScript Guide & Examples

## Index

- [Graph Example](./examples/Graph.js)
- [Queue Example](./examples/Queue.js)
- [Stack Example](./examples/Stack.js)
- [Primitive Values](###primitive-values)
- [Falsy & Truthy](###falsy-and-truthy)
- [Objects & Functions](###objects-and-functions)
- [Variables](###variables)
- [Expression & Statements](###expression-and-statements)
- [Loops in JavaScript](###loops-in-javaScript)
- [Immediately-Invoked Function Expression (IIFE)](<###immediately-invoked-function-expression-(iife)>)
- [Class & Prototype](###class-and-prototype)
- [Array Destructuring](###array-destructuring)

### Primitive Values

Primitiva values are immutable, that means there is nothing you can do to change them.

- Undefined (undefined): used for unintentionally missing values.
- Null (null): used for intentionally missing values.
- Booleans (true and false): used for logical operations.
- Numbers (-100, 3.14, and others): used for math calculations.
- Strings ("hello", "abracadabra": and others), used for text.

```javascript
typeof undefined;
// "undefined"

typeof null;
// "object"
// null is a primitive value even though it pretends to be an object, remember, this is JavaScript and primitive values are immutable.

typeof true;
// "boolean"

typeof 4.5;
// "number"

typeof "as";
// "string"
```

### Falsy and Truthy

Let's talk about a bigger concept of booleans called Falsy and Truthy.
This just means which values, if converted to booleans, are going to become Falsy and Truthy.

#### Falsy

- "", empty string
- 0, -0
- null
- NaN
- false
- undefined

#### Truthy

- "something"
- 242
- { wizard: 'Potter' }
- [5, 8, 3]
- true
- function() {}
- ...

```javascript
// Both do the same
// Here is implicit
while (wizardz.length) {
  ...
}

// Here is explicit
while (wizardz.length > 0) {
  ...
}
```

### Objects and functions

Objects and functions are also values, but not primitive.
Arrays, dates, and regular expressions are objects in JavaScript.

- Objects: One value for every object literal we execute.
- Function: One value for every function definition we execute.

```javascript
typeof function () {};
// "function"

typeof ((x) => x + 2);
// "function"

typeof [];
// "object"

typeof {};
// "object"

typeof /\azA-E96/;
// "object"
```

### Variables

Keep in mind that variable is not a value, is just a wire or brigde to the value itself.

```javascript
var whiteBeardWizard = "Dumbledore";
console.log(whiteBeardWizard);
// Dumbledore

let wizard = "Harry Potter";
console.log(wizard);
// Harry Potter

const theDarkLord = `Tom Riddle`;
console.log(theDarkLord);
// Tom Riddle
```

### Expression and Statements

An expression is just a piece of code that expresses a value.

- Expressions always result in a single value.

```javascript
console.log(2 + 2);
// 4

2 + 2; // This is an expression
console.log(2 + 2); // This is a statement

// Assigment statement
let deathlyHallows = [
  "Elder Wand",
  "The Resurrection Stone",
  "The Cloak of Invisibility",
];

console.log(deathlyHallows[0]); // Statement
deathlyHallows[0]; // Expression
// Elder Wand
```

### Loops in JavaScript

```javascript
for (let i = 0; i < elements.length; i++) {
  doSomething(elements[i]);
}

for (let element in elements) {
  doSomething(element);
}
```

### Immediately-Invoked Function Expression (IIFE)

```javascript
let name = "Alan"(function sayName() {
  let name = "David";
  console.log("Inside IFEE", name);
})();

console.log("Outside IFEE", name);
```

### Class and Prototype

- Prototype chain: The feature that enables emulation of OPP but its a compelling tool in itself.

It is possible to create an object with it's properties and create an empty object and then add properties to it.

```javascript
const player1 = {
  position: "Goalkeeper",
  name: "Alisson",
};

const player2 = {};

player2.position = "Goalkeeper";
player2.name = "Keylor";
```

Now we can access to the object's properties with the dot notation

```javascript
// objectName.property

console.log(player1.name);
// Alisson

console.log(player1.position);
// Goalkeeper

console.log(player2.name);
// Keylor

console.log(player2.position);
// Goalkeeper
```

Now we are going to see how to create an object as a 'class' and what JavaScript does under the hood when we use the keywork class.

Take a look to the next code.

```javascript
// Function object
function Book(name) {
  this.name = name;
}

Book.prototype.list = function () {
  return this.name;
};

const myBook = new Book("Harry Potter");
console.log(myBook.name);
// Harry Potter
console.log(myBook.list());
// Harry Potter
```

```javascript
// Class
class Book {
  constructor(name) {
    this.name = name;
  }

  list() {
    return this.name;
  }
}

const myBook = new Book("Harry Potter");
console.log(myBook.name);
// Harry Potter
console.log(myBook.list());
// Harry Potter
```

As you can see the code above does the same, in the function Book we are declaring a function and assigning parameters to it, then we use the object prototype to create a new method for that function, in the end we create a new object using the keyword 'new'.

In the class Book we create an object with the keyword class, now we have a constructor and we can make methods inside the class.
This way looks better what JavaScript is doing under the hood

There's a problem when creating objects using function, each time we create a new object we make space in the memory of our computer for all the data, but the function are just copies.

Something to keep in mind when usign the keyword new is that we automate two things using it:

- Create a new object
- Return the new object

### Array Destructuring

Decomposing a structure (array) into individual parts.
Destructuring is about assignment
The spread operator works

```javascript
function someData() {
  return [1, 2, 3, 4];
}

const data = someData();
const first = data[0]; // 1
const second = data[1]; // 2
const third = data[2]; // 3
const fourth = data[3]; // 4
```

```javascript
function someData() {
  return [1, 2, 3, 4, 5];
}

const [first, second, third, fourth, ...fifth] = someData();

console.log(first); // 1
console.log(second); // 2
console.log(third); // 3
console.log(fourth); // 4
console.log(fifth); // [5], this is the rest
```

You can skip an element with a comma

```javascript
function someData() {
  return [1, 2, 3, 4, 5];
}

const [first, , third, fourth, ...fifth] = someData();

console.log(first); // 1
console.log(third); // 3
console.log(fourth); // 4
console.log(fifth); // [5]
```
