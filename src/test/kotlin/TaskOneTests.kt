import TaskOneJava.*
import org.junit.Test

class TaskOneTests {

    private val taskJava = TaskOneJava()
    private val taskKotlin = TaskOneKotlin()

    @Test
    fun `step one java - update account name`() {
        val newAccountName = "awesome account"
        val inputAccount = createJavaBankAccount(name = "old name")
        val expectedAccount = createJavaBankAccount(name = newAccountName)

        taskJava.updateAccountName(inputAccount, newAccountName).isEqualTo(expectedAccount)
    }

    @Test
    fun `step one kotlin - update account name`() {
        val newAccountName = "awesome account"
        val inputAccount = createKolinBankAccount(name = "old name")
        val expectedAccount = createKolinBankAccount(name = newAccountName)

        taskKotlin.updateAccountName(inputAccount, newAccountName).isEqualTo(expectedAccount)
    }

    @Test
    fun `step two java - update promotion end timestamp`() {
        val newPromotionEndTimestamp: Long = 10000
        val inputAccountWithoutPromotion = createJavaBankAccount(promotion = null)
        val inputAccount = createJavaBankAccount(promotion = BankAccountJava.Promotion("big deal", 0))
        val expectedAccount = createJavaBankAccount(
            promotion = BankAccountJava.Promotion("big deal", newPromotionEndTimestamp)
        )

        taskJava.updatePromotionEndTimestamp(
            inputAccountWithoutPromotion,
            newPromotionEndTimestamp
        ).isEqualTo(inputAccountWithoutPromotion)

        taskJava.updatePromotionEndTimestamp(
            inputAccount,
            newPromotionEndTimestamp
        ).isEqualTo(expectedAccount)
    }

    @Test
    fun `step two kotlin - update promotion end timestamp`() {
        val newPromotionEndTimestamp: Long = 10000
        val inputAccountWithoutPromotion = createKolinBankAccount(promotion = null)
        val inputAccount = createKolinBankAccount(promotion = BankAccountKotlin.Promotion("big deal", 0))
        val expectedAccount = createKolinBankAccount(
            promotion = BankAccountKotlin.Promotion(
                "big deal",
                newPromotionEndTimestamp
            )
        )

        taskKotlin.updatePromotionEndTimestamp(inputAccountWithoutPromotion, newPromotionEndTimestamp)
            .isEqualTo(inputAccountWithoutPromotion)
        taskKotlin.updatePromotionEndTimestamp(inputAccount, newPromotionEndTimestamp)
            .isEqualTo(expectedAccount)
    }

}

private fun createJavaBankAccount(
    name: String = "account",
    balance: Long = 100000,
    promotion: TaskOneJava.BankAccountJava.Promotion? = null
) = BankAccountJava(name, balance, promotion)

private fun createKolinBankAccount(
    name: String = "account",
    balance: Long = 100000,
    promotion: BankAccountKotlin.Promotion? = null
) = BankAccountKotlin(name, balance, promotion)

private fun BankAccountKotlin.isEqualTo(expected: BankAccountKotlin) {
    assert(this == expected)
}

private fun TaskOneJava.BankAccountJava.isEqualTo(expected: TaskOneJava.BankAccountJava) {
    assert(this == expected)
}