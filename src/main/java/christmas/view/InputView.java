package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String REGEX_OF_ORDER = "^([가-힣| ]+-[1-9| ]+[0-9| ]?,?)*";
    private static final String DELIMITER_QUANTITY = "-";
    private static final String DELIMITER_MENU = ",";
    private static final String INVALID_DATE_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String INVALID_ORDER_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public int readDate() {
        System.out.println(INPUT_DATE_MESSAGE);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }

    public Map<String, Integer> readOrders() {
        System.out.println(INPUT_ORDER_MESSAGE);
        String inputString = Console.readLine();
        validateInputByRegex(inputString);
        Map<String, Integer> map = new HashMap<>();
        try {
            String[] inputOrders = inputString.split(DELIMITER_MENU);
            collectInputOrder(map, inputOrders);
            return map;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    private void validateInputByRegex(String input) {
        if (Pattern.matches(REGEX_OF_ORDER, input)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
    }

    private static void collectInputOrder(Map<String, Integer> map, String[] inputOrders) {
        for (String inputOrder : inputOrders) {
            String[] orderInformation = inputOrder.split(DELIMITER_QUANTITY);
            String menu = orderInformation[0].trim();
            int quantity = Integer.parseInt(orderInformation[1].trim());
            map.put(menu, quantity);
        }
    }
}
