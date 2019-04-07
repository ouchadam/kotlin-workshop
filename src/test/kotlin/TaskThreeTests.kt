import org.junit.Test

class TaskThreeTests {

    private val taskJava = TaskThreeJava()
    private val taskKotlin = TaskThreeKotlin()

    @Test
    fun `step one java - update age`() {
        val newAge = 11
        val inputPerson = createJavaPerson(age = 9)
        val expectedPerson = createJavaPerson(age = newAge)

        taskJava.updateAge(inputPerson, newAge).isEqualTo(expectedPerson)
    }

    @Test
    fun `step one kotlin - update age`() {
        val newAge = 11
        val inputPerson = createKotlinPerson(age = 9)
        val expectedPerson = createKotlinPerson(age = newAge)

        taskKotlin.updateAge(inputPerson, newAge).isEqualTo(expectedPerson)
    }

    @Test
    fun `step two - java family name`() {
        val newFamilyName = "hello world!"
        val inputChild = createJavaPerson(familyName = "any")
        val inputParent = createJavaPerson(familyName = "any", children = listOf(inputChild))
        val expectedChild = createJavaPerson(familyName = newFamilyName)
        val expectedParent = createJavaPerson(familyName = newFamilyName, children = listOf(expectedChild))

        taskJava.updateFamilyName(inputChild, newFamilyName).isEqualTo(expectedChild)
        taskJava.updateFamilyName(inputParent, newFamilyName).isEqualTo(expectedParent)
    }

    @Test
    fun `step two - kotlin family name`() {
        val newFamilyName = "hello world!"
        val inputChild = createKotlinPerson(familyName = "any")
        val inputParent = createKotlinPerson(familyName = "any", children = listOf(inputChild))
        val expectedChild = createKotlinPerson(familyName = newFamilyName)
        val expectedParent = createKotlinPerson(familyName = newFamilyName, children = listOf(expectedChild))

        taskKotlin.updateFamilyName(inputChild, newFamilyName).isEqualTo(expectedChild)
        taskKotlin.updateFamilyName(inputParent, newFamilyName).isEqualTo(expectedParent)
    }

    @Test
    fun `step three - java find the youngest child`() {
        val inputGrandchildA = createJavaPerson(firstName = "a", age = 10)
        val inputGrandchildB = createJavaPerson(firstName = "b", age = 5)
        val inputGrandchildC = createJavaPerson(firstName = "c", age = 1)
        val inputParent = createJavaPerson(
            familyName = "any",
            children = listOf(inputGrandchildA, inputGrandchildB, inputGrandchildC)
        )
        val inputGrandParent = createJavaPerson(familyName = "any", children = listOf(inputParent))

        assert(taskJava.findYoungestPerson(inputGrandParent) == inputGrandchildC)
    }

    @Test
    fun `step three - kotlin find the youngest child`() {
        val inputGrandchildA = createKotlinPerson(firstName = "a", age = 10)
        val inputGrandchildB = createKotlinPerson(firstName = "b", age = 5)
        val inputGrandchildC = createKotlinPerson(firstName = "c", age = 1)
        val inputParent = createKotlinPerson(
            familyName = "any",
            children = listOf(inputGrandchildA, inputGrandchildB, inputGrandchildC)
        )
        val inputGrandParent = createKotlinPerson(familyName = "any", children = listOf(inputParent))

        assert(taskKotlin.findYoungestPerson(inputGrandParent) == inputGrandchildC)
    }
}

private fun createKotlinPerson(
    firstName: String = "first name",
    age: Int = 50,
    familyName: String = "familyName",
    children: List<PersonKotlin>? = null
) = PersonKotlin(firstName, familyName, age, children)

private fun createJavaPerson(
    firstName: String = "first name",
    age: Int = 50,
    familyName: String = "familyName",
    children: List<TaskThreeJava.PersonJava>? = null
) = TaskThreeJava.PersonJava(firstName, familyName, age, children)

private fun PersonKotlin.isEqualTo(expected: PersonKotlin) {
    assert(this == expected)
}

private fun TaskThreeJava.PersonJava.isEqualTo(expected: TaskThreeJava.PersonJava) {
    assert(this == expected)
}
