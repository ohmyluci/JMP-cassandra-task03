package com.lucidiovacas.mongodb.task3;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskItemRepository taskItemRepository;

    public TaskServiceImpl(TaskItemRepository taskItemRepository) {
        this.taskItemRepository = taskItemRepository;
    }

    @Override
    public List<TaskItem> getAllTasks() {
        return taskItemRepository.findAll();
    }

    @Override
    public List<TaskItem> getAllOverdueTasks() {
        LocalDate today = LocalDate.now();
        return taskItemRepository.findAllOverdueTasks(today);
    }

    @Override
    public List<TaskItem> getAllTasksForCategory(Category category) {
        return null;
//        return taskItemRepository.findByCategory(category);
    }

    @Override
    public List<TaskItem> getAllTasksByWordInDescription(String word) {
        return null;
//        return taskItemRepository.findByWordInDescription(word);
    }

    @Override
    public TaskItem createTask(TaskItem taskItem) {
        return taskItemRepository.save(taskItem);
    }

    @Override
    public TaskItem updateTask(TaskItem taskItem) {
        return taskItemRepository.save(taskItem);
    }

    @Override
    public void deleteTask(String taskId) {
        taskItemRepository.deleteById(taskId);
    }

}
