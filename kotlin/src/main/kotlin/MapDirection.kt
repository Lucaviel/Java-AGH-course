enum class MapDirection {
    NORTH, SOUTH, EAST, WEST;

    override fun toString(): String {
        return when (this){
            NORTH -> "Północ"
            SOUTH -> "Południe"
            EAST -> "Wschód"
            WEST -> "Zachód"
        }
    }

    fun next() : MapDirection {
        return when (this){
            NORTH -> EAST
            SOUTH -> WEST
            EAST -> SOUTH
            WEST -> NORTH
        }
    }

    fun previous() : MapDirection {
        return when (this){
            NORTH -> WEST
            SOUTH -> EAST
            EAST -> NORTH
            WEST -> SOUTH
        }
    }

    fun toUnitVector(): Vector2d {
        return when (this) {
            NORTH -> Vector2d(0, 1)
            SOUTH -> Vector2d(0, -1)
            EAST -> Vector2d(1, 0)
            WEST -> Vector2d(-1, 0)
        }
    }
}