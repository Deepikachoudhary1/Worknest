
package com.worknest.service.impl;

import com.worknest.dao.TaskDao;
import com.worknest.model.Task;
import com.worknest.model.TaskStatus;
import com.worknest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public void save(Task task) { taskDao.save(task); }

    @Override
    public Task findById(Long id) { return taskDao.findById(id); }

    @Override
    public List<Task> findAll() { return taskDao.findAll(); }

    @Override
    public List<Task> forUser(Long userId) { return taskDao.findByUserId(userId); }

    @Override
    public long countByStatus(TaskStatus status) { return taskDao.countByStatus(status); }
}
