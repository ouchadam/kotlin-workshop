import java.util.ArrayList;
import java.util.List;

public class TaskTwoJava {

    /**
     *
     * Write a program that prints the numbers from 1 to 100.
     * But for multiples of three print “Fizz” instead of the number and
     * for the multiples of five print “Buzz”.
     * For numbers which are multiples of both three and five print “FizzBuzz“.
     */
    public List<String> fizzBuzz() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(toValue(i + 1));
        }
        return result;
    }

    private String toValue(int input) {
        if (input %  3 == 0 && input % 5 == 0) {
            return "FizzBuzz";
        } else if (input % 3 == 0) {
            return "Fizz";
        } else if (input % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(input);
        }
    }
}
