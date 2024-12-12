package pairmatching.core.constant;

public enum ExceptionMsg {
    ERROR_SIGN("[ERROR] "),
    NO_MATCHING_HISTORY("매칭 이력이 없습니다."),
    INVALID_ETC("잘못된 입력입니다. 다시 입력해 주세요.");

    private final String errorMsg;

    ExceptionMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String errorMsgOnly() {
        return errorMsg;
    }

    public String fullErrorMsg() {
        return ERROR_SIGN.errorMsg + errorMsgOnly();
    }
//    INVALID_ETC.fullErrorMsg() : 전체 에러 메세지 출력
//    ERROR_SIGN.errorMsg : 에러 사인만 출력
}
