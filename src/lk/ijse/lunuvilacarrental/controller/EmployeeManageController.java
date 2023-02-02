package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.lunuvilacarrental.model.CarManageModel;
import lk.ijse.lunuvilacarrental.model.CustomerModel;
import lk.ijse.lunuvilacarrental.model.EmployeeManageModel;
import lk.ijse.lunuvilacarrental.to.CarManage;
import lk.ijse.lunuvilacarrental.to.Customer;
import lk.ijse.lunuvilacarrental.to.Employee;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeManageController {
    public AnchorPane Pane;
    public JFXTextField txtEmployeeID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXRadioButton rbtnFemale;
    public JFXRadioButton btnMale;
    public JFXTextField txtNic;
    public JFXRadioButton rbtnDriver;

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

    public void AddOnAction(ActionEvent actionEvent)  {
        String id = txtEmployeeID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();

//        if(rbtnDriver.isSelected()){
//            driver="Yes";
//        }else{
//            driver="No";
//        }
        Employee employee = new Employee(id , name , address , nic);

        try {
            boolean isAdded = EmployeeManageModel.save(employee);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
/*        boolean isAdded = false;
        try {
            isAdded = EmployeeManageModel.save(employee);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }


        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }*/
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CustomerManage,Pane);
    }

    public void EmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EmployeeManage,Pane);
    }



    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = txtEmployeeID.getText();

        try {
            boolean isDelete = EmployeeManageModel.delete(id);

            if(isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtEmployeeID.getText();
        Employee employee;
        try {
            employee = EmployeeManageModel.search(id);
            if (employee != null) {
                fillData(employee);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(Employee employee) {
        txtEmployeeID.setText(employee.getId());
        txtName.setText(employee.getName());
        txtAddress.setText(employee.getAddress());
        txtNic.setText(employee.getNic());
    }
    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = txtEmployeeID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();

        Employee employee = new Employee(id, name, address, nic);

        try{
            boolean isUpdated = EmployeeManageModel.update(employee);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION,"Updated Sucessfully").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again").show();
            }

        }catch (SQLException | ClassNotFoundException ignored) {}

        //closeStage(CustomerUpdateContext);

    }

    public void AddDriverOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../veiw/DriverManage.fxml"))));
        stage1.centerOnScreen();
        //stage1.initStyle(StageStyle.UNDECORATED);
        stage1.show();
    }

}

