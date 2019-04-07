import org.jetbrains.annotations.Nullable;

public class TaskOneJava {

    /**
     * Step 1
     *
     * Create a copy of the BankAccountJava with the new account name
     */
    public BankAccountJava updateAccountName(BankAccountJava input, String newName) {
        return input;
    }

    /**
     * Step 2
     *
     *  Create a copy of the BankAccountJava with the new promotion end timestamp
     *  The promotion is nullable.
     */
    public BankAccountJava updatePromotionEndTimestamp(BankAccountJava input, long newPromotionEndTimestamp) {
        return input;
    }

    public static class BankAccountJava {

        final String name;
        final long balance;
        @Nullable final Promotion promotion;

        public BankAccountJava(String name, long balance, @Nullable Promotion promotion) {
            this.name = name;
            this.balance = balance;
            this.promotion = promotion;
        }

        static class Promotion {

            final String name;
            final long endTimestamp;

            Promotion(String name, long endTimestamp) {
                this.name = name;
                this.endTimestamp = endTimestamp;
            }
        }
    }
}
