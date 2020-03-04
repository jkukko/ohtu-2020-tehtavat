package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface IOKirjanpito {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
