package org.utl.dsm403.zarape.elzarape.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

import java.io.IOException;

public class Funciones {
    
    public static class Alertas {
        public static void mostrarError(String titulo, String contenido) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(contenido);
            alerta.showAndWait();
        }
        
        public static void mostrarInformacion(String titulo, String contenido) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(contenido);
            alerta.showAndWait();
        }
        
        public static boolean mostrarConfirmacion(String titulo, String contenido) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(contenido);
            return alerta.showAndWait().get() == ButtonType.OK;
        }
    }
    
    public static class Navegacion {
        public static void cambiarVista(String rutaFXML, ActionEvent evento, String titulo) {
            try {
                FXMLLoader cargador = new FXMLLoader(Navegacion.class.getResource(rutaFXML));
                Scene escena = new Scene(cargador.load());
                Stage ventana = (Stage)((Node)evento.getSource()).getScene().getWindow();
                ventana.setTitle(titulo);
                ventana.setScene(escena);
                ventana.show();
            } catch (IOException e) {
                Alertas.mostrarError("Error", "No se pudo cargar la vista: " + e.getMessage());
            }
        }
        
        public static void cerrarVentanaActual(ActionEvent evento) {
            Stage ventana = (Stage)((Node)evento.getSource()).getScene().getWindow();
            ventana.close();
        }
        
        public static void cargarVistaEnPanel(String rutaFXML, AnchorPane panel) {
            try {
                FXMLLoader cargador = new FXMLLoader(Navegacion.class.getResource(rutaFXML));
                Node vista = cargador.load();
                
                // Limpiar el panel y agregar la nueva vista
                panel.getChildren().clear();
                panel.getChildren().add(vista);
                
                // Ajustar la vista para que ocupe todo el espacio
                AnchorPane.setTopAnchor(vista, 0.0);
                AnchorPane.setRightAnchor(vista, 0.0);
                AnchorPane.setBottomAnchor(vista, 0.0);
                AnchorPane.setLeftAnchor(vista, 0.0);
                
            } catch (IOException e) {
                Alertas.mostrarError("Error", "No se pudo cargar la vista: " + e.getMessage());
            }
        }
        
        public static void abrirVentanaModal(String rutaFXML, String titulo) {
            try {
                FXMLLoader cargador = new FXMLLoader(Navegacion.class.getResource(rutaFXML));
                Scene escena = new Scene(cargador.load());
                Stage ventanaModal = new Stage();
                ventanaModal.setTitle(titulo);
                ventanaModal.setScene(escena);
                ventanaModal.initModality(Modality.APPLICATION_MODAL); // Hace que la ventana sea modal
                ventanaModal.showAndWait();
            } catch (IOException e) {
                Alertas.mostrarError("Error", "No se pudo cargar la vista: " + e.getMessage());
            }
        }
    }
}