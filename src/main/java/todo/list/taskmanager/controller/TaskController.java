package todo.list.taskmanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todo.list.taskmanager.model.Task;
import todo.list.taskmanager.service.TaskService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){
        List<Task> tasks = this.taskService.findAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable final Long id){
        Task foundTask = this.taskService.findTaskById(id);
        return ResponseEntity.ok(foundTask);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody final Task task){
        return ResponseEntity.ok(this.taskService.addTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody final Task task,@PathVariable final Long id){
        return ResponseEntity.ok(this.taskService.updateTask(task,id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable final Long id){
        this.taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
