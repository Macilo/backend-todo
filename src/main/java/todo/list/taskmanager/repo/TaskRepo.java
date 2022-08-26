package todo.list.taskmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.list.taskmanager.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
}
