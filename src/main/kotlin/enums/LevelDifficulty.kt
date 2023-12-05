package enums

enum class LevelDifficulty { //Difficulty levels
    BASIC,
    INTERMEDIARY,
    ADVANCED;

    override fun toString() : String {
        return when (this) {
            BASIC -> "Basic"
            INTERMEDIARY -> "Intermediary"
            ADVANCED -> "Advanced"
        }
    }
}