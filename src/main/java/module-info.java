module program.modul {
    requires javafx.controls;
    requires javafx.fxml;


    opens program.modul6 to javafx.fxml;
    exports program.modul6;
}