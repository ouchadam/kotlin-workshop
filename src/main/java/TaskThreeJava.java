import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TaskThreeJava {

    /**
     * Step 1
     *
     * Create a copy of the PersonJava with the new age
     */
    public PersonJava updateAge(PersonJava input, int newAge) {
        return input;
    }

    /**
     * Step 2
     *
     * Create a copy of the PersonJava with the new family name
     * and update all children (and children's children etc)
     */
    public PersonJava updateFamilyName(PersonJava input, String newFamilyName) {
        return input;
    }

    /**
     * Step 3
     *
     * Find the youngest PersonJava (taking into account the children's children)
     */
    public PersonJava findYoungestPerson(PersonJava input) {
        return input;
    }

    public static class PersonJava {

        final String firstName;
        final String lastName;
        final int age;
        @Nullable
        final List<PersonJava> children;

        PersonJava(String firstName, String lastName, int age, @Nullable List<PersonJava> children) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.children = children;
        }
    }

}
