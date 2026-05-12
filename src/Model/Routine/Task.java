package Model.Routine;

import Model.User;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    // Enum para controlar os estados possiveis da tarefa
    public enum TaskStatus {
        PENDING,   // Pendente (em andamento)
        COMPLETED, // Concluida com sucesso
        FAILED     // Falhou
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private int xpReward;

    private String attributeType;
    private int attributePoints;
    private int durationMinutes; // Tempo exigido em minutos

    // O JPA vai salvar a palavra "PENDING" no banco de dados em vez de um numero
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    // Relacionamento: Muitas tarefas pertencem a um User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Construtor vazio (Obrigatorio para o Spring Boot/JPA funcionar)
    public Task() {}

    // Construtor original
    public Task(String name, String description, int xpReward, String attributeType, int attributePoints, int durationMinutes) {
        this.name = name;
        this.description = description;
        this.xpReward = xpReward;
        this.attributeType = attributeType;
        this.attributePoints = attributePoints;
        this.durationMinutes = durationMinutes;
        this.status = TaskStatus.PENDING; // Toda tarefa nasce pendente
    }

    // Metodos de Regra de Negocio
    public void completeTask() {
        if (this.status == TaskStatus.PENDING) {
            this.status = TaskStatus.COMPLETED;
            System.out.println("Missao concluida com sucesso: " + this.name);
        }
    }

    public void failTask() {
        if (this.status == TaskStatus.PENDING) {
            this.status = TaskStatus.FAILED;
            System.out.println("Missao falhou: " + this.name + " (Foco interrompido!)");
        }
    }

    // Getters e Setters Padroes
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getXpReward() { return xpReward; }
    public void setXpReward(int xpReward) { this.xpReward = xpReward; }

    public String getAttributeType() { return attributeType; }
    public void setAttributeType(String attributeType) { this.attributeType = attributeType; }

    public int getAttributePoints() { return attributePoints; }
    public void setAttributePoints(int attributePoints) { this.attributePoints = attributePoints; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}