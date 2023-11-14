package christmas.model.domain.event;

public class EventResults {
    private final EventBenefits eventBenefits;
    private final Badge badge;

    public EventResults(EventBenefits eventBenefits, Badge badge) {
        this.eventBenefits = eventBenefits;
        this.badge = badge;
    }

    public static EventResults makeInitialEventResults() {
        return new EventResults(EventBenefits.makeInitialConditionEventBenefits(), Badge.NONE);
    }

    public EventBenefits getEventBenefit() {
        return eventBenefits;
    }

    public Badge getBadge() {
        return badge;
    }
}
