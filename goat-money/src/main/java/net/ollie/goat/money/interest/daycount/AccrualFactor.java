package net.ollie.goat.money.interest.daycount;

/**
 *
 * @author Ollie
 */
public interface AccrualFactor extends DayCount, YearCount {

    AccrualFactor ACT_ACT = ActualActualAccrualFactor.ACT_ACT;
    AccrualFactor ACT_365 = ActualFixedAccrualFactor.ACT_365;

}
