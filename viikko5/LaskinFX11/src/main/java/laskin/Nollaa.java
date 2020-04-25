package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    private int edeltavaTuloskentta = 0;
    private int edeltavaSyottokentta = 0;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        talletaEdeltavaTilanne();
        sovellus.nollaa();
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }

    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edeltavaTuloskentta);
        tuloskentta.setText(Integer.toString(edeltavaTuloskentta));
        syottokentta.setText(Integer.toString(edeltavaSyottokentta));
    }

    private void talletaEdeltavaTilanne() {
        edeltavaSyottokentta = Integer.parseInt(syottokentta.getText());
        edeltavaTuloskentta = Integer.parseInt(tuloskentta.getText());       
    }
    
}
