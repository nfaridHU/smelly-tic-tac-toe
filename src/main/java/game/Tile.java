package game;

public class Tile
{
    public int x;
    public int y;
    public Symbol symbol = Symbol.EMPTY;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isAt(int x, int y) {
        return this.x == x && this.y == y;
    }

    boolean isMarked() {
        return symbol != Symbol.EMPTY;
    }

    boolean hasSameSymbolAs(Tile other) {
        return this.symbol == other.symbol;
    }

    void mark(Symbol symbol) {
        this.symbol = symbol;
    }
}
