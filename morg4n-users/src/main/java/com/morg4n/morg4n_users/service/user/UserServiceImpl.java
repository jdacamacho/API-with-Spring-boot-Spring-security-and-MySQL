package com.morg4n.morg4n_users.service.user;

import com.morg4n.morg4n_users.model.User;
import com.morg4n.morg4n_users.model.UserLight;
import com.morg4n.morg4n_users.persistence.entities.UserEntity;
import com.morg4n.morg4n_users.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {
    private final UserRepository repository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserLight> findAll() {
        Iterable<UserEntity> data = repository.findAll();
        return mapper.map(data, new TypeToken<List<UserLight>>(){}.getType());
    }

    @Override
    public User findById(long id) throws Exception {
        UserEntity data = repository.findById(id)
                .orElseThrow(() -> {
                    log.error(String.format("Entity with ID %s does not exist.", id));
                    return new Exception(String.format("Entity with ID %s does not exist.", id));
                });
        return mapper.map(data, User.class);
    }

    @Override
    public User save(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        UserEntity data = mapper.map(user, UserEntity.class);
        return mapper.map(repository.save(data), User.class);
    }

    @Override
    public User update(long id, UserLight user) throws Exception {
         UserEntity data = repository.findById(id)
                .orElseThrow(() -> {
                    log.error(String.format("Entity with ID %s does not exist.", id));
                    return new Exception(String.format("Entity with ID %s does not exist.", id));
                });
        data.setName(user.getName());
        return mapper.map(repository.save(data), User.class);
    }

    @Override
    public boolean delete(long id) throws Exception {
        UserEntity data = repository.findById(id)
                .orElseThrow(() -> {
                    log.error(String.format("Entity with ID %s does not exist.", id));
                    return new Exception(String.format("Entity with ID %s does not exist.", id));
                });
        repository.delete(data);
        return true;
    }

    @Override
    public User changePassword(long id, String currentPassword, String newPassword) throws  Exception{
        UserEntity data = repository.findById(id)
                .orElseThrow(() -> {
                    log.error(String.format("Entity with ID %s does not exist.", id));
                    return new Exception(String.format("Entity with ID %s does not exist.", id));
                });

        if (!passwordEncoder.matches(currentPassword, data.getPassword())) {
            log.error("password incorrect.");
            throw new Exception("password incorrect.");
        }

        data.setPassword(passwordEncoder.encode(newPassword));
        return mapper.map(repository.save(data), User.class);
    }
}
