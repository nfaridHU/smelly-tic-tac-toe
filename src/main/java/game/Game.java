package game;

public class Game {

    private final Board board = new Board();
    private Symbol lastSymbol = Symbol.BLANK;

    public void play(char symbolChar, int x, int y) throws Exception {
        play(Symbol.from(symbolChar), x, y);
    }

    public void play(Symbol symbol, int x, int y) throws Exception {
        guardAgainstInvalidFirstPlayer(symbol);
        guardAgainstRepeatedTurns(symbol);
        guardAgainstInvalidPosition(x, y);

        lastSymbol = symbol;
        board.mark(symbol, x, y);
    }

    private void guardAgainstInvalidFirstPlayer(Symbol newSymbol) throws InvalidFirstPlayerException {
        if (lastSymbol.isBlank() && newSymbol.isO()) {
            throw new InvalidFirstPlayerException();
        }
    }

    private void guardAgainstRepeatedTurns(Symbol newSymbol) throws RepeatedPlayerException {
        if (newSymbol == lastSymbol) {
            throw new RepeatedPlayerException();
        }
    }

    private void guardAgainstInvalidPosition(int x, int y) throws InvalidPositionException {
        if (board.hasTileMarkedAt(x, y)) {
            throw new InvalidPositionException();
        }
    }

    public char winner() {
        if (board.hasWinnerInRow(0)) return board.symbolAt(0, 0).character();
        if (board.hasWinnerInRow(1)) return board.symbolAt(1, 0).character();
        if (board.hasWinnerInRow(2)) return board.symbolAt(2, 0).character();
        return Symbol.BLANK.character();
    }

}

