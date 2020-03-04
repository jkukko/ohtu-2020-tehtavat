package ohtu.verkkokauppa;

public interface IOPankki {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
