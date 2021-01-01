package com.anthodev.controller;

import com.anthodev.EmailManager;
import com.anthodev.view.FontSize;
import com.anthodev.view.Theme;
import com.anthodev.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends AbstractBaseController implements Initializable {

    @FXML
    private Slider fontSizeSlider;

    @FXML
    private ChoiceBox<Theme> themeDropdown;

    public OptionsWindowController(final EmailManager emailManager,
                                   final ViewFactory viewFactory,
                                   final String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void applyOptionsPressed() {
        FontSize appliedFontSize = FontSize.values()[(int) fontSizeSlider.getValue()];
        viewFactory.setFontSize(appliedFontSize);
        viewFactory.setTheme(themeDropdown.getValue());
        viewFactory.updateStyles();
    }

    @FXML
    void cancelOptionsPressed() {
        Stage stage = (Stage) fontSizeSlider.getScene().getWindow();
        viewFactory.tearDownStage(stage);
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        setupThemeDropDown();
        setupFontSizeSlider();
    }

    private void setupFontSizeSlider() {
        fontSizeSlider.setMin(0);
        fontSizeSlider.setMax(FontSize.values().length - 1);
        fontSizeSlider.setValue(viewFactory.getFontSize().ordinal());
        fontSizeSlider.setMinorTickCount(0);
        fontSizeSlider.setMajorTickUnit(1);
        fontSizeSlider.setBlockIncrement(1);
        fontSizeSlider.setSnapToTicks(true);
        fontSizeSlider.setShowTickMarks(true);
        fontSizeSlider.setShowTickLabels(true);

        // Set the values of the ticks to
        // the corresponding names in the
        // FontSize enum
        fontSizeSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int idx = aDouble.intValue();
                return FontSize.values()[idx].toString();
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });

        // Update the value of the slider to
        // correspond to whatever is snapped to
        fontSizeSlider.valueProperty().addListener((observableValue, oldVal, newVal) -> {
            fontSizeSlider.setValue(newVal.intValue());
        });
    }

    private void setupThemeDropDown() {
        themeDropdown.setItems(FXCollections.observableArrayList(Theme.values()));
        themeDropdown.setValue(viewFactory.getTheme());
    }
}
