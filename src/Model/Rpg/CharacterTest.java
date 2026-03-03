package Model.Rpg;

public class CharacterTest {
    public static void main(String[] args) {

        Character heroi = new Character("Arthur");
        System.out.println("--- Início da Jornada ---");
        exibirStatus(heroi);

        System.out.println("\n> Concluindo Quest: 'Estudar Java' (+150 XP, +15 INT)");
        heroi.QuestConclusion(150, "INT", 15);
        exibirStatus(heroi);

        System.out.println("\n> Concluindo Quest: 'Projeto de TCC' (+200 XP, +10 INT)");
        heroi.QuestConclusion(200, "INT", 10);
        exibirStatus(heroi);

        System.out.println("\n> Sincronizando Strava: 'Corrida Rápida de 2km' (+50 XP, +30 AGI)");
        heroi.QuestConclusion(50, "AGI", 30);
        exibirStatus(heroi);

        System.out.println("\n> Atividade Física: 'Corrida Longa de 5km' (+100 XP, +40 RES)");
        heroi.QuestConclusion(100, "RES", 40);
        exibirStatus(heroi);
    }

    public static void exibirStatus(Character c) {
        System.out.println("Nome: " + c.getName() + " | Nível: " + c.getLevel());

        System.out.println("Classe Atual: " + c.getCurrentClass().getName());
        System.out.println("Caminho da Imagem: " + c.getCurrentClass().getImagePath());

        System.out.println("XP: " + c.getExperience() + "/" + c.getExperienceRequired());
        System.out.println("Atributos -> INT: " + c.getIntelligence() + " | STR: " + c.getStrength() +
                " | AGI: " + c.getAgility() + " | RES: " + c.getResistance());
        System.out.println("-------------------------");
    }
}