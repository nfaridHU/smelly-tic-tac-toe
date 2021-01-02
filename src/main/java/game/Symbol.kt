package game

import java.util.Arrays

enum class Symbol(val character: Char) {
    BLANK(' '),
    O('O'),
    X('X');

    val isBlank get() = this == BLANK
    val isNotBlank get() = !isBlank
    val isO get() = this == O

    fun character(): Char {
        return character
    }

    companion object {
        @JvmStatic
        fun from(c: Char): Symbol {
            return values().find { c == it.character } ?: BLANK
        }
    }
}
