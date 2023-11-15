package christmas.model.domain.event;

import christmas.model.domain.event.benefit.Badge;
import christmas.model.domain.event.benefit.EventBenefits;

public class EventResults {
    private final EventBenefits eventBenefits;
    private final Badge badge;

    public EventResults(EventBenefits eventBenefits, Badge badge) {
        this.eventBenefits = eventBenefits;
        this.badge = badge;
    }

    public static EventResults makeZeroEventResults() {
        return new EventResults(EventBenefits.makeInitialConditionEventBenefits(), Badge.NONE);
    }

    public EventBenefits getEventBenefit() {
        return eventBenefits;
    }

    public Badge getBadge() {
        return badge;
    }
}
