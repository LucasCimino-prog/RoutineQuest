package Test;

import Model.Rpg.Character;
import Model.Routine.Task;
import Model.Routine.QuestFactory;
import java.util.List;

public class RoutineQuestMVP {
    public static void main(String[] args) {
        // 1. Inicia o aplicativo e carrega o usuário
        Character player = new Character("Lucas");

        System.out.println("=== Bem-vindo ao Routine Quest ===");
        System.out.println("Herói: " + player.getName() + " | Classe: " + player.getCurrentClass().getName());

        // 2. Usuário escolhe a trilha de estudos no app
        List<Task> studyQuests = QuestFactory.createStudyFocusQuests();
        Task currentQuest = studyQuests.get(0); // Pega a primeira missão (Pomodoro de 25 min)

        System.out.println("\n> Missão aceita: " + currentQuest.toString());
        System.out.println("> Cronômetro rodando por " + currentQuest.getDurationMinutes() + " minutos...");

        // 3. Simula que o usuário NÃO mexeu no celular e o tempo acabou
        currentQuest.completeTask();

        // 4. A PONTE DO MVP: Se a missão foi concluída, manda os prêmios para o personagem
        if (currentQuest.getStatus() == Task.TaskStatus.COMPLETED) {
            player.QuestConclusion(
                    currentQuest.getXpReward(),
                    currentQuest.getAttributeType(),
                    currentQuest.getAttributePoints()
            );
        }

        // 5. Exibe o resultado final na "Tela de Progresso"
        System.out.println("\n=== Tela de Progresso ===");
        System.out.println("Nível: " + player.getLevel() + " | XP: " + player.getExperience() + "/" + player.getExperienceRequired());
        System.out.println("Classe Atual: " + player.getCurrentClass().getName() + " (" + player.getCurrentClass().getImagePath() + ")");
        System.out.println("Atributos -> INT: " + player.getIntelligence());
    }
}