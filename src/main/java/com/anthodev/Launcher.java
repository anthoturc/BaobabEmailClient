package com.anthodev;

import com.anthodev.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.setupLoginWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
