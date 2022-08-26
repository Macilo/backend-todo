package todo.list.taskmanager.exception;

public class TaskNotFound extends RuntimeException{
        public TaskNotFound(String message) {
            super(message);
    }
}
