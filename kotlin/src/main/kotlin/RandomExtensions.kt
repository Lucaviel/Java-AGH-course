import java.util.Vector

fun BouncyMap.randomPosition() : Vector2d? {
    return animals.keys.randomOrNull()
}

fun BouncyMap.randomFreePosition(mapSize: Vector2d) : Vector2d? {
    val setPositions = mutableSetOf<Vector2d>()
    for (i in 0..mapSize.x)
        for (j in 0..mapSize.y)
            if (!isOccupied(Vector2d(i, j)))
                setPositions.add(Vector2d(i, j))
    return setPositions.randomOrNull()
}