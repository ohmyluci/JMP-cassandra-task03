package com.lucidiovacas.mongodb.task3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("add")
    private TaskItem createTask(@RequestBody TaskItem taskItem) {
        log.info("Saving task {}", taskItem.getName());
        taskItem.setId(UUID.randomUUID());
        return taskService.createTask(taskItem);
    }

    @GetMapping("all")
    private List<TaskItem> getAllTasks() {
        log.info("Getting all tasks");
        return taskService.getAllTasks();
    }

    @GetMapping("overdue")
    private List<TaskItem> getAllOverdueTasks() {
        log.info("Getting all overdue tasks");
        return taskService.getAllOverdueTasks();
    }

    @GetMapping
    private List<TaskItem> getTaskByCategory(@RequestParam Category category) {
        log.info("Getting tasks by category {}", category);
        return taskService.getAllTasksForCategory(category);
    }

    @PutMapping("{task_id}")
    private TaskItem updateTaskItem(@PathVariable("task_id") UUID taskId, @RequestBody TaskItem taskItem) {
        log.info("Updating task with id {}", taskId);
        taskItem.setId(taskId);
        return taskService.updateTask(taskItem);
    }

    @DeleteMapping("{task_id}")
    private void deleteTaskItem(@PathVariable("task_id") String taskId) {
        log.info("Deleting task with id {}", taskId);
        taskService.deleteTask(taskId);
    }

    @GetMapping("full-search/{word}")
    private List<TaskItem> getTaskByWordInDescription(@PathVariable("word") String word) {
        log.info("Getting tasks by word in description {}", word);
        return taskService.getAllTasksByWordInDescription(word);
    }
}
