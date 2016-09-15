package cz.lachi.drddesk.model;

import cz.lachi.drddesk.model.Kostka;



/**
 *
 * @author Aramis
 */
public class Vlastnost {

    /**
     * Uchovává bonusy od -5 do +10 pro vlastnosti od 1 až 32. Hodnota vlastnosti
     * je zároveň index pole příslušného bonusu.
     */
    static final String[] BONUSY = {"0", "-5", "-4", "-4", "-3", "-3", "-2",
    //                        indexy: 0    1     2     3     4     5     6
        "-2", "-1", "-1", "+0", "+0", "+0", "+1", "+1", "+2", "+2", "+3", "+3",
    //    7     8     9    10    11    12    13    14    15    16    17    18
         "+4", "+4", "+5", "+5", "+6", "+6", "+7", "+7", "+8", "+8", "+9", "+9",
    //    19    20    21    22    23    24    25    26    27    28    29    30
          "+10", "+10"};
    //      31     32

    /**
     * Uchovává vlastnosti pro rasu hobit v pořadí Síla, Obratnost, Odolnost,
     * Inteligence a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů
     * šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru je počet
     * hodů k6 a ve druhém konstanta.
     */
    static final int[][] HOBIT = {{1, 1, 1, 1, 2},
                                  {2,10, 7, 9, 6}};

    /**
     * Uchovává vlastnosti pro rasu kudůk v pořadí Síla, Obratnost, Odolnost,
     * Inteligence a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů
     * šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru je počet
     * hodů k6 a ve druhém konstanta.
     */
    static final int[][] KUDUK = {{1, 1, 1, 1, 1},
                                  {4, 9, 9, 8, 6}};

    /**
     * Uchovává vlastnosti pro rasu trpaslík v pořadí Síla, Obratnost, Odolnost,
     * Inteligence a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů
     * šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru je počet
     * hodů k6 a ve druhém konstanta.
     */
    static final int[][] TRPASLIK = {{1, 1, 1, 1, 1},
                                     {6, 6,11, 7, 6}};

    /**
     * Uchovává vlastnosti pro rasu elf v pořadí Síla, Obratnost, Odolnost,
     * Inteligence a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů
     * šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru je počet
     * hodů k6 a ve druhém konstanta.
     */
    static final int[][] ELF = {{1, 1, 1, 1, 2},
                                {5, 9, 5,11, 6}};

    /**
     * Uchovává vlastnosti pro rasu člověk v pořadí Síla, Obratnost, Odolnost,
     * Inteligence a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů
     * šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru je počet
     * hodů k6 a ve druhém konstanta.
     */
    static final int[][] CLOVEK = {{2, 1, 1, 1, 3},
                                   {4, 8, 8, 9,-1}};

    /**
     * Uchovává vlastnosti pro rasu barbar v pořadí Síla, Obratnost, Odolnost,
     * Inteligence a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů
     * šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru je počet
     * hodů k6 a ve druhém konstanta.
     */
    static final int[][] BARBAR = {{1, 1, 1, 1, 3},
                                   {9, 7,10, 5,-2}};

    /**
     * Uchovává vlastnosti pro rasu kroll v pořadí Síla, Obratnost, Odolnost,
     * Inteligence a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů
     * šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru je počet
     * hodů k6 a ve druhém konstanta.
     */
    static final int[][] KROLL = {{1, 1, 1, 1, 2},
                                 {10, 4,12, 1,-1}};

    /**
     * Uchovává základní vlastnosti povolání válečník v pořadí Síla, Obratnost,
     * Odolnost, Inteligence a Charisma. Každé povolání má právě dvě základní
     * vlastnosti, ostatní mají hodnotu 0,0. Hodnota vlastnosti se určuje určitým
     * počtem hodů šestistěnnou kostkou(k6) a připočtením konstanty. V prvním
     * rozměru je počet hodů k6 a ve druhém konstanta.
     */
    static final int[][] VALECNIK = {{1, 0, 1, 0, 0},
                                    {12, 0,12, 0, 0}};

    /**
     * Uchovává základní vlastnosti povolání hraničář v pořadí Síla, Obratnost,
     * Odolnost, Inteligence a Charisma. Každé povolání má právě dvě základní
     * vlastnosti, ostatní mají hodnotu 0,0. Hodnota vlastnosti se určuje určitým
     * počtem hodů šestistěnnou kostkou(k6) a připočtením konstanty. V prvním
     * rozměru je počet hodů k6 a ve druhém konstanta.
     */
    static final int[][] HRANICAR = {{1, 0, 0, 1, 0},
                                    {10, 0, 0,11, 0}};

    /**
     * Uchovává základní vlastnosti povolání alchymista v pořadí Síla, Obratnost,
     * Odolnost, Inteligence a Charisma. Každé povolání má právě dvě základní
     * vlastnosti, ostatní mají hodnotu 0,0. Hodnota vlastnosti se určuje určitým
     * počtem hodů šestistěnnou kostkou(k6) a připočtením konstanty. V prvním
     * rozměru je počet hodů k6 a ve druhém konstanta.
     */
    static final int[][] ALCHYLISTA = {{0, 1, 1, 0, 0},
                                       {0,12,11, 0, 0}};

    /**
     * Uchovává základní vlastnosti povolání kouzelník v pořadí Síla, Obratnost,
     * Odolnost, Inteligence a Charisma. Každé povolání má právě dvě základní
     * vlastnosti, ostatní mají hodnotu 0,0. Hodnota vlastnosti se určuje určitým
     * počtem hodů šestistěnnou kostkou(k6) a připočtením konstanty. V prvním
     * rozměru je počet hodů k6 a ve druhém konstanta.
     */
    static final int[][] KOUZELNIK = {{0, 0, 0, 1, 1},
                                      {0, 0, 0,13,12}};

    /**
     * Uchovává základní vlastnosti povolání zloděj v pořadí Síla, Obratnost,
     * Odolnost, Inteligence a Charisma. Každé povolání má právě dvě základní
     * vlastnosti, ostatní mají hodnotu 0,0. Hodnota vlastnosti se určuje určitým
     * počtem hodů šestistěnnou kostkou(k6) a připočtením konstanty. V prvním
     * rozměru je počet hodů k6 a ve druhém konstanta.
     */
    static final int[][] ZLODEJ = {{0, 1, 0, 0, 1},
                                   {0,13, 0, 0,11}};

    /**
     * Uchovává opravy - konstanty upravující základní vlastnosti povolání pro
     * rasu hobit, které jsou potřeba při určení hodnoty vlastnosti přičíst.
     * A to v pořadí Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    static final int[] HOBIT_OPRAVY = {-5, +2, 0, -2, +3};

    /**
     * Uchovává opravy - konstanty upravující základní vlastnosti povolání pro
     * rasu kudůk, které jsou potřeba při určení hodnoty vlastnosti přičíst.
     * A to v pořadí Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    static final int[] KUDUK_OPRAVY = {-3, +1, +1, -2, 0};

    /**
     * Uchovává opravy - konstanty upravující základní vlastnosti povolání pro
     * rasu trpaslík, které jsou potřeba při určení hodnoty vlastnosti přičíst.
     * A to v pořadí Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    static final int[] TRPASLIK_OPRAVY = {+1, -2, +3, -3, -2};

    /**
     * Uchovává opravy - konstanty upravující základní vlastnosti povolání pro
     * rasu elf, které jsou potřeba při určení hodnoty vlastnosti přičíst.
     * A to v pořadí Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    static final int[] ELF_OPRAVY = {0, +1, -4, +2, +2};

    /**
     * Uchovává opravy - konstanty upravující základní vlastnosti povolání pro
     * rasu člověk, které jsou potřeba při určení hodnoty vlastnosti přičíst.
     * A to v pořadí Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    static final int[] CLOVEK_OPRAVY = {0, 0, 0, 0, 0};

    /**
     * Uchovává opravy - konstanty upravující základní vlastnosti povolání pro
     * rasu barbar, které jsou potřeba při určení hodnoty vlastnosti přičíst.
     * A to v pořadí Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    static final int[] BARBAR_OPRAVY = {+1, -1, +1, 0, -2};

    /**
     * Uchovává opravy - konstanty upravující základní vlastnosti povolání pro
     * rasu kroll, které jsou potřeba při určení hodnoty vlastnosti přičíst.
     * A to v pořadí Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    static final int[] KROLL_OPRAVY = {+3, -4, +3, -6, -5};

    /**
     * Náhodně vygeneruje hodnotu vlastnosti.
     *
     * @param pocetKostek Počet hodů šestistěnnou kostkou.
     * @param konstanta Konstanta upravující hodnotu vlastnosti.
     * @return Hodnota vlastnosti.
     */
    public static int generujVlastnost(int pocetKostek, int konstanta) {
        Kostka k6 = new Kostka(6);
        int pomocna = 0;
        for (int i = 0; i < pocetKostek; i++) pomocna += k6.hod();
        return pomocna + konstanta;
    }

    /**
     * Název vlastnosti.
     */
    private final String nazev;

    /**
     * Bonus vlastnosti.
     */
    private final String bonus;


    /**
     * Hodnota vlastnosti.
     */
    private final int hodnota;

    /**
     * Konstruktor.
     *
     * @param n název vlastnosti
     * @param h hodnota vlastnosti
     */
    public Vlastnost(String n, int h) {
        nazev = n;
        bonus = BONUSY[h];
        hodnota = h;
    }

    /**
     * @return nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @return bonus
     */
    public String getBonus() {
        return bonus;
    }

    /**
     * @return bonus
     */
    public int getBonusInt() {
        return Integer.parseInt(bonus);
    }

    /**
     * @return hodnota
     */
    public int getHodnota() {
        return hodnota;
    }

    /**
     * @return hodnota
     */
    public String getHodnotaString() {
        return String.valueOf(hodnota);
    }

    /**
     * @return Hodnota vlastnosti.
     */
    @Override
    public String toString(){
        return getHodnotaString() + " " + getBonus();
    }

}
