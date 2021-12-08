module com.example.project_java_nfk {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.project_java_nfk to javafx.fxml;
    exports com.example.project_java_nfk;
    exports com.example.project_java_nfk.Controller;
    opens com.example.project_java_nfk.Controller to javafx.fxml;
}