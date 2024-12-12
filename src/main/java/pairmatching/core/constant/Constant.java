package pairmatching.core.constant;

public class Constant {
    public static final char OPENING_BRACKET = '[';
    public static final char CLOSING_BRACKET = ']';

    public static final String REGEX_ALPHA_NUMERIC_O = "[a-zA-Z가-힣0-9]+$";
    public static final String REGEX_ALPHA_NUMERIC_X = "[^a-zA-Z가-힣0-9]+$";
    public static final String REGEX_NUMERIC = "[0-9]+";
    public static final String HYPHEN = "-";
    public static final String COMMA = ",";
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";

    public static final String STOP_SIGN = "Q";
    public static final String PAIR_MATCHING_SIGN = "1";
    public static final String PAIR_SEARCH_SIGN = "2";
    public static final String PAIR_RESET_SIGN = "3";

    public static final int COURSE_NAME_IDX = 0;
    public static final int COURSE_LEVEL_IDX = 1;
    public static final int COURSE_MISSION_IDX = 2;


    public static final String SELECT_FUNCTION = "\n기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";

    public static final String PAIR_MATCHING_LIST = "\n#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################\n";

    public static final String REMATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
            "네 | 아니오";

    public static final String PAIR_MATCHING = "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";

    public static final String ANNOUNCE_MATCHING_RESULT = "페어 매칭 결과입니다.\n";
}


