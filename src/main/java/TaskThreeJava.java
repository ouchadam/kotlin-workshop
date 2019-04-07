import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

public class TaskThreeJava {

    /**
     * Step 1
     *
     * Create a copy of the PersonJava with the new age
     */
    public PersonJava updateAge(PersonJava input, int newAge) {
        return new PersonJava(input.firstName, input.lastName, newAge, input.children);
    }

    /**
     * Step 2
     *
     * Create a copy of the PersonJava with the new family name
     * and update all children (and children's children etc)
     */
    public PersonJava updateFamilyName(PersonJava input, String newFamilyName) {
        return recursivelyUpdateFamilyName(input, newFamilyName);
    }

    private PersonJava recursivelyUpdateFamilyName(PersonJava input, String familyName) {
        return new PersonJava(
                input.firstName,
                familyName,
                input.age,
                input.children == null ? null : input.children
                        .stream()
                        .map(personJava -> recursivelyUpdateFamilyName(personJava, familyName))
                        .collect(Collectors.toList())
        );
    }

    /**
     * Step 3
     *
     * Find the youngest PersonJava (taking into account the children's children)
     */
    public PersonJava findYoungestPerson(PersonJava input) {
        return recursivelyFindYoungest(input);
    }

    private PersonJava recursivelyFindYoungest(PersonJava input) {
        return input.children == null ? input : input.children
                .stream()
                .reduce(input.children.get(0), (acc, person) -> {
                    PersonJava youngest = recursivelyFindYoungest(person);
                    return acc.age > youngest.age ? youngest : acc;
                });
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersonJava that = (PersonJava) o;

            if (age != that.age) return false;
            if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
            if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
            return children != null ? children.equals(that.children) : that.children == null;
        }

        @Override
        public int hashCode() {
            int result = firstName != null ? firstName.hashCode() : 0;
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + age;
            result = 31 * result + (children != null ? children.hashCode() : 0);
            return result;
        }
    }

}
