- fetch api is a modern way to make http requests in javascript
- fetch is a promise-based api
- fetch returns a promise that resolves to the response to that request
- modern browsers support fetch api

- ```javascript
    fetch('http://someapi.com',
  {
  method: 'POST', 
  body: JSON.stringify(data),
  headers: {'Content-Type': 'application/json'},
  
  })
    .then(response => {
    if (response.ok)
    // Successful request -> Status 2XX
    else
    // Something went wrong -> Error response
    })
    .then(data => console.log(data))
    .catch(error => console.error(error));
    ```

Axios is a popular library for making http requests in javascript
- axios is promise-based
- axios is easy to use
- json data is automatically parsed
- ```javascript
    axios.post('http://someapi.com', data)
    .then(response => console.log(response))
    .catch(error => console.error(error));
    ```
- axios is not supported in all browsers, so you may need to use a polyfill
- axios is a third-party library, so you need to install it using npm or yarn
- ```javascript
    npm install axios
    ```
- ```javascript
  const response = await axios({
    method: 'POST',
    url: 'https://myapi.com/api/cars',
    headers: { 'Content-Type': 'application/json' },
    data: { brand: 'Ford', model: 'Ranger' },
    });
  ```