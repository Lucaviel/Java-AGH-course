class Animal(
    var position: Vector2d = Vector2d(2, 2),
    private var orientation: MapDirection = MapDirection.NORTH,
    private var map: IWorldMap? = null) {

    override fun toString(): String {
        return when (this.orientation) {
            MapDirection.NORTH -> "N"
            MapDirection.EAST -> "E"
            MapDirection.SOUTH -> "S"
            MapDirection.WEST -> "W"
        }
    }

    fun isAt(position: Vector2d?) = this.position == position

    fun move(direction: MoveDirection) {
        when (direction) {
            MoveDirection.LEFT -> orientation = orientation.previous()
            MoveDirection.RIGHT -> orientation = orientation.next()
            MoveDirection.FORWARD -> {
                if (map!!.canMoveTo(this.position+orientation.toUnitVector()))
                    this.position = this.position+orientation.toUnitVector()
            }
            MoveDirection.BACKWARD -> {
                if (map!!.canMoveTo(this.position-orientation.toUnitVector()))
                    this.position = this.position-orientation.toUnitVector()
            }
        }
    }
}