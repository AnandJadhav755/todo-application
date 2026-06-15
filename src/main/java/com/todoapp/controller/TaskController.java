package com.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todoapp.model.Task;
import com.todoapp.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService service;

    // Display all tasks
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", service.getAllTasks());
        return "index";
    }

    // Open add task form
    @GetMapping("/add")
    public String addTaskPage(Model model) {
        model.addAttribute("task", new Task());
        return "add-task";
    }

    // Save task
    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {
        service.saveTask(task);
        return "redirect:/";
    }

    // Open edit page
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", service.getTaskById(id));
        return "edit-task";
    }

    // Update task
    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        service.updateTask(task);
        return "redirect:/";
    }

    // Delete task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "redirect:/";
    }

    // Mark task as completed
    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        service.markAsCompleted(id);
        return "redirect:/";
    }
}