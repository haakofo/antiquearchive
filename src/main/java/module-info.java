module no.ntnu.idatg2001 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens no.ntnu.idatg2001 to javafx.fxml, com.google.gson;
    exports no.ntnu.idatg2001;
}