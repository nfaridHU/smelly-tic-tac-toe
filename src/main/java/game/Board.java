package game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> tiles = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(i, j);
                tiles.add(tile);
            }
        }
    }

    public Tile tileAt(int x, int y) {
        for (Tile tile : tiles) {
            if (tile.isAt(x, y)) {
                return tile;
            }
        }
        return null;
    }

    public void mark(Symbol symbol, int x, int y) {
        tileAt(x, y).mark(symbol);
    }

    boolean hasWinnerInRow(int row) {
        return hasAllTilesMarkedIn(row) && hasSameSymbolIn(row);
    }

    private boolean hasSameSymbolIn(int row) {
        return tileAt(row, 0).hasSameSymbolAs(tileAt(row, 1))
               && tileAt(row, 2).hasSameSymbolAs(tileAt(row, 1));
    }

    private boolean hasAllTilesMarkedIn(int row) {
        return hasTileMarkedAt(row, 0) &&
               hasTileMarkedAt(row, 1) &&
               hasTileMarkedAt(row, 2);
    }

    public boolean hasTileMarkedAt(int row, int i) {
        return tileAt(row, i).isMarked();
    }

    char symbolAt(int x, int y) {
        return tileAt(x, y).symbol.character;
    }
}
