package contentEducational

data class ContentEducational (var idContentEducational: Int,
                               var nameContentEducational: String,
                               var typeContentEducational: String,
                               var levelDifficultyContentEducational: String,
                               var durationContentEducational: Int){
    constructor() : this(0, "", "", "", 1)

    override fun toString(): String {
        return "ID: $idContentEducational | " +
                "NAME: $nameContentEducational\n\t↳ TYPE: $typeContentEducational | " +
                "LEVEL: $levelDifficultyContentEducational | " +
                "DURATION: $durationContentEducational" + "h"
    }
}