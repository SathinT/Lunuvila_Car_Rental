package lk.ijse.lunuvilacarrental.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;

public class DashBoardController {
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

    public void EmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EmployeeManage,Pane);
    }
}
