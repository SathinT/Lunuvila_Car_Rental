package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.lunuvilacarrental.model.CustomerModel;
import lk.ijse.lunuvilacarrental.to.Customer;

import java.sql.SQLException;

public class VehicleExpensesController {

    public JFXTextField txtVehicleExpenseID;
    public JFXTextField txtFault;
    public JFXTextField txtCarCareId;
    public JFXTextField txtCharges;

    public void AddOnAction(ActionEvent actionEvent) {
//        String id = txtVehicleExpenseID.getText();
//        String CarCareId = txtCarCareId.getText();
//        String Fault = txtFault.getText();
//        String Charges = txtCharges.getText();
//
//        Customer customer = new Customer(id, CarCareId, Fault, nic);
//        try {
//            boolean isAdded = CustomerModel.save(customer);
//
//            if (isAdded) {
//                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
//            } else {
//                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void BackOnAction(ActionEvent actionEvent) {
    }
}
