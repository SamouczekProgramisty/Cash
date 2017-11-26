package mojprogram.elkosz;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mojprogram.elkosz.database.dbutils.DbManager;
import mojprogram.elkosz.utils.Dialogs;

import java.util.Optional;

/**
 * Created by Dany on 2017-07-03.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainFrame.fxml"));
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Program ELKOSZ");
        primaryStage.show();


        DbManager.initDatabase();

    }


}
