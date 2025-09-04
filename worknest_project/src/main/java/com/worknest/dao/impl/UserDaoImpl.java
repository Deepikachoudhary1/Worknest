
package com.worknest.dao.impl;

import com.worknest.dao.UserDao;
import com.worknest.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() { return sessionFactory.getCurrentSession(); }

    @Override
    public void save(User user) { currentSession().saveOrUpdate(user); }

    @Override
    public User findById(Long id) { return currentSession().get(User.class, id); }

    @Override
    public User findByUsername(String username) {
        Query<User> q = currentSession().createQuery("from User u where u.username = :u", User.class);
        q.setParameter("u", username);
        return q.uniqueResult();
    }

    @Override
    public List<User> findAll() {
        return currentSession().createQuery("from User", User.class).list();
    }

    @Override
    public void delete(Long id) {
        User u = findById(id);
        if (u != null) currentSession().delete(u);
    }
}
