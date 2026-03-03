package Model.Rpg;

public class Character {
    private String name;
    private int level;
    private int experience;
    private int experienceRequired;

    private int intelligence;
    private int strength;
    private int agility;
    private int resistance;

    public Character(String name){
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.experienceRequired = 100;

        this.intelligence = 1;
        this.strength = 1;
        this.agility = 1;
        this.resistance = 1;
    }

    public void QuestConclusion(int xp, String attribute, int points) {
        IncreseExperience(xp);


        switch (attribute.toUpperCase()) {
            case "INT":
                this.intelligence += points;
                break;
            case "STR":
                this.strength += points;
                break;
            case "AGI":
                this.agility += points;
                break;
            case "RES":
                this.resistance += points;
                break;
        }
    }

    public void IncreseExperience(int amount){
        this.experience += amount;
        while (this.experience >= this.experienceRequired){
            LevelUp();
        }
    }

    private void LevelUp(){
        this.experience -= this.experienceRequired;
        this.level++;

        this.experienceRequired *= 1.5;

        System.out.println("Parabéns! " + name + "alcançou o nível " + level + "!");
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public int getExperienceRequired() { return experienceRequired; }
    public int getIntelligence() { return intelligence; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getResistance() { return resistance; }
}
