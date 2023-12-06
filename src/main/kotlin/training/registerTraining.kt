package training


import application.menuTraining
import enums.LevelDifficulty


fun Training.equalsIgnoringID(other: Training) : Boolean {
    return nameTraining == other.nameTraining && levelDifficultyTraining == other.levelDifficultyTraining
}
fun registerTraining() {
    var keyboardFormName: String? // Variable for the name of the training that will be received
    var keyboardLevelDifficultyFormation: String? //Selection variable for options in defining the level of difficulty that will be received
    var selectionLevelDifficultyTraining: String //Difficulty level variable that will be defined

    do { //Repeat execution while keyboardFormName does not receive a value that is not null, empty, without letters or numbers
        println("Enter training title:")
        keyboardFormName = readlnOrNull() //Receiving the value via the keyboard

        if (keyboardFormName.isNullOrEmpty() || !keyboardFormName.any { it.isLetter() }) {
            println("-----Invalid name!-----".uppercase())
        }
    } while (keyboardFormName.isNullOrEmpty() || !keyboardFormName.any { it.isLetter() })

    do { //Repeat execution until it receives 1 or 2 or 3
        println("Select the difficulty level of the training by entering the corresponding number:" +
                "\n1 - Basic\n2 - Intermediate\n3 - Advanced")
        keyboardLevelDifficultyFormation = readlnOrNull() //Receives user choice between options
        selectionLevelDifficultyTraining = keyboardLevelDifficultyFormation.toString() //receives the keyboardLevelDifficultyFormation value

        when (keyboardLevelDifficultyFormation) {
            "1" -> selectionLevelDifficultyTraining = LevelDifficulty.BASIC.toString() //changes the selection value selectionLevelDifficultyTraining to the value of the enum enums.enums.LevelDifficulty
            "2" -> selectionLevelDifficultyTraining = LevelDifficulty.INTERMEDIARY.toString() //changes the selection value selectionLevelDifficultyTraining to the value of the enum enums.enums.LevelDifficulty
            "3" -> selectionLevelDifficultyTraining = LevelDifficulty.ADVANCED.toString() //changes the selection value selectionLevelDifficultyTraining to the value of the enum enums.enums.LevelDifficulty
        }

        if (keyboardLevelDifficultyFormation.isNullOrEmpty() || (!keyboardLevelDifficultyFormation.equals("1") && !keyboardLevelDifficultyFormation.equals("2") && !keyboardLevelDifficultyFormation.equals("3"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (keyboardLevelDifficultyFormation.isNullOrEmpty() || (!keyboardLevelDifficultyFormation.equals("1") && !keyboardLevelDifficultyFormation.equals("2") && !keyboardLevelDifficultyFormation.equals("3")))

    val id = (listTraining.maxByOrNull { it.idTraining }?.idTraining ?: 0) + 1 //Autoincrement of id adds +1 to the largest id in the list
    val newTraining = Training()

    newTraining.idTraining = id
    newTraining.nameTraining = keyboardFormName
    newTraining.levelDifficultyTraining = selectionLevelDifficultyTraining

    //Check if the training is not already registered in the system. If you are not registered, registration is done:
    if (listTraining.any { it.equalsIgnoringID(newTraining) }) {
        println("Training registration failed: training is already registered in the system")
    } else {
        listTraining.add(newTraining) //Registration/Addition of training
        println("Successful training addition:\n$newTraining\n") //Addition feedback

        println("In the TRAINING MENU you can register users and educational content for the new training\n")
    }

    // "Loop" of registerTraining()
    do { //Repeat execution while you want toAddAnotherForm when not receiving a value that is not null, empty, without letters or different from "y" and "n"

        println("Would you like to register another training? Enter 'y' for yes or 'n' for no")
        val wantAddOtherFormation = readlnOrNull() //Receiving the value via the keyboard

        when (wantAddOtherFormation) {
            "s" -> registerTraining() //Go to the registerTraining() function
            "n" -> menuTraining()
        }

        if (wantAddOtherFormation.isNullOrEmpty() || !wantAddOtherFormation.any { it.isLetter() } || (!wantAddOtherFormation.equals("y") && !wantAddOtherFormation.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        }
    } while (wantAddOtherFormation.isNullOrEmpty() || !wantAddOtherFormation.any { it.isLetter() } || (!wantAddOtherFormation.equals("y") && !wantAddOtherFormation.equals("n")))

    menuTraining()
}