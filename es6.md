
- Constants and variable
- Arrow functions
  - ```javascript
    const add = (a, b) => a + b;
    console.log(add(5, 5)); // 10
    ```
- Template literals
  - ```javascript
    const name = 'John';
    const age = 30;
    const city = 'New York';
    console.log(`Name: ${name}, Age: ${age}, City: ${city}`);
    ``` 
- Object destructuring
  - ```javascript
    const person = {
      name: 'John',
      age: 30,
      city: 'New York'
    };
    const { name, age, city } = person;
    console.log(name, age, city); // John 30 New York
    ``` 
- Array destructuring
  - ```javascript
    const numbers = [1, 2, 3, 4, 5];
    const [a, b, c, d, e] = numbers;
    console.log(a, b, c, d, e); // 1 2 3 4 5
    ```
- Classes and inheritance
  - ```javascript
    class Person {
      constructor(name, age) {
        this.name = name;
        this.age = age;
      }
      greet() {
        return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
      }
    }
    class Employee extends Person {
      constructor(name, age, position) {
        super(name, age);
        this.position = position;
      }
      greet() {
        return `${super.greet()} I work as a ${this.position}.`;
      }
    }
    const john = new Employee('John', 30, 'Developer');
    console.log(john.greet()); // Hello, my name is John and I am 30 years old. I work as a Developer.
    ```
   