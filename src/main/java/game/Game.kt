package game

class Game {

    private val board = Board()
    private var lastSymbol = Symbol.BLANK

    fun play(symbol: Char, x: Int, y: Int) {
        play(Symbol.from(symbol), x, y)
    }

    fun play(symbol: Symbol, x: Int, y: Int) {
        guardAgainstInvalidFirstPlayer(symbol)
        guardAgainstRepeatedTurns(symbol)
        guardAgainstInvalidPosition(x, y)

        lastSymbol = symbol
        board.mark(symbol, x, y)
    }

    private fun guardAgainstInvalidFirstPlayer(newSymbol: Symbol) {
        if (lastSymbol.isBlank && newSymbol.isO) {
            throw InvalidFirstPlayerException()
        }
    }

    private fun guardAgainstRepeatedTurns(newSymbol: Symbol) {
        if (newSymbol == lastSymbol) {
            throw RepeatedPlayerException()
        }
    }

    private fun guardAgainstInvalidPosition(x: Int, y: Int) {
        if (board.hasTileMarkedAt(x, y)) {
            throw InvalidPositionException()
        }
    }

    fun winner(): Char {
        if (board.hasWinnerIn(row = 0)) return board.symbolAt(0, 0).character
        if (board.hasWinnerIn(row = 1)) return board.symbolAt(1, 0).character
        if (board.hasWinnerIn(row = 2)) return board.symbolAt(2, 0).character
        return Symbol.BLANK.character
    }
}
