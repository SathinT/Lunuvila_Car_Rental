package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.lunuvilacarrental.db.DBConnection;
import lk.ijse.lunuvilacarrental.model.*;
import lk.ijse.lunuvilacarrental.to.*;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PackSelectDashboardController {
    public AnchorPane Pane;
    public JFXComboBox cmbDriverId;
    public JFXComboBox cmbCarId;
    public Label lblBrand;
    public Label lblModel;
    public Label lblFuel;
    public Label lblEmpId;
    public Label lblDriverName;
    public Label lblDriverAddress;
    public JFXTextField txtPackageId;
    public JFXComboBox cmbCustomerId;
    public Label lblDate;
    public JFXTextField txtCarId;
    public JFXTextField txtDriverId;
    public Label lblAvailability;

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AddCustomerDashboard, Pane);
    }

    public void initialize(){
        loadCustomerIds();
        Date();
    }

    public void Date(){
        String date= String.valueOf(LocalDate.now());
        lblDate.setText(date);
    }

    public void ProceedOnAction(ActionEvent actionEvent) throws IOException {

        String PackId =txtPackageId.getText();
        String CusId = String.valueOf(cmbCustomerId.getValue());
        LocalDate Date = LocalDate.parse(lblDate.getText());
        String CarId = txtCarId.getText();
        String DriverId = txtDriverId.getText();

        PackSelect packSelect = new PackSelect(PackId , CarId , DriverId , CusId ,Date);

        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);

            boolean isAdded = PackSelectModel.save(packSelect);
            if(isAdded){

                boolean update = PackSelectModel.StatusUpdate(txtCarId.getText(), 0);

                if(update){

                    DBConnection.getInstance().getConnection().commit();
                    //System.out.println("Done");
                }

            }

            DBConnection.getInstance().getConnection().rollback();

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Package Confirmed Successfully!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Navigation.navigate(Routes.PaymentDashboard, Pane);
    }

    private void fillData(CarManage carManage) {
        lblModel.setText(carManage.getModel());
        lblBrand.setText(carManage.getBrand());
        lblFuel.setText(carManage.getFuel());
        lblAvailability.setText(String.valueOf(carManage.getAvailability()));
    }

    private void fillData(Driver driver) {
        lblEmpId.setText(driver.getEmployee_id());
        lblDriverName.setText(driver.getDriver_name());
        lblDriverAddress.setText(driver.getDriver_address());
    }

    public void CarSearchOnAction(ActionEvent actionEvent) {
        String id = txtCarId.getText();
        CarManage car;
        try {
            car = CarManageModel.search(id);
            if (car != null) {
                fillData(car);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void DriverSearchOnAction(ActionEvent actionEvent) {
        String id = txtDriverId.getText();
        Driver driver;
        try {
            driver = DriverModel.search(id);
            if (driver != null) {
                fillData(driver);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = PackSelectModel.loadCustomerIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbCustomerId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void cmbCustomerOnAction(ActionEvent actionEvent) {
    }
}
