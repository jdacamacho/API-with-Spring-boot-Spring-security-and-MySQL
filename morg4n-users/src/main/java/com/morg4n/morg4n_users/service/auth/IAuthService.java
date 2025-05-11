package com.morg4n.morg4n_users.service.auth;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
public interface IAuthService {
    public String login(String username, String password) throws Exception;
}
