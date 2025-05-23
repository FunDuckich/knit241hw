package org.knit.solutions.lab5sem2;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<Character, CharacterFlyweight> characterPool;

    public CharacterFactory() {
        this.characterPool = new HashMap<>();
    }

    public CharacterFlyweight getCharacter(char charCode) {
        return characterPool.computeIfAbsent(charCode, ConcreteCharacter::new);
    }

    public int getPoolSize() {
        return characterPool.size();
    }
}
