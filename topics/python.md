# Python

## Summary

- [What is python?](#What-is-Python?)
- [Virtual environments](#Virtual-environments)
- [Data types](#Data-types)
- [Math operators](#Math-operators)
- [Main method](#Main-method)
- [Variables](#Variables)
- [Functions](#Functions)
- [Conditional Statements](#Conditional-statements)
- [For statement](#For-statement)
- [While statement](#While-statement)
- [Classes](#Classes)
- [Error handling](#Error-handling)
- [Files](#Files)
- [Zip function](#Zip-function)
- [Data type conversion](#Data-type-conversion)
- [Common operations to data](#Common-operations-to-data)
- [Tests](#Tests)

## What is Python?

Python is a interpreted programming language created by Guido Van Rossum.

Python has its own community rules, those rules are in [PEP8](https://www.python.org/dev/peps/pep-0008/).

## Virtual environments

A virtual environment in Python is a self-contained directory that contains a certain installation for a particular version of Python and others libraries.

It´s a very useful way to make sure that we are using the right version of Python and other libraries when working on a particular project.

### For Windows

Create an environment.

```bash
[python version] -m venv [name]

py -3 -m venv [name]

python3 -m venv [name]
```

Activate the environment.

```bash
[name]\scripts\activate
```

### For Mac / Linux

Create an environment.

```bash
[python version] -m venv [name]

python3.7 -m venv [name]
```

Activate the environment.

```bash
source [name]/bin/activate
```

## Data types

- Numbers

Numbers include `int` and `float`.

```python
type(2) # <type 'int'>

type(4.5454) # <type 'float'>

type(2+3j) # <type 'complex'>
```

- Strings

Strings of text.

```python
type("String 1") # <type 'str'>

type('String 2') # <type 'str'>
```

- Booleans / Bool:

Booleans values are `True` and `False`.

```python
type(True) # <type 'bool'>

type(False) # <type 'bool'>
```

- List:

Lists are arrays of data, it can contain any of the values previously mentioned.

```python
type([1,2,3, [9,8,7], "Hi"]) # <type 'list'>

type([5, "Again", False]) # <type 'list'>
```

- Lists comprehensions:
  Syntax sugar to an easy list creation.

```python
even_numbers = []

for num in range(1, 31):
    if num % 2 == 0:
        even_numbers.append(num)


even_numbers = [num for num in range(1, 31) if num % 2 == 0]
```

- Dictionary:

Array of data in which you can access in a key-value way.

```python
type({ "name": "Rick Sanchez", "species": "Human"}) # <type 'dict'>
```

- Dictionary Comprehensions

Dictionary comprehensions are a quick and easy way of assembling dictionaries in Python.

```python
scores = {f"player-{num}":0 for num in range(0, 5)}
print(scores) # {'player-0': 0, 'player-1': 0, 'player-2': 0, 'player-3': 0, 'player-4': 0}
```

- Tuple:

Array of data, is like the list, but with the difference that tuples are inmmutable. Once a tuple is created you cannot modified it.

```python
type((1,2,3, (9,8,7), "Hi")) # <type 'tuple'>

type((5, "Again", False)) # <type 'tuple'>
```

- Sets:
  Sets are a data type similar to lists, sets allow you to store immutable types in an unsorted way.
  An item can only be contained in a set once, there are no duplicates allowed.

Ypu can perform operations like `union`, `difference`, `intersection`.

```python
s = set({1, 2, 3})
t = set({3, 4, 5})

# Operation
s.union(t) # {1, 2, 3, 4, 5}
s.intersection(t) # {3}
s.difference(t) # {1, 2}
s.add(7) # {1, 2, 3, 7}
s.discard(7) # {1, 2, 3}
```

- `s.union(t)`: creates a new set with all the items from both `s` and `t`.
- `s.intersection(t)`: creates a new set containing only items that are both in `s` and in `t`.
- `s.difference(t)`: creates a new set with items in `s` but not in `t`.

## Math operators

#### Addition (+)

Adds values on either side of the operator.

#### Subtraction (-)

Subtracts right hand operand from left hand operand.

#### Multiplication (\*)

Multiplies values on either side of the operator.

#### Division (/)

Divides left hand operand by right hand operand.

#### Floor division (//)

The division of operands where the result is the quotient in which the digits after the decimal point are removed. But if one of the operands is negative, the result is floored, i.e., rounded away from zero (towards negative infinity).

#### Modulus (%)

Divides left hand operand by right hand operand and returns remainder.

#### Exponent (\*\*)

Performs exponential (power) calculation on operators.

#### Equal (==)

If the values of two operands are equal, then the condition becomes true.

#### Different (!=)

If values of two operands are not equal, then condition becomes true.

#### Greater than (>)

If the value of left operand is greater than the value of right operand, then condition becomes true.

#### Less than (<)

If the value of left operand is less than the value of right operand, then condition becomes true.

#### Greater than or equal (>=)

If the value of left operand is greater than or equal to the value of right operand, then condition becomes true.

#### Less than or equal (<=)

If the value of left operand is less than or equal to the value of right operand, then condition becomes true.

```python
a = 10
b = 20

#Basic math operators
a + b # 30
a - b # -10
a * b # 200
b / a # 2

# Floor division
9//2 # 4
9.0//2.0 # 4.0
11//3 # -4
-11.0//3 # -4.0

# Modulus
b % a # 0

#Exponent
a**b # 10 to the power 20

# Comparison operators
a == b # False
a != b # True
a > b # False
a < b # True.
a >= b # False
a <= b # True.
```

## Main method

The purpose for checking for the main method is to make sure that the code inside the main method runs only when it's executed as a stand-alone program.
Because of how Python's imports system works, if someone else imports out Python programs, any code in it is executed on import.

`if __name__ == '__main__':`

This conditional means that our code only will eun if we are the ones running the program directly.

`_name__` is a variable that is set by Python that tells it where it was called from.

```python
def main():
    pass


if __name__ == '__main__':
    main()
```

## Variables

```python
name = "John Wick"

super_power = "Is John Wick"

number1 = 3
```

## Functions

- You define a function in Python with the keyword `def`.
- After the `def` keyword the name of the function comes and between parenthesis you can define the parameters of the function.
- The function declaration ends with `:`.
- Function names cannot start with digits.
- The name of the function must be descriptive.

`def name(parameters):`

```python
# Without parameters
def my_function():
    return "My first function"

my_function() # My first function

# With parameters
def addition(n1, n2):
    return n1+n2

addition(2,2) # 4

# Function as parameter
def double_number(n):
    return n * 2

def merge_func(func, numbers):
    results = []
    for number in numbers:
        result = func(number)
        results.append(result)

numbs = [1, 2, 3, 4]

merge_func(double_number, numbs) # [2, 4, 6, 8]

# Function as expression
lambda <vars>: <expression>
addition = lambda x, y: x + y

addition(4, 6) # 10
```

## Conditional statements

```python
if n1 > n2:
    # something...
elif n1 == n2:
    # something...
else:
    # something...
```

## For statement

```python
for item in iterable_element:
    items_iteration

for i in range(10):
    print(i)
```

## While statement

```python
while (condition):
    # elements
```

```python
x = 0
while (x < 10):
    print(x)
    x += 1
```

## Classes

You’ll find that everything in Python is an object of some kind, and almost everything has attributes and methods.
The Object-oriented Programming paradigm is structured around Classes and Instances.

### `self`

`self` is used inside classes to refer to a bound instance variable or object.
`self` refers to an instance

```python
class Wizard:
		def __init__(self, name):
				self.name = name

		def greet(self):
				return "Yer a wizard, %s!" % self.name

harry = Wizard("Harry")
print(harry.greet()) # Yer a wizard, Harry!
```

## Error handling

If an error happens in your code, it will broke automatically, to be a step ahead of this problem you can handle it.
The best way to do it is with the `try` `except` clause.
This approach allow us to handle any possible error in the code.

```python
try:
    # Code...
except ValueError as e:
    # except <Type of the error>:
    # Handle the error here
finally:
    # This block will always be executed, whether the error happens
```

## Files

- r .- Read, is the default.
- w .- Write.
- a .- Append.
- r+ .- Read and write.

Read the content of a file and print it.

```python
f = open('file.txt')
```

### Files with context managers

What is a context manager in a nutshell?

A context manager is kind of a wrapper around a block of code that depends on some resource.
Context managers can contain code that provides a resource before your code runs, and cleans up afterward.

```python
with open('file.txt', 'r') as f:
    for line in f:
        print(line)
```

You can perform all the functions that require access to the open file within the `with` scope, and once you exit the `with` scope, the context manager will automatically close your file for you, even if your code hits an exception inside the context manager.

## Zip function

The `zip` function takes any number of iterable arguments and steps through all of them at the same time until the end of the shortest iterable has been reached:

```python
names = ["Harry", "Mario", "Green Mario", "Luigi"]
scores = [42, 97, 68, 76]

for name, score in zip(names, scores):
    print(f"{name} had a score of {score}.")

# Harry had a score of 42.
# Mario had a score of 97.
# Green Mario had a score of 68.
# Luigi had a score of 76.
```

## Data type conversion

```python
# To float
float(6) # 6.0

# To integer
int(5.4) # 5

# To string
str(6.5) # "6.5"

# From tuple to list
list((5, 7, 3, 2)) # [5, 7, 3, 2]

# From list to tuple
tuple([5, 7, 3, 2]) # (5, 7, 3, 2)
```

## Common operations to data

- Length of a string, list, tuple, etc.

```python
len("Field") # 5
```

- Know the data type.

```python
type(34) # <class 'int'>
```

- Apply a conversion to an array.

```python
map(str, [1, 2, 3, 4, 5])
# ['1', '2', '3', '4', '5']
```

- Round a float number to n number of decimals.

```python
round(5.4322, 2)
# 5.43
```

- String slicing

```python
my_string = 'Vampire'
# Notation [start:end:steps]

my_string[2:]
# 'mpire'

my_string[:4]
# 'Vamp'

my_string[:-2]
# 'Vampi'

my_string[::2]
# 'Vmie'
```

- Generate a range of numbers in a list.

```python
range(5)
# [0, 1, 2, 3, 4]
```

- Addition of an array.

```python
sum([5, 2, 6, 4, 8])
# 25
```

- Sort an array from the higher number to the lowest.

```python
sorted([4, 7, 2, 8, 1])
# [1, 2, 4, 7, 8]
```

- Know all the possible commands you can apply to data in python.

```python
my_list = [1, 1, 1, 1, 1]
dir(my_list)

# ['__add__', '__class__', '__contains__', '__delattr__', '__delitem__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__getitem__', '__gt__', '__hash__', '__iadd__', '__imul__', '__init__', '__init_subclass__', '__iter__', '__le__', '__len__', '__lt__', '__mul__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__reversed__', '__rmul__', '__setattr__', '__setitem__', '__sizeof__', '__str__', '__subclasshook__', 'append', 'clear', 'copy', 'count', 'extend', 'index', 'insert', 'pop', 'remove', 'reverse', 'sort']

# These are the commands we can apply.
# ['append', 'count', 'extend', 'index', 'insert', 'pop', 'remove', 'reverse', 'sort']
```

## Tests

### Types of tests

There are several different kinds of automated tests that can be performed at different abstraction levels.

- Unit tests operate on the smallest testable unit of code, usually a function that performs a single action or operation.
- Integration tests check to see if different units or modules of code work together as a group.
- Functional tests operate on units of functionality, to make sure a specific function of the software is working, which may involve several units of software or whole systems working together.

### Unit tests

Unit testing is a software testing method by which individual functions are tested in an automated fashion to determine if they are fit for use.

### Assertions

Python comes with a `assert` keyword that we can use for simple checks.
An assertion is simply a boolean expression that checks if its condition return true or not.
If the assertion is true, the program continues. If it’s false, it throws an `AssertionError`, and your program will stop.

```python
value = 40
assert value < 30

Traceback (most recent call last):
  File "<input>", line 1, in <module>
AssertionError

assert value > 30
```

> `assert` is not for production!

### unittest

`unittest` is a built-in tests library and framework for Python.

In order to write `unittest` tests, you must:

- Write your tests as methods within classes.
- Use a series of built-in assertion methods.

```python
import unittest


def add(x, y):
    return x+y


class TestAdd(unittest.TestCase):
    def test_add(self):
        test_x = 30
        test_y = 20
        self.assertEqual(add(test_x, test_y), 50, 'Should be 50')


if __name__ == '__main__':
    unittest.main()

# Ran 1 test in 0.002s
# OK
```
