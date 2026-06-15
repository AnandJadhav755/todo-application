package com.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.model.Task;
import com.todoapp.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    // Save New Task
    public void saveTask(Task task) {
        repo.save(task);
    }

    // Get All Tasks
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    // Get Task By Id
    public Task getTaskById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Update Task
    public void updateTask(Task task) {
        repo.save(task);
    }

    // Delete Task
    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    // Mark Task As Completed
    public void markAsCompleted(Long id) {
        Task task = repo.findById(id).orElse(null);

        if (task != null) {
            task.setStatus("Completed");
            repo.save(task);
        }
    }
}