package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.core.constant.ExceptionMsg;

public class InputView {
    public String readRequest(){
        try{
            String request = Console.readLine().trim();

            return request;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ExceptionMsg.INVALID_ETC.fullErrorMsg());
        }
    }

    public String readYesNo() {
        try {
            String answer = Console.readLine().trim();

            return answer;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ExceptionMsg.INVALID_ETC.fullErrorMsg());
        }
    }
}
