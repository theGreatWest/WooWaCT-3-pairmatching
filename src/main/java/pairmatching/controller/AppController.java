package pairmatching.controller;

import pairmatching.core.constant.Constant;
import pairmatching.model.MatchingInfo;
import pairmatching.service.AppService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class AppController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    public void run(){
        while(true){
            String request = promptReceiveRequest();

            if(request.equalsIgnoreCase(Constant.STOP_SIGN)) break;
            functionStart(request);
        }
    }

    private String promptReceiveRequest(){
        while(true){
            outputView.readRequest();
            try{
                return appService.validateRequest(inputView.readRequest());
            }catch (IllegalArgumentException e){
                outputView.printExceptionMsg(e.getMessage());
            }
        }
    }

    private void functionStart(String request){
        if(request.equalsIgnoreCase(Constant.PAIR_MATCHING_SIGN)) promptReceiveInfo();
//        if(request.equalsIgnoreCase(Constant.PAIR_SEARCH_SIGN))
//        if(request.equalsIgnoreCase(Constant.PAIR_RESET_SIGN))
    }

    private void promptReceiveInfo(){
        outputView.printPairMatchingList();
        while (true){
            outputView.readPairMatching();
            try {
                List<String> infos = appService.validationInfo(inputView.readRequest());
                MatchingInfo matchingInfo = appService.pairMatching(infos);
                if(matchingInfo==null && promptRematching(infos)) matchingInfo = appService.pairMatching(infos);
                if(matchingInfo==null && promptRematching(infos))
                outputView.printMatchingResult(matchingInfo.announcePairResult());
                break;
            }catch (IllegalArgumentException e){
                outputView.printExceptionMsg(e.getMessage());
            }
        }
    }

    private boolean promptRematching(List<String> infos){
        outputView.printRematching();
        while(true){
            try{
                String answer = inputView.readYesNo();
                return appService.validationAnswer(answer);
            }catch (IllegalArgumentException e){
                outputView.printExceptionMsg(e.getMessage());
            }
        }
    }
}
