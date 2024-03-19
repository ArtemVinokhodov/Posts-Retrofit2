package org.task.utils;

import org.task.controller.AppController;
import org.task.model.AppModel;
import org.task.view.AppView;

public class AppStarter {

    public static void startApp() {
        AppModel appModel = new AppModel();
        AppView appView = new AppView();
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}
