package menu.core.config;

import menu.controller.AppController;
import menu.service.AppService;
import menu.service.DatabaseService;
import menu.service.ValidationService;

public class AppConfig {
    public AppController appController(){
        return new AppController(appService());
    }

    private AppService appService(){
        return new AppService(databaseService(), validatoinService());
    }

    private DatabaseService databaseService(){
        return new DatabaseService();
    }

    private ValidationService validatoinService(){
        return new ValidationService();
    }
}
