
package com.anthodev.controller;

import com.anthodev.EmailManager;

import com.anthodev.controller.service.LoginService;
import com.anthodev.model.EmailAccount;
import com.anthodev.model.ImmutableEmailAccount;
import com.anthodev.view.ViewFactory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends AbstractBaseController implements Initializable {

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
        if (validateInputFields()) {
            attemptEmailLogin();
        }
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        emailAddressTextField.setText("email@email.com");
        passwordTextField.setText("1234");
    }

    private void attemptEmailLogin() {

        final EmailAccount emailAccount = ImmutableEmailAccount.builder()
                .emailAddress(emailAddressTextField.getText())
                .password(passwordTextField.getText())
                .build();

        final LoginService loginService = new LoginService(emailManager, emailAccount);
        loginService.start();
        loginService.setOnSucceeded(workerStateEvent -> {

            switch (loginService.getValue()) {
                case SUCCESS:
                    viewFactory.setupMainWindow();
                    Stage stage = (Stage) errorLabel.getScene().getWindow();
                    viewFactory.tearDownStage(stage);
                    break;
                case FAILED_BY_CREDENTIALS:
                    errorLabel.setText("Invalid credentials passed!");
                    break;
                case FAILED_BY_NETWORK:
                    errorLabel.setText("Networking error. Try again later");
                    break;
                case FAILED_BY_UNEXPECTED_ERROR:
                    errorLabel.setText("Unexpected failure!");
                    break;
                default:
                    break;
            }

        });
    }

    private boolean validateInputFields() {

        if (emailAddressTextField.getText().isEmpty()) {
            errorLabel.setText("Email is required");
            return false;
        }

        if (passwordTextField.getText().isEmpty()) {
            errorLabel.setText("Password is required");
            return false;
        }

        return true;
    }

}
