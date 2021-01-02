package game

import java.lang.Exception

class InvalidPositionException : Exception("Invalid position")
class RepeatedPlayerException : Exception("Invalid next player")
class InvalidFirstPlayerException : Exception("Invalid first player")
