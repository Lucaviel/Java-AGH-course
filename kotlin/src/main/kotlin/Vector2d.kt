import java.util.*

data class Vector2d(var x: Int, var y: Int) {

    override fun toString(): String {
        return "($x, $y)"
    }

    operator fun compareTo(other: Vector2d) : Int =
        compareValuesBy(this, other,
        { it.x },
        { it.y }
    )

    operator fun plus(increment: Vector2d) = Vector2d(x + increment.x, y + increment.y)

    operator fun minus(decrement: Vector2d) = Vector2d(x - decrement.x, y - decrement.y)

    fun opposite() = Vector2d(-1 * this.x, -1 * this.y)

    fun upperRight(other: Vector2d) = Vector2d(Math.max(x, other.x), Math.max(y, other.y))

    fun lowerLeft(other: Vector2d) = Vector2d(Math.min(x, other.x), Math.min(y, other.y))

    override fun equals(other: Any?): Boolean =
        (other is Vector2d) && (other.x == x) && (other.y == y)

    override fun hashCode(): Int {
        return Objects.hash(x, y)
    }

// to jest extension, jednak nie działało mi wtedy w metodzie move w klasie Animal i nie wiedziałam, jak to zmienić
//    fun MapDirection.toUnitVector(): Vector2d {
//        return when (this) {
//            MapDirection.NORTH -> Vector2d(0, 1)
//            MapDirection.SOUTH -> Vector2d(0, -1)
//            MapDirection.EAST -> Vector2d(1, 0)
//            MapDirection.WEST -> Vector2d(-1, 0)
//        }
//    }
}