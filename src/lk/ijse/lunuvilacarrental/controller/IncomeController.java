package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;

public class IncomeController {
    public AnchorPane Pane;
    public JFXTextField txtincomeId;
    public JFXTextField txtincomeType;

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.income,Pane);
    }

    public void AddOnAction(ActionEvent actionEvent) {

    }
}
