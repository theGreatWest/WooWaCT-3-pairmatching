package pairmatching.core.config;

import pairmatching.controller.AppController;
import pairmatching.service.AppService;
import pairmatching.service.ValidationService;

public class AppConfig {
    public AppController appController(){
        return new AppController(appService());
    }

    private AppService appService(){
        return new AppService(validatoinService());
    }

    private ValidationService validatoinService(){
        return new ValidationService();
    }
}
