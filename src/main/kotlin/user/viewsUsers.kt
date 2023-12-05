package user

import application.menuUser

fun displayEmptyUserList() {

    do { //Repeat execution as long as AddUserKeyboard does not receive a value that is not null, empty, without letters or other than "y" and "n"

        println("Your user list is empty. Do you want to add a user? Enter 'y' for yes or 'n' for no")
        val addUserKeyboard = readlnOrNull() //Receiving the value via the keyboard

        when(addUserKeyboard) {
            "y" -> registerUser() //Go to function registerUser()
            "n" -> println("")
        }

        if (addUserKeyboard.isNullOrEmpty() || !addUserKeyboard.any { it.isLetter() } || (!addUserKeyboard.equals("y") && !addUserKeyboard.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        }
    } while (addUserKeyboard.isNullOrEmpty() || !addUserKeyboard.any { it.isLetter() } || (!addUserKeyboard.equals("y") && !addUserKeyboard.equals("n")))
}

fun displayUsers() {
    if (listUsers.isEmpty()) displayEmptyUserList() //If the list of users is empty, execute the displayEmptyUserList() function
    val builder = StringBuilder() //Using StringBuilder to build the string

    for (user in listUsers) {
        builder.append(user.toString()) //Add each user's toString()
        builder.append("\n") //Add a line break between each user
    }
    println(builder.toString())
}
fun displayUsersOptionMenu() { //Version of displayUsers() for forwarding menuUser()

    if (listUsers.isEmpty()) displayEmptyUserList() //If the list of users is empty, execute the displayEmptyUserList() function

    val builder = StringBuilder() //Using StringBuilder to build the string

    for (user in listUsers) {
        builder.append(user.toString()) //Add each user's toString()
        builder.append("\n") //Add a line break between each user
    }
    println(builder.toString())

    do {
        println("Type 'y' to return to the USER menu")
        val returnToMenuUser = readlnOrNull() //Receiving the value via the keyboard

        when(returnToMenuUser) {
            "y" -> menuUser() //Go to menuUser() function
            "n" -> println("")
        }

    }while (returnToMenuUser.isNullOrEmpty() || !returnToMenuUser.any { it.isLetter() } || (!returnToMenuUser.equals("y")))
}