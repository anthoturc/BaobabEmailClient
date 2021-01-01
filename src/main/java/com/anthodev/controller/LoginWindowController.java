
package com.anthodev.controller;

import com.anthodev.EmailManager;
import com.anthodev.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends AbstractBaseController {

    @FXML
    private Label errorLabel;

    @FXML
    private TextField emailAddressTextField;

    @FXML
    private PasswordField passwordTextField;

    public LoginWindowController(final EmailManager emailManager,
                                 final ViewFactory viewFactory,
                                 final String currentFXMLView) {
        super(emailManager, viewFactory, currentFXMLView);
    }

    @FXML
    void loginButtonPressed() {
        viewFactory.setupMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.tearDownStage(stage);
    }

}
