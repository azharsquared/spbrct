## [JSON Web Token (JWT)](https://jwt.io/)

for authentication and authorization
contains three different parts, separated by dots: xxxxx.yyyyy.zzzzz.
- The first part (xxxxx) is the header, which defines the type of token and the hashing
algorithm.
- The second part (yyyyy) is the payload, which, typically, in the case of authentication,
contains user information
- The third part (zzzzz) is the signature, which is used to verify that the token hasn’t been
  changed along the way.

Example of jwt library  [jjwt] (https://github.com/jwtk/jjwt)
