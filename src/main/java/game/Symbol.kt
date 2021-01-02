package game;

import java.util.Arrays;

public enum Symbol {
    BLANK(' '),
    O('O'),
    X('X');

    private final char character;

    Symbol(char character) {
        this.character = character;
    }

    public static Symbol from(char c) {
        return Arrays.stream(values()).filter(s -> s.character == c).findFirst().orElse(BLANK);
    }

    boolean isBlank() {
        return this == BLANK;
    }

    boolean isNotBlank() {
        return !isBlank();
    }

    boolean isO() {
        return this == O;
    }

    public char character() {
        return character;
    }
}
