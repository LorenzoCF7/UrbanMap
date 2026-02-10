package org.example.urbanmap.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.urbanmap.modelo.Usuario;

/**
 * Controlador para la barra de navegación lateral.
 * Gestiona la visualización del usuario activo y las opciones de menú.
 */
public class NavBarController {

    @FXML private Label lblUsuarioNombre;
    @FXML private Label lblUsuarioRol;

    private Usuario usuarioActivo;

    /**
     * Establece el usuario activo y actualiza la interfaz del navbar.
     */
    public void setUsuario(Usuario usuario) {
        this.usuarioActivo = usuario;
        actualizarInterfaz();
    }

    /**
     * Actualiza los labels del navbar con la información del usuario.
     */
    private void actualizarInterfaz() {
        if (usuarioActivo != null) {
            lblUsuarioNombre.setText(usuarioActivo.getNombreUsuario());
            lblUsuarioRol.setText(usuarioActivo.isUsuAdmin() ? "Administrador" : "Usuario");
        } else {
            lblUsuarioNombre.setText("Invitado");
            lblUsuarioRol.setText("Sin sesión");
        }
    }
}
