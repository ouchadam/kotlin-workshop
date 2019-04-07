import org.jetbrains.annotations.Nullable;

public class TaskOneJava {

    /**
     * Step 1
     *
     * Create a copy of the BankAccountJava with the new account name
     */
    public BankAccountJava updateAccountName(BankAccountJava input, String newName) {
        return new BankAccountJava(newName, input.balance, input.promotion);
    }

    /**
     * Step 2
     *
     *  Create a copy of the BankAccountJava with the new promotion end timestamp
     *  The promotion is nullable.
     */
    public BankAccountJava updatePromotionEndTimestamp(BankAccountJava input, long newPromotionEndTimestamp) {
        return new BankAccountJava(
                input.name,
                input.balance,
                input.promotion == null ? null : new BankAccountJava.Promotion(input.promotion.name, newPromotionEndTimestamp));
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

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Promotion promotion = (Promotion) o;

                if (endTimestamp != promotion.endTimestamp) return false;
                return name != null ? name.equals(promotion.name) : promotion.name == null;
            }

            @Override
            public int hashCode() {
                int result = name != null ? name.hashCode() : 0;
                result = 31 * result + (int) (endTimestamp ^ (endTimestamp >>> 32));
                return result;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BankAccountJava that = (BankAccountJava) o;

            if (balance != that.balance) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            return promotion != null ? promotion.equals(that.promotion) : that.promotion == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (int) (balance ^ (balance >>> 32));
            result = 31 * result + (promotion != null ? promotion.hashCode() : 0);
            return result;
        }
    }
}
