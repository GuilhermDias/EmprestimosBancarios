package com.guilherme.desafioEmprestimo.service;

import com.guilherme.desafioEmprestimo.domain.user.User;
import com.guilherme.desafioEmprestimo.domain.user.UserDTO;
import com.guilherme.desafioEmprestimo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private LocationService locationService;

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User findUserByDocument(String document) throws Exception {
        return this.userRepository.findByDocument(document).orElseThrow(() -> new Exception("User by document not found"));
    }
}
