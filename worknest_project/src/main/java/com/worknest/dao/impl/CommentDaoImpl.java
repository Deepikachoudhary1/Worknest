
package com.worknest.dao.impl;

import com.worknest.dao.CommentDao;
import com.worknest.model.Comment;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() { return sessionFactory.getCurrentSession(); }

    @Override
    public void save(Comment comment) { currentSession().saveOrUpdate(comment); }

    @Override
    public List<Comment> findByTaskId(Long taskId) {
        return currentSession().createQuery("from Comment c where c.task.id = :tid order by c.createdAt desc", Comment.class)
                .setParameter("tid", taskId)
                .list();
    }
}
