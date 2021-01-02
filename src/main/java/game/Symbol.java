package game;

import java.util.Arrays;

public enum Symbol {
    EMPTY(' '),
    O('O'),
    X('X');

    private char character;

    Symbol(char character) {
        this.character = character;
    }

    public static Symbol from(char c) {
        return Arrays.stream(values()).filter(s -> s.character == c).findFirst().orElse(EMPTY);
    }

    boolean isEmpty() {
        return this == EMPTY;
    }

    boolean isNotEmpty() {
        return !isEmpty();
    }

    boolean isO() {
        return this == O;
    }

    public char character() {
        return character;
    }
}
