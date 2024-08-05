package com.taskmanager.test;

import org.junit.jupiter.api.Test;

import com.taskmanager.Task;
import com.taskmanager.TaskManager;
import com.taskmanager.TaskPriority;
import com.taskmanager.TaskStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagerTest {
    @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Test Task", "This is a test task", TaskPriority.MEDIUM);
        
        assertEquals(1, taskManager.getTasks().size());
        assertEquals("Test Task", taskManager.getTasks().get(0).getTitle());
    }

    @Test
    public void testUpdateTask() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Test Task", "This is a test task", TaskPriority.MEDIUM);
        taskManager.updateTask("Test Task", "Updated Task", "Updated description", TaskPriority.HIGH, TaskStatus.IN_PROGRESS);
        
        Task updatedTask = taskManager.getTasks().get(0);
        assertEquals("Updated Task", updatedTask.getTitle());
        assertEquals("Updated description", updatedTask.getDescription());
        assertEquals(TaskPriority.HIGH, updatedTask.getPriority());
        assertEquals(TaskStatus.IN_PROGRESS, updatedTask.getStatus());
    }

    @Test
    public void testDeleteTask() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Test Task", "This is a test task", TaskPriority.MEDIUM);
        taskManager.deleteTask("Test Task");
        
        assertEquals(0, taskManager.getTasks().size());
    }

    @Test
    public void testMarkTaskAsDone() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Test Task", "This is a test task", TaskPriority.MEDIUM);
        taskManager.markTaskAsDone("Test Task");
        
        assertEquals(TaskStatus.DONE, taskManager.getTasks().get(0).getStatus());
    }
}
