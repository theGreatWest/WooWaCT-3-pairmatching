package pairmatching;

import pairmatching.controller.AppController;
import pairmatching.core.config.AppConfig;
import pairmatching.core.util.ReadFile;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        AppController appController = appConfig.appController();

        appController.run();
    }
}
