package com.morg4n.morg4n_users.controller;

import com.morg4n.morg4n_users.service.auth.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Auth management API")
public class AuthController {
    private final IAuthService service;

    @Operation(summary = "Login", description = "Get token to authenticate")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) throws Exception {
        String token = service.login(username, password);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
