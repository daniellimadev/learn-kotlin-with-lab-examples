package training

import application.menuTraining
import enums.LevelDifficulty

fun editDataTraining() {
    if (listTraining.isEmpty()) displayEmptyTrainingList() //If the list of formations is empty, execute the function displayEmptyFormationList()

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

    val trainingOptions = mutableListOf<String>() //Variable options receives the values of each formation id of trainingList
    for (training in listTraining) {
        val option = training.idTraining
        trainingOptions.add(option.toString())
    }

    var trainingSelection: String? //Variable that will receive training choice from the options above

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the course you want to edit:")
        trainingSelection = readlnOrNull() //Receiving the ID value of the training selected by the user

        if (!trainingOptions.contains(trainingSelection)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!trainingOptions.contains(trainingSelection))

    val idTraining = trainingSelection!!.toInt() //Training index in the mutable trainingList
    val selectedTraining = listTraining.find { it.idTraining == idTraining } //selectedTraining receives the equivalent Training of trainingList

    //Edit the training name
    do { //Repeat execution until a value corresponding to "y" or "n" is received
        println("Do you want to edit the training name? Enter 'y' for yes or 'n' for no")
        val responseEditFormName = readlnOrNull() //Receiving the value via the keyboard

        if (responseEditFormName.isNullOrEmpty() || ((responseEditFormName != "y") && (responseEditFormName != "n"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        } else {
            var keyboardNewFormatName: String? // Variable againFormName that will fill FormatName after editing

            if (responseEditFormName == "y") { //If you received "y", proceed to change the name of the training
                do { //Repeat execution while keyboardNewFormName does not receive a value that is not null, empty, without letters or numbers
                    println("Enter new full training name:")
                    keyboardNewFormatName = readlnOrNull() //Receiving the value via the keyboard

                    if (keyboardNewFormatName.isNullOrEmpty() || !keyboardNewFormatName.any { it.isLetter() }) {
                        println("-----Invalid name!-----".uppercase())
                    }
                } while (keyboardNewFormatName.isNullOrEmpty() || !keyboardNewFormatName.any { it.isLetter() })

                selectedTraining!!.nameTraining = keyboardNewFormatName //Assigning a new name to the formation with the given ID

                //Feedback message for editing the training name
                println("Successful formation name change:\n" +
                        "ID: ${selectedTraining.idTraining} | NAME: ${selectedTraining.nameTraining}\n\t↳ LEVEL: ${selectedTraining.levelDifficultyTraining}\n")
            }
        }
    } while (responseEditFormName.isNullOrEmpty() || ((responseEditFormName != "y") && (responseEditFormName != "n")))

    //Editing the training difficulty level
    do { //Repeat execution until a value corresponding to "y" or "n" is received

        println("Do you want to edit the difficulty level of the training? Enter 'y' for yes or 'n' for no")
        val answerEditDifficultyLevelTraining = readlnOrNull() //Receiving the value via the keyboard

        if (answerEditDifficultyLevelTraining.isNullOrEmpty() || ((answerEditDifficultyLevelTraining != "y") && (answerEditDifficultyLevelTraining != "n"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        } else {
            var selectionNewLevelDifficultyTraining: String // Variable again TrainingDifficultyLevel that will fill in TrainingDifficulty Level after editing

            if (answerEditDifficultyLevelTraining == "y") { //If you received "y", continue to change the difficulty level of the training

                do { //Repeat execution until you receive 1, 2 or 3
                    println("Select the new training difficulty level by entering the corresponding number:" +
                            "\n1 - Basic\n2 - Intermediate\n3 - Advanced")
                    var keyboardDifficultyLevelTraining = readlnOrNull() //Receives the user's choice between options
                    selectionNewLevelDifficultyTraining = keyboardDifficultyLevelTraining.toString() //receives the keyboardDifficultyLevelTraining value


                    when (keyboardDifficultyLevelTraining) {
                        "1" -> selectionNewLevelDifficultyTraining = LevelDifficulty.BASIC.toString() //changes the selection value selectionNewLevelDifficultyTraining to the value of the enum enums.enums.LevelDifficulty
                        "2" -> selectionNewLevelDifficultyTraining = LevelDifficulty.INTERMEDIARY.toString() //changes the selection value selectionNewLevelDifficultyTraining to the value of the enum enums.enums.LevelDifficulty
                        "3" -> selectionNewLevelDifficultyTraining = LevelDifficulty.ADVANCED.toString() //changes the selection valueNovo selectionNewLevelDifficultyTraining to the value of the enum enums.enums.LevelDifficulty

                    }

                    if (keyboardDifficultyLevelTraining.isNullOrEmpty() || (!keyboardDifficultyLevelTraining.equals("1") && !keyboardDifficultyLevelTraining.equals("2") && !keyboardDifficultyLevelTraining.equals("3"))) {
                        println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
                    }
                } while (keyboardDifficultyLevelTraining.isNullOrEmpty() || (!keyboardDifficultyLevelTraining.equals("1") && !keyboardDifficultyLevelTraining.equals("2") && !keyboardDifficultyLevelTraining.equals("3")))

                selectedTraining!!.levelDifficultyTraining = selectionNewLevelDifficultyTraining //Changing the difficulty level of the training of the entered ID

                //Feedback message for editing the training difficulty level
                println("Successful educational content type change:\n" +
                        "ID: ${selectedTraining.idTraining} | NAME: ${selectedTraining.nameTraining}\n\t↳ LEVEL: ${selectedTraining.levelDifficultyTraining}\n")
            }


        }
    } while (answerEditDifficultyLevelTraining.isNullOrEmpty() || ((answerEditDifficultyLevelTraining != "y") && (answerEditDifficultyLevelTraining != "n")))
    menuTraining()
}