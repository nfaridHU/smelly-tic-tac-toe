package game;

import java.util.Arrays;

public enum Symbol {
    EMPTY(' '),
    O('O'),
    X('X');

    char character;

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
}
