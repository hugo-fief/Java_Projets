package com.taskmanager;

public class Task {
    private String title;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;

    public Task(String title, String description, TaskPriority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.TODO;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Task: %s, Description: %s, Priority: %s, Status: %s", title, description, priority, status);
    }
}
