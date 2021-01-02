package com.anthodev;

import com.anthodev.controller.service.FetchFoldersService;
import com.anthodev.model.BaobabTreeItem;
import com.anthodev.model.EmailAccount;
import javafx.scene.control.TreeItem;

import javax.mail.Store;

public class EmailManager {

    private final BaobabTreeItem<String> rootFolder;

    public EmailManager() {
        this.rootFolder = new BaobabTreeItem<>("root-placeholder");
    }

    public TreeItem<String> getRootFolder() {
        return rootFolder;
    }

    public void addEmailAccount(final EmailAccount emailAccount, final Store store) {
        final BaobabTreeItem<String> emailRoot = new BaobabTreeItem<>(emailAccount.emailAddress());
        final FetchFoldersService fetchFoldersService = new FetchFoldersService(store, emailRoot);
        fetchFoldersService.start();
        rootFolder.getChildren().add(emailRoot);
    }

}