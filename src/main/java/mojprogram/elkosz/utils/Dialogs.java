package mojprogram.elkosz.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by Dany on 2017-07-06.
 */
public class Dialogs {

    public static void InformationDialog(){

        Alert informationdialog = new Alert(Alert.AlertType.INFORMATION);
        informationdialog.setTitle("O Programie");
        informationdialog.setHeaderText("Program ELKOSZ");
        informationdialog.setContentText("Progam rozwijamy");
        informationdialog.showAndWait();
    }

    public static Optional<ButtonType> exitDialog(){

        Alert exitdialog = new Alert(Alert.AlertType.CONFIRMATION);
        exitdialog.setTitle("Wyjscie");
        exitdialog.setHeaderText("Czy chcesz zakończyć pracę Aplikacji");
        Optional<ButtonType> result = exitdialog.showAndWait();
        return result;

    }




}
