package com.aditreilinii.Service;

import java.util.List;

public interface IUserService {
    public List<User> getUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
