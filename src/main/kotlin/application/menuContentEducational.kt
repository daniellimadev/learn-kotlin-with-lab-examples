package application

import contentEducational.deleteEducationalContent
import contentEducational.displayEducationalContentsOptionMenu
import contentEducational.editEducationalContent
import contentEducational.registerEducationalContent

fun menuContentEducational() {

    do { //Repeat execution until you receive 1, 2, 3, 4 or 5

        println("--------------------------------------------- -----------------------------------------" +
                "\nEDUCATIONAL CONTENT MENU" +
                "\nSelect what you want to access in EDUCATIONAL CONTENT by entering the corresponding number:" +
                "\n1 - List of registered educational content" +
                "\n2 - Register educational content(s)" +
                "\n3 - Edit registered educational content(s)" +
                "\n4 - Remove registered educational content(s)" +
                "\n5 - Return to home screen" +
                "\n------------------------------------------------------------- -----------------------------------------")
        val option = readlnOrNull()

        when (option) {
            "1" -> displayEducationalContentsOptionMenu()
            "2" -> registerEducationalContent()
            "3" -> editEducationalContent()
            "4" -> deleteEducationalContent()
            "5" -> homeScreen()
        }

        if (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5")))

}