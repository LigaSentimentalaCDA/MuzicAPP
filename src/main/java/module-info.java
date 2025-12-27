module com.example.musicapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.musicapp to javafx.fxml;
    exports com.example.musicapp;

}