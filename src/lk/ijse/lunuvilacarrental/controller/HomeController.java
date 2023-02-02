package lk.ijse.lunuvilacarrental.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;

public class HomeController {
    public AnchorPane Pane;

    public void NewRentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.NewRent,Pane);
    }

    public void ManagementOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Dashboard,Pane);
    }
}
