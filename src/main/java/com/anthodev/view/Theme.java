package com.anthodev.view;

public enum Theme {
    DEFAULT("/css/default.css"),
    LIGHT("/css/theme/lightTheme.css"),
    DARK("/css/theme/darkTheme.css");

    private final String themePath;

    Theme(final String themePath) {
        this.themePath = themePath;
    }

    public String getThemePath() {
        return themePath;
    }
}