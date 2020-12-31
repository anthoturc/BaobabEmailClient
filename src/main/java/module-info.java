module com.anthodev {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.anthodev;
    opens com.anthodev.controller;
    exports com.anthodev;
}
