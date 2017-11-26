package mojprogram.elkosz.modelFX;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mojprogram.elkosz.database.dao.CompanyDao;
import mojprogram.elkosz.database.models.Company;
import mojprogram.elkosz.utils.converters.ConverterCompany;
import org.omg.CORBA.portable.ApplicationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dany on 2017-08-01.
 */
public class CompanyListModel {

    private ObservableList<CompanyFx> companyFxObservableList = FXCollections.observableArrayList();

   private List<CompanyFx> CompanyFXList = new ArrayList<>();


    public void iniati() throws ApplicationException{
        CompanyDao companyDao = new CompanyDao();
        CompanyFXList.clear();
        List<Company> company = companyDao.queryForAll(Company.class);
        company.forEach(compan -> {
            this.CompanyFXList.add(ConverterCompany.converttoCompanyFX(compan));
        });
       this.companyFxObservableList.setAll(CompanyFXList);
    }

    public ObservableList<CompanyFx> getCompanyFxObservableList() {
        return companyFxObservableList;
    }

    public void setCompanyFxObservableList(ObservableList<CompanyFx> companyFxObservableList) {
        this.companyFxObservableList = companyFxObservableList;
    }

    public void deleteCompany(CompanyFx companyFx ) throws  ApplicationException{
        CompanyDao companyDao = new CompanyDao();
        companyDao.deleteById(Company.class, companyFx.getId());
        iniati();
    }
}
