TypeScript will automatically define the type of a variable when you initialize it. This is called
**type inference.**

```typescript
let name = 'John'; // type of name is string
let age = 30; // type of age is number
let isStudent = false; // type of isStudent is boolean
```

Then, you can declare an object that conforms to the Student interface or type:
```typescript
type Student = {
    id: string | number;
    name: string;
    email?: string;
};
```
```typescript
const myStudent: Student = {
id: 1,
name: "Lisa Smith ",
email: "lisa.s@mail.com ",
};
```

function parameters can also have types:
```typescript
function greet(name: string) {
    return `Hello, ${name}!`;
}
```

```typescript
// Function without parameters 
type HelloProps = {
 name: string;
 age: number;
 fn: () => void;
};
// Function with parameters
type HelloProps = {
 name: string;
 age: number;
 fn: (msg: string) => void;
};
```

```typescript
import React from 'react';
import { HelloProps } from './types';
const HelloComponent: React.FC<HelloProps> = ({ name, age }) => {
 return (
 <>
 Hello {name}, you are {age} years old!
 </>
 );
};
export default HelloComponent;
```

```typescript

const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
 setName(event.target.value);
} 
```


You can read the complete list of event types in the React TypeScript CheatSheet: 
https://react-typescript-cheatsheet.netlify.app/docs/basic/gettingstarted/forms_and_events/.

