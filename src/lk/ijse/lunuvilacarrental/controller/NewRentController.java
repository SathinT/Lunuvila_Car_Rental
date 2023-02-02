package lk.ijse.lunuvilacarrental.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;

public class NewRentController {
    public AnchorPane Pane;

    public void StartOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AddCustomerDashboard,Pane);
    }
}
