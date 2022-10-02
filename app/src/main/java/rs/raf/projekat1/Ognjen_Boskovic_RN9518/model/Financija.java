package rs.raf.projekat1.Ognjen_Boskovic_RN9518.model;

import java.io.Serializable;

public class Financija implements Serializable {

    private int id;
    private String naslov;
    private int kolicina;
    private String opis;
    private Enum<Tip> tip;

    public Financija(int id, String naslov, int kolicina, Enum<Tip> tip, String opis) {
        this.id = id;
        this.naslov = naslov;
        this.kolicina = kolicina;
        this.tip = tip;
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Enum<Tip> getTip() {
        return tip;
    }

    public void setTip(Enum<Tip> tip) {
        this.tip = tip;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
