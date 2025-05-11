package com.morg4n.morg4n_users.service.user;

import com.morg4n.morg4n_users.model.User;
import com.morg4n.morg4n_users.model.UserLight;

import java.util.List;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
public interface IUserService {
    public List<UserLight> findAll();
    public User findById(long id) throws Exception;
    public UserLight save(User user);
    public UserLight update(long id, UserLight user) throws  Exception;
    public boolean delete(long id) throws Exception;
    public User changePassword(long id, String currentPassword, String newPassword) throws  Exception;
}
