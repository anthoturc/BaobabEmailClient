package com.anthodev.view;

import com.anthodev.EmailManager;
import com.anthodev.controller.AbstractBaseController;
import com.anthodev.controller.LoginWindowController;
import com.anthodev.controller.MainWindowController;
import com.anthodev.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewFactory {

    private final EmailManager emailManager;
    private static final List<Stage> activeStages = new ArrayList<>();

    // View related options
    private Theme theme = Theme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ViewFactory(final EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void setupLoginWindow() {
        final String loginFXMLFileName = "login-window.fxml";
        final AbstractBaseController controller =
                new LoginWindowController(emailManager, this, loginFXMLFileName);

        setupAndShowStage(controller);
    }

    public void setupMainWindow() {
        final String mainFXMLFileName = "main-window.fxml";
        final AbstractBaseController controller =
                new MainWindowController(emailManager, this, mainFXMLFileName);

        setupAndShowStage(controller);
    }

    public void setupOptionsWindow() {
        final String optionsFXMLFileName = "options-window.fxml";
        final AbstractBaseController controller =
                new OptionsWindowController(emailManager, this, optionsFXMLFileName);

        setupAndShowStage(controller);
    }

    public void tearDownStage(final Stage stage) {
        stage.close();
        activeStages.remove(stage);
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    private void setupAndShowStage(final AbstractBaseController controller) {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        // Place active stage into active stages list so that we can apply
        // style changes to all active stages
        activeStages.add(stage);
    }

    public void updateStyles() {
        activeStages.stream()
            .map(Window::getScene)
            .forEach(scene -> {
                scene.getStylesheets().clear();
                scene.getStylesheets().addAll(
                    getClass().getResource(theme.getThemePath()).toExternalForm(),
                    getClass().getResource(fontSize.getFontSizePath()).toExternalForm()
                );
            });
    }

}