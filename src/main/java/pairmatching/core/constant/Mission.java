package pairmatching.core.constant;

public enum Mission {
    CAR("자동차 경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    IMPROVE("성능개선"),
    DISTRIBUTION("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }
}
