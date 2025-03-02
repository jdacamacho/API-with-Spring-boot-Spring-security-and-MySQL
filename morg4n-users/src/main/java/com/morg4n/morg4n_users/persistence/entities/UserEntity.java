package com.morg4n.morg4n_users.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserEntity extends UserLightEntity{
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<RoleEntity> roles;
}
