package lk.ijse.lunuvilacarrental.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;

public class FinanceManageController {
    public AnchorPane Pane;

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

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CustomerManage,Pane);
    }

    public void AddOnAction(ActionEvent actionEvent) {

    }

    public void EmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EmployeeManage,Pane);
    }

    public void IncomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../veiw/income.fxml"))));
        stage1.centerOnScreen();
        //stage1.initStyle(StageStyle.UNDECORATED);
        stage1.show();
    }

    public void VehicleExpensesOnAcyion(ActionEvent actionEvent) throws IOException {
       /* Stage stage2 = new Stage();
        stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/lunuvilacarrental/veiw/VehicleExpenses.fxml"))));
        stage2.centerOnScreen();
        //stage2.initStyle(StageStyle.UNDECORATED);
        stage2.show();*/

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/lunuvilacarrental/veiw/VehicleExpenses.fxml"))));
        stage1.centerOnScreen();
        //stage1.initStyle(StageStyle.UNDECORATED);
        stage1.show();
    }

    public void SalaryOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage3 = new Stage();
        stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("../veiw/Salary.fxml"))));
        stage3.centerOnScreen();
        //stage3.initStyle(StageStyle.UNDECORATED);
        stage3.show();
    }

    public void ReportOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Report,Pane);
    }
}
