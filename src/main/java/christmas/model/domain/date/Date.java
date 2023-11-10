package christmas.model.domain.date;

public class Date {
    private static final int CHRISTMAS_DATE = 25;
    private static final int WEEK = 7;
    private static final int FIRST_FRIDAY = 1;
    private static final int FIRST_SATURDAY = 2;

    private final int date;

    public Date(int date) {
        this.date = date;
    }

    public boolean isSpecialDate() {
        return SpecialDate.checkSpecialDate(this);
    }

    boolean isSameDate(int date) {
        return this.date == date;
    }

    public boolean isWeekEnd() {
        return date % WEEK == FIRST_FRIDAY || date % WEEK == FIRST_SATURDAY;
    }

    public int getDDayFromChristmas() {
        return CHRISTMAS_DATE - date;
    }

    public boolean isAfterChristmas() {
        return date > CHRISTMAS_DATE;
    }
}
