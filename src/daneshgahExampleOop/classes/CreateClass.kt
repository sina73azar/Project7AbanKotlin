package daneshgahExampleOop.classes

fun main() {
    val mathCourse = Course("Math", 10)

    val myStudent1 = Student("sina", "azar", 12345678)


    val courseList:List<Course>?=List(10){mathCourse}
    myStudent1.chosenCourses = courseList

    println(myStudent1)

}
fun testFun(myList: List<Course>) {
    for (course in myList) {
        println(course.toString())
    }
    println("fun is called")
}

