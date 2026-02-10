error id: file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/org/example/urbanmap/controlador/MainController.java:_empty_/TextField#clear#
file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/org/example/urbanmap/controlador/MainController.java
empty definition using pc, found symbol in pc: _empty_/TextField#clear#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2758
uri: file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/org/example/urbanmap/controlador/MainController.java
text:
```scala
package org.example.urbanmap.controlador;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.example.urbanmap.modelo.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Controlador principal de la aplicación UrbanMap.
 * Gestiona la navegación, filtros y la carga del listado de propiedades.
 */
public class MainController {

    // ─── Content ───
    @FXML private StackPane contentArea;

    // ─── Top bar ───
    @FXML private TextField txtBuscar;
    @FXML private ToggleButton pillVenta;
    @FXML private ToggleButton pillTodas;
    @FXML private ToggleButton pillCasa;
    @FXML private ToggleButton pillPiso;
    @FXML private ToggleButton pillLocal;
    @FXML private ComboBox<String> cmbOrdenar;

    // ─── Filter panel ───
    @FXML private TextField txtPrecioMin;
    @FXML private TextField txtPrecioMax;
    @FXML private CheckBox chkCasa;
    @FXML private CheckBox chkPiso;
    @FXML private CheckBox chkLocal;
    @FXML private CheckBox chkJardin;
    @FXML private CheckBox chkGaraje;
    @FXML private CheckBox chkAscensor;
    @FXML private CheckBox chkAlmacen;
    @FXML private ToggleButton btnDispTodas;
    @FXML private ToggleButton btnDisponibles;
    @FXML private ToggleButton btnVendidas;

    private final PropiedadController propiedadController = new PropiedadController();
    private final ImagenPropiedadController imagenController = new ImagenPropiedadController();

    private List<Propiedad> todasLasPropiedades = new ArrayList<>();

    @FXML
    public void initialize() {
        // Sort options
        cmbOrdenar.setItems(FXCollections.observableArrayList(
                "Más recientes", "Precio: menor a mayor", "Precio: mayor a menor", "Nombre A-Z"
        ));
        cmbOrdenar.setValue("Más recientes");
        cmbOrdenar.setOnAction(e -> cargarListadoPropiedades());

        // Search listener (on Enter)
        txtBuscar.setOnAction(e -> cargarListadoPropiedades());

        // Load all
        cargarListadoPropiedades();
    }

    // ═══════════════ EVENT HANDLERS ═══════════════

    @FXML
    private void onFiltroClick() {
        cargarListadoPropiedades();
    }

    @FXML
    private void onAplicarFiltros() {
        cargarListadoPropiedades();
    }

    @FXML
    private void onResetFiltros() {
        txtPrecioMin.@@clear();
        txtPrecioMax.clear();
        txtBuscar.clear();
        chkCasa.setSelected(false);
        chkPiso.setSelected(false);
        chkLocal.setSelected(false);
        chkJardin.setSelected(false);
        chkGaraje.setSelected(false);
        chkAscensor.setSelected(false);
        chkAlmacen.setSelected(false);
        btnDispTodas.setSelected(true);
        pillVenta.setSelected(true);
        cmbOrdenar.setValue("Más recientes");
        cargarListadoPropiedades();
    }

    // ═══════════════ PROPERTY LISTING ═══════════════

    private void cargarListadoPropiedades() {
        todasLasPropiedades = propiedadController.obtenerTodas();
        List<Propiedad> filtradas = aplicarFiltros(todasLasPropiedades);

        VBox listingRoot = new VBox(20);
        listingRoot.getStyleClass().add("listing-root");
        listingRoot.setPadding(new Insets(24, 28, 28, 28));

        // ─── Header: count + grid toggle ───
        HBox header = new HBox(8);
        header.setAlignment(Pos.CENTER_LEFT);
        header.getStyleClass().add("listing-header");

        TextFlow countFlow = new TextFlow();
        Text countNum = new Text(String.valueOf(filtradas.size()));
        countNum.getStyleClass().add("listing-count-number");
        Text countTxt = new Text(" Propiedades en UrbanMap");
        countTxt.getStyleClass().add("listing-count-text");
        countFlow.getChildren().addAll(countNum, countTxt);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        ToggleButton btnGrid = new ToggleButton("⊞");
        btnGrid.getStyleClass().add("grid-toggle-btn");
        btnGrid.setSelected(true);
        ToggleButton btnList = new ToggleButton("☰");
        btnList.getStyleClass().add("grid-toggle-btn");
        ToggleGroup viewGroup = new ToggleGroup();
        btnGrid.setToggleGroup(viewGroup);
        btnList.setToggleGroup(viewGroup);

        header.getChildren().addAll(countFlow, spacer, btnGrid, btnList);
        listingRoot.getChildren().add(header);

        if (filtradas.isEmpty()) {
            VBox emptyState = new VBox(12);
            emptyState.setAlignment(Pos.CENTER);
            emptyState.setPadding(new Insets(80, 0, 0, 0));

            Label emptyIcon = new Label("🏠");
            emptyIcon.getStyleClass().add("empty-icon");
            Label emptyTitle = new Label("No se encontraron propiedades");
            emptyTitle.getStyleClass().add("empty-title");
            Label emptyText = new Label("Prueba a cambiar los filtros de búsqueda.");
            emptyText.getStyleClass().add("empty-text");

            emptyState.getChildren().addAll(emptyIcon, emptyTitle, emptyText);
            listingRoot.getChildren().add(emptyState);
        } else {
            FlowPane grid = new FlowPane();
            grid.setHgap(20);
            grid.setVgap(20);
            grid.setPadding(new Insets(6, 0, 0, 0));

            for (Propiedad p : filtradas) {
                grid.getChildren().add(crearTarjetaPropiedad(p));
            }
            listingRoot.getChildren().add(grid);
        }

        ScrollPane scroll = new ScrollPane(listingRoot);
        scroll.setFitToWidth(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.getStyleClass().add("listing-scroll");

        contentArea.getChildren().clear();
        contentArea.getChildren().add(scroll);
    }

    // ═══════════════ FILTERS ═══════════════

    private List<Propiedad> aplicarFiltros(List<Propiedad> propiedades) {
        List<Propiedad> resultado = new ArrayList<>(propiedades);

        // ─── Top pill filter ───
        if (pillVenta != null && pillVenta.isSelected()) {
            resultado.removeIf(p -> !p.isDisponible());
        } else if (pillCasa != null && pillCasa.isSelected()) {
            resultado.removeIf(p -> !(p instanceof Casa));
        } else if (pillPiso != null && pillPiso.isSelected()) {
            resultado.removeIf(p -> !(p instanceof Piso));
        } else if (pillLocal != null && pillLocal.isSelected()) {
            resultado.removeIf(p -> !(p instanceof Local));
        }
        // pillTodas → no filter

        // ─── Search text ───
        String buscar = txtBuscar.getText();
        if (buscar != null && !buscar.isBlank()) {
            String lower = buscar.toLowerCase();
            resultado.removeIf(p ->
                    !p.getNombre().toLowerCase().contains(lower) &&
                    !p.getDescripcion().toLowerCase().contains(lower));
        }

        // ─── Price range ───
        try {
            String minStr = txtPrecioMin.getText();
            if (minStr != null && !minStr.isBlank()) {
                double min = Double.parseDouble(minStr.replace(",", "."));
                resultado.removeIf(p -> p.getPrecio() < min);
            }
        } catch (NumberFormatException ignored) {}

        try {
            String maxStr = txtPrecioMax.getText();
            if (maxStr != null && !maxStr.isBlank()) {
                double max = Double.parseDouble(maxStr.replace(",", "."));
                resultado.removeIf(p -> p.getPrecio() > max);
            }
        } catch (NumberFormatException ignored) {}

        // ─── Type checkboxes ───
        boolean anyTypeChecked = chkCasa.isSelected() || chkPiso.isSelected() || chkLocal.isSelected();
        if (anyTypeChecked) {
            resultado.removeIf(p -> {
                if (p instanceof Casa && chkCasa.isSelected()) return false;
                if (p instanceof Piso && chkPiso.isSelected()) return false;
                if (p instanceof Local && chkLocal.isSelected()) return false;
                return true;
            });
        }

        // ─── Amenity checkboxes ───
        if (chkJardin.isSelected()) {
            resultado.removeIf(p -> !(p instanceof Casa c && c.isTieneJardin()));
        }
        if (chkGaraje.isSelected()) {
            resultado.removeIf(p -> !(p instanceof Casa c && c.isTieneGaraje()));
        }
        if (chkAscensor.isSelected()) {
            resultado.removeIf(p -> !(p instanceof Piso pi && pi.isTieneAscensor()));
        }
        if (chkAlmacen.isSelected()) {
            resultado.removeIf(p -> !(p instanceof Local l && l.isTieneAlmacen()));
        }

        // ─── Availability ───
        if (btnDisponibles != null && btnDisponibles.isSelected()) {
            resultado.removeIf(p -> !p.isDisponible());
        } else if (btnVendidas != null && btnVendidas.isSelected()) {
            resultado.removeIf(Propiedad::isDisponible);
        }

        // ─── Sort ───
        String orden = cmbOrdenar.getValue();
        if (orden != null) {
            switch (orden) {
                case "Precio: menor a mayor" -> resultado.sort(Comparator.comparingDouble(Propiedad::getPrecio));
                case "Precio: mayor a menor" -> resultado.sort(Comparator.comparingDouble(Propiedad::getPrecio).reversed());
                case "Nombre A-Z" -> resultado.sort(Comparator.comparing(Propiedad::getNombre, String.CASE_INSENSITIVE_ORDER));
                default -> {} // Más recientes = default order
            }
        }

        return resultado;
    }

    // ═══════════════ CARD CREATION ═══════════════

    private VBox crearTarjetaPropiedad(Propiedad propiedad) {
        VBox card = new VBox();
        card.getStyleClass().add("property-card");
        card.setPrefWidth(290);
        card.setMaxWidth(290);

        // ─── Image ───
        StackPane imageContainer = new StackPane();
        imageContainer.getStyleClass().add("card-image-container");
        imageContainer.setPrefHeight(200);
        imageContainer.setMinHeight(200);
        imageContainer.setMaxHeight(200);
        imageContainer.setClip(createClipRect(290, 200));

        try {
            List<ImagenPropiedad> imgs = imagenController.obtenerPorPropiedad(propiedad.getIdPropiedad());
            if (imgs != null && !imgs.isEmpty()) {
                ImageView imgView = new ImageView();
                imgView.setFitWidth(290);
                imgView.setFitHeight(200);
                imgView.setPreserveRatio(false);
                try {
                    imgView.setImage(new Image(imgs.get(0).getUrlImagen(), 290, 200, false, true, true));
                } catch (Exception ignored) {}
                imageContainer.getChildren().add(imgView);
            } else {
                addPlaceholder(imageContainer);
            }
        } catch (Exception e) {
            addPlaceholder(imageContainer);
        }

        // Badges + heart
        HBox badgeRow = new HBox(6);
        badgeRow.setAlignment(Pos.TOP_LEFT);
        badgeRow.setPadding(new Insets(12, 12, 0, 12));
        StackPane.setAlignment(badgeRow, Pos.TOP_LEFT);

        Label badge = new Label(propiedad.isDisponible() ? "EN VENTA" : "VENDIDO");
        badge.getStyleClass().add(propiedad.isDisponible() ? "card-badge-sale" : "card-badge-sold");
        badgeRow.getChildren().add(badge);
        imageContainer.getChildren().add(badgeRow);

        // Heart button top-right
        Button heart = new Button("♡");
        heart.getStyleClass().add("card-heart");
        StackPane.setAlignment(heart, Pos.TOP_RIGHT);
        StackPane.setMargin(heart, new Insets(10, 10, 0, 0));
        heart.setOnAction(e -> {
            heart.setText(heart.getText().equals("♡") ? "♥" : "♡");
            e.consume();
        });
        imageContainer.getChildren().add(heart);

        // ─── Card Content ───
        VBox content = new VBox(6);
        content.getStyleClass().add("card-content");

        // Price
        HBox priceRow = new HBox(4);
        priceRow.setAlignment(Pos.CENTER_LEFT);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        Label price = new Label(nf.format(propiedad.getPrecio()));
        price.getStyleClass().add("card-price");
        Label unit = new Label("/ EUR");
        unit.getStyleClass().add("card-price-unit");
        priceRow.getChildren().addAll(price, unit);

        // Title
        Label title = new Label(propiedad.getNombre());
        title.getStyleClass().add("card-title");
        title.setWrapText(true);
        title.setMaxWidth(260);

        // Location
        Label location = new Label("📍 Lat: " + String.format("%.4f", propiedad.getLatitud())
                + ", Lng: " + String.format("%.4f", propiedad.getLongitud()));
        location.getStyleClass().add("card-location");

        // Separator
        Separator sep = new Separator();
        sep.getStyleClass().add("card-separator");

        // Stats row
        HBox statsRow = crearStatsRow(propiedad);

        content.getChildren().addAll(priceRow, title, location, sep, statsRow);
        card.getChildren().addAll(imageContainer, content);

        // ─── Click → Detalle ───
        card.setOnMouseClicked(event -> abrirDetalle(propiedad));

        return card;
    }

    private HBox crearStatsRow(Propiedad propiedad) {
        HBox row = new HBox(16);
        row.setAlignment(Pos.CENTER_LEFT);
        row.getStyleClass().add("card-stats-row");

        if (propiedad instanceof Casa casa) {
            row.getChildren().addAll(
                    crearStat("🏠", String.valueOf(casa.getNumPlantas()), "plantas"),
                    crearStat("🌿", casa.isTieneJardin() ? "Sí" : "No", "jardín"),
                    crearStat("🚗", casa.isTieneGaraje() ? "Sí" : "No", "garaje")
            );
        } else if (propiedad instanceof Piso piso) {
            row.getChildren().addAll(
                    crearStat("🛏", String.valueOf(piso.getNumHabitaciones()), "hab."),
                    crearStat("🏢", String.valueOf(piso.getPlanta()), "planta"),
                    crearStat("🛗", piso.isTieneAscensor() ? "Sí" : "No", "ascensor")
            );
        } else if (propiedad instanceof Local local) {
            row.getChildren().addAll(
                    crearStat("📐", String.format("%.0f", local.getSuperficie()), "m²"),
                    crearStat("📦", local.isTieneAlmacen() ? "Sí" : "No", "almacén")
            );
        }

        return row;
    }

    private HBox crearStat(String icon, String value, String label) {
        HBox stat = new HBox(4);
        stat.setAlignment(Pos.CENTER_LEFT);

        Label iconLbl = new Label(icon);
        iconLbl.getStyleClass().add("card-stat-icon");
        Label valLbl = new Label(value);
        valLbl.getStyleClass().add("card-stat-value");
        Label lblLbl = new Label(label);
        lblLbl.getStyleClass().add("card-stat-label");

        stat.getChildren().addAll(iconLbl, valLbl, lblLbl);
        return stat;
    }

    private void addPlaceholder(StackPane container) {
        Label placeholder = new Label("🏠");
        placeholder.setStyle("-fx-font-size: 42px; -fx-text-fill: #94a3b8;");
        container.getChildren().add(placeholder);
    }

    private javafx.scene.shape.Rectangle createClipRect(double w, double h) {
        javafx.scene.shape.Rectangle clip = new javafx.scene.shape.Rectangle(w, h);
        clip.setArcWidth(32);
        clip.setArcHeight(32);
        return clip;
    }

    // ═══════════════ NAVIGATION ═══════════════

    private void abrirDetalle(Propiedad propiedad) {
        PropiedadDetalleController.cargarDetalleEnContenedor(
                contentArea,
                propiedad,
                this::cargarListadoPropiedades
        );
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/TextField#clear#