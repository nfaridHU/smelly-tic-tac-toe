package game;

class InvalidPositionException extends Exception {
    public InvalidPositionException() {
        super("Invalid position");
    }
}

class RepeatedPlayerException extends Exception {
    public RepeatedPlayerException() {
        super("Invalid next player");
    }
}

class InvalidFirstPlayerException extends Exception {
    public InvalidFirstPlayerException() {
        super("Invalid first player");
    }
}
