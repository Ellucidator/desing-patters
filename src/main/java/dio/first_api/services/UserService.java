package dio.first_api.services;

import dio.first_api.handler.BusinessException;
import dio.first_api.models.User;
import dio.first_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    public void create(User user){
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }

    public void update(Integer id, User user){
        Optional<User> userBd = repository.findById(id);

    }

    public void delete(Integer id){
        Optional<User> userBd = repository.findById(id);
        repository.delete(userBd);
    }

}
