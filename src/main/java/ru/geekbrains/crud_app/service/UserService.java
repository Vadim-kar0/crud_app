package ru.geekbrains.crud_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.crud_app.model.User;
import ru.geekbrains.crud_app.repository.UserRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteById(int id){ userRepository.deleteById(id);}

    public void update(User user){ userRepository.update(user);}

    public User getUser(int id){ return userRepository.getUser(id);}
}
