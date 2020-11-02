package bimarestanProject

class Doctor(var name: String, var id: Long) {
    val list = mutableListOf<Patient>()
    override fun toString(): String {
        return "[$name , $id ]"
    }
}