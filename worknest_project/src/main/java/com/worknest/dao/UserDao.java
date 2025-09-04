
package com.worknest.dao;

import com.worknest.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    void delete(Long id);
}
