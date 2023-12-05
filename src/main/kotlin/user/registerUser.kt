package user

import application.menuUser
import enums.TypeUser

fun User.equalsIgnoringID(other: User) : Boolean { //Function to compare any new user to those already registered
    return nameUser == other.nameUser && typeUser == other.typeUser
}

fun registerUser() { //Function to register user

    var keyboardUserName: String? //Username variable that will be received
    var keyboardUserType: String? //Selection variable for options in defining the type of user that will be received
    var selectionUserType: String //Usertype variable that will be defined

    do { //Repeat execution as long as keyboardUserName does not receive a value that is not null, empty, without letters or numbers
        println("Enter the user's full name:")
        keyboardUserName = readlnOrNull() //Receiving the value via the keyboard

        if (keyboardUserName.isNullOrEmpty() || !keyboardUserName.any { it.isLetter() } || keyboardUserName.any { it.isDigit() }) {
            println("-----Invalid name!-----".uppercase())
        }
    } while (keyboardUserName.isNullOrEmpty() || !keyboardUserName.any { it.isLetter() } || keyboardUserName.any { it.isDigit() })

    do { //Repeat execution until you receive 1 or 2
        println("Select the user type by entering the corresponding number:" +
                "\n1 - Instructor\n2 - Student")
        keyboardUserType = readlnOrNull() // Receives user choice between options
        selectionUserType =keyboardUserType.toString() // Receives user choice between options

        when (keyboardUserType) {
            "1" -> selectionUserType = TypeUser.INSTRUCTOR.toString() //change the value of the selectionUserType to the value of the enum enums.TypeUser
            "2" -> selectionUserType = TypeUser.STUDENT.toString() //change the value of the selectionUserType to the value of the enum enums.TypeUser
        }

        if (keyboardUserType.isNullOrEmpty() || (!keyboardUserType.equals("1") && !keyboardUserType.equals("2"))) {
            println("-----Invalid select!-----".uppercase()) //Print if validation is not passed
        }

    } while (keyboardUserType.isNullOrEmpty() || (!keyboardUserType.equals("1") && !keyboardUserType.equals("2")))

    var newUser = User() //User Instance
    val id = (listUsers.maxByOrNull { it.idUser }?.idUser ?: 0) + 1 // Autoincrement of id adds +1 to the largest id in the list

    newUser.idUser = id //Userid of the User instance (newUser) = id
    newUser.nameUser = keyboardUserName //Username of the User instance (newUser) = keyboardUserName
    newUser.typeUser = selectionUserType //TypeUser of the User instance (newUser) = selectionUserType

    //Check if the user is not already registered in the system. If you are not registered, registration is done:
    if (listUsers.any { it.equalsIgnoringID(newUser) }) {
        println("User registration failed: user is already registered in the system")
    } else {
        listUsers.add(newUser) //Registration/Add user
        println("Successful user addition:\n$newUser\n") //Addition feedback
    }

    //"Loop" of registerUser()
    do {//Repeat execution while you wantAddAnotherUser not to receive a value that is not null, empty, without letters or other than "y" and "n"
        println("Would you like to register another user? Enter 'y' for yes or 'n' for no")
        val wantAddOtherUser = readlnOrNull() //Receiving the value via the keyboard

        when(wantAddOtherUser) {
            "y" -> registerUser() //Go to the registerUser() function
            "n" -> println("")
        }

        if (wantAddOtherUser.isNullOrEmpty() || !wantAddOtherUser.any { it.isLetter() } || (!wantAddOtherUser.equals("y") && !wantAddOtherUser.equals("n"))) {
            println("-----Invalid select!-----".uppercase())
        }

    } while (wantAddOtherUser.isNullOrEmpty() || !wantAddOtherUser.any { it.isLetter() } || (!wantAddOtherUser.equals("y") && !wantAddOtherUser.equals("n")))

    menuUser()

}