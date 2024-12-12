package menu.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ValidationServiceTest {
    ValidationService validationService = new ValidationService();

    @DisplayName("코치 이름의 길이가 2보다 작고 4보다 큰 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"hihih", "J"})
    void 예외_테스트_코치_이름_길이(String name) {
        List<String> names = new ArrayList<>(Collections.singletonList(name));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validationService.validateNameLength(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 코치의 수가 2보다 작은 경우 예외 발생")
    @Test
    void 예외_테스트_전체_코치_수_2보다_작은_경우() {
        List<String> coachesUnder2 = new ArrayList<>(Collections.singletonList("hihi"));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validationService.validateCoachesNum(coachesUnder2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 코치의 수가 5보다 큰 경우 예외 발생")
    @Test
    void 예외_테스트_전체_코치_수_5보다_큰_경우() {
        List<String> coachesOver5 = new ArrayList<>(Arrays.asList("hihi","hihi","hihi","hihi","hihi","hihi"));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validationService.validateCoachesNum(coachesOver5))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("못 먹는 음식의 종류가 2가지보다 많은 경우 예외 발생")
    @Test
    void 예외_테스트_못_먹는_음식_2보다_큰_경우() {
        List<String> cantEatMenusOver2 = new ArrayList<>(Arrays.asList("불고기","냉면","깐풍기"));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validationService.validateCantEatMenusNum(cantEatMenusOver2))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
