package mojprogram.elkosz.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mojprogram.elkosz.modelFX.CashRegisterFx;
import mojprogram.elkosz.modelFX.CashRegisterList;
import org.omg.CORBA.portable.ApplicationException;
import java.time.LocalDate;




/**
 * Created by Dany on 2017-10-07.
 */
public class ListofCashRegisterController {

    @FXML
    private TableView<CashRegisterFx> cashRegisterFxTableView;

    @FXML
    private TableColumn<CashRegisterFx,String> CompanyNameColumn;//objekt
    @FXML
    private TableColumn<CashRegisterFx, String> TypeofCashRegisterColumn;
    @FXML
    private TableColumn<CashRegisterFx, String> SerialNumerColumn;
    @FXML
    private TableColumn<CashRegisterFx, LocalDate> BuyColumn;
    @FXML
    private TableColumn<CashRegisterFx, LocalDate> LastCheckColumn;
   /* @FXML
    private TableColumn<CashRegisterFx, LocalDate> NextCheckColumn;*/
    @FXML
    private TableColumn<CashRegisterFx, CashRegisterFx> CheackColumn;

    private CashRegisterList cashRegisterList;


    private int month;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @FXML
    private void initialize(){



        this.cashRegisterList = new CashRegisterList();
        try {
            cashRegisterList.init();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
       // this.cashRegisterList

        this.cashRegisterFxTableView.setItems(this.cashRegisterList.getCashRegisterFxObservableList());
       // this.CompanyNameColumn.setCellValueFactory(cellData -> cellData.getValue().companyProperty());//poprawka
        this.TypeofCashRegisterColumn.setCellValueFactory(cellData -> cellData.getValue().modelfxProperty());
        this.SerialNumerColumn.setCellValueFactory((cellData -> cellData.getValue().srialnumberFXProperty()));
        this.BuyColumn.setCellValueFactory(cellData -> cellData.getValue().datepuchacefxProperty());
        this.LastCheckColumn.setCellValueFactory(cellData -> cellData.getValue().lastcheckFxProperty());
      //  this.NextCheckColumn.setCellValueFactory(cellData -> cellData.getValue().nextcheckfxProperty());
        this.CheackColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

        this.CheackColumn.setCellFactory(param -> {
            return new TableCell<CashRegisterFx, CashRegisterFx>() {
                Button button = createButton("/icons/if_325-Document_1_2124304.png");


                @Override
                protected void updateItem(CashRegisterFx item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        return;
                    }
                    if (!empty) {
                        setGraphic(button);
                        button.setOnAction(event -> {
                            try {
                                cashRegisterList.callservice(item);
                            } catch (ApplicationException e) {
                                e.printStackTrace();
                            }


                        });
                    }

                }
            };
        });
    }





        private Button createButton(String path){
        Button button = new Button();
        Image image = new Image(this.getClass().getResource(path).toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return  button;
    }
}
