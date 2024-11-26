package org.utl.dsm403.zarape.elzarape.model;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import com.google.gson.Gson;
import org.utl.dsm403.zarape.elzarape.modelos.Empleado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utilities {

    public static boolean validateLogin(String username, String password) {
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/ZarapeWeb/api/empleados/login")
                .field("nombreUsuario", username)
                .field("contrasenia", password)
                .asJson();
        return response.getStatus() == 200;
    }
    
    public static void showAlert(String title, String message) {
    }
    
    public static List<Empleado> getAllEmpleados() {
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/ZarapeWeb/api/empleados")
                .asJson();
        System.out.println("Inicia busqueda");
        if (response.getStatus() == 200) {
            List<Empleado> empleados = new ArrayList<>();
            Platform.runLater(() -> {
                Gson gson = new Gson();
                Empleado[] empleadosArray = gson.fromJson(response.getBody().toString(), Empleado[].class);
                empleados.addAll(FXCollections.observableArrayList(List.of(empleadosArray)));
                for (Empleado empleado : empleadosArray) {
                    System.out.println(empleado);
                }
            });
            return empleados;
        } else {
            System.err.println("Error al obtener empleados: " + response.getStatus() + " - " + response.getStatusText());
        }
        return Collections.emptyList();
    }
}