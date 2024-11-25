package org.utl.dsm403.zarape.elzarape.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import org.utl.dsm403.zarape.elzarape.model.Combo;
import org.utl.dsm403.zarape.elzarape.model.Funciones;

public class CombosController {
    @FXML private TableView<Combo> tablaCombos;
    @FXML private TableColumn<Combo, Integer> colId;
    @FXML private TableColumn<Combo, String> colNombre;
    @FXML private TableColumn<Combo, Double> colTotal;
    @FXML private TableColumn<Combo, Void> colAcciones;

    @FXML
    public void initialize() {
        configurarTabla();
        cargarCombos();
    }

    private void configurarTabla() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idCombo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        colAcciones.setCellFactory(col -> {
            return new TableCell<>() {
                private final Button btnEditar = new Button("Editar");
                private final Button btnEliminar = new Button("Eliminar");
                {
                    btnEditar.setOnAction(event -> editarCombo(getTableView().getItems().get(getIndex())));
                    btnEliminar.setOnAction(event -> eliminarCombo(getTableView().getItems().get(getIndex())));
                }
                
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        HBox buttons = new HBox(5, btnEditar, btnEliminar);
                        setGraphic(buttons);
                    }
                }
            };
        });
    }

    @FXML
    private void onNuevoComboClick(ActionEvent event) {
        Funciones.Navegacion.abrirVentanaModal(
            "/org/utl/dsm403/zarape/elzarape/view/viewDetalleCombo.fxml", 
            "Nuevo Combo"
        );
    }

    private void editarCombo(Combo combo) {
        Funciones.Navegacion.abrirVentanaModal(
            "/org/utl/dsm403/zarape/elzarape/view/viewDetalleCombo.fxml", 
            "Editar Combo"
        );
    }

    private void eliminarCombo(Combo combo) {
        if (Funciones.Alertas.mostrarConfirmacion("Eliminar Combo", 
            "¿Está seguro que desea eliminar este combo?")) {
            // Implementar lógica de eliminación
        }
    }

    private void cargarCombos() {
        // Implementar carga de combos desde la base de datos
    }
} 