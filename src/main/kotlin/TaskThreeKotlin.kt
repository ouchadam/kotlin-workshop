class TaskThreeKotlin {

    /**
     * Step 1
     *
     * Create a copy of the PersonKotlin with the new age
     */
    fun updateAge(input: PersonKotlin, newAge: Int): PersonKotlin {
        return input
    }

    /**
     * Step 2
     *
     * Create a copy of the PersonKotlin with the new family name
     * and update all children (and children's children etc)
     */
    fun updateFamilyName(input: PersonKotlin, newFamilyName: String): PersonKotlin {
        return input
    }

    /**
     * Step 3
     *
     * Find the youngest PersonKotlin (taking into account the children's children)
     */
    fun findYoungestPerson(input: PersonKotlin): PersonKotlin {
        return input
    }

}

data class PersonKotlin(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val children: List<PersonKotlin>? = null
)