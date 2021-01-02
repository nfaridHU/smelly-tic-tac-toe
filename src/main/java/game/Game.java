package game;

public class Game {

    private Symbol lastSymbol = Symbol.EMPTY;
    private final Board board = new Board();

    public void play(char symbolChar, int x, int y) throws Exception {
        play(Symbol.from(symbolChar), x, y);
    }

    // TODO: replace x, y with Postion (or Location) class
    public void play(Symbol symbol, int x, int y) throws Exception {
        validateFirstPlayer(symbol);
        validateNextPlayer(symbol);
        validateMoveLocation(x, y);

        lastSymbol = symbol;
        board.mark(symbol, x, y);
    }

    private void validateMoveLocation(int x, int y) throws Exception {
        if (board.hasTileMarkedAt(x, y)) {
            throw new Exception(ExceptionMessage.INVALID_POSITION);
        }
    }

    private void validateNextPlayer(Symbol symbol) throws Exception {
        if (symbol == lastSymbol) {
            throw new Exception(ExceptionMessage.INVALID_NEXT_PLAYER);
        }
    }

    private void validateFirstPlayer(Symbol symbol) throws Exception {
        if (lastSymbol.isEmpty() && symbol == Symbol.O) {
            throw new Exception(ExceptionMessage.INVALID_FIRST_PLAYER);
        }
    }

    public char winner() {
        if (board.hasWinnerInRow(0)) return board.symbolAt(0, 0).character;
        if (board.hasWinnerInRow(1)) return board.symbolAt(1, 0).character;
        if (board.hasWinnerInRow(2)) return board.symbolAt(2, 0).character;
        return Symbol.EMPTY.character;
    }

}

