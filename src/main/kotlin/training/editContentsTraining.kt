package training

import application.menuTraining
import contentEducational.displayEducationalContents
import contentEducational.displayListEducationalContentsEmpty
import contentEducational.listEducationalContents
import contentEducational.registerEducationalContent

fun editContentsTraining() {
    if (listEducationalContents.isEmpty()) displayListEducationalContentsEmpty() //If the list of educational content is empty, execute function displayListEducationalContentsEmpty()
    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the user list is empty, execute function displayEmptyFormationList()

    do { //Repeat execution until you receive 1, 2 or 3

        println("--------------------------------------------- -----------------------------------------" +
                "\nSelect the edition you want to make by entering the corresponding number:" +
                "\n1 - Add educational content(s) to a training" +
                "\n2 - Remove educational content(s) from a training" +
                "\n3 - Back" +
                "\n------------------------------------------------------------- -----------------------------------------")
        val option = readlnOrNull()

        when (option) {
            "1" -> addTrainingContent()
            "2" -> excludeTrainingContent()
            "3" -> menuTraining()
        }

        if (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (option.isNullOrEmpty() || (!option.equals("1") && !option.equals("2") && !option.equals("3")))
}

fun addTrainingContent() {

    if (listEducationalContents.isEmpty()) displayListEducationalContentsEmpty() //If the list of educational content is empty, execute function displayListEducationalContentsEmpty()
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

    val optionsTraining = mutableListOf<String>() //Variable options receives the values of each training id of trainingList
    for (training in listTraining) {
        val option = training.idTraining
        optionsTraining.add(option.toString())
    }

    var selectionTraining: String? //Variable that will receive training choice from the options above

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the training to which you want to add educational content(s):")
        selectionTraining = readlnOrNull() //Receiving the ID value of the training selected by the user

        if (!optionsTraining.contains(selectionTraining)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!optionsTraining.contains(selectionTraining))

    val idTraining = selectionTraining!!.toInt() //Training index in the mutableList trainingList
    val selectedTraining = listTraining.find { it.idTraining == idTraining } //selectedTraining receives the equivalent Training of trainingList

    if (selectedTraining != null) {
        addSelectedTrainingContent(selectedTraining)
    }
}

fun addSelectedTrainingContent(selectedTraining: Training) {

    println("ID: ${selectedTraining.idTraining} | NAME: ${selectedTraining.nameTraining}\n\t↳ LEVEL: ${selectedTraining.levelDifficultyTraining}\n")

    println("----- List of educational content registered in the training -----\n".uppercase())
    displayTrainingContent(selectedTraining)

    println("\n----- List of educational content in the system -----\n".uppercase())
    displayEducationalContents()

    //If you want to register content that is not yet in the system
    println("To add new educational content(s) before proceeding, type 'add'. Otherwise, type anything else.")
    val addConteudoAntes = readlnOrNull()
    if (addConteudoAntes == "add") {
        registerEducationalContent()
        displayEducationalContents()
    } else println()

    val optionsContent = mutableListOf<String>() //Variable options receives the values of each educational content id from listEducationalContents
    for (content in listEducationalContents) {
        val option = content.idContentEducational
        optionsContent.add(option.toString())
    }

    var selectionContent: String? //Variable that will receive a choice of educational content from the options above

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the educational content you wish to register in the training:")
        selectionContent = readlnOrNull() //Receiving the ID value of the selected educational content

        if (!optionsContent.contains(selectionContent)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!optionsContent.contains(selectionContent))

    val idContent = selectionContent!!.toInt() //Content index in mutableList listEducationalContents
    val selectedContent = listEducationalContents.find { it.idContentEducational == idContent } //contentSelected receives the equivalent Content from listEducationalContents

    //Check if the content is not already registered in the training. If you are not registered, registration is done:
    if (selectedTraining.contentTraining.any { it.idContentEducational == selectedContent!!.idContentEducational }) {
        println("Registration failed: educational content is already registered in the selected training")
    } else {

        //Add content to training:
        selectedTraining.contentTraining.add(selectedContent!!)

        //Adds the duration of the educational content to the duration of the training:
        selectedTraining.durationTraining += selectedContent.durationContentEducational

        println("Successful addition: ID content " + selectedContent.idContentEducational + "registered in ID formation " + selectedTraining.idTraining)
        println(selectedTraining)
    }

    do { //Repeat execution until valid value is received: "s" or "n"

        println("Do you want to register other educational content in this training? Enter 'y' for yes or 'n' for no")
        val addOtherContentTraining = readlnOrNull()

        if (addOtherContentTraining.isNullOrEmpty() || !addOtherContentTraining.any { it.isLetter() } || (!addOtherContentTraining.equals("y") && !addOtherContentTraining.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        }

        when(addOtherContentTraining) {
            "y" -> addSelectedTrainingContent(selectedTraining) //"Loop" of addSelectedTrainingContent() -> Continues registering content in the same training
            "n" -> {
                println("Registration of educational content in training ID ${selectedTraining.idTraining} completed\n")
                println(selectedTraining)
            }
        }

    } while (addOtherContentTraining.isNullOrEmpty() || !addOtherContentTraining.any { it.isLetter() } || (!addOtherContentTraining.equals("y") && !addOtherContentTraining.equals("n")))
    menuTraining()
}

fun excludeTrainingContent() {

    if (listEducationalContents.isEmpty()) displayListEducationalContentsEmpty() //If the list of educational content is empty, execute function displayListEducationalContentsEmpty()
    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the user list is empty, execute function displayEmptyTrainingList()

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

    val optionsTrainings = mutableListOf<String>() //Variable options receives the values of each training id of trainingList
    for (training in listTraining) {
        val option = training.idTraining
        optionsTrainings.add(option.toString())
    }

    var selectionTraining: String? //Variable that will receive training choice from the options above

    do { //Repeat execution until it receives a value corresponding to any of the values ​​of the options variable

        println("Enter the ID of the training from which you want to remove educational content(s):")
        selectionTraining = readlnOrNull() //Receiving the ID value of the training selected by the user

        if (!optionsTrainings.contains(selectionTraining)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!optionsTrainings.contains(selectionTraining))

    val idTraining = selectionTraining!!.toInt() //Training index in the mutableList trainingList
    val selectedTraining  = listTraining.find { it.idTraining == idTraining } //selectedTraining receives the equivalent Training of trainingList

    if (selectedTraining != null) {
        excludeSelectedTrainingContent(selectedTraining)
    }
}

fun excludeSelectedTrainingContent(selectedTraining: Training) {

    if (selectedTraining.contentTraining.isEmpty()) {
        println("There is no educational content to exclude from training.")
        menuTraining()
    } else {

        println("ID: ${selectedTraining.idTraining} | NAME: ${selectedTraining.nameTraining}\n\t↳ LEVEL: ${selectedTraining.levelDifficultyTraining}\n")

        println("----- List of educational content registered in the training -----\n".uppercase())
        displayTrainingContent(selectedTraining)

        val optionsContent =
            mutableListOf<String>() //Variable options receives the values of each educational content id from listEducationalContents
        for (content in listEducationalContents) {
            val option = content.idContentEducational
            optionsContent.add(option.toString())
        }

        var selectionContent: String? //Variable that will receive a choice of educational content from the options above

        do { //Repeat execution until it receives a value corresponding to any of the values ​​of the options variable

            println("Enter the ID of the educational content you wish to remove from the training:")
            selectionContent = readlnOrNull() //Receiving the ID value of the selected educational content

            if (!optionsContent.contains(selectionContent)) {
                println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
            }

        } while (!optionsContent.contains(selectionContent))

        val idConteudo = selectionContent!!.toInt() //Content index in mutableList listConteudo
        val selectedContent = listEducationalContents.find { it.idContentEducational == idConteudo } //contentSelected receives the equivalent Content fromlistaConteudo

        //Removal of training content:
        selectedTraining.contentTraining.remove(selectedContent!!)

        //Decreases the time of educational content removed from the training duration:
        selectedTraining.durationTraining -= selectedContent.durationContentEducational

        println("Successful removal: content of ID " + selectedContent.idContentEducational + " of training ID " + selectedTraining.idTraining)
        println(selectedTraining)

        do { //Repeat execution until valid value is received: "s" or "n"

            println("Do you want to remove other educational content from this training? Enter 'y' for yes or 'n' for no")
            val excludeOtherContentTraining = readlnOrNull()

            if (excludeOtherContentTraining.isNullOrEmpty() || !excludeOtherContentTraining.any { it.isLetter() } || (!excludeOtherContentTraining.equals("y") && !excludeOtherContentTraining.equals("n"))) {
                println("-----Invalid selection!-----".uppercase())
            }

            when(excludeOtherContentTraining) {
                "y" -> excludeSelectedTrainingContent(selectedTraining) //"Loop" of deleteConteudosFormacao() -> Continues deleting content in the same formation
                "n" -> {
                    println("Removal of educational content in ID formation ${selectedTraining.idTraining} completed\n")
                    println(selectedTraining)
                }
            }

        } while (excludeOtherContentTraining.isNullOrEmpty() || !excludeOtherContentTraining.any { it.isLetter() } || (!excludeOtherContentTraining.equals("s") && !excludeOtherContentTraining.equals("n")))
        menuTraining()
    }
}