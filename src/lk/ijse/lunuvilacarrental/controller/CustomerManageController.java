package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.lunuvilacarrental.db.DBConnection;
import lk.ijse.lunuvilacarrental.model.CustomerModel;
import lk.ijse.lunuvilacarrental.to.Customer;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerManageController {


    public AnchorPane pane;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;
    public JFXTextField txtName;
    public JFXTextField txtCusId;
    public TableView TblCustomerManage;
    public TableColumn ColId;
    public TableColumn ColName;
    public TableColumn ColAddress;
    public TableColumn ColNic;

    public void initialize() {
        ColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ColNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        getAllCustomers();
    }

    public void rbtnGenderMaleOnAction(ActionEvent actionEvent) {
    }

    public void rbtnGenderFemaleOnAction(ActionEvent actionEvent) {
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HOME, pane);
    }


//    public void SearchCustomersTable(){
//        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();
//        for (:
//             ) {
//
//        }
//    }

    public void getAllCustomers() {
        ObservableList data = FXCollections.observableArrayList();

        PreparedStatement statement = null;
        try {
            statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Customer");

            ResultSet allCustomers = statement.executeQuery();
            while (allCustomers.next()) {
                data.add(new Customer(allCustomers.getString(1), allCustomers.getString(2), allCustomers.getString(3), allCustomers.getString(4)));
            }

        } catch (SQLException e) {
            System.out.println("Sql Error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Error");
            throw new RuntimeException(e);
        }
        TblCustomerManage.setItems(data);
    }


    public void AddOnAction(ActionEvent actionEvent) {
        String id = txtCusId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();

        Customer customer = new Customer(id, name, address, nic);
        boolean isAdded = false;
        try {
            isAdded = CustomerModel.save(customer);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage());
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage());
        }

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
            getAllCustomers();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void CustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CustomerManage, pane);
    }

    public void CarOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CarManage, pane);
    }

    public void RentDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RentDetails, pane);
    }

    public void FinanceOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FinanceManage, pane);
    }

    public void EmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EmployeeManage, pane);
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = txtCusId.getText();

        try {
            boolean isDelete = CustomerModel.delete(id);

            if (isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtCusId.getText();
        Customer customer;
        try {
            customer = CustomerModel.search(id);
            if (customer != null) {
                fillData(customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(Customer customer) {
        txtCusId.setText(customer.getId());
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtNic.setText(customer.getNic());
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = txtCusId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();

        Customer customer = new Customer(id, name, address, nic);

        try {
            boolean isUpdated = CustomerModel.update(customer);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Updated Sucessfully").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }

        } catch (SQLException | ClassNotFoundException ignored) {
        }

        //closeStage(CustomerUpdateContext);
    }



    public void CusIdKeyPress(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("(C)([0-9]{1})([0-9])");
        Matcher matcher = pattern.matcher(txtCusId.getText());

        boolean isMatch = matcher.matches();


        if (!isMatch) {
            txtCusId.setFocusColor(Paint.valueOf("red"));


            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtCusId.setFocusColor(Paint.valueOf("green"));


        }
    }
}
