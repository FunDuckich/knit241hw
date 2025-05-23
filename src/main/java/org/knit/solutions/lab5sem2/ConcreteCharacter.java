package org.knit.solutions.lab5sem2;

public class ConcreteCharacter implements CharacterFlyweight {
    private final char characterCode;

    public ConcreteCharacter(char characterCode) {
        this.characterCode = characterCode;
        System.out.println("Создан объект ConcreteCharacter для символа: '" + characterCode + "'");
    }

    @Override
    public void render(int x, int y, String style) {
        System.out.println(
                "Отображение символа '" + characterCode +
                        "' в координатах (" + x + ", " + y +
                        ") со стилем '" + style + "'"
        );
    }

    public char getCharacterCode() {
        return characterCode;
    }
}
