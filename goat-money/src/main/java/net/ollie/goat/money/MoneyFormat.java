package net.ollie.goat.money;

import net.ollie.goat.currency.Currency;

/**
 *
 */
public enum MoneyFormat {

    SYMBOL_AMOUNT {

        @Override
        public String toString(final Money<?> money) {
            return this.symbol(money.currency()) + " " + money.amount();
        }

        private String symbol(final Currency currency) {
            return currency instanceof Currency
                    ? ((Currency) currency).uniqueSymbol()
                    : currency.toString();
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
