package com.anthodev.view;

import com.anthodev.EmailManager;

public class ViewFactory {

    private final EmailManager emailManager;

    public ViewFactory(final EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void showLoginWindow() {
        System.out.println("Login window shown");
    }

}