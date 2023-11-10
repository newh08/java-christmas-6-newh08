package christmas.model.domain.date;

public class Date {
    private static final int CHRISTMAS_DATE = 25;
    private static final int WEEK = 7;
    private static final int FIRST_FRIDAY = 1;
    private static final int FIRST_SATURDAY = 2;
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 31;
    private static final String INVALID_DATE_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final int date;

    public Date(int date) {
        validateDate(date);
        this.date = date;
    }

    private void validateDate(int date) {
        if (FIRST_DAY > date || date > LAST_DAY) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
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
