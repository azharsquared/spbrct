Auth (Open Authorization) is a standard for secure access to protected resources on the internet.

- resource owner refers typically to an end user 
- authorization server is part of the OAuth provider’s service.
- client is an application that wants to get access to protected resources.
- resource server commonly refers to an API that the client wants to use

The simplified version of the OAuth2 authentication process with a REST API contains the following steps:
1. Authentication: The third-party application authenticates by requesting access to protected resources.
2. Authorization: The resource owner authorizes access to their resources, commonly through
   user login.
3. The authorization server authorizes the resource owner and redirects the user back to the
   client with an authorization code.
4. The client requests an access token from the authorization server using the authorization code. The access token format is not specified in the standard, and JWTs are quite
   commonly used.
5. The authorization server validates the access token. If the token is valid, the client application receives an access token.
6. The client can start to use the access token to access protected resources, for example,
   calling REST API endpoints


- [Auth0](https://auth0.com/docs/quickstart/webapp/java-spring-boot/interactive)
- [Keycloak](https://www.baeldung.com/spring-boot-keycloak)
- [github](https://spring.io/guides/tutorials/spring-boot-oauth2)
