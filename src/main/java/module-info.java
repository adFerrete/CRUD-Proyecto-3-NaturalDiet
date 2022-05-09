module com.IESFranciscodelosrios.DavidFerrete.NaturalDiet {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires java.xml.bind;

    opens com.IESFranciscodelosrios.DavidFerrete.NaturalDiet to javafx.fxml;
    opens utils to java.xml.bind;
    opens model.Dao to java.sql;
    exports com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;
}
