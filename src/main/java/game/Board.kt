package game

class Board {

    private val tiles = mutableListOf<Tile>()

    init {
        for (i in 0..2) {
            for (j in 0..2) {
                val tile = Tile(i, j)
                tiles.add(tile)
            }
        }
    }

    fun tileAt(x: Int, y: Int): Tile? {
        return tiles.find { it.isAt(x, y) }
    }

    fun mark(symbol: Symbol, x: Int, y: Int) {
        tileAt(x, y)?.mark(symbol)
    }

    fun hasWinnerIn(row: Int): Boolean {
        return hasAllTilesMarkedIn(row) && hasSameSymbolIn(row)
    }

    private fun hasSameSymbolIn(row: Int): Boolean {
        return tileAt(row, 0)!!.hasSameSymbolAs(tileAt(row, 1))
               && tileAt(row, 2)!!.hasSameSymbolAs(tileAt(row, 1))
    }

    private fun hasAllTilesMarkedIn(row: Int): Boolean {
        return hasTileMarkedAt(row, 0) &&
               hasTileMarkedAt(row, 1) &&
               hasTileMarkedAt(row, 2)
    }

    fun hasTileMarkedAt(row: Int, i: Int): Boolean {
        return tileAt(row, i)?.isMarked ?: false
    }

    fun symbolAt(x: Int, y: Int): Symbol? {
        return tileAt(x, y)?.symbol
    }
}
