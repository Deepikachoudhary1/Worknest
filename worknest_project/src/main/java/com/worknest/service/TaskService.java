
package com.worknest.service;

import com.worknest.model.Task;
import com.worknest.model.TaskStatus;
import java.util.List;

public interface TaskService {
    void save(Task task);
    Task findById(Long id);
    List<Task> findAll();
    List<Task> forUser(Long userId);
    long countByStatus(TaskStatus status);
}
