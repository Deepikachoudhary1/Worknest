
package com.worknest.controller;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import com.worknest.model.TaskStatus;
import com.worknest.model.User;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private TaskService taskService;
    @Autowired private CommentService commentService;

    @GetMapping("/tasks")
    public String myTasks(HttpSession session, Model model) {
        User u = (User) session.getAttribute("authUser");
        if (u == null) return "redirect:/login";
        List<Task> tasks = taskService.forUser(u.getId());
        model.addAttribute("tasks", tasks);
        return "my-tasks";
    }

    @PostMapping("/tasks/updateStatus")
    public String updateStatus(@RequestParam Long taskId,
                               @RequestParam String status) {
        Task t = taskService.findById(taskId);
        if (t != null) {
            try { t.setStatus(TaskStatus.valueOf(status)); } catch (Exception ignored) {}
            taskService.save(t);
        }
        return "redirect:/user/tasks";
    }

    @PostMapping("/tasks/addComment")
    public String addComment(@RequestParam Long taskId,
                             @RequestParam String commentText,
                             HttpSession session) {
        User u = (User) session.getAttribute("authUser");
        Task t = taskService.findById(taskId);
        if (u != null && t != null && commentText != null && !commentText.trim().isEmpty()) {
            Comment c = new Comment();
            c.setText(commentText.trim());
            c.setTask(t);
            c.setUser(u);
            commentService.save(c);
        }
        return "redirect:/user/tasks";
    }
}
