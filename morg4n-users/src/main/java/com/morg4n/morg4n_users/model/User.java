package com.morg4n.morg4n_users.model;

import lombok.*;

import java.util.List;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class User extends UserLight{
    private String username;
    private String password;
    private List<Role> roles;
}
