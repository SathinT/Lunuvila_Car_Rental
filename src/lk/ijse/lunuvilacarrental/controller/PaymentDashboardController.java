package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.lunuvilacarrental.model.EmployeeManageModel;
import lk.ijse.lunuvilacarrental.model.PaymentModel;
import lk.ijse.lunuvilacarrental.to.Employee;
import lk.ijse.lunuvilacarrental.to.Payment;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentDashboardController {
    public AnchorPane Pane;
    public Label TimeField;
    public Label DateField;
    public JFXTextField txtAmount;
    public JFXTextField txtIncomeType;
    public JFXTextField txtIncomeID;

    public void initialize(){
        Date();
        Time();
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PackSelectDashboard,Pane);
    }

    public void Date(){
        String date= String.valueOf(LocalDate.now());
        DateField.setText(date);
    }

    public void Time(){
        String time = String.valueOf(LocalTime.now());
        TimeField.setText(time);
    }



    public void ProceedOnAction(ActionEvent actionEvent) {

        String id = txtIncomeID.getText();
        String type = txtIncomeType.getText();
        String Amount = txtAmount.getText();
        String Date = DateField.getText();
        String Time = TimeField.getText();

        Payment payment = new Payment(id , type , Amount , Date, Time);

        try {
            boolean isAdded = PaymentModel.save(payment);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Payment Successful!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        new Alert(Alert.AlertType.CONFIRMATION,"Rent Submission Successful!").showAndWait();
    }
}
