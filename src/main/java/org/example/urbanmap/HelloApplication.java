package org.example.urbanmap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Establecer la conexión con la base de datos
        ConexionBD.conectar();
        
        // Cargar la vista de login
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 650);
        
        // Cargar el CSS del login
        scene.getStylesheets().add(HelloApplication.class.getResource("login.css").toExternalForm());
        
        stage.setTitle("UrbanMap - Iniciar Sesión");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        // Cerrar la conexión al cerrar la aplicación
        stage.setOnCloseRequest(event -> ConexionBD.desconectar());
    }

    public static void main(String[] args) {
        launch();
    }
}