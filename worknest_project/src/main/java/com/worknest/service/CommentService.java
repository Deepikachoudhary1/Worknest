
package com.worknest.service;

import com.worknest.model.Comment;
import java.util.List;

public interface CommentService {
    void save(Comment comment);
    List<Comment> forTask(Long taskId);
}
