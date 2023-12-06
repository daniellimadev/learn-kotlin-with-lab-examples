package training

import application.menuTraining
import user.displayEmptyUserList
import user.displayUsers
import user.listUsers
import user.registerUser

fun editUsersTraining() {

    if (listUsers.isEmpty()) displayEmptyUserList() //If the user list is empty, execute function displayEmptyUserList()
    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the user list is empty, execute function displayEmptyFormationList()

    do { //Repeat execution until you receive 1, 2 or 3

        println("--------------------------------------------- -----------------------------------------" +
                "\nSelect the edition you want to make by entering the corresponding number:" +
                "\n1 - Add user(s) to a training" +
                "\n2 - Remove user(s) from a training" +
                "\n3 - Back" +
                "\n------------------------------------------------------------- -----------------------------------------")
        val option = readlnOrNull()

        when (option) {
            "1" -> addUserTraining()
            "2" -> excludeUserTraining()
            "3" -> menuTraining()
        }

        if (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3")))
}

fun addUserTraining() {
    if (listUsers.isEmpty()) displayEmptyUserList() //If the user list is empty, execute function displayEmptyUserList()
    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the user list is empty, execute function displayEmptyFormationList()

    displayListTrainings()

    do { //Repeat execution until valid value is received: "y" or "n"

        println("Do you want to view details of any training before proceeding? Type 'y' for yes or 'n' for no.")
        val viewDetails = readlnOrNull()

        if (viewDetails.isNullOrEmpty() || !viewDetails.any { it.isLetter() } || (!viewDetails.equals("y") && !viewDetails.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        }

        when(viewDetails) {
            "y" -> displayDetailedTraining()
            "n" -> println()
        }

    } while (viewDetails.isNullOrEmpty() || !viewDetails.any { it.isLetter() } || (!viewDetails.equals("y") && !viewDetails.equals("n")))

    val optionsTraining = mutableListOf<String>() //Variable options receives the values of each formation id of trainingList
    for (training in listTraining) {
        val option = training.idTraining
        optionsTraining.add(option.toString())
    }

    var selectionTraining: String? //Variable that will receive training choice from the options above

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the training to which you want to add user(s):")
        selectionTraining = readlnOrNull() //Receiving the ID value of the training selected by the user

        if (!optionsTraining.contains(selectionTraining)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!optionsTraining.contains(selectionTraining))

    val idTraining = selectionTraining!!.toInt() //Training index in the mutableList trainingList
    val selectedTraining = listTraining.find { it.idTraining == idTraining } //selectedTraining receives the equivalent Training of trainingList

    if (selectedTraining != null) {
        addUserSelectedTraining(selectedTraining)
    }

}

fun addUserSelectedTraining(selectedTraining: Training) {

    println("ID: ${selectedTraining.idTraining} | NOME: ${selectedTraining.nameTraining}\n\t↳ NÍVEL: ${selectedTraining.levelDifficultyTraining}\n")

    println("----- List of users registered in the training -----\n".uppercase())
    displayTrainingRegistrants(selectedTraining)

    println("\n----- List of users in the system -----\n".uppercase())
    displayUsers()

    //If you want to register a user who is not yet in the system
    println("To add new user(s) before following, type 'add'. Otherwise, type anything else.")
    val addUserBefore = readlnOrNull()
    if (addUserBefore == "add") {
        registerUser()
        displayUsers()
    } else println()

    val optionsUser = mutableListOf<String>() //Variable options receives the values of each user id from listUsers
    for (user in listUsers) {
        val option = user.idUser
        optionsUser.add(option.toString())
    }

    var selectionUser: String? //Variable that will receive user choice from the options above

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the user you wish to enroll in the training:")
        selectionUser = readlnOrNull() //Receiving the selected user ID value

        if (!optionsUser.contains(selectionUser)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!optionsUser.contains(selectionUser))

    val idUser = selectionUser!!.toInt() //User index in mutableList listUsers
    val selectedUser = listUsers.find { it.idUser == idUser } //selectedUser receives the equivalent User from listUsers

    //Check if the user is not already enrolled in the training. If you are not registered, registration is done:
    if (selectedTraining.registeredTraining.any { it.idUser == selectedUser!!.idUser }) {
        println("Registration failed: user is already enrolled in the selected training")
    } else {
        selectedTraining.registeredTraining.add(selectedUser!!)

        println("Successful addition: ID user " + selectedUser.idUser + " enrolled in ID formation " + selectedTraining.idTraining)

        println("----- List of users registered in the training -----\n".uppercase())
        displayTrainingRegistrants(selectedTraining)
    }

    do { //Repeat execution until valid value is received: "s" or "n"

        println("Do you want to enroll another user in this training? Enter 'y' for yes or 'n' for no")
        val addAnotherUserTraining = readlnOrNull()

        if (addAnotherUserTraining.isNullOrEmpty() || !addAnotherUserTraining.any { it.isLetter() } || (!addAnotherUserTraining.equals("y") && !addAnotherUserTraining.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        }

        when(addAnotherUserTraining) {
            "y" -> addUserSelectedTraining(selectedTraining) //"Loop" of addUserSelectedTraining() -> Continues registering users in the same formation
            "n" -> {
                println("Registration of users in ID formation ${selectedTraining.idTraining} completed\n")
                println(selectedTraining)
            }
        }

    } while (addAnotherUserTraining.isNullOrEmpty() || !addAnotherUserTraining.any { it.isLetter() } || (!addAnotherUserTraining.equals("y") && !addAnotherUserTraining.equals("n")))
    menuTraining()
}

fun excludeUserTraining() {

    if (listUsers.isEmpty()) displayEmptyUserList() //If the user list is empty, execute function displayEmptyUserList()
    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the user list is empty, execute function displayEmptyFormationList()

    displayListTrainings()

    do { //Repeat execution until valid value is received: "y" or "n"

        println("Do you want to view details of any training before proceeding? Type 'y' for yes or 'n' for no.")
        val viewDetails = readlnOrNull()

        if (viewDetails.isNullOrEmpty() || !viewDetails.any { it.isLetter() } || (!viewDetails.equals("y") && !viewDetails.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        }

        when(viewDetails) {
            "y" -> displayDetailedTraining()
            "n" -> println()
        }

    } while (viewDetails.isNullOrEmpty() || !viewDetails.any { it.isLetter() } || (!viewDetails.equals("y") && !viewDetails.equals("n")))

    val optionsTraining = mutableListOf<String>() //Variable options receives the values of each formation id of trainingList
    for (training in listTraining) {
        val option = training.idTraining
        optionsTraining.add(option.toString())
    }

    var selectionTraining : String? //Variable that will receive training choice from the options above

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the training you want to remove user(s) from:")
        selectionTraining = readlnOrNull() //Receiving the ID value of the training selected by the user

        if (!optionsTraining.contains(selectionTraining)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!optionsTraining.contains(selectionTraining))

    val idTraining = selectionTraining!!.toInt() //Training index in the mutableList trainingList
    val selectedTraining = listTraining.find { it.idTraining == idTraining } //selectedTraining receives the equivalent Training of trainingList

    if (selectedTraining != null) {
        excludeUserSelectedTraining(selectedTraining)
    }

}

fun excludeUserSelectedTraining(selectedTraining: Training) {

    if (selectedTraining.registeredTraining.isEmpty()) {
        println("There are no users to exclude from training.")
        menuTraining()
    } else {
        println("ID: ${selectedTraining.idTraining} | NAME: ${selectedTraining.nameTraining}\n\t↳ LEVEL: ${selectedTraining.levelDifficultyTraining}\n")

        println("----- List of users registered in the training -----\n".uppercase())
        displayTrainingRegistrants(selectedTraining)

        val optionsUser = mutableListOf<String>() //Variable options receives the values of each user id from listUsers
        for (user in listUsers) {
            val option = user.idUser
            optionsUser.add(option.toString())
        }

        var selectionUsers : String? //Variable that will receive user choice from the options above

        do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

            println("Enter the ID of the user you want to remove from the training:")
            selectionUsers = readlnOrNull() //Receiving the selected user ID value

            if (!optionsUser.contains(selectionUsers)) {
                println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
            }

        } while (!optionsUser.contains(selectionUsers))

        val idUser = selectionUsers!!.toInt() //User index in mutableList listUsers
        val selectedUser = listTraining.find { it.idTraining == idUser } //selectedUser receives the equivalent User from listUsers

        if (selectedUser != null) { //Removal with feedback
            val removed = listTraining.remove(selectedUser)

            if (removed) {
                println("Successful removal of:\n$selectedUser!\n")
                println("ID: ${selectedTraining.idTraining} | NAME: ${selectedTraining.nameTraining}\n\t↳ LEVEL: ${selectedTraining.levelDifficultyTraining}\n")
                displayTrainingRegistrants(selectedTraining)
            }
        }

        do { //Repeat execution until valid value is received: "y" or "n"

            println("Do you want to remove another user from this lineup? Enter 'y' for yes or 'n' for no")
            val excludeAnotherUserTraining = readlnOrNull()

            if (excludeAnotherUserTraining.isNullOrEmpty() || !excludeAnotherUserTraining.any { it.isLetter() } || (!excludeAnotherUserTraining.equals("y") && !excludeAnotherUserTraining.equals("n"))) {
                println("-----Invalid selection!-----".uppercase())
            }

            when(excludeAnotherUserTraining) {
                "y" -> excludeUserSelectedTraining(selectedTraining) //"Loop" of excludeUserSelectedTraining() -> Continues removing users in the same formation
                "n" -> {
                    println("Removing users in formation with ID ${selectedTraining.idTraining} completed\n")
                    println(selectedTraining)
                }
            }

        } while (excludeAnotherUserTraining.isNullOrEmpty() || !excludeAnotherUserTraining.any { it.isLetter() } || (!excludeAnotherUserTraining.equals("y") && !excludeAnotherUserTraining.equals("n")))
        menuTraining()
    }
}