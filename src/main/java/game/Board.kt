package game

class Board {

    private val tiles = mutableListOf<Tile>()

    init {
        for (i in 0..2)
            for (j in 0..2)
                tiles.add(Tile(i, j))
    }

    fun tileAt(x: Int, y: Int) = tiles.find { it.isAt(x, y) }!!

    fun hasWinnerIn(row: Int) = hasAllTilesMarkedIn(row) && hasSameSymbolIn(row)

    fun hasTileMarkedAt(row: Int, i: Int) = tileAt(row, i).isMarked

    fun symbolAt(x: Int, y: Int) = tileAt(x, y).symbol

    fun mark(symbol: Symbol, x: Int, y: Int) {
        tileAt(x, y).mark(symbol)
    }

    private fun tilesIn(row: Int) = tiles.filter { row == it.x }

    private fun hasAllTilesMarkedIn(row: Int) = tilesIn(row).all { it.isMarked }

    private fun hasSameSymbolIn(row: Int) = tileAt(row, 0).hasSameSymbolAs(tileAt(row, 1))
                                            && tileAt(row, 2).hasSameSymbolAs(tileAt(row, 1))
}
