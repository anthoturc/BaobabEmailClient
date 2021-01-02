package com.anthodev.controller;

import com.anthodev.EmailManager;
import com.anthodev.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends AbstractBaseController implements Initializable {

    @FXML
    private TreeView<String> emailTreeView;

    @FXML
    private TableView<?> emailTableView;

    public MainWindowController(final EmailManager emailManager,
                                final ViewFactory viewFactory,
                                final String currentFXMLView) {
        super(emailManager, viewFactory, currentFXMLView);
    }

    @FXML
    void optionsPressed() {
        viewFactory.setupOptionsWindow();
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        setupEmailFolderTreeView();
    }

    private void setupEmailFolderTreeView() {

        emailTreeView.setRoot(emailManager.getRootFolder());
        emailTreeView.setShowRoot(false);
    }


}