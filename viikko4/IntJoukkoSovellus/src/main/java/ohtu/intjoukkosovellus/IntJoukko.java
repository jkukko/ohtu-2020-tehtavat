
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatusKoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuJoukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        lukuJoukko = new int[KAPASITEETTI];
        alkioidenLkm = 0;
        this.kasvatusKoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        this.lukuJoukko = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatusKoko = OLETUSKASVATUS;

    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti tai kasvatuskoko väärin");//heitin vaan jotain :D
        }
        this.lukuJoukko = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatusKoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            this.lukuJoukko[this.alkioidenLkm] = luku;
            alkioidenLkm++;
                if (alkioidenLkm == lukuJoukko.length) {
                    kasvataTaulukko();
                }
                return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        if (palauttaaLuvunIndeksinMuutenMiinusYksi(luku) != -1) {
            return true;
        }
        return false;
    }
    
    public int palauttaaLuvunIndeksinMuutenMiinusYksi(int luku) {
        for (int i = 0; i < this.alkioidenLkm; i++) {
            if (luku == this.lukuJoukko[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {
        int luvunIndeksi = palauttaaLuvunIndeksinMuutenMiinusYksi(luku);
        if (luvunIndeksi == -1 ) {
            return false;
        }
        this.lukuJoukko[luvunIndeksi] = 0;
        siirtaaLukuja(luvunIndeksi);
        alkioidenLkm--;
        return true;
    }
    
    public void siirtaaLukuja(int i) {
        int apu;
        for (int j = i; j < this.alkioidenLkm - 1; j++) {
            apu = this.lukuJoukko[j];
            this.lukuJoukko[j] = this.lukuJoukko[j + 1];
            this.lukuJoukko[j + 1] = apu;
        }        
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += lukuJoukko[i];
                tuotos += ", ";
            }
            tuotos += lukuJoukko[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        return Arrays.copyOf(this.lukuJoukko, this.alkioidenLkm);
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }

    private void kasvataTaulukko() {
        int[] newTaulukko = new int[this.alkioidenLkm + OLETUSKASVATUS];
        for (int i = 0; i < this.lukuJoukko.length; i++) {
            newTaulukko[i] = this.lukuJoukko[i];    
        }
        this.lukuJoukko = newTaulukko;
    }
        
}
