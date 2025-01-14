package dio.first_api.controller;

import dio.first_api.models.User;
import dio.first_api.repository.UserRepository;
import dio.first_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;

    @GetMapping()
    public List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserByUsername(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @PostMapping()
    public void createUser(@RequestBody User user){
        service.create(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Integer id, User user){
        service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        service.delete(id);
    }
}
