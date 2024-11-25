package org.utl.dsm403.zarape.elzarape.controller;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.util.Callback;
import org.utl.dsm403.zarape.elzarape.model.Funciones;
import org.utl.dsm403.zarape.elzarape.model.Producto;
import javafx.stage.Stage;
import javafx.scene.Node;

public class DetalleComboController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtTotal;
    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, Integer> colIdProducto;
    @FXML private TableColumn<Producto, String> colNombreProducto;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Void> colAccionesProducto;

    @FXML
    public void initialize() {
        configurarTabla();
    }

    private void configurarTabla() {
        colAccionesProducto.setCellFactory(col -> {
            return new TableCell<>() {
                private final Button btnEliminar = new Button("Eliminar");
                {
                    btnEliminar.setOnAction(event -> eliminarProducto(getTableView().getItems().get(getIndex())));
                }
                
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : btnEliminar);
                }
            };
        });
    }

    @FXML
    private void onAgregarProductoClick(ActionEvent event) {
        // Implementar diálogo de selección de producto
    }

    @FXML
    private void onGuardarClick(ActionEvent event) {
        if (validarDatos()) {
            // Implementar lógica de guardado
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void onCancelarClick(ActionEvent event) {
        if (Funciones.Alertas.mostrarConfirmacion("Cancelar", 
            "¿Está seguro que desea cancelar? Se perderán los cambios no guardados.")) {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    private void eliminarProducto(Producto producto) {
        if (Funciones.Alertas.mostrarConfirmacion("Eliminar Producto", 
            "¿Está seguro que desea eliminar este producto del combo?")) {
            tablaProductos.getItems().remove(producto);
            actualizarTotal();
        }
    }

    private boolean validarDatos() {
        if (txtNombre.getText().trim().isEmpty()) {
            Funciones.Alertas.mostrarError("Error", "El nombre del combo es obligatorio");
            return false;
        }
        if (tablaProductos.getItems().isEmpty()) {
            Funciones.Alertas.mostrarError("Error", "Debe agregar al menos un producto al combo");
            return false;
        }
        return true;
    }

    private void actualizarTotal() {
        double total = tablaProductos.getItems().stream()
                                   .mapToDouble(Producto::getPrecio)
                                   .sum();
        txtTotal.setText(String.format("%.2f", total));
    }
} 