package com.anthodev.model;

import javafx.scene.control.TreeItem;

public class BaobabTreeItem<String> extends TreeItem<String> {

    private final String name;

    public BaobabTreeItem(final String name) {
        super(name);
        this.name = name;
    }



}
