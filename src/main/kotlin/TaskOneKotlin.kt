class TaskOneKotlin {

    /**
     * Step 1
     *
     * Create a copy of the BankAccountJava with the new account name
     */
    fun updateAccountName(input: BankAccountKotlin, newName: String): BankAccountKotlin {
        return input
    }

    /**
     * Step 2
     *
     *  Create a copy of the BankAccountJava with the new promotion end timestamp
     *  The promotion is nullable.
     */
    fun updatePromotionEndTimestamp(input: BankAccountKotlin, newPromotionEndTimestamp: Long): BankAccountKotlin {
        return input
    }
}

data class BankAccountKotlin(
    val name: String,
    val balance: Long,
    val promotion: Promotion?
) {
    data class Promotion(val name: String, val endTimestamp: Long)
}