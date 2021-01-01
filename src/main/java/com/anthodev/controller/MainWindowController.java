package com.anthodev.controller;

import com.anthodev.EmailManager;
import com.anthodev.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;

public class MainWindowController extends AbstractBaseController {

    @FXML
    private TreeView<?> emailTreeView;

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

}