package Model.Routine;

public class Task {

    // Enum para controlar os estados possíveis da tarefa
    public enum TaskStatus {
        PENDING,   // Pendente (em andamento)
        COMPLETED, // Concluída com sucesso
        FAILED     // Falhou (ex: usuário usou o celular)
    }

    private String name;
    private String description;
    private int xpReward;
    private String attributeType;
    private int attributePoints;
    private int durationMinutes; // Tempo exigido em minutos
    private TaskStatus status;   // Estado atual da missão

    public Task(String name, String description, int xpReward, String attributeType, int attributePoints, int durationMinutes) {
        this.name = name;
        this.description = description;
        this.xpReward = xpReward;
        this.attributeType = attributeType;
        this.attributePoints = attributePoints;
        this.durationMinutes = durationMinutes;
        this.status = TaskStatus.PENDING; // Toda tarefa nasce pendente
    }

    // Método para sucesso
    public void completeTask() {
        if (this.status == TaskStatus.PENDING) {
            this.status = TaskStatus.COMPLETED;
            System.out.println("Missão concluída com sucesso: " + this.name);
        }
    }

    // Método para falha (quando o usuário desiste ou abre outro app)
    public void failTask() {
        if (this.status == TaskStatus.PENDING) {
            this.status = TaskStatus.FAILED;
            System.out.println("Missão falhou: " + this.name + " (Foco interrompido!)");
        }
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getXpReward() { return xpReward; }
    public String getAttributeType() { return attributeType; }
    public int getAttributePoints() { return attributePoints; }
    public int getDurationMinutes() { return durationMinutes; }
    public TaskStatus getStatus() { return status; }

    @Override
    public String toString() {
        String statusMarker = "[ ]"; // Pendente
        if (status == TaskStatus.COMPLETED) statusMarker = "[X]"; // Sucesso
        else if (status == TaskStatus.FAILED) statusMarker = "[F]"; // Falha

        // Só exibe o tempo na listagem se a tarefa tiver duração > 0
        String timeInfo = (durationMinutes > 0) ? " | " + durationMinutes + " min" : "";

        return statusMarker + " " + name + " (+" + xpReward + " XP | +" + attributePoints + " " + attributeType + timeInfo + ")";
    }
}