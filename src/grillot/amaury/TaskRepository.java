package grillot.amaury;

import java.util.List;

public interface TaskRepository {
    Task getTaskById(String id);
    List<Task> getAllTasks();
    void addTask(Task task);
    void updateTask(Task task);
    void removeTask(Task task);
}
