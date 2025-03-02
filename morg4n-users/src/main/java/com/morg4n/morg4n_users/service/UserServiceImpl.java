package com.morg4n.morg4n_users.service;

import com.morg4n.morg4n_users.model.User;
import com.morg4n.morg4n_users.model.UserLight;
import com.morg4n.morg4n_users.persistence.entities.UserEntity;
import com.morg4n.morg4n_users.persistence.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository repository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserLight> findAll() {
        Iterable<UserEntity> data = repository.findAll();
        return mapper.map(data, new TypeToken<List<UserLight>>(){}.getType());
    }

    @Override
    public User findById(long id) throws Exception {
        UserEntity data = repository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Entity with ID %s does not exist.", id)));
        return mapper.map(data, User.class);
    }

    @Override
    public User save(User user) {
        UserEntity data = mapper.map(user, UserEntity.class);
        return mapper.map(repository.save(data), User.class);
    }

    @Override
    public User update(long id, UserLight user) throws Exception {
        final UserEntity data = repository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Entity with ID %s does not exist.", id)));
        data.setName(user.getName());
        return mapper.map(repository.save(data), User.class);
    }

    @Override
    public boolean delete(long id) throws Exception {
        UserEntity data = repository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Entity with ID %s does not exist.", id)));
        repository.delete(data);
        return true;
    }

    @Override
    public User changePassword(long id, String currentPassword, String newPassword) throws  Exception{
        UserEntity data = repository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Entity with ID %s does not exist.", id)));

        if(data.getPassword().equals(currentPassword))
            data.setPassword(newPassword);
        else
            throw  new Exception("password incorrect.");

        return mapper.map(repository.save(data), User.class);
    }
}
