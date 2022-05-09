package com.IESFranciscodelosrios.DavidFerrete.NaturalDiet;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToInicioSesion() throws IOException {
        App.setRoot("InicioSesion");
    }
    
    @FXML
    private void switchToRegistro() throws IOException {
        App.setRoot("Registro");
    }
}
