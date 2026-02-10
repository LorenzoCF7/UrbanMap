package org.example.urbanmap.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.urbanmap.HelloApplication;
import org.example.urbanmap.modelo.Usuario;

/**
 * Controlador para la vista de login.
 * Gestiona la autenticación de usuarios en la aplicación.
 */
public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblError;
    @FXML private Button btnLogin;

    private final UsuarioController usuarioController = new UsuarioController();

    @FXML
    public void initialize() {
        // Focus automático en el campo de usuario
        txtUsuario.requestFocus();
    }

    /**
     * Maneja el evento de clic en el botón de login o Enter en el campo de contraseña.
     */
    @FXML
    private void onLoginClick() {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText();

        // Validación básica
        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarError("Por favor, ingresa usuario y contraseña");
            return;
        }

        // Intentar autenticar
        Usuario usuarioAutenticado = usuarioController.autenticar(usuario, password);
        
        if (usuarioAutenticado != null) {
            // Login exitoso
            abrirVistaPrincipal(usuarioAutenticado);
        } else {
            // Login fallido
            mostrarError("Usuario o contraseña incorrectos");
            txtPassword.clear();
            txtPassword.requestFocus();
        }
    }

    /**
     * Muestra un mensaje de error en la interfaz.
     */
    private void mostrarError(String mensaje) {
        lblError.setText(mensaje);
        lblError.setVisible(true);
        lblError.setManaged(true);
    }

    /**
     * Abre la vista principal de la aplicación después del login exitoso.
     */
    private void abrirVistaPrincipal(Usuario usuario) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    HelloApplication.class.getResource("mainView.fxml"));
            Scene scene = new Scene(loader.load(), 1200, 780);

            // Pasar el usuario al MainController
            MainController mainController = loader.getController();
            mainController.setUsuarioActivo(usuario);

            // Cargar todos los CSS necesarios
            scene.getStylesheets().add(HelloApplication.class.getResource("navBar.css").toExternalForm());
            scene.getStylesheets().add(HelloApplication.class.getResource("mainView.css").toExternalForm());
            scene.getStylesheets().add(HelloApplication.class.getResource("propertyDetail.css").toExternalForm());

            // Obtener el stage actual y cambiar la escena
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("UrbanMap - " + usuario.getNombreUsuario());
            stage.setResizable(true);
            stage.setMinWidth(900);
            stage.setMinHeight(600);
            stage.setWidth(1200);
            stage.setHeight(780);
            stage.centerOnScreen();
            
        } catch (Exception e) {
            System.err.println("Error al abrir vista principal: " + e.getMessage());
            e.printStackTrace();
            mostrarError("Error al cargar la aplicación principal");
        }
    }
}
