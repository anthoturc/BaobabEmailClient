
package com.anthodev.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {

    @FXML
    private Label errorLabel;

    @FXML
    private TextField emailAddressTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    void loginButtonPressed() {
        System.out.println("Clicked!");
    }

}
