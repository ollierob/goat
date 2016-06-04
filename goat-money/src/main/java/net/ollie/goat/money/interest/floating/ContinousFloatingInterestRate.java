package net.ollie.goat.money.interest.floating;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import net.ollie.goat.money.currency.Currency;
import net.ollie.goat.temporal.date.years.Years;
import net.ollie.goat.money.Money;
import net.ollie.goat.money.interest.curve.YieldCurve;
import net.ollie.goat.temporal.date.count.AccrualFactor;
import net.ollie.goat.money.interest.fixed.ContinuousFixedInterestRate;
import net.ollie.goat.numeric.interpolation.Interpolator;
import net.ollie.goat.numeric.percentage.Percentage;

/**
 *
 * @author ollie
 */
@XmlRootElement
public class ContinousFloatingInterestRate extends FloatingInterestRate {

    @XmlAttribute(name = "spot")
    private LocalDate spot;

    @XmlElementRef(name = "curve")
    private YieldCurve<Years> curve;

    @XmlElementRef(name = "interpolator", required = true)
    private Interpolator<Years, Percentage> interpolator;

    @XmlElementRef(name = "accrual")
    private AccrualFactor accrual;

    @Deprecated
    ContinousFloatingInterestRate() {
    }

    public ContinousFloatingInterestRate(
            final LocalDate spot,
            final YieldCurve<Years> curve,
            final AccrualFactor accrual,
            final Interpolator<Years, Percentage> interpolator) {
        this.spot = spot;
        this.interpolator = interpolator;
        this.curve = curve;
        this.accrual = accrual;
    }

    @Override
    public AccrualFactor accrual() {
        return accrual;
    }

    @Override
    public Percentage spot(final LocalDate date) {
        final Years years = accrual.yearsBetween(spot, date);
        return curve.get(years, interpolator);
    }

    @Override
    public LocalDate spot() {
        return spot;
    }

    @Override
    public Percentage rateOver(final Years term) {
        return curve.get(term, interpolator);
    }

    @Override
    public <C extends Currency> Money<C> accrue(Money<C> money, Percentage forwardRate, LocalDate start, LocalDate end) {
        return new ContinuousFixedInterestRate(forwardRate, accrual).accrue(money, start, end);
    }

    @Override
    public ContinousFloatingInterestRate plus(final Percentage bump) {
        return bump.isZero()
                ? this
                : new ContinousFloatingInterestRate(spot, curve.plus(bump), accrual, interpolator);
    }

}
