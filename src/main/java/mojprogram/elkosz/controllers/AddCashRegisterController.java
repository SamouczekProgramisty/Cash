package mojprogram.elkosz.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mojprogram.elkosz.modelFX.CashRegisterModel;
import mojprogram.elkosz.modelFX.CompanyFx;
import org.omg.CORBA.portable.ApplicationException;

import java.io.IOException;

/**
 * Created by Dany on 2017-08-03.
 */
public class AddCashRegisterController {

    @FXML
   private TextField companyTextField;
    @FXML
    private Button addRegister;
    @FXML
    private TextField cashMachinetextfield;
    @FXML
    private TextField serialnumbertextfield;
    @FXML
    private DatePicker buydate;
    @FXML
    private DatePicker firstcheck;
   /* @FXML
    private DatePicker nextcheck;*/

    private CashRegisterModel cashRegisterModel;

    private CompanyFx selected;



    @FXML
     private TextField companytextfieldCH;





    public void choiceCompany() {
        Stage stage = new Stage();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ChoiceCompany.fxml"));
        try {
            Parent parent = loader.load();
            ChoiceCompanyController choiceCompanyController = loader.getController();
            choiceCompanyController.setAddCashRegisterController(this);
            Scene  scene = new Scene(parent);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize(){
       // this.companyTextField.setEditable(false);
        //this.companyTextField.setMouseTransparent(true);
        //this.companyTextField.setFocusTraversable(false);

        this.cashRegisterModel = new CashRegisterModel();
      // this.cashRegisterModel.getCashMachineFxObjectProperty().companyProperty().bind(this.companyTextField.textProperty());

         //this.cashRegisterModel.cashMachineFxObjectPropertyProperty().get().companyProperty().bind(this.companyTextField.textProperty());

        this.cashRegisterModel.cashMachineFxObjectPropertyProperty().get().modelfxProperty().bind(this.cashMachinetextfield.textProperty());
         this.cashRegisterModel.cashMachineFxObjectPropertyProperty().get().srialnumberFXProperty().bind(this.serialnumbertextfield.textProperty());
         this.buydate.valueProperty().bindBidirectional(this.cashRegisterModel.getCashMachineFxObjectProperty().datepuchacefxProperty());
         this.firstcheck.valueProperty().bindBidirectional(this.cashRegisterModel.getCashMachineFxObjectProperty().lastcheckFxProperty());
        // this.nextcheck.valueProperty().bindBidirectional(this.cashRegisterModel.getCashMachineFxObjectProperty().nextcheckfxProperty());

    }

    public void addCashRegister() {
        try {
            cashRegisterModel.saveCashRegister();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    public void setSelected(CompanyFx selected){
        this.selected=selected;
       this.companyTextField.setText(this.selected.getCompanyNameFx());
       //this.companyTextField.promptTextProperty().bindBidirectional(selected.companyNameFxProperty());
    }

    public CompanyFx getSelected() {
        return selected;
    }
}

