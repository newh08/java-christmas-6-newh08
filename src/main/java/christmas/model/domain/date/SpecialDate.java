package christmas.model.domain.date;

import java.util.Arrays;

public enum SpecialDate {
    THREE(3), TEN(10), TWELVE(12), SEVENTEEN(17), TWENTY_FOUR(24), TWENTY_FIVE(25), THIRTY_ONE(31);
    private final int specialDate;

    SpecialDate(int specialDate) {
        this.specialDate = specialDate;
    }

    public static boolean checkSpecialDate(Date date) {
        return Arrays.stream(values())
                .map(specialDate -> specialDate.specialDate)
                .anyMatch(date::isSameDate);
    }
}
