package menu.service;

import menu.core.constant.ExceptionMsg;

import java.util.List;

public class ValidationService {
    public void validateNameLength(List<String> names) {
        for (String name : names) {
            int nameLength = name.length();
            if (nameLength < 2 || nameLength > 4)
                throw new IllegalArgumentException(ExceptionMsg.INVALID_NAME_LENGTH.fullErrorMsg());
        }
    }

    public void validateCoachesNum(List<String> names) {
        int coachesNum = names.size();
        if (coachesNum < 2 || coachesNum > 5)
            throw new IllegalArgumentException(ExceptionMsg.INVALID_COACHES_NUM.fullErrorMsg());
    }

    public void validateCantEatMenusNum(List<String> cantEatMenus) {
        int num = cantEatMenus.size();
        if (num > 2) throw new IllegalArgumentException(ExceptionMsg.INVALID_CANT_EAT_MENUS.fullErrorMsg());
    }
}
