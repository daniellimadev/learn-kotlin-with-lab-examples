package contentEducational

import application.menuContentEducational
import enums.LevelDifficulty
import enums.TypeEducationalContent

fun editEducationalContent() {

    if (listEducationalContents.isEmpty()) displayListEducationalContentsEmpty()  //If the list of educational content is empty, execute the function displayEmptyEducationalContentList()

    println("----- List of registered educational content -----\n".uppercase())
    displayEducationalContents()

    //Options variable receives the values of each educational content id from theEducational Contents list
    val options = mutableListOf<String>()
    for (contentEducational in listEducationalContents) {
        val option = contentEducational.idContentEducational
        options.add(option.toString())
    }

    var educationalContentEditionSelection: String? //Variable that will receive an option informed by keyboard in the following do/while
    var contentEducationalForEditing: ContentEducational?

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the educational content you want to edit:")
        educationalContentEditionSelection = readlnOrNull()
        //Receiving the ID value entered by the user

        if (!options.contains(educationalContentEditionSelection)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!options.contains(educationalContentEditionSelection))

    val idContent = educationalContentEditionSelection!!.toInt() //Variable that receives the value of what will be the id of the list element ContentEducational
    contentEducationalForEditing = listEducationalContents.find { it.idContentEducational == idContent } //ContentEducational to be edited is the element that has the given id

    //Editing the name of the educational content
    do { //Repeat execution until a value corresponding to "y" or "n" is received
        println("Do you want to edit the title of the educational content? Enter 'y' for yes or 'n' for no")
        val responseEditEducationalContentName = readlnOrNull() //Receiving the value via the keyboard

        if (responseEditEducationalContentName.isNullOrEmpty() || ((responseEditEducationalContentName != "y") && (responseEditEducationalContentName != "n"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        } else {
            var keyboardNewNameContentEducational: String? //New variableEducationalContentName that will fill inEducationalContentName after editing

            if (responseEditEducationalContentName == "y") { //If you received "y", proceed to change the name of the educational content
                do { //Repeat execution as long as keyboardNewNameContentEducational does not receive a value that is not null, empty, without letters
                    println("Enter new educational content title:")
                    keyboardNewNameContentEducational = readlnOrNull() //Receiving the value via the keyboard

                    if (keyboardNewNameContentEducational.isNullOrEmpty() || !keyboardNewNameContentEducational.any { it.isLetter() }) {
                        println("-----Invalid title!-----".uppercase())
                    }
                } while (keyboardNewNameContentEducational.isNullOrEmpty() || !keyboardNewNameContentEducational.any { it.isLetter() })

                contentEducationalForEditing!!.nameContentEducational = keyboardNewNameContentEducational //Assigning a new name to the educational content of the given ID

                println("Successful change of name of educational content:\n$contentEducationalForEditing\n") //Feedback message for editing the name of educational content
            }
        }
    } while (responseEditEducationalContentName.isNullOrEmpty() || ((responseEditEducationalContentName != "y") && (responseEditEducationalContentName != "n")))

    //Editing the type of educational content
    do { //Repeat execution until a value corresponding to "y" or "n" is received

        println("Do you want to edit the type of educational content? Enter 'y' for yes or 'n' for no")
        val responseEditTypeContentEducational = readlnOrNull() //Receiving the value via the keyboard

        if (responseEditTypeContentEducational.isNullOrEmpty() || ((responseEditTypeContentEducational != "y") && (responseEditTypeContentEducational != "n"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        } else {
            var selectionNewTypeEducationalContent: String //Variable de NewTypeEducationalContent that will fill in the typeEducationalContent after editing

            if (responseEditTypeContentEducational == "y") { //If you received "y", proceed to change the type of educational content

                do { //Repeat execution until you receive 1, 2 or 3
                    println("Select the new type of educational content by entering the corresponding number:" +
                            "\n1 - Course\n2 - Code challenge\n3 - Project challenge")
                    val keyboardNewTypeContentEducational = readlnOrNull() //Receives user choice between options
                    selectionNewTypeEducationalContent = keyboardNewTypeContentEducational.toString() //receives the  keyboardNewTypeContentEducational


                    when (keyboardNewTypeContentEducational) {
                        "1" -> selectionNewTypeEducationalContent = TypeEducationalContent.COURSE.toString() //changes the selection value newTypeEducationalContent to the value of the enum enums.TypeEducationalContent
                        "2" -> selectionNewTypeEducationalContent = TypeEducationalContent.CHALLENGECODE.toString() //changes the selection value newTypeEducationalContent to the value of the enum enums.TypeEducationalContent
                        "3" -> selectionNewTypeEducationalContent = TypeEducationalContent.CHALLENGEPROJECT.toString() //changes the selection value newTypeEducationalContent to the value of the enum enums.TypeEducationalContent

                    }

                    if (keyboardNewTypeContentEducational.isNullOrEmpty() || (!keyboardNewTypeContentEducational.equals("1") && !keyboardNewTypeContentEducational.equals("2") && !keyboardNewTypeContentEducational.equals("3"))) {
                        println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
                    }

                } while (keyboardNewTypeContentEducational.isNullOrEmpty() || (!keyboardNewTypeContentEducational.equals("1") && !keyboardNewTypeContentEducational.equals("2") && !keyboardNewTypeContentEducational.equals("3")))

                contentEducationalForEditing!!.typeContentEducational = selectionNewTypeEducationalContent //Changing the type of educational content of the entered ID
                println("Successful change of educational content type:\n$contentEducationalForEditing\n") //Feedback message for editing the educational content type
            }
        }

    } while (responseEditTypeContentEducational.isNullOrEmpty() || ((responseEditTypeContentEducational != "y") && (responseEditTypeContentEducational != "n")))

    // Editing the difficulty level of educational content
    do { //Repeat execution until a value corresponding to "y" or "n" is received

        println("Do you want to edit the difficulty level of the educational content? Enter 'y' for yes or 'n' for no")
        val responseEditLevelDifficultyEducationalContent = readlnOrNull() //Receiving the value via the keyboard

        if (responseEditLevelDifficultyEducationalContent.isNullOrEmpty() || ((responseEditLevelDifficultyEducationalContent != "y") && (responseEditLevelDifficultyEducationalContent != "n"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        } else {
            var selectionNewLevelDifficultyEducationalContent: String //Variable againLevelDifficultyEducationalContent that will fill LevelDifficultyEducationalContent after editing

            if (responseEditLevelDifficultyEducationalContent == "y") { // If you received "y", continue to change the difficulty level of the educational content

                do { //Repeat execution until you receive 1, 2 or 3
                    println("\"Select the new difficulty level of the educational content by entering the corresponding number:" +
                            "\n1 - Basic\n2 - Intermediate\n3 - Advanced")
                    var keyboardLevelDifficultyEducational = readlnOrNull() //Receives user choice between options
                    selectionNewLevelDifficultyEducationalContent = keyboardLevelDifficultyEducational.toString() //receives the keyboardLevelDifficultyEducational

                    when (keyboardLevelDifficultyEducational) {
                        "1" -> selectionNewLevelDifficultyEducationalContent = LevelDifficulty.BASIC.toString() //changes the value of selectionNewLevelDifficultyEducationalContent to the value of the enum enums.LevelDifficulty
                        "2" -> selectionNewLevelDifficultyEducationalContent = LevelDifficulty.INTERMEDIARY.toString() //changes the value of selectionNewLevelDifficultyEducationalContent to the value of the enum enums.LevelDifficulty
                        "3" -> selectionNewLevelDifficultyEducationalContent = LevelDifficulty.ADVANCED.toString() //changes the value of selectionNewLevelDifficultyEducationalContent to the value of the enum enums.LevelDifficulty
                    }

                    if (keyboardLevelDifficultyEducational.isNullOrEmpty() || (!keyboardLevelDifficultyEducational.equals("1") && !keyboardLevelDifficultyEducational.equals("2") && !keyboardLevelDifficultyEducational.equals("3"))) {
                        println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
                    }
                } while (keyboardLevelDifficultyEducational.isNullOrEmpty() || (!keyboardLevelDifficultyEducational.equals("1") && !keyboardLevelDifficultyEducational.equals("2") && !keyboardLevelDifficultyEducational.equals("3")))

                contentEducationalForEditing!!.levelDifficultyContentEducational = selectionNewLevelDifficultyEducationalContent //Changing the difficulty level of the educational content of the ID entered

                println("Successful change of educational content type:\n$contentEducationalForEditing\n") //Feedback message for editing the difficulty level of educational content
            }
        }
    } while (responseEditLevelDifficultyEducationalContent.isNullOrEmpty() || ((responseEditLevelDifficultyEducationalContent != "y") && (responseEditLevelDifficultyEducationalContent != "n")))

    //Editing the duration in hours of educational content
    do { //Repeat execution until a value corresponding to "y" or "n" is received
        println("Do you want to edit the duration in whole hours of the educational content? Enter 'y' for yes or 'n' for no")
        val responseEditDurationEducationalContent = readlnOrNull() //Receiving the value via the keyboard

        if (responseEditDurationEducationalContent.isNullOrEmpty() || ((responseEditDurationEducationalContent != "y") && (responseEditDurationEducationalContent != "n"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        } else {
            var keyboardNewDurationEducationalContent: String? //New VariableEducationalContentDuration that will fillEducationalContentDuration after editing

            if (responseEditDurationEducationalContent == "y") { //If you received "y", continue to change the duration of the educational content
                do { //Repeats execution while keyboardNewDurationEducationalContent does not receive a value that is not null, empty or not entirely composed of numbers
                    println("Enter the new duration in hours of the educational content:")
                    keyboardNewDurationEducationalContent = readlnOrNull() //Receiving the value via the keyboard

                    if (keyboardNewDurationEducationalContent.isNullOrEmpty() || !keyboardNewDurationEducationalContent.all { it.isDigit() }) {
                        println("-----Invalid duration!-----".uppercase())
                    }
                } while (keyboardNewDurationEducationalContent.isNullOrEmpty() || !keyboardNewDurationEducationalContent.all { it.isDigit() })

                contentEducationalForEditing!!.durationContentEducational = keyboardNewDurationEducationalContent.toInt() //Assigning a new duration to the educational content of the given ID

                println("Successful change of duration in hours of educational content:\n$contentEducationalForEditing\n") //Feedback message for editing the duration of educational content
            }
        }
    } while (responseEditDurationEducationalContent.isNullOrEmpty() || ((responseEditDurationEducationalContent != "y") && (responseEditDurationEducationalContent != "n")))

    println("Editing the educational content of ID $educationalContentEditionSelection completed") //Feedback on the completion of editing the educational content

    if (educationalContentEditionSelection.isNotEmpty()) {

        // "Loop" of editEducationalContent()
        do { //Repeat execution as long as editOtherEducationalContent does not receive a value that is not null, empty, without letters or different from "y" and "n"

            println("Would you like to edit other educational content? Enter 'y' for yes or 'n' for no")
            val editOtherEducationalContent = readlnOrNull() //Receiving the value via the keyboard

            when(editOtherEducationalContent) {
                "y" -> editEducationalContent() //Go to function displayEducationalContent()
                "n" -> println("")
            }

            if (editOtherEducationalContent.isNullOrEmpty() || !editOtherEducationalContent.any { it.isLetter() } || (!editOtherEducationalContent.equals("y") && !editOtherEducationalContent.equals("n"))) {
                println("-----Invalid selection!-----".uppercase())
            } else println("")

        } while (editOtherEducationalContent.isNullOrEmpty() || !editOtherEducationalContent.any { it.isLetter() } || (!editOtherEducationalContent.equals("y") && !editOtherEducationalContent.equals("n")))
    }
    menuContentEducational()
}