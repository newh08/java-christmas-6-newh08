package christmas.model.domain.dto;

import christmas.model.domain.event.Badge;
import christmas.model.domain.event.EventBenefits;

public class EventResultsDto {
    private final EventBenefits eventBenefits;
    private final Badge badge;

    public EventResultsDto(EventBenefits eventBenefits, Badge badge) {
        this.eventBenefits = eventBenefits;
        this.badge = badge;
    }

    public int getTotalDiscount() {
        return eventBenefits.getDiscountBenefit();
    }

    public int getTotalBenefitAmount() {
        return eventBenefits.getTotalBenefit();
    }

    public Badge getBadge() {
        return badge;
    }

    public String getGiftMessage() { return eventBenefits.getGiftMessage();}

    public String getBenefitMessage() {
        return eventBenefits.makeBenefitMessage();
    }
}
