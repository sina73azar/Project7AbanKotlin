package daneshgahExampleOop.classes

class Student(val name: String, val lastName: String, val studentId: Long) {
    val age: Int? =null
    val major: String? =null
    var chosenCourses:List<Course>?=null

    val passedCourses:List<Course>?=null
    init {
        println("$name is initialized as an actual object")
    }

    fun searchAndLearn() {
        println("Do it for 5 minutes ...")
    }


}