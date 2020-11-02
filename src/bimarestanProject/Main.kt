package bimarestanProject

import java.lang.NumberFormatException
import bimarestanProject.isInEditMethod as isInEditMethod1

var isInEditMethod = true
val doctorsList = mutableListOf<Doctor>()
val patientsList = mutableListOf<Patient>()
fun main() {
    printMenu()
}

fun printMenu() {
    print("""
        1. Patient Section
        2. Doctors Section
        3. Exit
        Enter your section:
    """.trimIndent())
    when (readLine()) {
        "1" -> printPatientMenu()
        "2" -> printDoctorMenu()
        "3" -> exit()
        else -> printTypeTryAgain()
    }
}

fun exit() {
    println("Are you sure you want to exit(yes/no)")
    when (readLine()) {
        "y", "Y", "yes", "Yes", "YES" -> println("Good Bye")
        "n", "N", "no", "No", "NO" -> printMenu()
    }

}

fun printTypeTryAgain() {
    println("Invalid input. please enter 1 or 2")
    printMenu()
}

fun printDoctorMenu() {
    println(">>>>>>>>>>Doctors<<<<<<<<<<<<")
    print("""
        1. Add Doctor
        2. Edit Doctor
        3. Remove Doctor
        4. Show all doctors
        5. Back
        
    """.trimIndent())
    when (readLine()) {
        "1" -> addDoctor()
        "2" -> editDoctor()
        "3" -> removeDoctor()
        "4" -> showAllDoctors()
        "5" -> printMenu()
        else -> {
            println("Invalid Input")
            printDoctorMenu()
        }
    }
}

fun showAllDoctors() {
    for (item in doctorsList) {
        println(item.toString())
    }
    println("press any key to continue...")
    readLine()
    printDoctorMenu()

}


fun removeDoctor() {
    isInEditMethod1 = false
    println(">>>>>>>>>>remove Doctor<<<<<<<<<<<<")
    println("Enter Doctor Name to remove:")
    val unknownInput = readLine()
    if (unknownInput is String) {
        selectFromPatientList(unknownInput)
    } else {
        println("try again")
        printPatientMenu()
    }

}

fun editDoctor() {
    isInEditMethod1 = true
    println(">>>>>>>>>>edit Doctor<<<<<<<<<<<<")
    println("Enter Doctor Name to edit:")
    val unknownInput = readLine()
    if (unknownInput is String) {
        selectFromDoctorListContain(unknownInput)
    } else {
        println("try again")
        printPatientMenu()
    }

}

fun selectFromDoctorListContain(str: String) {
    for (item in doctorsList) {
        val searchFlag = item.name.contains(str, true)
        if (searchFlag) {
            print("""Current status of doctor:
                name: ${item.name}
                ID: ${item.id}
            """.trimIndent())
            println()
            when (bimarestanProject.isInEditMethod) {
                //it means we are in edit method
                true -> {
                    println("enter new name:")
                    val newName = readLine()!!
                    item.name = newName
                    println("enter new id:")
                    //this next line 's so wrong...I know...lol
                    item.id = readLine()!!.toLong()
                    println("successfully edited")
                    printDoctorMenu()

                }
                //this block works when we are in remove method instead
                false -> {
                    println("Are you sure to delete ${item.name} ?(yes/no)")
                    when (readLine().toString()) {
                        "y", "Y", "Yes", "yes" -> {
                            doctorsList.remove(item)
                            println("doctor ${item.name} successfully removed...")

                        }
                        "n", "N", "no", "No" -> println()

                    }
                    printDoctorMenu()
                }
            }

        }
        else {
            println("Not exist")
            printDoctorMenu()
        }
    }
}

fun addDoctor() {
    println(">>>>>>>>>>Add Doctor<<<<<<<<<<<<")
    println("Enter Doctor Name:")
    val nameDoctor = readLine()!!
    println("Enter Doctor Id:")
    val idDoctorString = readLine()
    var idDoctorLong: Long = 0
    if (idDoctorString != null) {
        try {
            idDoctorLong = idDoctorString.toLong()
        } catch (e: NumberFormatException) {
            println("Invalid input")
            printDoctorMenu()
        }
    }

    val myDoctor = Doctor(nameDoctor, idDoctorLong)
    doctorsList.add(myDoctor)

    println("Doctor $nameDoctor Successfully added...(1.add doctor/2.back)")
    when (readLine()) {
        "1" -> addDoctor()
        "2" -> printDoctorMenu()
        else -> {
            println("Invalid Input")
            printDoctorMenu()
        }
    }

}

fun printPatientMenu() {
    println(">>>>>>>>>>Parients<<<<<<<<<<<<")
    print("""
        1. Add Patient
        2. Edit Patient
        3. Remove Patient
        4. Show all patients
        5. Back
    """.trimIndent())
    when (readLine()) {
        "1" -> addPatient()
        "2" -> editPatient()
        "3" -> removePatient()
        "4" -> showAllPatients()
        "5" -> printMenu()
        else -> {
            println("Invalid Input")
            printPatientMenu()
        }
    }
}

fun showAllPatients() {
    for (item in patientsList) {
        println(item.toString())
    }
    println("press any key to continue...")
    readLine()
    printPatientMenu()
}

fun removePatient() {
    isInEditMethod1=false
    println(">>>>>>>>>>remove patient<<<<<<<<<<<<")
    println("Enter patient Name to remove:")
    val unknownInput= readLine()
    if (unknownInput is String) {
        selectFromPatientList(unknownInput)
    } else {
        println("try again")
        printPatientMenu()
    }

}

fun editPatient() {
    isInEditMethod1=true
    println(">>>>>>>>>>edit Patient<<<<<<<<<<<<")
    println("Enter patient name to edit:")
    val unknownInput = readLine()
    if (unknownInput is String) {
        selectFromPatientList(unknownInput)
    } else {
        println("try again")
        printPatientMenu()
    }
}

fun selectFromPatientList(str: String) {
    for (item in patientsList) {
        val searchFlag = item.name.contains(str, true)
        if (searchFlag) {
            print("""Current status of patient:
                name: ${item.name}
                ID: ${item.id}
            """.trimIndent())
            println()
            when (bimarestanProject.isInEditMethod) {
                //it means we are in edit method
                true -> {
                    println("enter new name:")
                    val newName = readLine()!!
                    item.name = newName
                    println("enter new id:")
                    //this next line 's so wrong...I know...lol
                    item.id = readLine()!!.toLong()
                    println("successfully edited")
                    printPatientMenu()

                }
                //this block works when we are in remove method instead
                false -> {
                    println("Are you sure to delete ${item.name} ?(yes/no)")
                    when (readLine().toString()) {
                        "y", "Y", "Yes", "yes" -> {
                            patientsList.remove(item)
                            println("doctor ${item.name} successfully removed...")

                        }
                        "n", "N", "no", "No" -> println()

                    }
                    printPatientMenu()
                }
            }

        }
        else {
            println("Not exist")
            printPatientMenu()
        }
    }

}

fun addPatient() {
    println(">>>>>>>>>>Add Patient<<<<<<<<<<<<")
    println("Enter patient Name:")
    val namePatient = readLine()!!
    println("Enter patient Id:")
    val idPatientString = readLine()
    var idPatientLong: Long = 0
    if (idPatientString != null) {
        try {
            idPatientLong = idPatientString.toLong()
        } catch (e: NumberFormatException) {
            println("Invalid input")
            printDoctorMenu()
        }
    }

    val myPatient = Patient(namePatient, idPatientLong)
    patientsList.add(myPatient)

    println("Doctor $namePatient Successfully added...(1.add doctor/2.back)")
    when (readLine()) {
        "1" -> addPatient()
        "2" -> printPatientMenu()
        else -> {
            println("Invalid Input")
            printPatientMenu()
        }
    }

}
