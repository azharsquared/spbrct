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

