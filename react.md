React uses the virtual document object model (VDOM) for selective re-rendering of the UI, which
makes it more cost-effective. 
The document object model (DOM) is a programming interface
for web documents that represents the web page as a structured tree of objects. 

The VDOM is a lightweight copy of the DOM

React compares it to a snapshot that was taken of the VDOM
before updates were run. After the comparison, React will know which parts have been changed,
and only these parts will be updated to the real DOM. This is called selective re-rendering.

a React fragment is a way to group elements together without adding an extra node to the DOM.

React.StrictMode is a tool that highlights potential problems in an application. It does not render any visible UI. It activates additional checks and warnings for its descendants.

root API is used to render React components inside a browser DOM node.

// eg: ReactDOM.createRoot(document.getElementById('root')).render(<App />);

named and default exports/imports in React

JSX

React hooks
    - useState
        - ```// Correct -> Function is called when button is pressed
                <button onClick={() => setCount(count + 1)}>
                // Wrong -> Function is called in render -> Infinite loop
                <button onClick={setCount(count + 1)}>```
        - State updates are asynchronous, so you have to be careful when a new state value depends on the
            current state value. To be sure that the latest value is used, you can pass a function to the update
            function. You can see an example of this here:
            setCount(prevCount => prevCount + 1)
        - Batched updates
            - React batches state updates to improve performance. This means that if you call the
                update function multiple times in the same event, React will batch the updates together and
                only render the component once. This is important to know because it can affect the value of
                state when you depend on the current state value.
        - Batching
            - by default
            - _flushSync_ api to avoid batching
    - useEffect
        - ```javascript
            useEffect(() => {
                // code to run on component mount
                return () => {
                    // code to run on component unmount
                };
            }, [dependencies]);
            ```
    - useContext
    - useReducer
        - use when we have complex state logic
    - useMemo
    - useCallback
    - useRef


