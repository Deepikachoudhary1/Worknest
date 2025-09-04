
package com.worknest.service;

import com.worknest.model.User;
import java.util.List;

public interface UserService {
    void register(User user);
    User login(String username, String password);
    List<User> allUsers();
    User findById(Long id);
    void delete(Long id);
}
