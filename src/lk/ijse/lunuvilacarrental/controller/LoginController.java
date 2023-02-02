package lk.ijse.lunuvilacarrental.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.lunuvilacarrental.util.Navigation;
import lk.ijse.lunuvilacarrental.util.Routes;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtUsername;
    public AnchorPane Pane;
    public JFXButton BtnLogIn;

    public void LogIn() throws IOException {
        if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("1234")){
            Navigation.navigate(Routes.HOME,Pane);
        }else {
            new Alert(Alert.AlertType.ERROR,"Login Failed!").showAndWait();
            txtUsername.requestFocus();
        }
    }

    public void LogInOnAction(ActionEvent actionEvent) throws IOException {
        txtUsername.requestFocus();
        //Stage stage1 = new Stage();
       // stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../veiw/Home.fxml"))));
        //stage1.centerOnScreen();
       // stage1.initStyle(StageStyle.UNDECORATED);
       // stage1.show();

        LogIn();

    }

    public void usernameOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void PasswordOnAction(ActionEvent actionEvent) throws IOException {
        txtUsername.requestFocus();

        LogIn();
    }

    public void UsernameKeyPress(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(txtUsername.getText());

        boolean isMatch = matcher.matches();


        if (isMatch) {
            txtUsername.setFocusColor(Paint.valueOf("red"));


            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtUsername.setFocusColor(Paint.valueOf("green"));


        }
    }

    public void PasswordKeyPress(KeyEvent keyEvent) {
    }
}
