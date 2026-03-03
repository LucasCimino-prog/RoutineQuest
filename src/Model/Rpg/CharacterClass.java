package Model.Rpg;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum CharacterClass {

    NOVICE("Novice", "novice.png"),
    WARRIOR("Warrior", "warrior.png"),
    MAGE("Mage", "mage.png"),
    ASSASSIN("Assassin", "assassin.png"),
    TANK("Tank", "tank.png");

    private final String name;
    private final String imagePath;

    CharacterClass(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public String getImagePath() { return imagePath; }

    public static CharacterClass getBestFit(int str, int intel, int agi, int res) {
        if (str <= 5 && intel <= 5 && agi <= 5 && res <= 5) return NOVICE;

        Map<CharacterClass, Integer> stats = new HashMap<>();
        stats.put(WARRIOR, str);
        stats.put(MAGE, intel);
        stats.put(ASSASSIN, agi);
        stats.put(TANK, res);

        return Collections.max(stats.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}