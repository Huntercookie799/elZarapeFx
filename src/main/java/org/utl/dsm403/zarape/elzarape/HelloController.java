package org.utl.dsm403.zarape.elzarape;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import org.utl.dsm403.zarape.elzarape.model.Funciones;

public class HelloController {
    @FXML
    private TextField txtUsuario;
    
    @FXML
    private PasswordField txtPassword;

    @FXML
    protected void iniciarSesion(ActionEvent event) {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();
        
        // Validación básica
        if (usuario.isEmpty() || password.isEmpty()) {
            Funciones.Alertas.mostrarError("Error", "Por favor, complete todos los campos");
            return;
        }
        
        // Aquí deberías agregar la lógica de autenticación real
        if (usuario.equals("admin") && password.equals("123")) {
            Funciones.Alertas.mostrarInformacion("Éxito", "Bienvenido al sistema");
            Funciones.Navegacion.cambiarVista("/org/utl/dsm403/zarape/elzarape/vista/menu-principal.fxml", event, "Menú Principal");
        } else {
            Funciones.Alertas.mostrarError("Error", "Usuario o contraseña incorrectos");
        }
    }
}