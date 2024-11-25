package org.utl.dsm403.zarape.elzarape.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import org.utl.dsm403.zarape.elzarape.model.Utilities;
import org.utl.dsm403.zarape.elzarape.model.Funciones;

public class LoginController {
    @FXML
    private TextField txtUsername;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    protected void onLoginButtonClick(ActionEvent evento) {
        String usuario = txtUsername.getText().trim();
        String contrasena = txtPassword.getText().trim();
        
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            Funciones.Alertas.mostrarError("Error de Acceso", "Por favor, complete todos los campos");
            return;
        }
        
        if (Utilities.validateLogin(usuario, contrasena)) {
            Funciones.Alertas.mostrarInformacion("Éxito", "Bienvenido al sistema");
            Funciones.Navegacion.cambiarVista("/org/utl/dsm403/zarape/elzarape/view/viewPrincipal.fxml",
                                            evento, 
                                            "El Zarape - Panel Principal");
        } else {
            Funciones.Alertas.mostrarError("Error de Acceso", "Usuario o contraseña incorrectos");
        }
    }
} 