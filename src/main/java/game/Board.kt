package game

class Board {

    private val tiles = mutableListOf<Tile>()

    init {
        for (i in 0..2)
            for (j in 0..2)
                tiles.add(Tile(i, j))
    }

    fun tileAt(x: Int, y: Int): Tile {
        return tiles.find { it.isAt(x, y) }!!
    }

    fun mark(symbol: Symbol, x: Int, y: Int) {
        tileAt(x, y).mark(symbol)
    }

    fun hasWinnerIn(row: Int): Boolean {
        return hasAllTilesMarkedIn(row) && hasSameSymbolIn(row)
    }

    private fun tilesIn(row: Int): List<Tile> {
        return tiles.filter { row == it.x }
    }

    private fun hasSameSymbolIn(row: Int): Boolean {
        return tileAt(row, 0).hasSameSymbolAs(tileAt(row, 1))
               && tileAt(row, 2).hasSameSymbolAs(tileAt(row, 1))
    }

    private fun hasAllTilesMarkedIn(row: Int): Boolean {
        return tilesIn(row).all { it.isMarked }
    }

    fun hasTileMarkedAt(row: Int, i: Int): Boolean {
        return tileAt(row, i).isMarked
    }

    fun symbolAt(x: Int, y: Int): Symbol {
        return tileAt(x, y).symbol
    }
}
