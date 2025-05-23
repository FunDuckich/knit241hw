package org.knit.solutions.lab5sem2;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private final List<StyledCharacter> styledCharacters;
    private final CharacterFactory characterFactory;

    public TextEditor(CharacterFactory characterFactory) {
        this.styledCharacters = new ArrayList<>();
        this.characterFactory = characterFactory;
    }

    public void addCharacter(char charCode, int x, int y, String style) {
        CharacterFlyweight flyweight = characterFactory.getCharacter(charCode);
        styledCharacters.add(new StyledCharacter(flyweight, x, y, style));
    }

    public void renderAll() {
        System.out.println("\n--- Отображение всего текста ---");
        for (StyledCharacter styledChar : styledCharacters) {
            styledChar.render();
        }
        System.out.println("--- Конец отображения ---");
        System.out.println("Текущий размер пула символов (приспособленцев): " + characterFactory.getPoolSize());
    }
}
