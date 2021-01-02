package game

class Tile(val x: Int, private val y: Int) {

    var symbol = Symbol.BLANK
        private set

    val isMarked get() = symbol.isNotBlank

    fun isAt(x: Int, y: Int): Boolean {
        return this.x == x && this.y == y
    }

    fun hasSameSymbolAs(other: Tile): Boolean {
        return symbol == other.symbol
    }

    fun mark(symbol: Symbol) {
        this.symbol = symbol
    }
}
