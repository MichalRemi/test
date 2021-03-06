package cz.lachi.drddesk.model;

/*******************************************************************************
 * Instance třídy {@code Vlastnosti} představují pole vlastností pro daného
 * tvora. Skládá se z Vlastnost[] - obsahuje názv, hodnotu a bonus.
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 2016-09-04
 */
public class Vlastnosti
{
//== CONSTANT CLASS ATTRIBUTES =================================================

//== VARIABLE CLASS ATTRIBUTES =================================================

    String[] nazvyVlastnosti = {"Síla", "Obratnost", "Odolnost", "Inteligence", "Charisma"};


//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /**
     * Vrátí vlastnosti podle rasy a povolání ve formě intervalu - počet k6
     * plus konstanta
     *
     * @param rasa Rasa
     * @param povolani Povolání
     * @param opravy Opravy vlastností podle rasy.
     * @return 2D Pole int, v prvním rozmětu počet k6, ve druhém konstanta.
     */
    public static int[][] vlastnostiVIntervalech(Rasa rasa, Povolani povolani, int[] opravy) {
        int[][] vlastnostiRasy = rasa.getVlastnosti();
        int delka = vlastnostiRasy[0].length;
        int[][] vlastnostiPovolani = povolani.getVlastnosti();
        int[][] vlastnostiNovePostavy = new int[5][5];

        // Výběr vlastností. Pokud se jedná o základní vlastnost povolání,
        // je zvolena ta. V opčaném případě je použita vlastnost rasy.
        // U vlastnosti povolání se ke konstantě přičte oprava za rasu.
        for (int i = 0; i < delka; i++) {
            if (vlastnostiPovolani[0][i] > 0) {
                vlastnostiNovePostavy[0][i] = vlastnostiPovolani[0][i];
                vlastnostiNovePostavy[1][i] = vlastnostiPovolani[1][i] + opravy[i];
            }
            else {
                vlastnostiNovePostavy[0][i] = vlastnostiRasy[0][i];
                vlastnostiNovePostavy[1][i] = vlastnostiRasy[1][i];
            }
        }
        return vlastnostiNovePostavy;
    }

    /**
     * Vygeneruje náhodně hodnoty vlastností.
     *
     * @param interval 2D pole vlastností, první rozměr udává počet k6, druhý
     * konstantu.
     * @return Pole hodnot vlastností - výsledek "hodů" xk6 + konstanta.
     */
    public static int[] generujVlastnosti(int[][] interval) {
        int[] pomocne = new int[interval.length];
        for (int i = 0; i < interval.length; i++) {
            pomocne[i] = Vlastnost.generujVlastnost(interval[0][i],interval[1][i]);
        }
        return pomocne;
    }

//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /***************************************************************************
     * Pole o velikosti 5 prvků, obsahuje vlastnosti tvora.
     */
    Vlastnost[] vlastnosti = new Vlastnost[5];


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     * @param hodnotyVlastnosti
     */
    public Vlastnosti(int[] hodnotyVlastnosti) {
        for (int i = 0; i < hodnotyVlastnosti.length; i++) {
            vlastnosti[i] = new Vlastnost(nazvyVlastnosti[i], hodnotyVlastnosti[i]);
        }
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
     * @param i Číslo pořadí vlastnosti od 0 do 4 pro Sílu až Charisma.
     * @return vlastnost
     */
    public Vlastnost getVlastnost(int i) {
        return vlastnosti[i];
    }

    /**
     * @param i Číslo pořadí vlastnosti od 0 do 4 pro Sílu až Charisma.
     * @return bonus
     */
    public String getBonus(int i) {
        return vlastnosti[i].getBonus();
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
