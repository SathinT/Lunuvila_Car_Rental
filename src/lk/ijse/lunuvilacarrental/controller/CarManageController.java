package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import lk.ijse.lunuvilacarrental.model.CarManageModel;
import lk.ijse.lunuvilacarrental.model.CustomerModel;
import lk.ijse.lunuvilacarrental.to.CarManage;
import lk.ijse.lunuvilacarrental.to.Customer;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class CarManageController {
    public AnchorPane Pane;
    public JFXTextField txtCarID;
    public JFXTextField txtModel;
    public JFXTextField txtBrand;
    public JFXRadioButton rbtnFuelPetrol;
    public JFXRadioButton rbtnFuelDiesel;
    public JFXRadioButton rbtnAvailable;
    public JFXRadioButton rbtnNotAvailable;
    public ToggleGroup Available;

    public void CustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CustomerManage,Pane);
    }

    public void CarOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CarManage,Pane);
    }

    public void RentDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RentDetails,Pane);
    }

    public void FinanceOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FinanceManage,Pane);
    }

    public void EmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EmployeeManage,Pane);
    }

    public void rbtnGenderMaleOnAction(ActionEvent actionEvent) {
    }

    public void rbtnGenderFemaleOnAction(ActionEvent actionEvent) {
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HOME,Pane);
    }

    public int radio(){

        int a = 0;

        if (rbtnAvailable.isSelected()){a = 1;}

        return a;
        }

    public void AddOnAction(ActionEvent actionEvent) {
       String id = txtCarID.getText();
        String model = txtModel.getText();
        String brand = txtBrand.getText();
        String Fuel = null;
        int Availability = 0;

        if (rbtnAvailable.isSelected()){
            Availability = 1;
        }else {
            Availability = 0;
        }

        if(rbtnFuelPetrol.isSelected()) {
            Fuel="Petrol";
        }else {
            Fuel="Diesel";
        }

        CarManage carManage = new CarManage(id, model, brand, Fuel, Availability);
        boolean isAdded = false;
        try {
            isAdded = CarManageModel.save(new CarManage(id, model, brand, Fuel, Availability));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Car Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = txtCarID.getText();

        try {
            boolean isDelete = CarManageModel.delete(id);

            if(isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Car Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtCarID.getText();
        CarManage carManage;
        try {
            carManage = CarManageModel.search(id);
            if (carManage != null) {
                fillData(carManage);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = txtCarID.getText();
        String model = txtModel.getText();
        String brand = txtBrand.getText();
        String Fuel = rbtnFuelPetrol.getText();

        int Availability = radio();

        CarManage carManage = new CarManage(id, model, brand, Fuel, Availability);

        try{
            boolean isUpdated = CarManageModel.update(carManage);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION,"Updated Sucessfully").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again").show();
            }

        }catch (SQLException | ClassNotFoundException ignored) {
            System.out.println(ignored);
        }
    }

    private void fillData(CarManage carManage) {
        txtCarID.setText(carManage.getCarId());
        txtModel.setText(carManage.getModel());
        txtBrand.setText(carManage.getBrand());
    }

}
