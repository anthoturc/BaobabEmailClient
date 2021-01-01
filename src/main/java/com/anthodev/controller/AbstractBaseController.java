
package com.anthodev.controller;

import com.anthodev.EmailManager;
import com.anthodev.view.ViewFactory;

public abstract class AbstractBaseController {

    private static final String VIEW_PREFIX = "/view/";

    protected final EmailManager emailManager;
    protected final ViewFactory viewFactory;
    private final String fxmlName;

    public AbstractBaseController(final EmailManager emailManager,
                                  final ViewFactory viewFactory,
                                  final String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;

    }

    public String getFxmlName() {
        return VIEW_PREFIX + fxmlName;
    }
}
