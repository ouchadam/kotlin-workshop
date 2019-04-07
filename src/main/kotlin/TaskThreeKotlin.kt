class TaskThreeKotlin {

    /**
     * Step 1
     *
     * Create a copy of the PersonKotlin with the new age
     */
    fun updateAge(input: PersonKotlin, newAge: Int): PersonKotlin {
        return input.copy(age = newAge)
    }

    /**
     * Step 2
     *
     * Create a copy of the PersonKotlin with the new family name
     * and update all children (and children's children etc)
     */
    fun updateFamilyName(input: PersonKotlin, newFamilyName: String): PersonKotlin {
        return input.updateFamilyName(newFamilyName)
    }

    /**
     * Step 3
     *
     * Find the youngest PersonKotlin (taking into account the children's children)
     */
    fun findYoungestPerson(input: PersonKotlin): PersonKotlin {
        return input.findYoungest()
    }

}

private fun PersonKotlin.updateFamilyName(familyName: String): PersonKotlin {
    return this.copy(lastName = familyName, children = this.children?.map {
        it.updateFamilyName(familyName)
    })
}

private fun PersonKotlin.findYoungest(): PersonKotlin {
    return this.children?.foldRight(this.children.first()) { acc, person ->
        val youngest = person.findYoungest()
        return if (acc.age > youngest.age) youngest else acc
    } ?: this
}

data class PersonKotlin(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val children: List<PersonKotlin>? = null
)