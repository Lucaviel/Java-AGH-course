fun main(args: Array<String>) {
    val vec1 = Vector2d(0,4)
    val vec2 = Vector2d(5,6)
    val vec3 = Vector2d(0,4)

    println(vec1)

    println(vec1+vec2)
    println(vec1-vec2)
    println(vec2.opposite())
    println(vec1 <= vec2)
    println(vec1 == vec3)

}