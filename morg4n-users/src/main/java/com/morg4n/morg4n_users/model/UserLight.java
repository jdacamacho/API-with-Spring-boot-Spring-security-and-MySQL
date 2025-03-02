package com.morg4n.morg4n_users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLight {
    private long id;
    private String name;
}