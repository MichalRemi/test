package cz.lachi.drddesk.model;

import java.util.Random;

/**
 *
 * @author Lachi
 */
class Kostka {
    private Random random;

    private final int pocetSten;

    /**
     * Konstruktor pro kostku s libovolným počtem stěn
     *
     * @param PocetSten
     */
    public Kostka(int PocetSten)
    {
        this.pocetSten = PocetSten;
        random = new Random();
    }

    /**
    * Vrátí počet stěn hrací kostky
    * @return počet stěn hrací kostky
    */
    public int getPocetSten()
    {
        return pocetSten;
    }

    /**
    * Vykoná hod kostkou
    * @return Číslo od 1 do počtu stěn
    */
    public int hod()
    {
        return random.nextInt(pocetSten) + 1;
    }

    /**
    * Vrací textovou reprezentaci kostky - vypíše kolik má stěn
    * @return Textová reprezentace kostky
    */
    @Override
    public String toString()
    {
        return String.format("Kostka s %s stěnami", pocetSten);
    }
}
