module no.ntnu.idatg2001 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens no.antiquearchive to javafx.fxml, com.google.gson;
    exports no.antiquearchive;
}