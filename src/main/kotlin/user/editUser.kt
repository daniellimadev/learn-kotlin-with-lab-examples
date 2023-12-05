package user

import application.menuUser
import enums.TypeUser

fun editUser() { //Function to edit user

    if (listUsers.isEmpty()) displayEmptyUserList() //If the list of users is empty, execute the function displayEmptyUserList()

    println("----- List of registered users -----\n".uppercase())
    displayUsers()

    //Variable options receives the values of each user id from listUser
    val options = mutableListOf<String>()
    for (user in listUsers) {
        val option = user.idUser
        options.add(option.toString())
    }

    var userEditionSelection: String? //Variable that will receive an option informed by keyboard in the following do/while
    var userToEdit: User?

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the user you want to edit:")
        userEditionSelection = readlnOrNull() //Receiving the ID value entered by the user

        if (!options.contains(userEditionSelection)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!options.contains(userEditionSelection)) //User index in mutableList listUsers

    val idUser = userEditionSelection!!.toInt()
    userToEdit = listUsers.find { it.idUser == idUser }

    //Edit username
    do { //Repeat execution until a value corresponding to "y" or "n" is received
        println("Do you want to edit the username? Enter 'y' for yes or 'n' for no")
        val responseEditUserName = readlnOrNull() //Receiving the value via the keyboard

        if (responseEditUserName.isNullOrEmpty() || ((responseEditUserName != "y") && (responseEditUserName != "n"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        } else {
            var keyboardNewUserName: String? //NewUserName variable that will fill inUserName after editing

            if (responseEditUserName == "y") { //If you received "y", proceed to change the responseEditUserName
                do { //Repeat execution while keyboardNewUserName does not receive a value that is not null, empty, without letters or numbers
                    println("Enter new username:")
                    keyboardNewUserName = readlnOrNull() //Receiving the value via the keyboard

                    if (keyboardNewUserName.isNullOrEmpty() || !keyboardNewUserName.any { it.isLetter() } || keyboardNewUserName.any { it.isDigit() }) {
                        println("-----Invalid name!-----".uppercase())
                    }
                } while (keyboardNewUserName.isNullOrEmpty() || !keyboardNewUserName.any { it.isLetter() } || keyboardNewUserName.any { it.isDigit() })

                userToEdit!!.nameUser = keyboardNewUserName //Assigning a new name to the user with the given ID

                println("User name change successful:\n$userToEdit\n") //Feedback message for user name editing
            }
        }
    } while (responseEditUserName.isNullOrEmpty() || ((responseEditUserName != "y") && (responseEditUserName != "n")))

    //Edit user type
    do { //Repeat execution until a value corresponding to "y" or "n" is received

        println("Do you want to edit the user type? Enter 'y' for yes or 'n' for no")
        val responseEditTypeUser = readlnOrNull() //Receiving the value via the keyboard

        if (responseEditTypeUser.isNullOrEmpty() || ((responseEditTypeUser != "y") && (responseEditTypeUser != "n"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        } else {
            var selectionNewUserType : String //NewUserType variable that will fill inUsername after editing

            if (responseEditTypeUser == "y") { //If received "y", proceed to change the user type

                do { //Repeat execution until it receives 1 or 2
                    println("Select the new user type by entering the corresponding number:" +
                            "\n1 - Instructor\n2 - Student")
                    var keyboardNewUserType = readlnOrNull() //Receives the user's choice between options
                    selectionNewUserType = keyboardNewUserType.toString() //receives the keyboardNewUserType value


                    when (keyboardNewUserType) {
                        "1" -> selectionNewUserType = TypeUser.INSTRUCTOR.toString() //changes the selectionNewUserType value to the value of the enum enums.TypeUser
                        "2" -> selectionNewUserType = TypeUser.STUDENT.toString() //changes the selectionNewUserType value to the value of the enum enums.TypeUser
                    }

                    if (keyboardNewUserType.isNullOrEmpty() || (!keyboardNewUserType.equals("1") && !keyboardNewUserType.equals("2"))) {
                        println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
                    }

                } while (keyboardNewUserType.isNullOrEmpty() || (!keyboardNewUserType.equals("1") && !keyboardNewUserType.equals("2")))

                userToEdit!!.typeUser = selectionNewUserType //Change of the user type of the entered ID

                println("User type change successful:\n$userToEdit\n") //Feedback message for user type editing
            }
        }
    } while (responseEditTypeUser.isNullOrEmpty() || ((responseEditTypeUser != "y") && (responseEditTypeUser != "n")))
    println("Editing user ID $userEditionSelection completed") //Feedback on user editing completion

    if (listUsers.isNotEmpty()) {

        //"Loop" of editUser()
        do { //Repeat execution as long as editOtherUser does not receive a value that is not null, empty, without letters or different from "y" and "n"

            println("Would you like to edit another user? Enter 'y' for yes or 'n' for no")
            val editOtherUser = readlnOrNull() //Receiving the value via the keyboard

            when(editOtherUser) {
                "y" -> editUser() //Go to editUser() function
                "n" -> println("")
            }

            if (editOtherUser.isNullOrEmpty() || !editOtherUser.any { it.isLetter() } || (!editOtherUser.equals("y") && !editOtherUser.equals("n"))) {
                println("-----Invalid selection!-----".uppercase())
            } else println("")

        } while (editOtherUser.isNullOrEmpty() || !editOtherUser.any { it.isLetter() } || (!editOtherUser.equals("y") && !editOtherUser.equals("n")))

    }
    menuUser()
}