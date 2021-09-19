package controller;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginController {
    public TextField txtuserName;

    public Button btnLogin;
    public AnchorPane root;
    public PasswordField txtpassword;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
      /*  String name = txtuserName.getText().trim();
        String password = txtpassword.getText().trim();

        if (name.length()>0 && password.length()>0){

            if (name.equalsIgnoreCase("user") && password.equalsIgnoreCase("1234")){


                URL resource = this.getClass().
                        getResource("/view/AddnewCustomer.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene= new Scene(load);

                Stage stage= (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();




        }else{
                new Alert(Alert.AlertType.WARNING,"Try Again !!!!",
                        ButtonType.OK,ButtonType.NO).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty !!!!",
                    ButtonType.OK,ButtonType.NO).show();
        }*/
        if (txtuserName.getText().equalsIgnoreCase("admin") && txtpassword.getText().equalsIgnoreCase("1234")) {
            Stage window = (Stage) root.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddnewCustomer.fxml"))));
        } else if (txtuserName.getText().equalsIgnoreCase("cash") && txtpassword.getText().equalsIgnoreCase("1234")) {
            Stage window = (Stage) root.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManageItems.fxml"))));
           window.centerOnScreen();

        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid login, please try again", ButtonType.CLOSE).show();

        }

    }
}
