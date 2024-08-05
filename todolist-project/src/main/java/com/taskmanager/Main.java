package com.taskmanager;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Add some test tasks
        taskManager.addTask("Buy milk", "Buy milk from the supermarket", TaskPriority.HIGH);
        taskManager.addTask("Clean the room", "Tidy up and clean the room", TaskPriority.MEDIUM);
        taskManager.addTask("Call the doctor", "Make an appointment with the doctor", TaskPriority.LOW);

        // Display all tasks
        taskManager.displayTasks();

        // Update a task
        taskManager.updateTask("Buy milk", "Buy groceries", "Buy milk, bread, and eggs", TaskPriority.HIGH, TaskStatus.TODO);

        // Mark a task as done
        taskManager.markTaskAsDone("Clean the room");

        // Display tasks by priority
        taskManager.displayTasksByPriority(TaskPriority.HIGH);

        // Display tasks by status
        taskManager.displayTasksByStatus(TaskStatus.DONE);

        // Delete a task
        taskManager.deleteTask("Call the doctor");
        taskManager.displayTasks();
    }
}
