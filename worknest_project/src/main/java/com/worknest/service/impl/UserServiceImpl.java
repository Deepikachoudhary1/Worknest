
package com.worknest.service.impl;

import com.worknest.dao.UserDao;
import com.worknest.model.User;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        // NOTE: Demo only; passwords are stored as plain text for simplicity.
        // Replace with hashing in a real app.
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        User u = userDao.findByUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    @Override
    public List<User> allUsers() { return userDao.findAll(); }

    @Override
    public User findById(Long id) { return userDao.findById(id); }

    @Override
    public void delete(Long id) { userDao.delete(id); }
}
