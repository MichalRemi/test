/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.lachi.drddesk;

import cz.lachi.drddesk.model.DataIO;
import cz.lachi.drddesk.model.Rasa;
import cz.lachi.drddesk.model.Vlastnosti;
import cz.lachi.drddesk.model.Postava;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aramis
 */
public class FXMLNovaPostavaController implements Initializable {

    /**
     * TextField pro jméno postavy.
     */
    @FXML
    private TextField jmenoPostavyTextField;

    /**
     * ComboBox s výběrem ras postav.
     */
    @FXML
    private ComboBox<String> rasaComboBox;

    /**
     * ComboBox s výběrem povolání postav.
     */
    @FXML
    private ComboBox<String> povolaniComboBox;

    /**
     * ComboBox s výběrem úrovní postav.
     */
    @FXML
    private ComboBox<String> urovenComboBox;

    /**
     * ComboBox s výběrem výšky postavy.
     */
    @FXML
    private ComboBox<Integer> vyskaPostavyComboBox;

    /**
     * ComboBox s výběrem váhy postavy.
     */
    @FXML
    private ComboBox<Integer> vahaPostavyComboBox;

    /**
     * Tlačítko pro zavření dialogového okna
     */
    @FXML
    private Button konecButton;

    /**
     * Tlačítko pro vygenerování náhodných Vlastností nové postavy
     */
    @FXML
    private Button nahodneVlastnostiButton;

    /**
     * Tlačítko pro vygenerování náhodných Vlastností nové postavy
     */
    @FXML
    private Button pokracujButton;

    /**
     * Label zobrazující sílu postavy.
     */
    @FXML
    private Label silaLabel;

    /**
     * Label zobrazující obratnost postavy.
     */
    @FXML
    private Label obratnostLabel;

    /**
     * Label zobrazující odolnost postavy.
     */
    @FXML
    private Label odolnostLabel;

    /**
     * Label zobrazující inteligenci postavy.
     */
    @FXML
    private Label inteligenceLabel;

    /**
     * Label zobrazující charisma postavy.
     */
    @FXML
    private Label charismaLabel;

    /**
     * Label s bonusem/posihem síly postavy.
     */
    @FXML
    private Label silaBonusLabel;

    /**
     * Label s bonusem/posihem obratnosti postavy.
     */
    @FXML
    private Label obratnostBonusLabel;

    /**
     * Label s bonusem/posihem odolnosti postavy.
     */
    @FXML
    private Label odolnostBonusLabel;

    /**
     * Label s bonusem/posihem inteligence postavy
     */
    @FXML
    private Label inteligenceBonusLabel;

    /**
     * Label s bonusem/posihem charisma postavy.
     */
    @FXML
    private Label charismaBonusLabel;

    /**
     * Obsluha tlačítka pro zavření dialogového okna
     */
    @FXML
    private void handleKonec(ActionEvent event) {
        Stage stage = (Stage) konecButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Obsluha tlačítka pro pokračování
     */
    @FXML
    private void handlePokracuj(ActionEvent event) {
        Postava novaPostava = new Postava(jmenoPostavyTextField.getText(),
                    rasaComboBox.getSelectionModel().getSelectedItem(),
                    povolaniComboBox.getSelectionModel().getSelectedItem(),
                    urovenComboBox.getSelectionModel().getSelectedItem(),
                    vyskaPostavyComboBox.getSelectionModel().getSelectedItem(),
                    vahaPostavyComboBox.getSelectionModel().getSelectedItem());
        AktualniPostava.setVlastnosti(novaPostava);
        Postava.setAktualniPostava(novaPostava);
        Stage stage = (Stage) pokracujButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Obsluha tlačítka pro pokračování
     */
    @FXML
    private void handleVyber(ActionEvent event) {
        testovaniVyberu();
    }

    /**
     * Obsluha tlačítka pro pokračování
     */
    @FXML
    private void handleText(KeyEvent event) {
        testovaniVyberu();
    }

    /**
     * Na základě zvolené rasy a povolání uručí náhodně pomocí instance metody
     * kostka k6 (sestistěnná kostka) hodnoty vlastností z intervalů definovaných
     * ve třídě Vlastnost.
     */
    @FXML
    private void handleNahodneVlastnosti(ActionEvent event) {
        DataIO io = new DataIO();
        String zvolenaRasa = rasaComboBox.getSelectionModel().getSelectedItem();
        String zvolenePovolani = povolaniComboBox.getSelectionModel().getSelectedItem();

        int[][] intervalVlastnosti = Vlastnosti.vlastnostiVIntervalech(zvolenaRasa, zvolenePovolani, zvolenaRasa.getOpravy());
        int[] hodnotyVlastnosti = Vlastnosti.generujVlastnosti(intervalVlastnosti);

        Vlastnosti noveVlastnosti = new Vlastnosti(hodnotyVlastnosti);
        Postava.setAktualniVlastnosti(noveVlastnosti);

        silaLabel.setText(noveVlastnosti.getVlastnost(0).getHodnotaString());
        obratnostLabel.setText(noveVlastnosti.getVlastnost(1).getHodnotaString());
        odolnostLabel.setText(noveVlastnosti.getVlastnost(2).getHodnotaString());
        inteligenceLabel.setText(noveVlastnosti.getVlastnost(3).getHodnotaString());
        charismaLabel.setText(noveVlastnosti.getVlastnost(4).getHodnotaString());

        silaBonusLabel.setText(noveVlastnosti.getBonus(0));
        obratnostBonusLabel.setText(noveVlastnosti.getBonus(1));
        odolnostBonusLabel.setText(noveVlastnosti.getBonus(2));
        inteligenceBonusLabel.setText(noveVlastnosti.getBonus(3));
        charismaBonusLabel.setText(noveVlastnosti.getBonus(4));

        pokracujButton.setDisable(false);
    }

    /**
     * Testuje, zda byl proveden výběr jména, rasy a povolání. Pokud ano, povolí
     * tlačítko Pokračovat. Pokub byla zvolena správně pouze rasa, povolí
     * a naplní podle aktuální rasy výšku a váhu pomocí metod nastavVysku()
     * a nastavVahu().
     */
    private void testovaniVyberu() {
        Rasa aktualniRasa = rasaComboBox.getSelectionModel().getSelectedItem();
        if (aktualniRasa != null) {
            nastavVysku(aktualniRasa);
            nastavVahu(aktualniRasa);
            if (!(jmenoPostavyTextField.getText().equals("")) &&
                (povolaniComboBox.getSelectionModel().getSelectedItem() != null) &&
                (vyskaPostavyComboBox.getSelectionModel().getSelectedItem() != null) &&
                (vahaPostavyComboBox.getSelectionModel().getSelectedItem() != null))
                nahodneVlastnostiButton.setDisable(false);
            else nahodneVlastnostiButton.setDisable(true);
        }
    }

    /**
     * Na základě zvolené rasy postavy inicializuje combobox vyskaPostavyComboBox
     * @param rasa Rasa
     */
    private void nastavVysku(Rasa rasa){

        ObservableList<Integer> vyska = FXCollections.observableArrayList();
        vyska = null;
        vyskaPostavyComboBox.setItems(vyska);



        vyskaPostavyComboBox.setDisable(false);
        int[] aktualniMeze = rasa.getVyska();
        Integer[] aktualniInterval = Rasa.hodnotyPodleMezi(aktualniMeze[0], aktualniMeze[1], 5);
        vyskaPostavyComboBox.setItems(naplnKolekci(aktualniInterval));
        vyskaPostavyComboBox.setPromptText("Vyberte výšku");
    }

    /**
     * Na základě zvolené rasy postavy inicializuje combobox vahaPostavyComboBox
     * @param rasa Rasa
     */
    private void nastavVahu(Rasa rasa){

        ObservableList<Integer> vaha = FXCollections.observableArrayList();
        vaha = null;
        vahaPostavyComboBox.setItems(vaha);

        vahaPostavyComboBox.setDisable(false);
        int[] aktualniMeze = rasa.getVaha();
        Integer[] aktualniInterval = Rasa.hodnotyPodleMezi(aktualniMeze[0], aktualniMeze[1], 100);
        vahaPostavyComboBox.setItems(naplnKolekci(aktualniInterval));
        vahaPostavyComboBox.setPromptText("Vyberte váhu");
    }

    /**
     * Po vložení Integer[] vrátí ekvivalent v FXCollections
     * @param pole Integer[]
     * @return FXCollections
     */
    private ObservableList<Integer> naplnKolekci(Integer[] pole) {
        ObservableList<Integer> pomocne = FXCollections.observableArrayList();
        pomocne.addAll(pole);
        return pomocne;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataIO io = new DataIO();

        /**
        * Inicializace názvů ras, vytvoření ObservableCollection rasy
        */
        ObservableList<String> rasy = FXCollections.observableArrayList();
        rasy.addAll(io.getNazvyRasy());
        rasaComboBox.setItems(rasy);
        rasaComboBox.setPromptText("vyberte rasu");

        /**
        * Inicializace povolání, vytvoření ObservableCollection povolani
        */
        ObservableList<String> povolani = FXCollections.observableArrayList();
        povolani.addAll(io.getNazvyPovolani());
        povolaniComboBox.setItems(povolani);
        povolaniComboBox.setPromptText("vyberte povolání");


        /**
        * Inicializace úrovní, vytvoření ObservableCollection úrovní
        */
        ObservableList<String> uroven = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        urovenComboBox.setItems(uroven);
        urovenComboBox.getSelectionModel().selectFirst();
    }
}
