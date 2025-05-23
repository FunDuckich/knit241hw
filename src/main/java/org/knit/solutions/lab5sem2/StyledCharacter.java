package org.knit.solutions.lab5sem2;

class StyledCharacter {
    private final CharacterFlyweight flyweight;
    private final int x;
    private final int y;
    private final String style;

    public StyledCharacter(CharacterFlyweight flyweight, int x, int y, String style) {
        this.flyweight = flyweight;
        this.x = x;
        this.y = y;
        this.style = style;
    }

    public void render() {
        flyweight.render(x, y, style);
    }
}
