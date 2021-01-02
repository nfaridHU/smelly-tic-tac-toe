package game;

public class Game {

    private Symbol lastSymbol = Symbol.EMPTY;
    private final Board board = new Board();

    public void play(char symbolChar, int x, int y) throws Exception {
        play(Symbol.from(symbolChar), x, y);
    }

    public void play(Symbol symbol, int x, int y) throws Exception {
        validateFirstPlayer(symbol);
        validateNextPlayer(symbol);
        validateMoveLocation(x, y);

        lastSymbol = symbol;
        board.mark(symbol, x, y);
    }

    private void validateMoveLocation(int x, int y) throws Exception {
        if (board.hasTileMarkedAt(x, y)) {
            throw new Exception("Invalid position");
        }
    }

    private void validateNextPlayer(Symbol symbol) throws Exception {
        if (symbol == lastSymbol) {
            throw new Exception("Invalid next player");
        }
    }

    private void validateFirstPlayer(Symbol symbol) throws Exception {
        if (lastSymbol.isEmpty() && symbol == Symbol.O) {
            throw new Exception("Invalid first player");
        }
    }

    public char winner() {
        if (board.hasWinnerInRow(0)) return board.symbolAt(0, 0);
        if (board.hasWinnerInRow(1)) return board.symbolAt(1, 0);
        if (board.hasWinnerInRow(2)) return board.symbolAt(2, 0);
        return Symbol.EMPTY.character;
    }

}

