package org.as2.web;

import org.as2.domain.AccountCredentials;
import org.as2.service.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public LoginController(JwtService jwtService,
                           AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody
                                      AccountCredentials credentials) {
        UsernamePasswordAuthenticationToken creds = new
                UsernamePasswordAuthenticationToken(credentials.username(),
                credentials.password());
        Authentication auth = authenticationManager.authenticate(creds);
        // Generate token
        String jwts = jwtService.getToken(auth.getName());
        // Build response with the generated token
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,
                "Bearer" + jwts).header(HttpHeaders.
                        ACCESS_CONTROL_EXPOSE_HEADERS,
                "Authorization").build();
    }

    @GetMapping("/okta")
    public String home( @AuthenticationPrincipal OidcUser principal) {
//        if (principal != null) {
//            model.addAttribute("profile", principal.getClaims());
//        }
        return "index";
    }
}
