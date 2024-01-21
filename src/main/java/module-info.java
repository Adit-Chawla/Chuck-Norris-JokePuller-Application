module com.example.javaassign2200531948 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
            
                            
    opens com.example.javaassign2200531948 to javafx.fxml, com.google.gson;
    exports com.example.javaassign2200531948;
}