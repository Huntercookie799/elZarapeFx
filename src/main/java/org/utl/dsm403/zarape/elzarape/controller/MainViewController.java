package org.utl.dsm403.zarape.elzarape.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.utl.dsm403.zarape.elzarape.model.Funciones;

import java.io.IOException;
import java.util.Optional;

public class MainViewController {
    
    @FXML
    private Button btnEmpleados;
    
    @FXML
    private Button btnSucursales;
    
    @FXML
    private Button btnArticulos;
    
    @FXML
    private Button btnCombos;

    @FXML
    private AnchorPane panelPrincipal;

    @FXML
    protected void onLogoutButtonClick(ActionEvent event) {
        // Mostrar diálogo de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Cierre de Sesión");
        alert.setHeaderText("¿Está seguro que desea cerrar sesión?");
        alert.setContentText("Presione OK para confirmar.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Cargar la vista de login
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/utl/dsm403/zarape/elzarape/view/login.fxml"));
                Parent root = loader.load();

                // Obtener el stage actual
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

                // Crear nueva escena y mostrarla
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Inicio de Sesión");
                stage.show();

            } catch (IOException e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Error al cargar la vista");
                errorAlert.setContentText("No se pudo cargar la pantalla de inicio de sesión.");
                errorAlert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void onEmpleadosButtonClick(ActionEvent event) {
        try {
            Funciones.Navegacion.cargarVistaEnPanel(
                "/org/utl/dsm403/zarape/elzarape/view/viewEmpleados.fxml",
                panelPrincipal
            );
        } catch (Exception e) {
            Funciones.Alertas.mostrarError("Error", 
                "No se pudo cargar la vista de gestión de empleados: " + e.getMessage());
        }
    }

    @FXML
    protected void onSucursalesButtonClick(ActionEvent event) {
        try {
            Funciones.Navegacion.cargarVistaEnPanel(
                "/org/utl/dsm403/zarape/elzarape/view/sucursales.fxml",
                panelPrincipal
            );
        } catch (Exception e) {
            Funciones.Alertas.mostrarError("Error", 
                "No se pudo cargar la vista de gestión de sucursales: " + e.getMessage());
        }
    }

    @FXML
    protected void onArticulosButtonClick(ActionEvent event) {
        try {
            Funciones.Navegacion.cargarVistaEnPanel(
                "/org/utl/dsm403/zarape/elzarape/view/articulos.fxml",
                panelPrincipal
            );
        } catch (Exception e) {
            Funciones.Alertas.mostrarError("Error", 
                "No se pudo cargar la vista de gestión de artículos: " + e.getMessage());
        }
    }

    @FXML
    protected void onCombosButtonClick(ActionEvent event) {
        try {
            Funciones.Navegacion.cargarVistaEnPanel(
                "/org/utl/dsm403/zarape/elzarape/view/viewCombos.fxml",
                panelPrincipal
            );
        } catch (Exception e) {
            Funciones.Alertas.mostrarError("Error", 
                "No se pudo cargar la vista de gestión de combos: " + e.getMessage());
        }
    }
} 