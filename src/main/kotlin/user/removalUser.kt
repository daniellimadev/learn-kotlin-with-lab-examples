package user

import application.menuUser

fun deleteUser() {
    if (listUsers.isEmpty()) displayEmptyUserList() //If the list of users is empty, execute the function displayEmptyUserList()

    println("----- List of registered users -----\n".uppercase())
    displayUsers()

    //Variable options receives the values of each user id from listUser
    val options = mutableListOf<String>()
    for (user in listUsers) {
        val option = user.idUser
        options.add(option.toString())
    }

    var selectionRemovalUser: String? //Variable that will receive an option informed by keyboard in the following do/while

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the user you want to delete:")
        selectionRemovalUser = readlnOrNull() //Receiving the value via the keyboard

        if (!options.contains(selectionRemovalUser)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!options.contains(selectionRemovalUser))

    val idUser = selectionRemovalUser!!.toInt() //User index in mutableList listUser
    val selectedUser = listUsers.find { it.idUser == idUser } //userSelected receives the equivalent User from listUser

    if (selectedUser != null) { //Removal with feedback
        val removed = listUsers.remove(selectedUser)

        if (removed) {
            println("Successful removal of:\n$selectedUser!\n") //Removal feedback message
        } else println("Removal failed")
    }

    if (listUsers.isNotEmpty()) {
        //"Loop" of deleteUser()
        do { //Repeat execution as long as deleteOtherUser does not receive a value that is not null, empty, without letters or different from "y" and "n"

            println("Would you like to delete another user? Enter 'y' for yes or 'n' for no")
            val deleteOtherUser = readlnOrNull() //Receiving the value via the keyboard

            when(deleteOtherUser) {
                "y" -> deleteUser() //Go to deleteUser() function
                "n" -> println("")
            }

            if (deleteOtherUser.isNullOrEmpty() || !deleteOtherUser.any { it.isLetter() } || (!deleteOtherUser.equals("y") && !deleteOtherUser.equals("n"))) {
                println("-----Invalid selection!-----".uppercase())
            } else println("")

        } while (deleteOtherUser.isNullOrEmpty() || !deleteOtherUser.any { it.isLetter() } || (!deleteOtherUser.equals("y") && !deleteOtherUser.equals("n")))
    }

    menuUser()
}