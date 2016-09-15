/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.lachi.drddesk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*******************************************************************************
 * Instance třídy {@code DataIO} pracují s daty z databáze drdesk_db.
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 2016-19-11
 */


//------------------------------------------------------------------------------
//
//  *** DATABÁZE drdesk_db: ***
//
//  tabulka heros_character (povolání):
//
//  id - INT - id
//  name - VARCHAR(50) - název
//  strengthMin - TINYINT - dolní mez síly
//  strengthMax - TINYINT - horní mez síly
//  dexterityMin - TINYINT - dolní nez obratnosti
//  dexterityMax - TINYINT - horní mez obratnosti
//  enduranceMin - TINYINT - dolní mez odolosti
//  enduranceMax - TINYINT - horní mez odolnosti
//  intelligenceMin - TINYINT - dolní mez inteligence
//  intelligenceMax - TINYINT - horní mez inteligence
//  charismaMin - TINYINT - dolní mez charisma
//  charismaMax - TINYINT - hormí mez charisma
//  health - TINYINT - přírůstek životů podle povolání
//  specialAbilities - VARCHAR(21845) - zvláštní schopnosti podle povolání
//  description - VARCHAR(21845) - popis povolání
//
//
//  tabulka experiences (zkušenosti):
//
//  id - INT - id
//  level - TINYINT - úroveň postavy
//  warrior - INT - válečník
//  ranger - INT - hraničář
//  alchemist - INT - alchymista
//  sorcerer - INT - kouzelník
//  thief - INT - zloděj
//
//
//  tabulka hero (postava):
//
//  id - INT - id
//  name - VARCHAR(50) - jméno
//  race - VARCHAR(50) - rasa
//  herosCharacter - VARCHAR(50) - povolání
//  health - SMALLINT - životy
//  healthMax - SMALLINT - maximum životů
//  mags - SMALLINT - magy
//  magsMax - SMALLINT - maximum magů
//  level - TINYINT - úroveň
//  experiences - INT - zkušenosti
//  nextLevelExp - INT - zkušenosti potřebné na další úroveň
//  strength - TINYINT - síla
//  dexterity - TINYINT - obratnost
//  endurance - TINYINT - odolnost
//  intelligence - TINYINT - inteligence
//  charisma - TINYINT - charisma
//  movability - TINYINT - pohyblivost
//
//
//  tabulka monster (nestvůra):
//
//  id - int - id
//  name - VARCHAR(50) - název
//  viability - TINYINT - životaschopnost
//  attack - VARCHAR(200) - útočné číslo, popis různých druhů útoku, atd.
//  defense - TINYINT - obranné číslo
//  strength - TINYINT - síla
//  dexterity - TINYINT - obratnost
//  endurance - TINYINT - odolnost
//  intelligence - TINYINT - inteligence
//  charisma - TINYINT - charisma
//  movability - VARCHAR(50) - pohyblivost
//  size - VARCHAR(2) - velikost nestvůry
//  agresivity - TINYINT - bojovnost
//  vulnerability - VARCHAR(200) - zranitelnost
//  stamina - VARCHAR(50) - vytrvalost
//  manoeuvring - TINYINT - manévrovací schopnost
//  basicMindStrength - VARCHAR(20) - základní síla mysli
//  conviction - VARCHAR(50) - přesvědčení
//  treasure - VARCHAR(100) - poklad
//  experiences - SMALLINT - získané zkušenosti za přemožení
//  tamed - VARCHAR(50) - ochočení
//  note - VARCHAR(21845) - poznámka
//
//
//  tabulka race (rasa):,
//
//  id - int - id
//  name - VARCHAR(50) - název
//  strengthMin - TINYINT - dolní mez síly
//  strengthMax - TINYINT - horní mez síly
//  dexterityMin - TINYINT - dolní nez obratnosti
//  dexterityMax - TINYINT - horní mez obratnosti
//  enduranceMin - TINYINT - dolní mez odolosti
//  enduranceMax - TINYINT - horní mez odolnosti
//  intelligenceMin - TINYINT - dolní mez inteligence
//  intelligenceMax - TINYINT - horní mez inteligence
//  charismaMin - TINYINT - dolní mez charisma
//  charismaMax - TINYINT - hormí mez charisma
//  correctionCharacterStrength - TINYINT - oprava síly podle povolání
//  correctionCharacterDexterity - TINYINT - oprava obratnosti podle povolání
//  correctionCharacterEndurance - TINYINT - oprava odolnosti podle povolání
//  correctionCharacterIntelligence - TINYINT - oprava inteligence podle povolání
//  correctionCharacterCharisma - TINYINT - oprava charismy podle povolání
//  heightMin - SMALLINT - minimální výška rasy
//  heigthMax - SMALLINT - maximální výška rasy
//  weigthMin - SMALLINT - minimální váha rasy
//  weigthMax - SMALLINT - maximální váha rasy
//  movability - TINYINT - základ pohyblivosti podle ras (+ Obr + 2Sil)
//  specialAbilites - CHAR(255) - zvláštní schopnosti podle rasy
//  raseWeapon - VARCHAR(50) - rodová zbraň
//  size - VARCHAR(2) - velikost rasy
//  description - VARCHAR(21845) - popis rasy
//
//------------------------------------------------------------------------------



public class DataIO {

//== CONSTANT CLASS ATTRIBUTES =================================================

//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private static final String HESLO = "root";

//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public DataIO() {

    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


    public ArrayList<String> getNazvyRas() {
        try (Connection spojeni = DriverManager.getConnection(
                "jdbc:mysql://localhost/drddesk_db?user=root&password=" + HESLO);
        PreparedStatement dotaz = spojeni.prepareStatement("SELECT nazev FROM rasa");
        ResultSet data = dotaz.executeQuery(); ) {
        ArrayList<String> rasy = new ArrayList();
        while (data.next()) {
                String nazev = data.getString("nazev");
                rasy.add(nazev);
            }
            return rasy;

        } catch (SQLException ex) {
         System.out.println("Chyba při komunikaci s databází: " + ex);
         return null;
        }
    }

    public ArrayList<String> getNazvyPovolani() {
        try (Connection spojeni = DriverManager.getConnection(
                "jdbc:mysql://localhost/drddesk_db?user=root&password=" + HESLO);
        PreparedStatement dotaz = spojeni.prepareStatement(
                "SELECT nazev FROM povolani");
        ResultSet data = dotaz.executeQuery(); ) {
        ArrayList<String> povolani = new ArrayList();
        while (data.next()) {
                String nazev = data.getString("nazev");
                povolani.add(nazev);
            }
            return povolani;

        } catch (SQLException ex) {
         System.out.println("Chyba při komunikaci s databází: " + ex);
         return null;
        }
    }


    public Rasa getRasa(String rasa) {
        try (Connection spojeni = DriverManager.getConnection(
                "jdbc:mysql://localhost/drddesk_db?user=root&password=" + HESLO);
        PreparedStatement dotaz = spojeni.prepareStatement(
                "SELECT * FROM rasa WHERE nazev=?");) {
        dotaz.setString(1, rasa);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();

                int[][] vlastnosti = {{vysledky.getInt("sila_min"),
                                       vysledky.getInt("obratnost_min"),
                                       vysledky.getInt("odolnost_min"),
                                       vysledky.getInt("inteligence_min"),
                                       vysledky.getInt("charisma_min")},
                                      {vysledky.getInt("sila_max"),
                                       vysledky.getInt("obratnost_max"),
                                       vysledky.getInt("odolnost_max"),
                                       vysledky.getInt("inteligence_max"),
                                       vysledky.getInt("charisma_max")}};

                int[] opravy = {vysledky.getInt("oprava_sila"),
                                vysledky.getInt("oprava_obratnost"),
                                vysledky.getInt("oprava_odolnost"),
                                vysledky.getInt("oprava_inteligence"),
                                vysledky.getInt("oprava_charisma")};

                int[] vyska = {vysledky.getInt("vyska_min"),
                               vysledky.getInt("vyska_max")};

                int[] vaha = {vysledky.getInt("vaha_min"),
                              vysledky.getInt("vaha_max")};

                Rasa rasaPomocna = new Rasa(rasa, vlastnosti, opravy, vyska, vaha,
                        vysledky.getInt("pohyblivost"),
                        vysledky.getString("zvlastni_schopnosti"),
                        vysledky.getString("rodova_zbran"),
                        vysledky.getString("velikost"),
                        vysledky.getString("popis"));

                return rasaPomocna;
            }
        } catch (SQLException ex) {
        System.out.println("Chyba při komunikaci s databází" + ex);
        return null;
        }
    }

    public Povolani getPovolani(String povolani) {
        try (Connection spojeni = DriverManager.getConnection(
                "jdbc:mysql://localhost/drdesk_db?user=root&password=" + HESLO);
        PreparedStatement dotaz = spojeni.prepareStatement(
                "SELECT * FROM heros_character WHERE name=?");) {
        dotaz.setString(1, povolani);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();

                int[][] vlastnosti = {{vysledky.getInt("strengthMin"),
                                       vysledky.getInt("dexterityMin"),
                                       vysledky.getInt("enduranceMin"),
                                       vysledky.getInt("intelligenceMin"),
                                       vysledky.getInt("charismaMin")},
                                      {vysledky.getInt("strengthMax"),
                                       vysledky.getInt("dexterityMax"),
                                       vysledky.getInt("enduranceMax"),
                                       vysledky.getInt("intelligenceMax"),
                                       vysledky.getInt("charismaMax")}};

                Povolani povolaniPomocne = new Povolani(povolani, vlastnosti,
                        vysledky.getInt("health"),
                        vysledky.getString("specialAbilities"),
                        vysledky.getString("description"));

                return povolaniPomocne;
            }
        } catch (SQLException ex) {
        System.out.println("Chyba při komunikaci s databází" + ex);
        return null;
        }
    }

    public int getZkusenosti(String povolani, int uroven) {
        try (Connection spojeni = DriverManager.getConnection(
                "jdbc:mysql://localhost/drdesk_db?user=root&password=" + HESLO);
        PreparedStatement dotaz = spojeni.prepareStatement(
                "SELECT * FROM experiences WHERE level=?");) {
            dotaz.setInt(1, uroven);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();
                switch (povolani) {
                    case "válečník": return vysledky.getInt("warrior");
                    case "hraničář": return vysledky.getInt("ranger");
                    case "alchymista": return vysledky.getInt("alchemist");
                    case "kouzelník": return vysledky.getInt("sorcerer");
                    case "zloděj": return vysledky.getInt("thief");
                    default: return -1;
                }
            }
        } catch (SQLException ex) {
        System.out.println("Chyba při komunikaci s databází" + ex);
        return -1;
        }
    }











//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================

}
