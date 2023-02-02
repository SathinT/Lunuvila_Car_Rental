package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.lunuvilacarrental.db.DBConnection;
import lk.ijse.lunuvilacarrental.model.CarManageModel;
import lk.ijse.lunuvilacarrental.model.EmployeeManageModel;
import lk.ijse.lunuvilacarrental.model.RentModel;
import lk.ijse.lunuvilacarrental.to.CarManage;
import lk.ijse.lunuvilacarrental.to.Customer;
import lk.ijse.lunuvilacarrental.to.Employee;
import lk.ijse.lunuvilacarrental.to.Rent;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDetailsController {

    public AnchorPane Pane;
    public Label lblDate;
    public Label lblCustomerId;
    public Label lblPackId;
    public JFXComboBox cmbRentId;
    public Label lblDriverId;
    public Label lblCarId;
    public TableView TblRent;
    public TableColumn ColRentId;
    public TableColumn ColCusId;

    public TableColumn ColDate;
    //public TableColumn ColPackId;
    public TableColumn ColCarId;
    public TableColumn ColDriverId;
    public TableColumn colId;

    public void initialize(){

        ColRentId.setCellValueFactory(new PropertyValueFactory<>("RentId"));
        colId.setCellValueFactory(new PropertyValueFactory<>("PackId"));
        ColCarId.setCellValueFactory(new PropertyValueFactory<>("CarId"));
        ColDriverId.setCellValueFactory(new PropertyValueFactory<>("DriverId"));
        ColCusId.setCellValueFactory(new PropertyValueFactory<>("CusId"));
        ColDate.setCellValueFactory(new PropertyValueFactory<>("Date"));

        getAllRent();
        RentLoad();

    }

    public void getAllRent(){
        ObservableList data = FXCollections.observableArrayList();

        PreparedStatement statement = null;
        try {
            statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Rent");

            ResultSet allRent = statement.executeQuery();
            while (allRent.next()){
                data.add(new Rent(allRent.getString(1),allRent.getString(2),allRent.getString(5),
                        allRent.getString(4),allRent.getString(3),allRent.getString(6)));
            }

        } catch (SQLException e) {
            System.out.println("Sql Error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Error");
            throw new RuntimeException(e);
        }
        TblRent.setItems(data);
    }

    public void RentLoad(){
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = RentModel.loadRentIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbRentId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HOME,Pane);
    }

    public void AddOnAction(ActionEvent actionEvent) {
    }

    public void CustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CustomerManage,Pane);
    }

    public void EmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EmployeeManage,Pane);
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

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    private void fillData(Rent rent) {
        lblPackId.setText(rent.getRentId());
        lblCustomerId.setText(rent.getCusId());
        lblDriverId.setText(rent.getDriverId());
        lblCarId.setText(rent.getCarId());
        lblDate.setText(rent.getDate());
    }

    public void cmbRentOnAction (ActionEvent actionEvent) {
        String id = (String) cmbRentId.getValue();
        Rent rent;
        try {
            rent = RentModel.search(id);
            if (rent != null) {
                fillData(rent);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
