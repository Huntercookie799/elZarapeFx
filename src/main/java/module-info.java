module org.utl.dsm403.zarape.elzarape {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.utl.dsm403.zarape.elzarape.controller to javafx.fxml;
    opens org.utl.dsm403.zarape.elzarape to javafx.fxml, javafx.graphics;
    opens org.utl.dsm403.zarape.elzarape.model to javafx.base;
    opens org.utl.dsm403.zarape.elzarape.view to javafx.fxml;

    exports org.utl.dsm403.zarape.elzarape;
    exports org.utl.dsm403.zarape.elzarape.controller;
    exports org.utl.dsm403.zarape.elzarape.model;
}