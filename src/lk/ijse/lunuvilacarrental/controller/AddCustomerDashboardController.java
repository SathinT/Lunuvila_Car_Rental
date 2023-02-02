package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.lunuvilacarrental.model.CustomerModel;
import lk.ijse.lunuvilacarrental.to.Customer;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCustomerDashboardController {
    public AnchorPane Pane;
    public JFXTextField txtCusID;
    public JFXTextField txtName;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;

    public void rbtnGenderMaleOnAction(ActionEvent actionEvent) {
    }

    public void rbtnGenderFealeOnAction(ActionEvent actionEvent) {
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HOME,Pane);

    }

    public void ProceedOnAction(ActionEvent actionEvent) throws IOException {

        String id = txtCusID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();

        Customer customer = new Customer(id, name, address,nic);
        boolean isAdded = false;
        try {
            isAdded = CustomerModel.save(customer);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }


        Navigation.navigate(Routes.PackSelectDashboard,Pane);
    }

    public void CusIdOnKeyPrtess(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("(C)([0-9]{1})([0-9])");
        Matcher matcher = pattern.matcher(txtCusID.getText());

        boolean isMatch = matcher.matches();


        if (!isMatch) {
            txtCusID.setFocusColor(Paint.valueOf("red"));


            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtCusID.setFocusColor(Paint.valueOf("green"));


        }
    }
}
