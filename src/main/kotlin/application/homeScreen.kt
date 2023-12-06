package application

fun homeScreen() {

    do { //Repeat execution until you receive 1, 2, 3 or 5

        println("--------------------------------------------- -----------------------------------------" +
                "\nHOME SCREEN" +
                "\nSelect what you want to access by entering the corresponding number:" +
                "\n1 - Users" +
                "\n2 - Educational content" +
                "\n3 - Trainings" +
                "\n4 - Exit the application" +
                "\n------------------------------------------------------------- -----------------------------------------")
        val option = readlnOrNull()

        when (option) {
            "1" -> menuUser()
            "2" -> menuContentEducational()
            "3" -> menuTraining()
            "4" -> println("See you next time!")
        }

        if (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")) ) {
            println("Invalid selection!".uppercase()) //Prints if validation does not pass
        }

    } while (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") ))
}