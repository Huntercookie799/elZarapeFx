package org.utl.dsm403.zarape.elzarape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL resource = HelloApplication.class.getResource("/org/utl/dsm403/zarape/elzarape/view/login.fxml");
        if (resource == null) {
            System.err.println("No se pudo encontrar el archivo FXML");
            System.exit(1);
        }
        System.out.println("Ruta del recurso: " + resource.toString());
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Scene scene = new Scene(fxmlLoader.load(), 657, 407);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}