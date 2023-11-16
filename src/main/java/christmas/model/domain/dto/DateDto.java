package christmas.model.domain.dto;

import christmas.model.domain.date.Date;

public class DateDto extends Date {
    private final int date;

    public DateDto(int date) {
        super(date);
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
