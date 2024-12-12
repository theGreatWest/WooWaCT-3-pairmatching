package pairmatching.view;

import pairmatching.core.constant.Constant;

public class OutputView {
    public void readRequest() {
        System.out.println(Constant.SELECT_FUNCTION);
    }

    public void readPairMatching() {
        System.out.println(Constant.PAIR_MATCHING);
    }

    public void printMatchingResult(String result){
        System.out.println(result);
    }

    public void printPairMatchingList(){
        System.out.println(Constant.PAIR_MATCHING_LIST);
    }

    public void printRematching(){
        System.out.println(Constant.REMATCHING);
    }

    public void printExceptionMsg(String errorMsg) {
        System.out.println(errorMsg);
    }
}
