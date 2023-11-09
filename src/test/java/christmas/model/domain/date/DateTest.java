package christmas.model.domain.date;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    void dateTest_1() {
        Date specialDate = new Date(3);
        Date normalDate = new Date(4);
        assertThat(specialDate.isSpecialDate()).isTrue();
        assertThat(normalDate.isSpecialDate()).isFalse();
    }

}