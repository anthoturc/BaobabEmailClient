package com.anthodev.controller.service;

import com.anthodev.model.BaobabTreeItem;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;
import java.util.Arrays;
import java.util.List;

public class FetchFoldersService extends Service<Void> {

    private final Store store;
    private final BaobabTreeItem<String> rootFolder;

    public FetchFoldersService(final Store store, final BaobabTreeItem<String> rootFolder) {
        this.store = store;
        this.rootFolder = rootFolder;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<>() {
            @Override
            protected Void call() throws Exception {
                fetchFolders();
                return null;
            }
        };
    }

    private void fetchFolders() throws MessagingException {
        final List<Folder> folders = Arrays.asList(store.getDefaultFolder().list());
        processFolders(folders, rootFolder);
    }

    private void processFolders(final List<Folder> folder, final BaobabTreeItem<String> root) throws MessagingException {

        for (Folder directory : folder) {
            final BaobabTreeItem<String> child = new BaobabTreeItem<>(directory.getName());
            root.getChildren().add(child);
            root.setExpanded(true);
            processFolders(Arrays.asList(directory.list()), child);
        }
    }
}
