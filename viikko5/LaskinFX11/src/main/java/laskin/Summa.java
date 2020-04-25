package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    private int edeltavaSyottokentta = 0;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        talletaEdeltavaTilanne();
        sovellus.plus(Integer.parseInt(syottokentta.getText()));
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
        nollaa.disableProperty().set(false);
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        sovellus.miinus(edeltavaSyottokentta);
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }

    private void talletaEdeltavaTilanne() {
        edeltavaSyottokentta = Integer.parseInt(syottokentta.getText());
    }
    
}
