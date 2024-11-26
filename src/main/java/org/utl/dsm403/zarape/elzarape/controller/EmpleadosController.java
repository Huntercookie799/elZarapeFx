package org.utl.dsm403.zarape.elzarape.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import org.utl.dsm403.zarape.elzarape.model.Utilities;
import org.utl.dsm403.zarape.elzarape.modelos.Empleado;
import org.utl.dsm403.zarape.elzarape.model.Funciones;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class EmpleadosController {
    @FXML private TableView<Empleado> tablaEmpleados;
    @FXML private TableColumn<Empleado, Integer> colIdEmpleado;
    @FXML private TableColumn<Empleado, String> colNombreEmpleado;
    @FXML private TableColumn<Empleado, String> colApellidosEmpleado;
    @FXML private TableColumn<Empleado, String> colTelefonoEmpleado;
    @FXML private TableColumn<Empleado, String> colSucursal;
    @FXML private TableColumn<Empleado, String> colUsuario;
    @FXML private TableColumn<Empleado, Boolean> colActivo;
    @FXML private TableColumn<Empleado, Void> colAcciones;

    @FXML
    public void initialize() {
        configurarTabla();
        cargarEmpleados();
    }

    private void configurarTabla() {
        colIdEmpleado.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdEmpleado()));
        colNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPersona().getNombre()));
        colApellidosEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPersona().getApellidos()));
        colTelefonoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPersona().getTelefono()));
        colSucursal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSucursal().getNombre()));
        colUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario().getNombre()));
        colActivo.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getActivo() == 1));
        
        colAcciones.setCellFactory(col -> {
            return new TableCell<>() {
                private final Button btnEditar = new Button("Editar");
                private final Button btnEliminar = new Button("Eliminar");
                {
                    btnEditar.setOnAction(event -> editarEmpleado(getTableView().getItems().get(getIndex())));
                    btnEliminar.setOnAction(event -> eliminarEmpleado(getTableView().getItems().get(getIndex())));
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

    private void cargarEmpleados() {
        new Thread(() -> {
            List<Empleado> empleados = Utilities.getAllEmpleados();
            Platform.runLater(() -> {
                for (Empleado empleado : empleados) {
                    tablaEmpleados.getItems().add(empleado);
                }
                tablaEmpleados.refresh();
            });
        }).start();
    }

    private void editarEmpleado(Empleado empleado) {
        Funciones.Navegacion.abrirVentanaModal(
            "/org/utl/dsm403/zarape/elzarape/view/viewDetalleEmpleado.fxml", 
            "Editar Empleado"
        );
    }

    private void eliminarEmpleado(Empleado empleado) {
        if (Funciones.Alertas.mostrarConfirmacion("Eliminar Empleado", 
            "¿Está seguro que desea eliminar este empleado?")) {
        }
    }

    @FXML
    private void abrirVentanaAgregar() {
        Funciones.Navegacion.abrirVentanaModal(
            "/org/utl/dsm403/zarape/elzarape/view/viewDetalleEmpleado.fxml", 
            "Agregar Empleado"
        );
    }
}
