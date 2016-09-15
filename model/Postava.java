package cz.lachi.drddesk.model;

/**
 * Postava v DrD - jmeno, rasa, povolání,
 *
 * @author Lachi
 */
public class Postava {

    /**
     * jméno postavy
     */
    private final String jmeno;

    /**
     * rasa postavy
     */
    private final Rasa rasa;

    /**
     * povolání postavy
     */
    private final Povolani povolani;

    /**
     * vlastnosti postavy
     */
    private final Vlastnosti vlastnostiPostavy;

    /**
     * úroveň postavy
     */
    private String uroven;

    /**
     * výška postavy v coulech (1 coul [cl] je 1 cm)
     */
    private final int vyskaPostavy;

    /**
     * váha postavy v mincích (20 mincí [mn] je 1kg)
     */
    private final int vahaPostavy;

//    public static Postava getAktualniPostava() {
//        return aktualniPostava;
//    }
//
//    public static Vlastnosti getAktualniVlastnosti() {
//        return aktualniVlastnosti;
//    }
//
//    public static void setAktualniVlastnosti(Vlastnosti aktualniVlastnosti) {
//        Postava.aktualniVlastnosti = aktualniVlastnosti;
//    }
//
//    public static void setAktualniPostava(Postava aktualniPostava) {
//        Postava.aktualniPostava = aktualniPostava;
//    }
//
//    /**
//     * Konstruktor(přetížený).
//     *
//     * @param j jméno postavy
//     * @param r rasa postavy
//     * @paramu p povolání postavy
//     * @param ur úroveň postavy
//     * @param vyska výška postavy
//     * @param vaha váha postavy
//     */
//    public Postava(String j, Rasa r, Povolani p, String ur, int vyska, int vaha) {
//        this(j, r, p, aktualniVlastnosti, ur, vyska, vaha);
//    }

    /**
     * Konstruktor(Přetížený).
     *
     * @param j jméno postavy
     * @param r rasa postavy
     * @param p povolání postavy
     * @param v vlastnosti postavy
     * @param ur úroveň postavy
     * @param vyska výška postavy
     * @param vaha váha postavy
     */
    public Postava(String j, Rasa r, Povolani p, Vlastnosti v, String ur, int vyska, int vaha) {
        jmeno = j;
        rasa = r;
        povolani = p;
        vlastnostiPostavy = v;
        vahaPostavy = vaha;
        vyskaPostavy = vyska;
        uroven = ur;
    }

//    /**
//    * Vrací textovou reprezentaci postavy - vypíše jméno, rasu, povolání
//    * a vlastnosti postavy
//    *
//    * @return Textová reprezentace postavy
//    */
//    @Override
//    public String toString(){
//        String s = String.format("\n%s %s %s\n", this.getJmeno(), rasa.getJmeno(), povolani.getJmeno());
//        int hodnota;
//        int bonus;
//        String znamenko;
//        for (Vlastnost v : vlastnostiPostavy) {
//            hodnota = v.getHodnota();
//            bonus = Vlastnost.urciBonus(hodnota);
//            if (bonus > 0) znamenko = "+";
//            else znamenko = "";
//            s = s + String.format("%s %d %s%d\n", v.getNazev(), hodnota, znamenko, bonus);
//        }
//        return s;
//    }


    public String getJmeno() {
        return jmeno;
    }

    public Rasa getRasa() {
        return rasa;
    }

    public Povolani getPovolani() {
        return povolani;
    }

    public String getUroven() {
        return uroven;
    }

    public Vlastnosti getVlastnostiPostavy() {
        return vlastnostiPostavy;
    }

    public int getVyskaPostavy() {
        return vyskaPostavy;
    }

    public int getVahaPostavy() {
        return vahaPostavy;
    }

    public void setUroven(String uroven) {
        this.uroven = uroven;
    }


}
