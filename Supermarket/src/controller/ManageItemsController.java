package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageItemsController {
    public Button btnRegister;
    public Button btnModifyItem;
    public Button btnRemoveOnAction;
    public Label lblTime;
    public Label lblDate;
    public Button btnIncomeReport;
    public AnchorPane ManageItemsAnchorpane;
    public AnchorPane root;


    public  void  initialize(){
        lblDate.setText((String.valueOf(LocalDate.now())));
        setLblTime();
    }

    private void setLblTime() {
        Timeline timeLine = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }

    public void RegisterOnAction(ActionEvent actionEvent) throws IOException {

        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/RegisterNewItem.fxml"))));
    }

    public void RemoveOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/RemoveItem.fxml"));
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

   /* public void ModifyOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/ModifyItem.fxml"));
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }*/

    public void btnInComeOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ModifyItem.fxml"))));
    }
}
