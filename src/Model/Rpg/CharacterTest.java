package Model.Rpg;

public class CharacterTest {
    public static void main(String[] args) {
        // 1. Criar o personagem
        Character heroi = new Character("Arthur");
        System.out.println("--- Início da Jornada ---");
        exibirStatus(heroi);

        // 2. Simular a conclusão de uma Quest de Inteligência
        System.out.println("\n> Concluindo Quest: 'Estudar Java' (+50 XP, +5 INT)");
        heroi.QuestConclusion(50, "INT", 5);
        exibirStatus(heroi);

        // 3. Simular ganho de XP para subir de nível
        System.out.println("\n> Concluindo Quest: 'Projeto de TCC' (+60 XP, +10 INT)");
        heroi.QuestConclusion(60, "INT", 10);
        exibirStatus(heroi);

        // 4. Sincronização Strava
        System.out.println("\n> Sincronizando Strava: 'Corrida 5km' (+20 AGI)");
        heroi.QuestConclusion(10, "AGI", 20);
        exibirStatus(heroi);
    }

    public static void exibirStatus(Character c) {
        System.out.println("Nome: " + c.getName() + " | Nível: " + c.getLevel());
        System.out.println("XP: " + c.getExperience() + "/" + c.getExperienceRequired());
        System.out.println("Atributos -> INT: " + c.getIntelligence() + " | STR: " + c.getStrength() +
                " | AGI: " + c.getAgility() + " | RES: " + c.getResistance());
        System.out.println("-------------------------");
    }
}
