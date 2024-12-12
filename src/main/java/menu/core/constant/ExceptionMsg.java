package menu.core.constant;

public enum ExceptionMsg {
    ERROR_SIGN("[ERROR] "),
    INVALID_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자여야 합니다."),
    INVALID_COACHES_NUM("코치는 최소 2명, 최대 5명이어야 합니다."),
    INVALID_CANT_EAT_MENUS("못 먹는 음식은 최소 0개, 최대 2개여야 합니다."),
    INVALID_ETC("잘못된 입력입니다.");

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
}
