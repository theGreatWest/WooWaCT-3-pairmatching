package menu.view;

import menu.core.constant.Constant;

public class OutputView {
    public void printStart() {
        System.out.println(Constant.START_MESSAGE);
    }

    public void printCoaches(){
        System.out.println(Constant.INPUT_COACHES_NANE);
    }

    public void printCantEatMenus(String name){
        System.out.println(Constant.NEW_LINE+name+Constant.INPUT_ASK_CANT_EAT_MENUS);
    }

    public void printResult(String recommendResult){
        System.out.println(recommendResult);
    }

    public void printExceptionMsg(String errorMsg) {
        System.out.println(errorMsg);
    }
}
