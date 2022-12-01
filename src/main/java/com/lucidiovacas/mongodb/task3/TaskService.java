package com.lucidiovacas.mongodb.task3;

import java.util.List;

public interface TaskService {

    public List<TaskItem> getAllTasks();
    public List<TaskItem> getAllOverdueTasks();
    public List<TaskItem> getAllTasksForCategory(Category category);
    public List<TaskItem> getAllTasksByWordInDescription(String word);
    public TaskItem createTask(TaskItem taskItem);
    public TaskItem updateTask(TaskItem taskItem);
    public void deleteTask(String taskId);
}
