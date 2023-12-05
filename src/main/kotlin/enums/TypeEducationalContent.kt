package enums

enum class TypeEducationalContent { // Types of educational content
    COURSE,
    CHALLENGECODE,
    CHALLENGEPROJECT;

    override fun toString(): String {
        return when (this) {
            COURSE -> "Course"
            CHALLENGECODE -> "Code Challenge"
            CHALLENGEPROJECT -> "Project challenge"
        }
    }
}