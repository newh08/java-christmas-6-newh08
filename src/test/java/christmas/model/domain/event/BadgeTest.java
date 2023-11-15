package christmas.model.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.event.benefit.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @DisplayName("혜택 금액에 따라 알맞은 배지 등급을 반환한다.")
    @Test
    void badgeTest_1() {
        Badge badge_1 = Badge.getBadge(4999);
        assertThat(badge_1).isEqualTo(Badge.NONE);
        Badge badge_2 = Badge.getBadge(5000);
        assertThat(badge_2).isEqualTo(Badge.STAR);
        Badge badge_3 = Badge.getBadge(9999);
        assertThat(badge_3).isEqualTo(Badge.STAR);
        Badge badge_4 = Badge.getBadge(10000);
        assertThat(badge_4).isEqualTo(Badge.TREE);
    }
}