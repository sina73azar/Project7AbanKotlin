package daneshgahExampleOop.classes

class Course(val name: String, val courseId: Long) {
    var timeOfCourse:Int?=null
    var courseCapacity:Int?=20
    var remainingCapacity:Int?=0
    var courseTeacher: String? = null

    override fun toString(): String {
        return "Course named $name with ID of:$courseId"
    }
}