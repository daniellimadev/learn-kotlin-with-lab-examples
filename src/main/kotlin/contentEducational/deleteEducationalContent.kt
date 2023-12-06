package contentEducational

import application.menuContentEducational

fun deleteEducationalContent() { //Function to remove educational content

    if (listEducationalContents.isEmpty()) displayListEducationalContentsEmpty() //If the educational content list is empty, execute the function displayEducationalContentListEmpty()

    println("----- List of registered educational content -----\n".uppercase())
    displayEducationalContents()

    //options variable receives the values of each educational content id from theEducational Contents list
    val options = mutableListOf<String>()
    for (contentEducational in listEducationalContents) {
        val option = contentEducational.idContentEducational
        options.add(option.toString())
    }

    var selectionRemovalEducationalContent: String? //Variable that will receive an option informed by keyboard in the following do/while

    do { //Repeat execution until it receives a value corresponding to any of the values of the options variable

        println("Enter the ID of the educational content you want to delete:")
        selectionRemovalEducationalContent = readlnOrNull() //Receiving the value via the keyboard

        if (!options.contains(selectionRemovalEducationalContent)) {
            println("-----Invalid selection!-----".uppercase()) //Prints if validation is not passed
        }

    } while (!options.contains(selectionRemovalEducationalContent))

    val idEducationalContent = selectionRemovalEducationalContent!!.toInt() //Receives the value of the selected id
    val contentSelected = listEducationalContents.find { it.idContentEducational == idEducationalContent } //Receives the selected content

    if (contentSelected != null) { //Removal with feedback
        val removed = listEducationalContents.remove(contentSelected)

        if (removed) {
            println("Successful removal of:\n$contentSelected!\n")
        } else println("Removal failed")
    }

    if (listEducationalContents.isNotEmpty()) {

        //"Loop" of deleteEducationalContent()
        do { //Repeat execution while you wantDeleteOtherEducationalContent not to receive a value that is not null, empty, without letters or different from "y" and "n"

            println("Would you like to delete other educational content? Enter 'y' for yes or 'n' for no")
            val wantDeleteOtherEducationalContent = readlnOrNull() //Receiving the value via the keyboard

            when (wantDeleteOtherEducationalContent) {
                "y" -> deleteEducationalContent() //Go to deleteEducationalContent() function
                "n" -> println("")
            }

            if (wantDeleteOtherEducationalContent.isNullOrEmpty() || !wantDeleteOtherEducationalContent.any { it.isLetter() } || (!wantDeleteOtherEducationalContent.equals("y")
                        && !wantDeleteOtherEducationalContent.equals("n"))) {
                println("-----Invalid selection!-----".uppercase())
            } else println("")

        } while (wantDeleteOtherEducationalContent.isNullOrEmpty() || !wantDeleteOtherEducationalContent.any { it.isLetter() } || (!wantDeleteOtherEducationalContent.equals("y")
                    && !wantDeleteOtherEducationalContent.equals("n")))

    } else {
        println("There is no more educational content to remove")
    }
    menuContentEducational()
}