package christmas.model.domain.event.benefit.gift;

import java.util.stream.Stream;

public interface Gift {

    int getGiftBenefit();

    String makeGiftMessage();

    Stream<String> makeGiftBenefitMessageStream();
}
