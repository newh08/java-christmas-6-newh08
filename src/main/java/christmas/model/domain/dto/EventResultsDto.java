package christmas.model.domain.dto;

import christmas.model.domain.event.Badge;
import christmas.model.domain.event.EventBenefits;
import java.util.stream.Stream;

public class EventResultsDto {
    private final EventBenefits eventBenefits;
    private final int totalBenefitAmount;
    private final Badge badge;

    public EventResultsDto(EventBenefits eventBenefits, int totalBenefitAmount, Badge badge) {
        this.eventBenefits = eventBenefits;
        this.totalBenefitAmount = totalBenefitAmount;
        this.badge = badge;
    }

    public int getTotalDiscount() {
        return eventBenefits.getTotalDiscount();
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public Badge getBadge() {
        return badge;
    }

    public String getGiftMessage() { return eventBenefits.getGiftMessage();}

    public Stream<String> getBenefitMessage() {
        return eventBenefits.makeBenefitMessageStream();
    }
}
