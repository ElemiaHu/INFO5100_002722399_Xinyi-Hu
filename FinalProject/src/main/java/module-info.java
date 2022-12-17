module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javaxt.core;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}