package ohtu.verkkokauppa;

public interface IOOstoskori {

    int hinta();

    void lisaa(Tuote t);

    void poista(Tuote t);
    
}
