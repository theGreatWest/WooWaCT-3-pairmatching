package menu.controller;

import menu.core.constant.Constant;
import menu.model.Coach;
import menu.service.AppService;
import menu.view.InputView;
import menu.view.OutputView;
import menu.core.util.ChangeDataType;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    public void run(){
        outputView.printStart();
        try{
            List<String> names = promptCoaches();
            List<Coach> coaches = promptCantEatMenus(names);
            String recommendResult = appService.startRecommend(coaches);
            outputView.printResult(recommendResult);
        }catch (IllegalArgumentException e) {
            outputView.printExceptionMsg(e.getMessage());
        }
    }

    public List<String> promptCoaches(){
        outputView.printCoaches();
        List<String> coaches = ChangeDataType.stringArrayToList(inputView.readRequest().split(Constant.COMMA));
        try{
            appService.validateCoachesName(coaches);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        return coaches;
    }

    public List<Coach> promptCantEatMenus(List<String> coaches){
        List<Coach> coachesInfo = new ArrayList<>();
        try{
            for(String name : coaches){
                outputView.printCantEatMenus(name);
                List<String> cantEatMenus = ChangeDataType.stringArrayToList(inputView.readRequest().split(Constant.COMMA));
                coachesInfo.add(appService.createCoachInfo(name, cantEatMenus));
            }
        }catch (IllegalArgumentException e){throw new IllegalArgumentException(e.getMessage());}
        return coachesInfo;
    }
}
