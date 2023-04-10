data class Figure(val width: Double, val height: Double){
    private var _area: Double = 0.0
    var area: Double
        private set(value){
            if(value>0){
                _area = value
            }
        }
        get(){
            _area = width * height
            return _area
        }
}


sealed class Shape{
    class Rectangle(var a:Int, var b:Int): Shape()
    class Oval(var radius1:Double, var radius2: Double): Shape()
    class Line(var length:Int): Shape()
}




fun main(args: Array<String>) {
    val square = Figure(15.0, 4.0)
    val square2 = Figure(17.0, 2.0)
    val square3 = Figure(25.0, 10.0)
    val square4 = Figure(7.5, 4.0)

    var listOfSquares = arrayListOf<Figure>(square, square2, square3, square4)

    var howMuch:Double = 0.0
    for (i in listOfSquares){
        howMuch += i.area
    }
    println("Sum of areas = $howMuch")

    val rect = Shape.Rectangle(7,5)
    val rect2 = Shape.Rectangle(8,6)
    val rect3 = Shape.Rectangle(9,7)
    val oval = Shape.Oval(14.2, 5.7)
    val oval2 = Shape.Oval(15.2, 6.7)
    val oval3 = Shape.Oval(16.2, 7.7)
    val line = Shape.Line(7)
    val line2 = Shape.Line(8)
    val line3 = Shape.Line(9)

    var listOfShapes = arrayListOf<Shape>(rect, oval3, line3, oval, oval2, rect2, line, line2, rect3)

    var howMuchRect: Int = 0
    var howMuchOvals: Int = 0
    var howMuchLines: Int = 0

    // when
    for (i in listOfShapes){
        when(i){
            is Shape.Rectangle -> howMuchRect+=1
            is Shape.Oval -> howMuchOvals+=1
            is Shape.Line -> howMuchLines+=1
        }
    }
    println("WHEN - Rectangles: $howMuchRect, Ovals: $howMuchOvals, Lines: $howMuchLines")

    val filterRectangle = listOfShapes.filter {it is Shape.Rectangle}
    val filterOval = listOfShapes.filter {it is Shape.Oval}
    val filterLine = listOfShapes.filter {it is Shape.Line}

    println("FILTER - Rectangles: ${filterRectangle.size}, Ovals: ${filterOval.size}, Lines: ${filterLine.size}")
}