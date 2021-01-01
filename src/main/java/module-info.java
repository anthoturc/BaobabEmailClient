module com.anthodev {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires java.mail;
    requires org.immutables.value;

    opens com.anthodev;
    opens com.anthodev.controller;
    exports com.anthodev;
}
