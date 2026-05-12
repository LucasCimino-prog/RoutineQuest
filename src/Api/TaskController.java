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
@CrossOrigin(origins = "*")
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

        // --- A TRAVA DE NOME DUPLICADO ENTRA AQUI ---
        if (taskRepository.existsByNameAndUserId(task.getName(), userId)) {
            // Retorna o status 409 (Conflito) para avisar o Android que o nome já existe
            return ResponseEntity.status(409).build();
        }

        task.setUser(userOptional.get());
        task.setStatus(Task.TaskStatus.PENDING);
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

            Long userId = task.getUser().getId();

            // Verifica se já existe OUTRA tarefa desse usuário com esse nome
            if (taskRepository.existsByNameAndUser_IdAndIdNot(details.getName(), userId, taskId)) {
                return ResponseEntity.status(409).<Task>build();
            }

            task.setName(details.getName());
            task.setDescription(details.getDescription());
            task.setXpReward(details.getXpReward());
            task.setAttributeType(details.getAttributeType());
            task.setAttributePoints(details.getAttributePoints());
            task.setDurationMinutes(details.getDurationMinutes());
            task.setStatus(details.getStatus());

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

    // ROTA DE BUSCA: /tasks/user/1/search?name=flexao
    @GetMapping("/user/{userId}/search")
    public ResponseEntity<List<Task>> searchTasks(
            @PathVariable Long userId,
            @RequestParam String name) {

        List<Task> tasks = taskRepository.findByUserIdAndNameContainingIgnoreCase(userId, name);
        return ResponseEntity.ok(tasks);
    }
}