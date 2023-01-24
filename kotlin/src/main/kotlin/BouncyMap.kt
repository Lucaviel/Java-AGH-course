data class BouncyMap (val width: Int,
                 val height: Int) : IWorldMap {

    var animals: MutableMap<Vector2d, Animal?> = mutableMapOf()

    // funkcja canMoveTo zrozumiałam, że nie znajduje się w mapie zwierzątko na tym miejscu
    override fun canMoveTo(position: Vector2d): Boolean = !(position in animals.keys)

    override fun place(animal: Animal) {
        if (!isOccupied(animal.position))
            animals[animal.position] = animal
        else{
            val rand = randomFreePosition(Vector2d(width,height))
            if (rand != null) {
                animal.position = rand
                animals[rand] = animal
            }
        }
    }

    override fun isOccupied(position: Vector2d): Boolean = objectAt(position) != null

    override fun objectAt(position: Vector2d): Any? {
        if (canMoveTo(position))
            return null
        return animals[position]
    }
}