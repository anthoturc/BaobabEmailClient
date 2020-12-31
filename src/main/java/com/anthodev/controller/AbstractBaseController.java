
package com.anthodev.controller;

import com.anthodev.EmailManager;
import com.anthodev.view.ViewFactory;

public abstract class AbstractBaseController {

    private final EmailManager emailManager;
    private final ViewFactory viewFactory;
    private final String currentFXMLView;

    public AbstractBaseController(final EmailManager emailManager,
                                  final ViewFactory viewFactory,
                                  final String currentFXMLView) {

        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.currentFXMLView = currentFXMLView;

    }

}