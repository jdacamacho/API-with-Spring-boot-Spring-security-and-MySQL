package com.morg4n.morg4n_users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String id;
    private String name;
    private String description;
}
