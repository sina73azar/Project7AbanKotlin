package bimarestanProject

class Patient(var name:String,var id:Long) {
    var relatedDoctor:Doctor?=null
    override fun toString(): String {
        return "[$name , $id ]"
    }
}