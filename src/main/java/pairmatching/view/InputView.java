package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.core.constant.ExceptionMsg;

public class InputView {
    public String readRequest(){
        try{
            return  Console.readLine().trim();
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
