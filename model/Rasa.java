package cz.lachi.drddesk.model;

/**
 *
 * @author Lachi
 */
public class Rasa {

    /**
     * Jméno rasy.
     */
    private final String nazev;

    /**
     * Hodnoty vlastností (atributů) rasy v pořadí Síla, Obratnost, Odolnost, Inteligence
     * a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů šestistěnnou
     * kostkou(k6) a připočtením konstanty. V prvním rozměru je počet hodů k6 a ve druhém
     * konstanta.
     */
    private final int[][] vlastnosti;

    /**
     * Základní vlastnosti povolání (jsou vždy dvě) je potřeba opravit v závislosti
     * na rase, tj. přičíst konstantu k vlastnostem určeným podle povolání v pořadí
     * Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    private final int[] opravy;

    /**
     * Dolní a horní mez výšky rasy.
     */
    private final int[] vyska;

    /**
     * Dolní a horní mez váhy rasy.
     */
    private final int[] vaha;

    /**
     * Pohyblivost rasy.
     */
    private final int pohyblivost;

    /**
     * Zvlášní schopnosti rasy.
     */
    private final String zvlastniSchopnosti;

    /**
     * Rodova zbran rasy.
     */
    private final String rodovaZbran;

    /**
     * Velikost rasy.
     */
    private final String velikost;

    /**
     * Popis rasy.
     */
    private final String popis;

    /**
     * Vytvoří vzestupné pole hodnot od minima po maximum.
     * @param minimum Dolní mez intervalu včetně.
     * @param maximum Horní mez intervalu včetně.
     * @param krok Krok mezi sousedícími hodnotami.
     * @return pole Integer
     */
    public static Integer[] hodnotyPodleMezi(int minimum, int maximum, int krok) {
        int konstanta = ((maximum - minimum) / krok);
        Integer[] pomocne = new Integer[konstanta + 1];
        for (int i = 0; i <= konstanta; i++) {
            pomocne[i] = minimum + i * krok;
        }
        return pomocne;
    }

    /**
     * Konstruktor.
     *
     * @param nazev Jméno rasy.
     * @param vlastnosti Vlastnosti rasy. Typ int [5][5].
     * @param opravy Opravy vlastností podle povolání. Typ int[5].
     * @param vyska Dolní a horní mez výšky rasy. Typ int[2].
     * @param vaha Dolní a horní mez váhy rasy. Typ int[2].
     * @param pohyblivost Pohyblivost rasy pro určení pohyblivosti postavy, Typ int.
     * @param zvlastniSchopnosti Zvláštní schopnosti rasy, pokud žádné postava
     *      nemá, obsahuje 0. Typ String.
     * @param rodovaZbran Rodová zbraň rasy. Typ String.
     * @param velikost Velikost rasy. Typ String - 2 znaky.
     * @param popis Popis rasy. Typ String.
     */
    public Rasa(String nazev, int[][] vlastnosti, int[] opravy, int[] vyska,
    int[] vaha, int pohyblivost, String zvlastniSchopnosti, String rodovaZbran,
    String velikost, String popis) {

        this.nazev = nazev;
        this.vlastnosti = vlastnosti;
        this.opravy = opravy;
        this.vyska = vyska;
        this.vaha = vaha;
        this.pohyblivost = pohyblivost;
        this.zvlastniSchopnosti = zvlastniSchopnosti;
        this.rodovaZbran = rodovaZbran;
        this.velikost = velikost;
        this.popis = popis;
    }

    /**
     * @return jmeno rasy
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @return vlastnosti rasy v pořadí Síla, Obratnost, Odolnost, Inteligence
     * a Charisma
     */
    public int[][] getVlastnosti() {
        return vlastnosti;
    }

    /**
     * @return opravy vlastností rasy podle povolání v pořadí Síla, Obratnost,
     * Odolnost, Inteligence a Charisma
     */
    public int[] getOpravy() {
        return opravy;
    }

    /**
     * @return Dolní a horní mez výšky rasy - int[2].
     */
    public int[] getVyska() {
        return vyska;
    }

    /**
     * @return Dolní a horní mez váhy rasy - int[2].
     */
    public int[] getVaha() {
        return vaha;
    }

    /**
     * @return Pohyblivost rasy - int.
     */
    public int getPohyblivost() {
        return pohyblivost;
    }

    /**
     * @return Zvláštní schopnosti rasy, pokud rasa žádnou nemá, vrací 0 - String.
     */
    public String getZvlastniSchopnosti() {
        return zvlastniSchopnosti;
    }

    /**
     * @return Rodová zbraň rasy - String.
     */
    public String getRodovaZbran() {
        return rodovaZbran;
    }

    /**
     * @return Velikost rasy, dva znaky - String.
     */
    public String getVelikost() {
        return velikost;
    }

    /**
     * @return Popis rasy - String.
     */
    public String getPopis() {
        return popis;
    }

    /**
     * @return název rasy
     */
    @Override
    public String toString(){
        return getNazev();
    }

}
