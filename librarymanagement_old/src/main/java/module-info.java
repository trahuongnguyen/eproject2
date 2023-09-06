module com.mycompany.librarymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;
    requires javafx.graphics;
    requires java.base;
    requires java.sql;
    requires org.controlsfx.controls;
    requires flow;
    requires de.jensd.fx.glyphs.fontawesome;
    opens com.mycompany.librarymanagement to javafx.fxml;
    exports com.mycompany.librarymanagement;
}
