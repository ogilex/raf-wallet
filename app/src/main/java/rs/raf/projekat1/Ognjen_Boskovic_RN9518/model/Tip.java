package rs.raf.projekat1.Ognjen_Boskovic_RN9518.model;

public enum Tip {

    PRIHOD(true), RASHOD(false);

    public final boolean flag;

    Tip(boolean b) {
        this.flag = b;
    }
}
