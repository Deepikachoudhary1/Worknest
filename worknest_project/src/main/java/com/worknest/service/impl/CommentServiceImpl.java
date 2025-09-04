
package com.worknest.service.impl;

import com.worknest.dao.CommentDao;
import com.worknest.model.Comment;
import com.worknest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void save(Comment comment) { commentDao.save(comment); }

    @Override
    public List<Comment> forTask(Long taskId) { return commentDao.findByTaskId(taskId); }
}
