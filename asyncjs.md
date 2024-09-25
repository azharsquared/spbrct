- promise
  - . A promise can be in one of three states:
    • Pending: Initial state
    • Fulfilled (or Resolved): Successful operation
    • Rejected: Failed operation
  - ```javascript
    const myPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
    resolve("Hello");
    }, 500);
    });
    ```
  - ```javascript
    doAsyncCall()
    .then(response => // Get some data from the response)
    .then(data => // Do something with data)
    .catch(error => console.error(error))
    .finally(() => console.log("All done!"));
  ```
- async/await
  - ```javascript
    async function fetchData() {
    try {
    const response = await fetch("https://api.example.com/data");
    const data = await response.json();
    console.log(data);
    } catch (error) {
    console.error(error);
    }
    }
    fetchData();
    ```
  - The async/await method is based on promises. The async keyword is used to define an asynchronous function, and the await keyword is used to pause the execution of the function until the promise is resolved.
  - 