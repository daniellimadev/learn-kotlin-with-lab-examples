package contentEducational

import application.menuContentEducational
import enums.LevelDifficulty
import enums.TypeEducationalContent

fun ContentEducational.equalsIgnoringID(other: ContentEducational) : Boolean { //Function to compare any new educational content to those already registered

    return nameContentEducational == other.nameContentEducational &&
            typeContentEducational == other.typeContentEducational &&
            levelDifficultyContentEducational == other.levelDifficultyContentEducational &&
            durationContentEducational == other.durationContentEducational
}
fun registerEducationalContent() {

    var keyboardEducationalContentName: String? // Variable for the name of the educational content that will be received
    var keyboardTypeEducationalContent: String? //Selection variable for options in defining the type of educational content that will be received
    var selectionTypeContentEducational: String //EducationalContent type variable that will be defined
    var keyboardDifficultyLevelEducationalContent: String? //Selection variable for options in defining the level of difficulty that will be received
    var selectionLevelDifficultyEducationalContent: String //Difficulty level variable that will be defined
    var keyboardDurationContentEducational: String? //Duration variable in hours of educational content that will be received

    do { //Repeat execution as long as keyboardNameEducationalContent does not receive a value that is not null, empty, without letters or numbers
        println("Enter educational content title:")
        keyboardEducationalContentName = readlnOrNull() //Receiving the value via the keyboard

        if (keyboardEducationalContentName.isNullOrEmpty() || !keyboardEducationalContentName.any { it.isLetter() }) {
            println("-----Invalid name!-----".uppercase())
        }
    } while (keyboardEducationalContentName.isNullOrEmpty() || !keyboardEducationalContentName.any { it.isLetter() })

    do { //Repeat execution until it receives 1 or 2 or 3
        println("Select the type of educational content by entering the corresponding number:" +
                "\n1 - Course\n2 - Code challenge\n3 - Project challenge")
        keyboardTypeEducationalContent = readlnOrNull() //Receives user choice between options
        selectionTypeContentEducational = keyboardTypeEducationalContent.toString() //receives the keyboardTypeEducationalContent value


        when (keyboardTypeEducationalContent) {
            "1" -> selectionTypeContentEducational = TypeEducationalContent.COURSE.toString() //changes the value of selectionTypeContentEducational to the value of the enum enums.TypeEducationalContent
            "2" -> selectionTypeContentEducational = TypeEducationalContent.CHALLENGECODE.toString() //changes the value of selectionTypeContentEducational to the value of the enum enums.TypeEducationalContent
            "3" -> selectionTypeContentEducational = TypeEducationalContent.CHALLENGEPROJECT.toString() //changes the value of selectionTypeContentEducational to the value of the enum enums.TypeEducationalContent
        }

        if (keyboardTypeEducationalContent.isNullOrEmpty() || (!keyboardTypeEducationalContent.equals("1") && !keyboardTypeEducationalContent.equals("2") && !keyboardTypeEducationalContent.equals("3"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (keyboardTypeEducationalContent.isNullOrEmpty() || (!keyboardTypeEducationalContent.equals("1") && !keyboardTypeEducationalContent.equals("2") && !keyboardTypeEducationalContent.equals("3")))

    do { //Repeat execution until it receives 1 or 2 or 3
        println("Select the difficulty level of the educational content by entering the corresponding number:" +
                "\n1 - Basic\n2 - Intermediate\n3 - Advanced")
        keyboardDifficultyLevelEducationalContent = readlnOrNull() //Receives user choice between options
        selectionLevelDifficultyEducationalContent = keyboardDifficultyLevelEducationalContent.toString() //receives the value of keyboardDifficultyLevelEducationalContent


        when (keyboardDifficultyLevelEducationalContent) {
            "1" -> selectionLevelDifficultyEducationalContent = LevelDifficulty.BASIC.toString() //changes the selection value selectionLevelDifficultyEducationalContent to the value of the enum enums.LevelDifficulty
            "2" -> selectionLevelDifficultyEducationalContent = LevelDifficulty.INTERMEDIARY.toString() //changes the selection value selectionLevelDifficultyEducationalContent to the value of the enum enums.LevelDifficulty
            "3" -> selectionLevelDifficultyEducationalContent = LevelDifficulty.ADVANCED.toString() //changes the selection value selectionLevelDifficultyEducationalContent to the value of the enums.LevelDifficulty
        }

        if (keyboardDifficultyLevelEducationalContent.isNullOrEmpty() || (!keyboardDifficultyLevelEducationalContent.equals("1") && !keyboardDifficultyLevelEducationalContent.equals("2") && !keyboardDifficultyLevelEducationalContent.equals("3"))) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (keyboardDifficultyLevelEducationalContent.isNullOrEmpty() || (!keyboardDifficultyLevelEducationalContent.equals("1") && !keyboardDifficultyLevelEducationalContent.equals("2") && !keyboardDifficultyLevelEducationalContent.equals("3")))

    do { //Repeats execution while keyboardDurationContentEducational does not receive a value that is not null, empty or not composed entirely of numbers

        println("Enter the duration in whole hours of the educational content:")
        keyboardDurationContentEducational = readlnOrNull() //Receiving the value via the keyboard

        if (keyboardDurationContentEducational.isNullOrEmpty() || !keyboardDurationContentEducational.all { it.isDigit() }) {
            println("-----Invalid duration!-----".uppercase()) //Prints if validation is not passed
        }

    } while (keyboardDurationContentEducational.isNullOrEmpty() || !keyboardDurationContentEducational.all { it.isDigit() })


    val newEducationalContent = ContentEducational() //Educational Content Instance

    val id = (listEducationalContents.maxByOrNull { it.idContentEducational }?.idContentEducational ?: 0) + 1 // Autoincrement of id adds +1 to the largest id in the list

    //val id = listEducationalContents.count() + 1  //id = amount of educational content already included in the listEducational Contents + 1

    newEducationalContent.idContentEducational = id //newEducationalContent of the idContentEducational instance (newEducationalContent) = id
    newEducationalContent.nameContentEducational = keyboardEducationalContentName //EducationalContentName of the nameContentEducational instance (newEducationalContent) = keyboardEducationalContentName
    newEducationalContent.typeContentEducational = selectionTypeContentEducational //EducationalContentName of the typeContentEducational instance (newEducationalContent) = keyboardEducationalContentType
    newEducationalContent.levelDifficultyContentEducational = selectionLevelDifficultyEducationalContent //EducationalContentName of the levelDifficultyContentEducational instance (newEducationalContent) = keyboardEducationalContentDifficultyLevel
    newEducationalContent.durationContentEducational = keyboardDurationContentEducational.toInt() //EducationalContentName of the instance of durationContentEducational (newEducationalContent) = keyboardDurationContentEducational

    //Check if the educational content is not already registered in the system. If you are not registered, registration is done:
    if (listEducationalContents.any { it.equalsIgnoringID(newEducationalContent) }) {
        println("Cadastro de conteúdo educacional falhou: conteúdo educacional já está cadastrado no sistema")
    } else {
        listEducationalContents.add(newEducationalContent) //Registration/Addition of educational content
        println("Adição de conteúdo educacional bem sucedida:\n$newEducationalContent\n") //Addition feedback
    }

    //"Loop" to registerEducationalContent()
    do { //Repeat execution while you wantAddOtherEducationalContent not to receive a value that is not null, empty, without letters or different from "y" and "n"

        println("Would you like to register other educational content? Enter 'y' for yes or 'n' for no")
        val wantAddOtherEducationalContent = readlnOrNull() //Receiving the value via the keyboard

        when (wantAddOtherEducationalContent) {
            "y" -> registerEducationalContent() //Go to function registerEducationalContent()
            "n" -> println("")
        }

        if (wantAddOtherEducationalContent.isNullOrEmpty() || !wantAddOtherEducationalContent.any { it.isLetter() } || (!wantAddOtherEducationalContent.equals("y") && !wantAddOtherEducationalContent.equals("n"))) {
            println("-----Seleção inválida!-----".uppercase())
        } else println("")

    } while (wantAddOtherEducationalContent.isNullOrEmpty() || !wantAddOtherEducationalContent.any { it.isLetter() } || (!wantAddOtherEducationalContent.equals("y") && !wantAddOtherEducationalContent.equals("n")))

    menuContentEducational()
}