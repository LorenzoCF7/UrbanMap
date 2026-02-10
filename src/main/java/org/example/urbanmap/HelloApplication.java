package org.example.urbanmap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Establecer la conexión con la base de datos
        ConexionBD.conectar();
        
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("UrbanMap");
        stage.setScene(scene);
        stage.show();
        
        // Cerrar la conexión al cerrar la aplicación
        stage.setOnCloseRequest(event -> ConexionBD.desconectar());
    }

    public static void main(String[] args) {
        launch();
    }
}