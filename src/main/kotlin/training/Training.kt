package training

import contentEducational.ContentEducational
import user.User

data class Training (var idTraining: Int, var nameTraining: String, var levelDifficultyTraining: String){

    constructor() : this(0, "", "")

    var registeredTraining = mutableListOf<User>()
    var contentTraining = mutableListOf<ContentEducational>()
    var durationTraining : Int = 0

    override fun toString(): String { //Customization of the formation display using the toString() method

        var builder = StringBuilder()

        builder.append("--------------------------------------------------\n")
        builder.append("ID: $idTraining | NAME: $nameTraining\n↳ LEVELS: $levelDifficultyTraining | DURAÇÃO: ${durationTraining}h")
        builder.append("\n")
        builder.append("\nLIST OF CONTENTS:\n")
        contentTraining.forEach{contentEducational -> builder.append("\t$contentEducational\n")}
        builder.append("\nSUBSCRIBER LIST:\n")
        registeredTraining.forEach{user -> builder.append("\t$user\n") }
        builder.append("--------------------------------------------------")

        return builder.toString()
    }
}