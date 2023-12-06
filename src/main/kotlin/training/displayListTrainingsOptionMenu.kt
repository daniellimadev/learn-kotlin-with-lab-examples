package training

import application.menuTraining

fun displayListTrainings(){ //Training list printing -> Lean display that excludes subscribers and training content

    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the list of training is empty, execute the function displayDetailedFormat()

    val builder = StringBuilder()

    for (training in listTraining) {
        builder.append("ID: ${training.idTraining} | NAME: ${training.nameTraining}\n\t↳ LEVEL: ${training.levelDifficultyTraining} | DURATION: ${training.durationTraining}h")
        builder.append("\n") //Add a line break between each training
    }

    println(builder.toString())


}
fun displayListTrainingsOptionMenu() { //Version of displayDetailedFormat() for forwarding menuTraining()

    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the list of formations is empty, execute the function displayDetailedFormat()

    val builder = StringBuilder()

    for (training in listTraining) {
        builder.append("ID: ${training.idTraining} | NAME: ${training.nameTraining}\n\t↳ LEVEL: ${training.levelDifficultyTraining} | DURATION: ${training.durationTraining}h")
        builder.append("\n") //Add a line break between each training
    }

    println(builder.toString())

    do {

        println("Type 's' to return to the TRAINING menu")
        val backToMenuTraining = readlnOrNull() //Receiving the value via the keyboard

        when(backToMenuTraining) {
            "y" -> menuTraining() //Go to menuTraining() function
            "n" -> print("")
        }

    } while (backToMenuTraining.isNullOrEmpty() || !backToMenuTraining.any { it.isLetter() } || (!backToMenuTraining.equals("y")))
}

fun displayEmptyTrainingList() { //Display if Formation list is empty

    do { //Repeat execution while you wantToAddKeyboardTraining not to receive a value that is not null, empty, without letters or other than "y" and "n"

        println("Your formation list is empty. Do you want to add a formation? Enter 'y' for yes or 'n' for no")
        val wantToAddKeyboardTraining = readlnOrNull() //Receiving the value by the keyboard

        if (wantToAddKeyboardTraining.isNullOrEmpty() || !wantToAddKeyboardTraining.any { it.isLetter() } || (!wantToAddKeyboardTraining.equals("s") && !wantToAddKeyboardTraining.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        } else if (wantToAddKeyboardTraining == "y") registerTraining() //Proceed to training registration
        else println("Empty formation list")
    } while (wantToAddKeyboardTraining.isNullOrEmpty() || !wantToAddKeyboardTraining.any { it.isLetter() } || (!wantToAddKeyboardTraining.equals("y") && !wantToAddKeyboardTraining.equals("n")))
}

fun displayDetailedTraining() { // Displays a training in detail, including participants and contents of that training

    println("----- List of registered formations -----\n".uppercase())
    displayListTrainings()

    //Variable options receives the values of each formation id of traininglist
    val options = mutableListOf<String>()
    for (training in listTraining) {
        val option = training.idTraining
        options.add(option.toString())
    }

    var selectionDisplayTraining: String? //Variable that will receive an option informed by keyboard in the following do/while

    do { //Repeat execution until it receives a value corresponding to any of the values ​​of the options variable

        println("Enter the ID of the training you want to see more details about:")
        selectionDisplayTraining = readlnOrNull() //Receiving the value via the keyboard

        if (!options.contains(selectionDisplayTraining)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!options.contains(selectionDisplayTraining))

    val idtraining = selectionDisplayTraining!!.toInt() //Training index in the mutableList traininglist
    val selectedTraining = listTraining.find { it.idTraining == idtraining } //selectedTraining receives the equivalent training of traininglist

    println(selectedTraining)

    // "Loop" of displayDetailedFormat()
    do { //Repeat execution as long as deleteOutroUsuario does not receive a value that is not null, empty, without letters or different from "s" and "n"

        println("Would you like to view another formation in more detail? Enter 'y' for yes or 'n' for no")
        val displayOtherDetailedFormat = readlnOrNull() //Receiving the value via the keyboard

        when(displayOtherDetailedFormat) {
            "y" -> displayDetailedTraining() //Repeat displayFormacaoDetailed()
            "n" -> println("")
        }

        if (displayOtherDetailedFormat.isNullOrEmpty() || !displayOtherDetailedFormat.any { it.isLetter() } || (!displayOtherDetailedFormat.equals("s") && !displayOtherDetailedFormat.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        } else println("")

    } while (displayOtherDetailedFormat.isNullOrEmpty() || !displayOtherDetailedFormat.any { it.isLetter() } || (!displayOtherDetailedFormat.equals("y") && !displayOtherDetailedFormat.equals("n")))
}

fun displayTrainingRegistrants(selectedTraining: Training) { //Display the list of registrants for a training

    val builder = StringBuilder()

    for (user in selectedTraining.registeredTraining) {
        builder.append(user.toString())
        builder.append("\n") //Add a line break between each user enrolled in the training displayed
    }

    println(builder.toString())
}

fun displayTrainingContent(selectedTraining: Training) {

    val builder = StringBuilder()

    for (content in selectedTraining.contentTraining) {
        builder.append(content.toString())
        builder.append("\n") //Add a line break between each user enrolled in the training displayed
    }

    println(builder.toString())
}