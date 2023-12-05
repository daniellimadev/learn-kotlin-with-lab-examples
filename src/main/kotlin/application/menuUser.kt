package application

import user.deleteUser
import user.displayUsersOptionMenu
import user.editUser
import user.registerUser

fun menuUser() {

    do { //Repeat execution until you receive 1, 2 or 3

        println("--------------------------------------------- -----------------------------------------" +
                "\nUSER MENU" +
                "\nSelect what you want to access in USER by entering the corresponding number:" +
                "\n1 - List of registered users" +
                "\n2 - Register user(s)" +
                "\n3 - Edit registered user(s)" +
                "\n4 - Remove registered user(s)" +
                "\n5 - Return to home screen" +
                "\n------------------------------------------------------------- -----------------------------------------")
        val option = readlnOrNull()

        when (option) {
            "1" -> displayUsersOptionMenu()
            "2" -> registerUser()
            "3" -> editUser()
            "4" -> deleteUser()
            "5" -> homeScreen()
        }

        if (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5")))
}