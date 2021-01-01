package com.anthodev.view;

public enum FontSize {
    SMALL("/css/font/smallFont.css"),
    MEDIUM("/css/font/mediumFont.css"),
    BIG("/css/font/bigFont.css");

    private final String fontSizePath;

    FontSize(final String fontSizePath) {
        this.fontSizePath = fontSizePath;
    }

    public String getFontSizePath() {
        return fontSizePath;
    }
}