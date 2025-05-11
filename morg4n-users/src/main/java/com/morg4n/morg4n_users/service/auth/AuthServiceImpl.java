package com.morg4n.morg4n_users.service.auth;

import com.morg4n.morg4n_users.persistence.entities.UserEntity;
import com.morg4n.morg4n_users.persistence.repositories.UserRepository;
import com.morg4n.morg4n_users.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import java.util.Optional;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements  IAuthService{
    private final UserRepository repository;
    private  final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(String username, String password) throws Exception{
        Optional<UserEntity> user = repository.findByUsername(username);
        if(!user.isPresent()){
            log.error(String.format("user with username %s not found.", username));
            throw new Exception(String.format("user with username %s not found.", username));
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if(!authentication.isAuthenticated())
            log.error("Password incorrect.");

        return jwtService.getToken(user.get());
    }
}
