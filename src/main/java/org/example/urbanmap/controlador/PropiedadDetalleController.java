package org.example.urbanmap.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.urbanmap.HelloApplication;
import org.example.urbanmap.modelo.*;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Controlador para la vista de detalle de una propiedad.
 * Se encarga de mostrar toda la información de una Propiedad seleccionada.
 */
public class PropiedadDetalleController {

    // ─── Top Bar ───
    @FXML private Button btnVolver;
    @FXML private Button btnCompartir;
    @FXML private Button btnGuardar;

    // ─── Images ───
    @FXML private ImageView imgPrincipal;
    @FXML private ImageView imgSecundaria1;
    @FXML private ImageView imgSecundaria2;

    // ─── Badges ───
    @FXML private Label lblEstado;
    @FXML private Label lblTipoPropiedad;

    // ─── Info ───
    @FXML private Label lblTitulo;
    @FXML private Label lblUbicacion;
    @FXML private Label lblNumFotos;
    @FXML private Label lblDescripcion;

    // ─── Stats ───
    @FXML private Label lblStatIcon1;
    @FXML private Label lblStatLabel1;
    @FXML private Label lblStatValue1;
    @FXML private Label lblStatIcon2;
    @FXML private Label lblStatLabel2;
    @FXML private Label lblStatValue2;
    @FXML private Label lblStatIcon3;
    @FXML private Label lblStatLabel3;
    @FXML private Label lblStatValue3;
    @FXML private Label lblStatIcon4;
    @FXML private Label lblStatLabel4;
    @FXML private Label lblStatValue4;

    // ─── Sidebar ───
    @FXML private Label lblPrecio;
    @FXML private Label lblHipoteca;

    // ─── Buttons ───
    @FXML private Button btnComprar;
    @FXML private Button btnContactar;

    // ─── Data ───
    private Propiedad propiedad;
    private List<ImagenPropiedad> imagenes;
    private Runnable onVolverCallback;

    /**
     * Establece la propiedad a mostrar y rellena la vista con sus datos.
     */
    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
        cargarDatos();
        cargarImagenes();
    }

    /**
     * Establece un callback para cuando el usuario pulse "Volver".
     * Permite regresar a la vista anterior (listado de propiedades).
     */
    public void setOnVolverCallback(Runnable callback) {
        this.onVolverCallback = callback;
    }

    /**
     * Carga los datos de la propiedad en los controles de la vista.
     */
    private void cargarDatos() {
        if (propiedad == null) return;

        // ─── Título y descripción ───
        lblTitulo.setText(propiedad.getNombre());
        lblDescripcion.setText(propiedad.getDescripcion());

        // ─── Ubicación (lat/lng) ───
        lblUbicacion.setText(String.format("Lat: %.4f, Lng: %.4f",
                propiedad.getLatitud(), propiedad.getLongitud()));

        // ─── Badges ───
        lblEstado.setText(propiedad.isDisponible() ? "EN VENTA" : "VENDIDO");
        lblEstado.getStyleClass().clear();
        lblEstado.getStyleClass().add(propiedad.isDisponible() ? "badge-sale" : "badge-sold");
        lblTipoPropiedad.setText(propiedad.getTipoVivienda().toUpperCase());

        // ─── Precio ───
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        lblPrecio.setText(nf.format(propiedad.getPrecio()));

        // Estimación hipoteca (30 años, ~3.5% anual simplificado)
        double hipotecaMensual = (propiedad.getPrecio() * 0.8) * (0.035 / 12)
                / (1 - Math.pow(1 + 0.035 / 12, -360));
        NumberFormat nfHip = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        lblHipoteca.setText("Est. Hipoteca: " + nfHip.format(hipotecaMensual) + "/mes");

        // ─── Deshabilitar compra si no está disponible ───
        btnComprar.setDisable(!propiedad.isDisponible());

        // ─── Stats según tipo ───
        cargarStats();
    }

    /**
     * Carga las estadísticas/detalles según el tipo de propiedad.
     */
    private void cargarStats() {
        // Stat 4 — siempre: Estado
        lblStatIcon4.setText("✅");
        lblStatLabel4.setText("ESTADO");
        lblStatValue4.setText(propiedad.isDisponible() ? "Disponible" : "Vendido");

        if (propiedad instanceof Casa casa) {
            lblStatIcon1.setText("🏠");
            lblStatLabel1.setText("PLANTAS");
            lblStatValue1.setText(casa.getNumPlantas() + " Plantas");

            lblStatIcon2.setText("🌿");
            lblStatLabel2.setText("JARDÍN");
            lblStatValue2.setText(casa.isTieneJardin() ? "Sí" : "No");

            lblStatIcon3.setText("🚗");
            lblStatLabel3.setText("GARAJE");
            lblStatValue3.setText(casa.isTieneGaraje() ? "Sí" : "No");

        } else if (propiedad instanceof Piso piso) {
            lblStatIcon1.setText("🛏");
            lblStatLabel1.setText("HABITACIONES");
            lblStatValue1.setText(piso.getNumHabitaciones() + " Hab.");

            lblStatIcon2.setText("🏢");
            lblStatLabel2.setText("PLANTA");
            lblStatValue2.setText("Planta " + piso.getPlanta());

            lblStatIcon3.setText("🛗");
            lblStatLabel3.setText("ASCENSOR");
            lblStatValue3.setText(piso.isTieneAscensor() ? "Sí" : "No");

        } else if (propiedad instanceof Local local) {
            lblStatIcon1.setText("📐");
            lblStatLabel1.setText("SUPERFICIE");
            lblStatValue1.setText(String.format("%.0f m²", local.getSuperficie()));

            lblStatIcon2.setText("📦");
            lblStatLabel2.setText("ALMACÉN");
            lblStatValue2.setText(local.isTieneAlmacen() ? "Sí" : "No");

            lblStatIcon3.setText("🏪");
            lblStatLabel3.setText("TIPO");
            lblStatValue3.setText("Local Comercial");
        }
    }

    /**
     * Carga las imágenes de la propiedad desde la base de datos.
     */
    private void cargarImagenes() {
        if (propiedad == null) return;

        try {
            ImagenPropiedadController imgController = new ImagenPropiedadController();
            imagenes = imgController.obtenerPorPropiedad(propiedad.getIdPropiedad());

            if (imagenes != null && !imagenes.isEmpty()) {
                // Imagen principal
                cargarImagen(imgPrincipal, imagenes.get(0).getUrlImagen());

                // Imagen secundaria 1
                if (imagenes.size() > 1) {
                    cargarImagen(imgSecundaria1, imagenes.get(1).getUrlImagen());
                }

                // Imagen secundaria 2
                if (imagenes.size() > 2) {
                    cargarImagen(imgSecundaria2, imagenes.get(2).getUrlImagen());
                }

                // Contador de fotos
                lblNumFotos.setText("Ver " + imagenes.size() + " Fotos");
            } else {
                lblNumFotos.setText("Sin fotos");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar imágenes: " + e.getMessage());
            lblNumFotos.setText("Sin fotos");
        }
    }

    /**
     * Carga una imagen en un ImageView desde una URL.
     */
    private void cargarImagen(ImageView imageView, String url) {
        try {
            if (url != null && !url.isEmpty()) {
                Image image = new Image(url, true); // background loading
                imageView.setImage(image);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar imagen: " + url + " - " + e.getMessage());
        }
    }

    // ═══════════════ EVENT HANDLERS ═══════════════

    @FXML
    private void onVolverClick() {
        if (onVolverCallback != null) {
            onVolverCallback.run();
        } else {
            // Si no hay callback, intentar cerrar/volver a la escena anterior
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void onCompartirClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Compartir");
        alert.setHeaderText("Compartir propiedad");
        alert.setContentText("Enlace copiado: UrbanMap://" + propiedad.getIdPropiedad());
        alert.showAndWait();
    }

    @FXML
    private void onGuardarClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardado");
        alert.setHeaderText(null);
        alert.setContentText("Propiedad \"" + propiedad.getNombre() + "\" guardada en favoritos.");
        alert.showAndWait();
    }

    @FXML
    private void onVerFotosClick() {
        if (imagenes == null || imagenes.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Galería");
            alert.setHeaderText(null);
            alert.setContentText("Esta propiedad no tiene fotos disponibles.");
            alert.showAndWait();
            return;
        }

        // Mostrar galería de imágenes en una nueva ventana
        Stage galeriaStage = new Stage();
        galeriaStage.setTitle("Galería - " + propiedad.getNombre());

        javafx.scene.layout.VBox root = new javafx.scene.layout.VBox(10);
        root.setStyle("-fx-background-color: #0f172a; -fx-padding: 20;");
        root.setAlignment(javafx.geometry.Pos.CENTER);

        ImageView visorImagen = new ImageView();
        visorImagen.setFitWidth(800);
        visorImagen.setFitHeight(500);
        visorImagen.setPreserveRatio(true);

        Label lblContador = new Label("1 / " + imagenes.size());
        lblContador.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

        final int[] indice = {0};
        cargarImagen(visorImagen, imagenes.get(0).getUrlImagen());

        javafx.scene.layout.HBox botones = new javafx.scene.layout.HBox(20);
        botones.setAlignment(javafx.geometry.Pos.CENTER);

        Button btnAnterior = new Button("← Anterior");
        btnAnterior.setStyle("-fx-background-color: #1d6cff; -fx-text-fill: white; " +
                "-fx-font-weight: 700; -fx-background-radius: 8; -fx-padding: 10 20;");
        btnAnterior.setOnAction(e -> {
            if (indice[0] > 0) {
                indice[0]--;
                cargarImagen(visorImagen, imagenes.get(indice[0]).getUrlImagen());
                lblContador.setText((indice[0] + 1) + " / " + imagenes.size());
            }
        });

        Button btnSiguiente = new Button("Siguiente →");
        btnSiguiente.setStyle("-fx-background-color: #1d6cff; -fx-text-fill: white; " +
                "-fx-font-weight: 700; -fx-background-radius: 8; -fx-padding: 10 20;");
        btnSiguiente.setOnAction(e -> {
            if (indice[0] < imagenes.size() - 1) {
                indice[0]++;
                cargarImagen(visorImagen, imagenes.get(indice[0]).getUrlImagen());
                lblContador.setText((indice[0] + 1) + " / " + imagenes.size());
            }
        });

        botones.getChildren().addAll(btnAnterior, lblContador, btnSiguiente);
        root.getChildren().addAll(visorImagen, botones);

        Scene scene = new Scene(root, 860, 600);
        galeriaStage.setScene(scene);
        galeriaStage.show();
    }

    @FXML
    private void onComprarClick() {
        if (propiedad == null || !propiedad.isDisponible()) return;

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar Compra");
        confirmacion.setHeaderText("¿Desea comprar esta propiedad?");

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        confirmacion.setContentText(
                "Propiedad: " + propiedad.getNombre() + "\n" +
                "Precio: " + nf.format(propiedad.getPrecio()) + "\n\n" +
                "Esta acción registrará la compra."
        );

        Optional<ButtonType> resultado = confirmacion.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            // Registrar la compra
            CompraController compraCtrl = new CompraController();
            Compra compra = new Compra();
            compra.setIdPropiedadCompra(propiedad.getIdPropiedad());
            compra.setIdUsuarioCompra(1); // TODO: usar usuario logueado
            compra.setFechaCompra(java.time.LocalDate.now());

            boolean exito = compraCtrl.insertar(compra);
            if (exito) {
                // Marcar propiedad como no disponible
                propiedad.setDisponible(false);
                PropiedadController propCtrl = new PropiedadController();
                propCtrl.actualizar(propiedad);

                // Actualizar la vista
                cargarDatos();

                Alert ok = new Alert(Alert.AlertType.INFORMATION);
                ok.setTitle("Compra Exitosa");
                ok.setHeaderText(null);
                ok.setContentText("¡Felicidades! Ha comprado \"" + propiedad.getNombre() + "\" exitosamente.");
                ok.showAndWait();
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText(null);
                error.setContentText("No se pudo completar la compra. Inténtelo de nuevo.");
                error.showAndWait();
            }
        }
    }

    @FXML
    private void onContactarClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Solicitar Información");
        alert.setHeaderText("Contacto UrbanMap");
        alert.setContentText(
                "Para más información sobre:\n\"" + propiedad.getNombre() + "\"\n\n" +
                "Contáctenos en: info@urbanmap.com\n" +
                "Teléfono: +34 900 123 456"
        );
        alert.showAndWait();
    }

    // ═══════════════ STATIC UTILITY METHODS ═══════════════

    /**
     * Abre la vista de detalle de una propiedad en una nueva ventana.
     *
     * @param propiedad La propiedad a mostrar.
     */
    public static void abrirDetalle(Propiedad propiedad) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    HelloApplication.class.getResource("propertyDetail.fxml"));
            Parent root = loader.load();

            PropiedadDetalleController controller = loader.getController();
            controller.setPropiedad(propiedad);

            Stage stage = new Stage();
            stage.setTitle("UrbanMap - " + propiedad.getNombre());
            stage.setScene(new Scene(root, 1100, 750));
            stage.setMinWidth(900);
            stage.setMinHeight(600);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error al abrir detalle de propiedad: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Carga la vista de detalle dentro de un contenedor (StackPane) existente,
     * útil para navegación dentro de la misma ventana.
     *
     * @param container   El StackPane donde se mostrará la vista.
     * @param propiedad   La propiedad a mostrar.
     * @param onVolver    Acción a ejecutar cuando se pulse "Volver".
     */
    public static void cargarDetalleEnContenedor(StackPane container, Propiedad propiedad, Runnable onVolver) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    HelloApplication.class.getResource("propertyDetail.fxml"));
            Parent root = loader.load();

            PropiedadDetalleController controller = loader.getController();
            controller.setPropiedad(propiedad);
            controller.setOnVolverCallback(onVolver);

            container.getChildren().clear();
            container.getChildren().add(root);
        } catch (IOException e) {
            System.err.println("Error al cargar detalle en contenedor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
