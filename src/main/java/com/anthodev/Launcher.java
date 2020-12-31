package com.anthodev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final Parent parent =
                FXMLLoader.load(this.getClass().getResource("/view/login-window.fxml"));

        final Scene scene = new Scene(parent);

        stage.setTitle("Basic button");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
