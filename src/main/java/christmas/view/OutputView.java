package christmas.view;

import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.RequestOrdersDto;

public class OutputView {
    private static final String RESULT_PRINT_OPENING_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDERED_MENU = "\n<주문 메뉴>";
    private static final String TOTAL_PRICE_BEFORE_DISCOUNT = "\n<할인 전 총주문 금액>";
    private static final String GIFT_MENU = "\n<증정 메뉴>";
    private static final String BENEFIT_LIST = "\n<혜택 내역>";
    private static final String AMOUNT_OF_BENEFIT = "\n<총혜택 금액>";
    private static final String TOTAL_PRICE_AFTER_DISCOUNT = "\n<할인 후 예상 결제 금액>";
    private static final String DECEMBER_BADGE = "\n<12월 이벤트 배지>";
    private static final String FORMAT_OF_PRICE = "%,d원\n";
    private static final String EMPTY = "없음";

    public void printStartOfBenefitInfo(DateDto dateDto) {
        System.out.printf(RESULT_PRINT_OPENING_MESSAGE, dateDto.getDate());
    }

    public void printOrder(RequestOrdersDto requestOrdersDto) {
        System.out.println(ORDERED_MENU);
        System.out.println(requestOrdersDto.getOrdersMessage());
    }

    public void printTotalOrderPrice(RequestOrdersDto requestOrdersDto) {
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT);
        System.out.printf(FORMAT_OF_PRICE, requestOrdersDto.getTotalOrderPrice());
    }

    public void printEventResult(EventResultsDto eventResultsDto, RequestOrdersDto requestOrdersDto) {
        printGift(eventResultsDto);
        printTotalBenefit(eventResultsDto);
        printTotalBenefitAmount(eventResultsDto);
        printAfterDiscount(requestOrdersDto, eventResultsDto);
        printBadge(eventResultsDto);
    }

    private void printGift(EventResultsDto eventResultsDto) {
        System.out.println(GIFT_MENU);
        System.out.println(eventResultsDto.getGiftMessage());
    }

    private void printTotalBenefit(EventResultsDto eventResultsDto) {
        System.out.println(BENEFIT_LIST);
        String benefitMessage = eventResultsDto.getBenefitMessage();

        if (benefitMessage.isEmpty()) {
            System.out.println(EMPTY);
            return;
        }
        System.out.println(benefitMessage);
    }

    private void printTotalBenefitAmount(EventResultsDto eventResultsDto) {
        System.out.println(AMOUNT_OF_BENEFIT);
        System.out.printf(FORMAT_OF_PRICE, eventResultsDto.getTotalBenefitAmount());
    }

    private void printAfterDiscount(RequestOrdersDto requestOrdersDto, EventResultsDto eventResultsDto) {
        System.out.println(TOTAL_PRICE_AFTER_DISCOUNT);
        int finalPrice = requestOrdersDto.getTotalOrderPrice() + eventResultsDto.getTotalDiscount();
        System.out.printf(FORMAT_OF_PRICE, finalPrice);
    }

    private void printBadge(EventResultsDto eventResultsDto) {
        System.out.println(DECEMBER_BADGE);
        System.out.println(eventResultsDto.getBadge());
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
