package application

import training.*

fun menuTraining() {

    do { //Repeat execution until you receive 1, 2, 3, 4, 5, 6, 7 or 8

        println("--------------------------------------------- -----------------------------------------" +
                "\nTRAINING MENU" +
                "\nSelect what you want to access in TRAINING by entering the corresponding number:" +
                "\n1 - List of registered formations" +
                "\n2 - Display details of a training" +
                "\n3 - Register training(s)" +
                "\n4 - Edit registered training(s) - Name / Difficulty level" +
                "\n5 - Remove registered training(s)" +
                "\n6 - Edit training users - Add / Remove" +
                "\n7 - Edit educational content of a training - Add / Remove" +
                "\n8 - Return to home screen" +
                "\n------------------------------------------------------------- -----------------------------------------")
        val option = readlnOrNull()

        when (option) {
            "1" -> displayListTrainingsOptionMenu()
            "2" -> displayDetailedTraining()
            "3" -> registerTraining()
            "4" -> editDataTraining()
            "5" -> excludeTraining()
            "6" -> editUsersTraining()
            "7" -> editContentsTraining()
            "8" -> homeScreen()
        }

        if (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5") && !option.equals("6") && !option.equals("7") && !option.equals("8"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5") && !option.equals("6") && !option.equals("7") && !option.equals("6")))

}