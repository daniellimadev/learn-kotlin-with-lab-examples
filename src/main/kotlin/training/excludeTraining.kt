package training

import application.menuTraining

fun excludeTraining() {

    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the user list is empty, execute function displayEmptyFormationList()

    println("----- List of registered formations -----\n".uppercase())
    displayListTrainings()

    //Variable options receives the values of each formation id of trainingList
    val options = mutableListOf<String>()
    for (training in listTraining) {
        val option = training.idTraining
        options.add(option.toString())
    }

    var selectionRemovalTraining: String? //Variable that will receive an option informed by keyboard in the following do/while

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the course you want to delete:")
        selectionRemovalTraining = readlnOrNull() //Receiving the value via the keyboard

        if (!options.contains(selectionRemovalTraining)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!options.contains(selectionRemovalTraining))

    val idTraining = selectionRemovalTraining!!.toInt() //Training index in mutable trainingList
    val selectedTraining = listTraining.find { it.idTraining == idTraining } //selectedTraining receives the equivalent Training of idTraining

    if (selectedTraining != null) { //Removal with feedback
        val removed = listTraining.remove(selectedTraining) //Remove the formation

        if (removed) { //Removal feedback message
            println("Successful removal of:\n$selectionRemovalTraining\n")
        } else println("Removal failed")
    }

    if (listTraining.isNotEmpty()) {

        //"Loop" of excludeTraining()
        do { //Repeat execution while you wantDeleteOtherForm when not receiving a value that is not null, empty, without letters or different from "y" and "n"

            println("Would you like to delete another formation? Enter 'y' for yes or 'n' for no")
            val wantToDeleteAnotherTraining = readlnOrNull() //Receiving the value via the keyboard

            when(wantToDeleteAnotherTraining) {
                "y" -> excludeTraining() //Go to excludeTraining() function
                "n" -> menuTraining()
            }

            if (wantToDeleteAnotherTraining.isNullOrEmpty() || !wantToDeleteAnotherTraining.any { it.isLetter() } || (!wantToDeleteAnotherTraining.equals("y") && !wantToDeleteAnotherTraining.equals("n"))) {
                println("-----Invalid selection!-----".uppercase())
            }

        } while (wantToDeleteAnotherTraining.isNullOrEmpty() || !wantToDeleteAnotherTraining.any { it.isLetter() } || (!wantToDeleteAnotherTraining.equals("y") && !wantToDeleteAnotherTraining.equals("n")))
    }
    menuTraining()
}