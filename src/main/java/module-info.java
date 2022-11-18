module at.fhtw.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.fhtw.javafx to javafx.fxml;
    exports at.fhtw.javafx;
}
