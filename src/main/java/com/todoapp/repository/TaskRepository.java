package com.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
