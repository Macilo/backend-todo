package todo.list.taskmanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.list.taskmanager.exception.TaskNotFound;
import todo.list.taskmanager.model.Task;
import todo.list.taskmanager.repo.TaskRepo;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(final TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task addTask(final Task task){
       return this.taskRepo.save(task);
    }

    public Task findTaskById(final Long id){
        return this.taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFound("Task with id " + id + "not found"));
    }

    public List<Task> findAllTasks(){
        return this.taskRepo.findAll();
    }

    public Task updateTask(final Task task, final Long id){
        Task foundTask = this.findTaskById(id);
        if(foundTask!=null){
            foundTask.setName(task.getName());
            foundTask.setDescription(task.getDescription());
            foundTask.setDueDate(task.getDueDate());
            foundTask.setStatus(task.getStatus());
            this.taskRepo.save(foundTask);
        }
        return foundTask;
    }

    public void deleteTaskById(final Long id) {
        Task foundTask = this.findTaskById(id);
        if (foundTask != null) {
            this.taskRepo.delete(foundTask);
        }
    }
}
