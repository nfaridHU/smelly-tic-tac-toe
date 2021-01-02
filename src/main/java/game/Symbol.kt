package game

import java.util.Arrays

enum class Symbol(val character: Char) {
    BLANK(' '),
    O('O'),
    X('X');

    val isBlank get() = this == BLANK
    val isNotBlank get() = !isBlank
    val isO get() = this == O

    companion object {
        fun from(c: Char) = values().find { c == it.character } ?: BLANK
    }
}
