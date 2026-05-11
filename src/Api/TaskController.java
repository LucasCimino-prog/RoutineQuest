package Api;

import Data.TaskRepository;
import Data.UserRepository;
import Model.Routine.Task;
import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE: Adiciona uma nova tarefa (missao) para um usuario
    @PostMapping("/user/{userId}")
    public ResponseEntity<Task> createTask(@PathVariable Long userId, @RequestBody Task task) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        task.setUser(userOptional.get());
        task.setStatus(Task.TaskStatus.PENDING); // Garante que nasce pendente
        return ResponseEntity.ok(taskRepository.save(task));
    }

    // READ: Lista todas as tarefas de um usuario especifico
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getUserTasks(@PathVariable Long userId) {
        return ResponseEntity.ok(taskRepository.findByUserId(userId));
    }

    // UPDATE: Atualiza os dados ou o Status da tarefa (ex: para COMPLETED ou FAILED)
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task details) {
        return taskRepository.findById(taskId).map(task -> {
            task.setName(details.getName());
            task.setDescription(details.getDescription());
            task.setXpReward(details.getXpReward());
            task.setAttributeType(details.getAttributeType());
            task.setAttributePoints(details.getAttributePoints());
            task.setDurationMinutes(details.getDurationMinutes());
            task.setStatus(details.getStatus()); // Aqui voce muda para COMPLETED ou FAILED
            return ResponseEntity.ok(taskRepository.save(task));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Remove uma tarefa do sistema
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.deleteById(taskId);
        return ResponseEntity.ok().build();
    }
}