package christmas.model.domain.dto;

public class RequestDateDto {
    private final int date;

    public RequestDateDto(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
