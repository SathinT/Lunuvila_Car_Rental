package lk.ijse.lunuvilacarrental.util;

/*
    @author Sathin Thenuja
    @created 11/1/22 - 1:27 PM   
*/

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route,AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case HOME:
                window.setTitle("Home");
                setUi("Home.fxml");
                break;
            case NewRent:
                window.setTitle("Start Rent");
                setUi("NewRent.fxml");
                break;
            case AddCustomerDashboard:
                window.setTitle("Add Customer");
                setUi("AddCustomerDashboard.fxml");
                break;
            case PackSelectDashboard:
                window.setTitle("Select Package");
                setUi("PackSelectDashboard.fxml");
                break;
            case PaymentDashboard:
                window.setTitle("Payment");
                setUi("PaymentDashboard.fxml");
                break;
            case Dashboard:
                window.setTitle("Dashboard");
                setUi("DashBoard.fxml");
                break;
            case CustomerManage:
                window.setTitle("CustomerManager");
                setUi("CustomerManage.fxml");
                break;
            case CarManage:
                window.setTitle("Car Manager");
                setUi("CarManage.fxml");
                break;
            case FinanceManage:
                window.setTitle("Finance Manager");
                setUi("FinanceManage.fxml");
                break;
            case EmployeeManage:
                window.setTitle("Employee Manage");
                setUi("EmployeeManage.fxml");
                break;
            case RentDetails:
                window.setTitle("Rent Detail Manage");
                setUi("RentDetails.fxml");
                break;
            case income:
                window.setTitle("income Manage");
                setUi("income.fxml");
                break;
            case VehicleExpences:
                window.setTitle("Vehicle Expense Manage");
                setUi("VehicleExpenses.fxml");
                break;
            case DriverManage:
                window.setTitle("Driver Manage");
                setUi("DriverManage.fxml");
                break;
            case Report:
                window.setTitle("Report Manage");
                setUi("Report.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void setUi(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                        .getResource("/lk/ijse/lunuvilacarrental/veiw/" + location)));
    }
}
