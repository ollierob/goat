package net.ollie.goat.money;

/**
 *
 */
public enum MoneyFormat {

    SYMBOL_AMOUNT {

        @Override
        public String toString(final Money<?> money) {
            return money.currency().uniqueSymbol() + " " + money.amount();
        }

    },
    CURRENCY_AMOUNT {

        @Override
        public String toString(final Money<?> money) {
            return money.currency() + " " + money.amount();
        }

    },
    AMOUNT_CURRENCY {

        @Override
        public String toString(final Money<?> money) {
            return money.amount() + " " + money.currency();
        }

    };

    public abstract String toString(Money<?> money);

}
