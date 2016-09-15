/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.lachi.drddesk;

import cz.lachi.drddesk.model.Postava;










/*******************************************************************************
 * Instance třídy {@code aktualniPostava} představují ...
 * Instances of class {@code aktualniPostava} represent ...
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class AktualniPostava
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    private static String Sila;
    private static String Obratnost;
    private static String Odolnost;
    private static String Inteligence;
    private static String Charisma;



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================

    

    public static void setSila(Postava postava) {
        Sila = postava.getVlastnostiPostavy().getVlastnost(0).toString();
    }

    public static void setObratnost(Postava postava) {
        Obratnost = postava.getVlastnostiPostavy().getVlastnost(1).toString();
    }

    public static void setOdolnost(Postava postava) {
        Odolnost = postava.getVlastnostiPostavy().getVlastnost(2).toString();
    }

    public static void setInteligence(Postava postava) {
        Inteligence = postava.getVlastnostiPostavy().getVlastnost(3).toString();
    }

    public static void setCharisma(Postava postava) {
        Charisma = postava.getVlastnostiPostavy().getVlastnost(4).toString();
    }

    public static void setVlastnosti(Postava postava) {
        setSila(postava);
        setObratnost(postava);
        setOdolnost(postava);
        setInteligence(postava);
        setCharisma(postava);
    }

    public static String getSila() {
        return Sila;
    }

    public static String getObratnost() {
        return Obratnost;
    }

    public static String getOdolnost() {
        return Odolnost;
    }

    public static String getInteligence() {
        return Inteligence;
    }

    public static String getCharisma() {
        return Charisma;
    }






//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public AktualniPostava()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
