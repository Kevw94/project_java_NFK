module com.example.project_java_nfk {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports com.example.project_java_nfk;
    exports com.example.project_java_nfk.Controller;
    opens com.example.project_java_nfk.Controller to javafx.fxml;
    exports com.example.project_java_nfk.Module;
    opens com.example.project_java_nfk.Module to javafx.base;
    opens com.example.project_java_nfk to javafx.base, javafx.fxml;
}