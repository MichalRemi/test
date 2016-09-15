package cz.lachi.drddesk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// import javafx.stage.StageStyle;

/**
 *
 * @author Aramis
 */
public class DrDdesk extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLFirst.fxml"));

        Scene scene = new Scene(root);
        // scene.getStylesheets().add(getClass().getResource("DrDdesk.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("DrDdesk");
        // stage.initStyle(StageStyle.TRANSPARENT);
        // scene.setFill(null);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
