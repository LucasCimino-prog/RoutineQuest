package Data;

import Model.Routine.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Busca todas as tarefas associadas a um usuario especifico
    List<Task> findByUserId(Long userId);
    // Busca tarefas do usuário onde o nome contenha o texto (ignorando maiúsculas/minúsculas)
    List<Task> findByUserIdAndNameContainingIgnoreCase(Long userId, String name);
    boolean existsByNameAndUserId(String name, Long userId);
    boolean existsByNameAndUser_IdAndIdNot(String name, Long userId, Long id);
}