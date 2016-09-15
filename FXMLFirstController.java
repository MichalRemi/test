package cz.lachi.drddesk;

import cz.lachi.drddesk.model.DataIO;
import cz.lachi.drddesk.model.Zbroj;
import cz.lachi.drddesk.model.ZbranTVT;
import cz.lachi.drddesk.model.ZbranSAV;
import cz.lachi.drddesk.model.Postava;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Aramis
 */
public class FXMLFirstController implements Initializable {

    @FXML
    private Label JmenoLabel;

    @FXML
    private Label RasaLabel;

    @FXML
    private Label PovolaniLabel;

    @FXML
    private Label ZivotyLabel;

    @FXML
    private Label UrovenLabel;

    @FXML
    private Label MagyLabel;

    @FXML
    private Label ZkusenostiLabel;

    @FXML
    private Button konecButton;

    @FXML
    private Button novaButton;

    // Vlastnosti a atributy postavy ###########################################
    @FXML
    private Label SilaLabel;

    @FXML
    private Label ObratnostLabel;

    @FXML
    private Label OdolnostLabel;

    @FXML
    private Label InteligenceLabel;

    @FXML
    private Label CharismaLabel;

    @FXML
    private Label VahaLabel;

    @FXML
    private Label VyskaLabel;

    @FXML
    private Label PohyblivostLabel;

    @FXML
    private Label PohyblivostMirneLabel;

    @FXML
    private Label PohyblivostStredniLabel;

    @FXML
    private Label PohyblivostVelkeLabel;

    @FXML
    private Label NalozeniLabel;

    @FXML
    private Label NosnostZadneLabel;

    @FXML
    private Label NosnostMirneLabel;

    @FXML
    private Label NosnostStredniLabel;

    @FXML
    private Label NosnostVelkeLabel;

    @FXML
    private Label PostrehObjektyNahodnyLabel;

    @FXML
    private Label PostrehObjektyHledaniLabel;

    @FXML
    private Label PostrehMechanismyNahodnyLabel;

    @FXML
    private Label PostrehMechanismyHledaniLabel;

    // Zbraně tváří v tvář #####################################################
    @FXML
    private ComboBox<ZbranTVT> ZbranTvariVTvar1ComboBox;

    @FXML
    private ComboBox<ZbranTVT> ZbranTvariVTvar2ComboBox;

    @FXML
    private ComboBox<ZbranTVT> ZbranTvariVTvar3ComboBox;

    @FXML
    private Label UCZbranTvariVTvar1Label;

    @FXML
    private Label UCZbranTvariVTvar2Label;

    @FXML
    private Label UCZbranTvariVTvar3Label;

    @FXML
    private Label UtocnostZbranTvariVTvar1Label;

    @FXML
    private Label UtocnostZbranTvariVTvar2Label;

    @FXML
    private Label UtocnostZbranTvariVTvar3Label;

    @FXML
    private Label OZZbranTvariVTvar1Label;

    @FXML
    private Label OZZbranTvariVTvar2Label;

    @FXML
    private Label OZZbranTvariVTvar3Label;

    @FXML
    private Label HmotnostZbranTvariVTvar1Label;

    @FXML
    private Label HmotnostZbranTvariVTvar2Label;

    @FXML
    private Label HmotnostZbranTvariVTvar3Label;

    @FXML
    private Label OCZbranTvariVTvar1Label;

    @FXML
    private Label OCZbranTvariVTvar2Label;

    @FXML
    private Label OCZbranTvariVTvar3Label;

    // Zbraně střelné a vrhací #################################################
    @FXML
    private ComboBox<ZbranSAV> ZbranStrelnaAVrhaci1ComboBox;

    @FXML
    private ComboBox<ZbranSAV> ZbranStrelnaAVrhaci2ComboBox;

    @FXML
    private ComboBox<ZbranSAV> ZbranStrelnaAVrhaci3ComboBox;

    @FXML
    private Label UCZbranStrelnaAVrhaci1Label;

    @FXML
    private Label UCZbranStrelnaAVrhaci2Label;

    @FXML
    private Label UCZbranStrelnaAVrhaci3Label;

    @FXML
    private Label UtocnostZbranStrelnaAVrhaci1Label;

    @FXML
    private Label UtocnostZbranStrelnaAVrhaci2Label;

    @FXML
    private Label UtocnostZbranStrelnaAVrhaci3Label;

    @FXML
    private Label DostrelZbranStrelnaAVrhaci1Label;

    @FXML
    private Label DostrelZbranStrelnaAVrhaci2Label;

    @FXML
    private Label DostrelZbranStrelnaAVrhaci3Label;

    @FXML
    private Label HmotnostZbranStrelnaAVrhaci1Label;

    @FXML
    private Label HmotnostZbranStrelnaAVrhaci2Label;

    @FXML
    private Label HmotnostZbranStrelnaAVrhaci3Label;

    // Zbroj a štít ############################################################
    @FXML
    private ComboBox<Zbroj> ZbrojAStit1ComboBox;

    @FXML
    private ComboBox<Zbroj> ZbrojAStit2ComboBox;

    @FXML
    private Label KZZbrojAStit1Label;

    @FXML
    private Label KZZbrojAStit2Label;

    @FXML
    private Label HmotnostZbrojAStit1Label;

    @FXML
    private Label HmotnostZbrojAStit2Label;

    // Poznámky ################################################################
    @FXML
    private TextArea PoznamkyTextArea;

    // Zvláštní Schopnosti a kouzla ############################################
    @FXML
    private ListView<String> ZvlastniSchopnostiAKouzla;



    @FXML
    private void handleKonec(ActionEvent event)
    {
        Stage stage = (Stage) konecButton.getScene().getWindow();
        stage.close();
    }

//     /**
//     * Obsluha tlačítka na kartě Postava tlačítko Nová
//     * @param event
//     */
//    @FXML
//    private void handleNovaPostava(ActionEvent event) throws IOException {
//        try {
//            Postava postava = Postava.getAktualniPostava();
//            Stage stage;
//            Parent root;
//            stage = new Stage();
//            root = FXMLLoader.load(getClass().getResource("FXMLNovaPostava.fxml"));
//            stage.setScene(new Scene(root));
//            stage.setTitle("Nová postava");
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.initOwner(novaButton.getScene().getWindow());
//            stage.showAndWait();
//            aktualizujPostavu();
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void aktualizujPostavu() {
//        JmenoLabel.setText(AktualniPostava);
//        RasaLabel.setText(AktualniPostava);
//        PovolaniLabel.setText(AktualniPostava);
//        ZivotyLabel.setText(AktualniPostava);
//        UrovenLabel.setText(AktualniPostava);
//        ZkusenostiLabel.setText(AktualniPostava);
//        //Magy
//        MagyLabel;

        SilaLabel.setText(AktualniPostava.getSila());
        ObratnostLabel.setText(AktualniPostava.getObratnost());
        OdolnostLabel.setText(AktualniPostava.getOdolnost());
        InteligenceLabel.setText(AktualniPostava.getInteligence());
        CharismaLabel.setText(AktualniPostava.getCharisma());

//        VyskaLabel.setText(AktualniPostava);
//        VahaLabel.setText(AktualniPostava);
//
//        // Pohyblivost, mírné, střední, velké
//        PohyblivostLabel;
//        PohyblivostMirneLabel;
//        PohyblivostStredniLabel;
//        PohyblivostVelkeLabel;
//
//        //Naložení
//        NalozeniLabel;
//
//        // Nosnost, žádné, mírné, střední, velké
//
//        NosnostZadneLabel;
//        NosnostMirneLabel;
//        NosnostStredniLabel;
//        NosnostVelkeLabel;
//
//        // postřeh objekty a mechaizmy - náhodný, hledaný
//        PostrehObjektyNahodnyLabel;
//        PostrehObjektyHledaniLabel;
//        PostrehMechanismyNahodnyLabel;
//        PostrehMechanismyHledaniLabel;
//
//        // Zbraně tváří v tvář
//        ZbranTvariVTvar1ComboBox;
//        ZbranTvariVTvar2ComboBox;
//        ZbranTvariVTvar3ComboBox;
//
//        // Zbraně střelné a vrhací
//        ZbranStrelnaAVrhaci1ComboBox;
//        ZbranStrelnaAVrhaci2ComboBox;
//        ZbranStrelnaAVrhaci3ComboBox;
//
//        // Zbroj a štít
//        ZbrojAStit1ComboBox;
//        ZbrojAStit2ComboBox;
//
//        PoznamkyTextArea;
//
//        ZvlastniSchopnostiAKouzla;



    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }
}
