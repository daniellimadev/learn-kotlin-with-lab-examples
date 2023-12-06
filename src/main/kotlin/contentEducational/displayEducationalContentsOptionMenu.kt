package contentEducational

import application.menuContentEducational

fun displayListEducationalContentsEmpty() {
    do { //Repeat execution while you want toAddEducationalContentKeyboard does not receive a value that is not null, empty, without letters or other than "y" and "n"

        println("Your educational content list is empty. Do you want to add educational content? Enter 'y' for yes or 'n' for no")
        val wantAddEducationalContentKeyboard = readlnOrNull() //Receiving the value via the keyboard

        if (wantAddEducationalContentKeyboard.isNullOrEmpty() || !wantAddEducationalContentKeyboard.any { it.isLetter() }
            || (!wantAddEducationalContentKeyboard.equals("y") && !wantAddEducationalContentKeyboard.equals("n"))) {
            println("-----Invalid selection!-----".uppercase())
        } else if (wantAddEducationalContentKeyboard == "y") registerEducationalContent() //Proceed to register educational content
        else println("Empty educational content list")
    } while (wantAddEducationalContentKeyboard.isNullOrEmpty() || !wantAddEducationalContentKeyboard.any { it.isLetter() }
        || (!wantAddEducationalContentKeyboard.equals("y") && !wantAddEducationalContentKeyboard.equals("n")))
}
fun displayEducationalContents() { //Printing listEducationalContents

    if (listEducationalContents.isEmpty()) displayListEducationalContentsEmpty() //If the educational content list is empty, execute the function displayEducationalContentListEmpty()

    val builder = StringBuilder() //Using StringBuilder to build the string

    for (contentEducational in listEducationalContents) {
        builder.append(contentEducational.toString()) //Adds the toString() of each educational content
        builder.append("\n") //Add a line break between each educational content
    }

    println(builder.toString())
}
fun displayEducationalContentsOptionMenu() { //Version of displayEducationalContentsOptionMenu() for forwarding menuContentEducational()

    if (listEducationalContents.isEmpty()) displayListEducationalContentsEmpty() //If the educational content list is empty, execute the function displayEducationalContentListEmpty()

    val builder = StringBuilder() //Using StringBuilder to build the string

    for (contentEducational in listEducationalContents) {
        builder.append(contentEducational.toString()) //Adds the toString() of each educational content
        builder.append("\n") //Add a line break between each educational content
    }

    println(builder.toString())

    do { //Repeat execution as long as editOtherUser does not receive a value that is not null, empty, without letters or other than "y"

        println("Type 'y' to return to the EDUCATIONAL CONTENT menu")
        val backToMenuEducationalContent = readlnOrNull() //Receiving the value via the keyboard

        when(backToMenuEducationalContent) {
            "y" -> menuContentEducational() //Go to menuContentEducational() function
            "n" -> print("")
        }

    } while (backToMenuEducationalContent.isNullOrEmpty() || !backToMenuEducationalContent.any { it.isLetter() } || (!backToMenuEducationalContent.equals("y")))

}