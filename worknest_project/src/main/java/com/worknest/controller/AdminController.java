
package com.worknest.controller;

import com.worknest.model.*;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired private UserService userService;
    @Autowired private TaskService taskService;
    @Autowired private CommentService commentService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pendingCount", taskService.countByStatus(TaskStatus.PENDING));
        model.addAttribute("inProgressCount", taskService.countByStatus(TaskStatus.IN_PROGRESS));
        model.addAttribute("completedCount", taskService.countByStatus(TaskStatus.COMPLETED));
        model.addAttribute("delayedCount", taskService.countByStatus(TaskStatus.DELAYED));
        return "admin-dashboard";
    }

    // User CRUD
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "users-list";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        model.addAttribute("u", new User());
        return "user-form";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("u") User user) {
        if (user.getRole() == null || user.getRole().trim().isEmpty()) user.setRole("USER");
        userService.register(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("u", userService.findById(id));
        return "user-form";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

    // Task allocation
    @GetMapping("/tasks")
    public String tasksPage(Model model) {
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("tasks", taskService.findAll());
        return "task-allocate";
    }

    @PostMapping("/tasks/save")
    public String saveTask(@RequestParam String title,
                           @RequestParam String description,
                           @RequestParam Long userId,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dueDate) {
        User user = userService.findById(userId);
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setAssignedUser(user);
        task.setStartDate(startDate);
        task.setDueDate(dueDate);
        // Determine delayed at creation if dueDate < today
        if (dueDate != null && dueDate.isBefore(LocalDate.now())) {
            task.setStatus(TaskStatus.DELAYED);
        } else {
            task.setStatus(TaskStatus.PENDING);
        }
        taskService.save(task);
        return "redirect:/admin/tasks";
    }

    @GetMapping("/tasks/{id}/comments")
    public String viewComments(@PathVariable Long id, Model model) {
        Task task = taskService.findById(id);
        List<Comment> comments = commentService.forTask(id);
        model.addAttribute("task", task);
        model.addAttribute("comments", comments);
        return "task-comments";
    }
}
