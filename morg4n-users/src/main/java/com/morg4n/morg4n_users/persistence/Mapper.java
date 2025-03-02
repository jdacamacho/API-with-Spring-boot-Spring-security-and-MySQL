package com.morg4n.morg4n_users.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@Configuration
public class Mapper {
    @Bean
    public ModelMapper createMapper(){
        return new ModelMapper();
    }
}
