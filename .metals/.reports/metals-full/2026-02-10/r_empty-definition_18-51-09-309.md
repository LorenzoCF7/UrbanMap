error id: file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/module-info.java:
file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/module-info.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 93
uri: file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/module-info.java
text:
```scala
module org.example.urbanmap {
    requires transitive javafx.controls;
    requires javafx.@@fxml;
    requires transitive javafx.web;
    requires transitive javafx.graphics;
    requires transitive java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens org.example.urbanmap to javafx.fxml;
    opens org.example.urbanmap.controlador to javafx.fxml;
    exports org.example.urbanmap;
    exports org.example.urbanmap.modelo;
    exports org.example.urbanmap.controlador;
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 