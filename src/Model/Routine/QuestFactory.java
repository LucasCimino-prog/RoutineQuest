package Model.Routine;

import java.util.ArrayList;
import java.util.List;

public class QuestFactory {

    // Trilha de Estudo (Ganha INT) - Baseada em Tempo de Foco
    public static List<Task> createStudyFocusQuests() {
        List<Task> trail = new ArrayList<>();
        // Nome, Descrição, XP, Atributo, Pontos, Tempo em Minutos
        trail.add(new Task("Sessão Pomodoro", "Focar nos estudos sem mexer no celular.", 50, "INT", 5, 25));
        trail.add(new Task("Imersão Profunda", "Sessão de foco intenso.", 120, "INT", 15, 60));
        trail.add(new Task("Maratona de Leitura", "Foco total para ler artigos técnicos.", 250, "INT", 30, 120));
        return trail;
    }

    // Trilha de Corrida (Ganha AGI/RES) - Será integrada com o Strava depois
    public static List<Task> createRunningQuests() {
        List<Task> trail = new ArrayList<>();
        // No caso da corrida, o tempo (0) será definido pelos dados do Strava
        trail.add(new Task("Trote Leve", "Correr 3km em ritmo confortável.", 60, "RES", 10, 0));
        trail.add(new Task("Tiro de 5km", "Correr 5km tentando bater seu pace.", 150, "AGI", 20, 0));
        return trail;
    }
}