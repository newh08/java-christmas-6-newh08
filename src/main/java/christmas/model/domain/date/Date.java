package christmas.model.domain.date;

public class Date {
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
        return date % 7 == 1 || date % 7 == 2;
    }
}
