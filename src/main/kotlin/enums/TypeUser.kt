package enums

enum class TypeUser { // Type Users
    INSTRUCTOR,
    STUDENT;

    override fun toString(): String {
        return when (this) {
            INSTRUCTOR -> "Instructor"
            STUDENT -> "Student"
        }
    }
}