package game;

public class Tile {
    private final int x;
    private final int y;
    private Symbol symbol = Symbol.EMPTY;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isAt(int x, int y) {
        return this.x == x && this.y == y;
    }

    boolean isMarked() {
        return symbol.isNotEmpty();
    }

    boolean hasSameSymbolAs(Tile other) {
        return symbol == other.symbol;
    }

    void mark(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol symbol() {
        return symbol;
    }
}
