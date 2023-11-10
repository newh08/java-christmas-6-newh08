package christmas.model.domain.dto;

import christmas.model.domain.event.Badge;
import christmas.model.domain.event.Gift;
import christmas.model.domain.event.TotalDiscount;
import java.util.stream.Stream;

public class EventResultsDto {
    private final TotalDiscount totalDiscount;
    private final Gift gift;
    private final int totalBenefitAmount;
    private final Badge badge;

    public EventResultsDto(TotalDiscount totalDiscount, Gift gift, int totalBenefitAmount, Badge badge) {
        this.totalDiscount = totalDiscount;
        this.gift = gift;
        this.totalBenefitAmount = totalBenefitAmount;
        this.badge = badge;
    }

    public int getTotalDiscount() {
        return totalDiscount.getTotalDiscount();
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public Badge getBadge() {
        return badge;
    }

    public String getGiftMessage() {
        return gift.getGiftMessage();
    }

    public Stream<String> getDiscountMessage() {
        return totalDiscount.makeMessageStream();
    }
}
