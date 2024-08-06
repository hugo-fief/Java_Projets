package com.taskmanager;

import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class TaskManager {
    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String title, String description, TaskPriority priority) {
        Task task = new Task(title, description, priority);
        tasks.add(task);
        logger.info(ansi().fg(Ansi.Color.GREEN).a("Task added : {}").reset().toString(), task.getTitle());
    }

    public void updateTask(String title, String newTitle, String newDescription, TaskPriority newPriority, TaskStatus newStatus) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                task.setTitle(newTitle);
                task.setDescription(newDescription);
                task.setPriority(newPriority);
                task.setStatus(newStatus);
                logger.info(ansi().fg(Ansi.Color.YELLOW).a("Task updated : " + title + " => " + task.getTitle()).reset().toString());
                return;
            }
        }
        logger.warn(ansi().fg(Ansi.Color.RED).a("Task not found : {}").reset().toString(), title);
    }

    public void deleteTask(String title) {
        tasks.removeIf(task -> task.getTitle().equals(title));
        logger.info(ansi().fg(Ansi.Color.RED).a("Task deleted : {}").reset().toString(), title);
    }

    public void markTaskAsDone(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                task.setStatus(TaskStatus.DONE);
                logger.info(ansi().fg(Ansi.Color.GREEN).a("Task marked as done : {}").reset().toString(), task.getTitle());
                return;
            }
        }
        logger.warn(ansi().fg(Ansi.Color.RED).a("Task not found : {}").reset().toString(), title);
    }

    public void displayTasks() {
        logger.info(ansi().fg(Ansi.Color.CYAN).a("Displaying tasks :").reset().toString());
        for (Task task : tasks) {
            logger.info(task.toString());
        }
    }

    public void displayTasksByPriority(TaskPriority priority) {
        List<Task> filteredTasks = tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
        logger.info(ansi().fg(Ansi.Color.CYAN).a("Displaying tasks with priority {} :").reset().toString(), priority);
        for (Task task : filteredTasks) {
            logger.info(task.getTitle());
        }
    }

    public void displayTasksByStatus(TaskStatus status) {
        List<Task> filteredTasks = tasks.stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
        logger.info(ansi().fg(Ansi.Color.CYAN).a("Displaying tasks with status {} :").reset().toString(), status);
        for (Task task : filteredTasks) {
            logger.info(task.getTitle());
        }
    }

    // Getter for tasks (useful for testing)
    public List<Task> getTasks() {
        return tasks;
    }
}
