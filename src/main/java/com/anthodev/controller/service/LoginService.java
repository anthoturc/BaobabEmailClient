package com.anthodev.controller.service;

import com.anthodev.EmailManager;
import com.anthodev.model.EmailAccount;
import javafx.concurrent.Service;
import javafx.concurrent.Task;


import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import static com.anthodev.controller.service.LoginResult.FAILED_BY_CREDENTIALS;
import static com.anthodev.controller.service.LoginResult.FAILED_BY_NETWORK;
import static com.anthodev.controller.service.LoginResult.FAILED_BY_UNEXPECTED_ERROR;
import static com.anthodev.controller.service.LoginResult.SUCCESS;


public class LoginService extends Service<LoginResult> {

    private final EmailManager emailManager;
    private final EmailAccount emailAccount;

    public LoginService(final EmailManager emailManager, final EmailAccount emailAccount) {
        this.emailManager = emailManager;
        this.emailAccount = emailAccount;
    }

    @Override
    protected Task<LoginResult> createTask() {
        return new Task<>() {
            @Override
            protected LoginResult call() throws Exception {
                return login();
            }
        };
    }

    private LoginResult login() {
        final Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAccount.emailAddress(), emailAccount.password());
            }
        };

        try {
            Session session = Session.getInstance(emailAccount.properties(), authenticator);
            Store store = session.getStore(emailAccount.properties().getProperty("mail.store.protocol"));
            store.connect(
                    emailAccount.properties().getProperty("incomingHost"),
                    emailAccount.emailAddress(),
                    emailAccount.password()
            );
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return FAILED_BY_NETWORK;
        } catch (AuthenticationFailedException e) {
            e.printStackTrace();
            return FAILED_BY_CREDENTIALS;
        } catch (MessagingException e) {
            e.printStackTrace();
            return FAILED_BY_UNEXPECTED_ERROR;
        }

        return SUCCESS;
    }
}
