class TaskTwoKotlin {

    /**
     * Step 1
     *
     * Write a program that prints the numbers from 1 to 100.
     * But for multiples of three print “Fizz” instead of the number and
     * for the multiples of five print “Buzz”.
     * For numbers which are multiples of both three and five print “FizzBuzz“.
     */
    fun fizzBuzz(): List<String> {
        return (1..100).toList().map { it.toFizBuzz() }
    }

    private fun Int.toFizBuzz() = when {
        this % 3 == 0 && this % 5 == 0 -> "FizzBuzz"
        this % 3 == 0 -> "Fizz"
        this % 5 == 0 -> "Buzz"
        else -> this.toString()
    }
}