module org.example.urbanmap {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens org.example.urbanmap to javafx.fxml;
    opens org.example.urbanmap.controlador to javafx.fxml;
    exports org.example.urbanmap;
    exports org.example.urbanmap.modelo;
    exports org.example.urbanmap.controlador;
}