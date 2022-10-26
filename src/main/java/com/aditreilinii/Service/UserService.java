package com.aditreilinii.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("User with id %s does not exist", id)));

        validateEmail(user.getEmail());

        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());

        userRepository.save(userToUpdate);
    }

    public void validateEmail(String email) {

        User userOptional = userRepository.findByEmail(email);
         if(userOptional != null){
             throw new IllegalArgumentException(String.format("Email address %s already exists", email));
         }

    }

    public void deleteUser(Long id){
        boolean userExists = userRepository.existsById(id);
        if(!userExists){
            throw new IllegalStateException(String.format("User with id %s does not exist", id));
        }
        userRepository.deleteById(id);
    }


}
