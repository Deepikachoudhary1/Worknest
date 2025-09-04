
package com.worknest.dao.impl;

import com.worknest.dao.TaskDao;
import com.worknest.model.Task;
import com.worknest.model.TaskStatus;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() { return sessionFactory.getCurrentSession(); }

    @Override
    public void save(Task task) { currentSession().saveOrUpdate(task); }

    @Override
    public Task findById(Long id) { return currentSession().get(Task.class, id); }

    @Override
    public List<Task> findAll() {
        return currentSession().createQuery("from Task", Task.class).list();
    }

    @Override
    public List<Task> findByUserId(Long userId) {
        Query<Task> q = currentSession().createQuery("from Task t where t.assignedUser.id = :uid", Task.class);
        q.setParameter("uid", userId);
        return q.list();
    }

    @Override
    public long countByStatus(TaskStatus status) {
        Query<Long> q = currentSession().createQuery("select count(t) from Task t where t.status = :s", Long.class);
        q.setParameter("s", status);
        return q.uniqueResult();
    }
}
