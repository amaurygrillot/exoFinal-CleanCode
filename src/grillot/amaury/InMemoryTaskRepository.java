package grillot.amaury;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTaskRepository implements TaskRepository {
    private List<Task> tasks;
    private String tasksFilePath = System.getProperty("user.home") + "/.consoleAgenda/tasks.json";

    public InMemoryTaskRepository() {
       //TODO: initialize tasks
    }

    @Override
    public Task getTaskById(String id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        //TODO: save tasks to file
    }

    @Override
    public void updateTask(Task task) {
        tasks = tasks.stream()
                .map(existingTask -> existingTask.getId().equals(task.getId()) ? task : existingTask)
                .collect(Collectors.toList());
                //TODO: save tasks to file
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
        // TODO : save tasks to file
    }
}
