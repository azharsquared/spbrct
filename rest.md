# Representational State Transfer (REST)
is an architectural style for creating web services. REST
is neither language- nor platform-dependent; different clients like mobile apps, browsers, and
other services can communicate with each other. RESTful services can be scaled easily to fulfill
increased demand

> a set of constraints, defined by Roy Fielding


- **Stateless**: The server shouldn’t hold any information about the client state.
- **Client-server** independence: The client and server should act independently. The server
should not send any information without a request from the client.
- **Cacheable**: Many clients often request the same resources; therefore, caching should be
applied to resources in order to improve performance.
- **Uniform interface**: Requests from different clients should look the same. Clients may
include, for example, a browser, a Java application, and a mobile application.
  - **Identification of resources**: Resources should be identified by unique identifiers, for example, URIs in web-based REST services. REST resources should expose easily understood
    directory structure URIs. Therefore, a good resource-naming strategy is very important.
  - **Resource manipulation through representation**: When making a request to a resource,
    the server should respond with a representation of the resource. Typically, the format of
    the representation is JSON or XML
  - **Self-descriptive messages**: Messages should contain enough information that the server
    knows how to process them
  - **Hypermedia as the engine of application state (HATEOAS)**: The server should send
    hyperlinks to the client so that the client can navigate through the application. This
    constraint is optional, but it is a good practice to include it in RESTful services.

- **Layered system**: Components can be added or modified without affecting the entire
service. This constraint affects scalability.
- **Code on demand**: This is an optional constraint. Most of the time, the server sends static
content in the form of JSON or XML. This constraint allows the server to send executable
code if needed

`spring.data.rest.base-path` is used to change the base path of the REST API

> Spring Data REST returns JSON data in the **Hypertext Application Language (HAL)** format.

Documentation can be generated using OpenAPI, RAML etc

