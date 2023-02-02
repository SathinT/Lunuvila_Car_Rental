package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lk.ijse.lunuvilacarrental.model.CarManageModel;
import lk.ijse.lunuvilacarrental.model.CustomerModel;
import lk.ijse.lunuvilacarrental.model.DriverModel;
import lk.ijse.lunuvilacarrental.model.EmployeeManageModel;
import lk.ijse.lunuvilacarrental.to.CarManage;
import lk.ijse.lunuvilacarrental.to.Customer;
import lk.ijse.lunuvilacarrental.to.Driver;
import lk.ijse.lunuvilacarrental.to.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class DriverManageController {
    public Label lblDriverName;
    public Label lblDriverNic;
    public JFXComboBox cmbEmpId;
    public JFXTextField lblDriverId;

    public void initialize(){
        employeeload();

    }

   public void employeeload(){
       try {
           ObservableList<String> observableList = FXCollections.observableArrayList();
           ArrayList<String> idList = EmployeeManageModel.loadEmployeeIds();

           for (String id : idList) {
               observableList.add(id);
           }
           cmbEmpId.setItems(observableList);
       } catch (SQLException | ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

    public void AddOnAction(ActionEvent actionEvent) {
        String empId = (String) cmbEmpId.getValue();
        String driverId = lblDriverId.getText();
        String name = lblDriverName.getText();
        String nic = lblDriverNic.getText();

        Driver driver = new Driver(driverId,empId,name,nic);
        boolean isAdded = false;
        try {
            isAdded = DriverModel.save(driver);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
            System.out.println(e);
        }

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    private void fillData(Employee employee) {
        lblDriverName.setText(employee.getName());
        lblDriverNic.setText(employee.getNic());
    }

    public void sarchOnAction(ActionEvent actionEvent) {
        String id = (String) cmbEmpId.getValue();
        Employee employee;
        try {
            employee = EmployeeManageModel.search(id);
            if (employee != null) {
                fillData(employee);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
