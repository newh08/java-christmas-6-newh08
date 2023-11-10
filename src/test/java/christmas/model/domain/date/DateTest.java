package christmas.model.domain.date;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTest {

    @DisplayName("specialDate 로 Date 를 생성후 확인하면 True 를, 아닌경우는 False 를 반환한다.")
    @Test
    void dateTest_1() {
        Date specialDate = new Date(3);
        Date normalDate = new Date(4);
        assertThat(specialDate.isSpecialDate()).isTrue();
        assertThat(normalDate.isSpecialDate()).isFalse();
    }

    @DisplayName("달력상 주말인 날짜로 Date 를 만들면 True 를, 주말이 아닌 날짜로 Date 를 만들면 false 를 반환한다.")
    @Test
    void dateTest_2() {
        Date weekend = new Date(1);
        Date day = new Date(4);
        assertThat(weekend.isWeekEnd()).isTrue();
        assertThat(day.isWeekEnd()).isFalse();
    }
}