package mojprogram.elkosz.modelFX;

import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.QueryBuilder;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mojprogram.elkosz.database.dao.CashRegisterDao;
import mojprogram.elkosz.database.dao.CompanyDao;
import mojprogram.elkosz.database.models.CashRegister;
import mojprogram.elkosz.database.models.Company;
import mojprogram.elkosz.utils.converters.ConverterCashRegister;
import mojprogram.elkosz.utils.converters.ConverterCompany;
import org.omg.CORBA.portable.ApplicationException;

/**
 * Created by Dany on 2017-07-30.
 */
public class CashRegisterModel {

    private ObjectProperty<CashRegisterFx> cashRegisterFxObjectProperty = new SimpleObjectProperty<>(new CashRegisterFx());
    private ObservableList<CompanyFx> companyFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<CompanyFx> companyFxSimpleObjectProperty = new SimpleObjectProperty<>();

    public ObservableList<CompanyFx> getCompanyFxObservableList() {
        return companyFxObservableList;
    }

    public void setCompanyFxObservableList(ObservableList<CompanyFx> companyFxObservableList) {
        this.companyFxObservableList = companyFxObservableList;
    }

    public void transfer(CompanyFx cofx){
        this.companyFxObservableList.clear();
        companyFxObservableList.add(cofx);
    }

    public CashRegisterFx getCashMachineFxObjectProperty() {
        return cashRegisterFxObjectProperty.get();
    }

    public ObjectProperty<CashRegisterFx> cashMachineFxObjectPropertyProperty() {
        return cashRegisterFxObjectProperty;
    }

    public void setCashMachineFxObjectProperty(CashRegisterFx cashMachineFxObjectProperty) {
        this.cashRegisterFxObjectProperty.set(cashMachineFxObjectProperty);
    }

    public void saveCashRegister() throws ApplicationException {
        CashRegister cashRegister = ConverterCashRegister.convertToCashRegister(this.getCashMachineFxObjectProperty());



        CashRegisterDao cashRegisterDao = new CashRegisterDao();
        cashRegisterDao.createOrUpdate(cashRegister);



    }
}
