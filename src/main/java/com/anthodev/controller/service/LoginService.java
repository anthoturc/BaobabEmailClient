package com.anthodev.controller.service;

import com.anthodev.EmailManager;
import com.anthodev.model.EmailAccount;

import static com.anthodev.controller.service.LoginResult.SUCCESS;

public class LoginService {

    private final EmailManager emailManager;
    private final EmailAccount emailAccount;

    public LoginService(final EmailManager emailManager, final EmailAccount emailAccount) {
        this.emailManager = emailManager;
        this.emailAccount = emailAccount;
    }

    public LoginResult login() {
        return SUCCESS;
    }

}
