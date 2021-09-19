package controller;

import bo.BoFactory;
import bo.custom.ItemBo;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyItemController {
   
    public Button btnModify;
    public DatePicker datePick;
    public Button btnSearch;
    public Button btnDailyIncome;
    public Button btnMonthncome1;
    public Button btnAnnualIncome1;
    public TableView tableDaliyInCome;
    public Label lblTotalIncome;
    public TableColumn colSellingQuntity;
    public TableColumn colItemCode;
    public TableColumn colDescription;
    public TableColumn colQtyOnHand;
    public TableColumn colDailyInCome;
    public AnchorPane root;
    public AnchorPane AnnualIncomeAnchorpane;
    public AnchorPane MonthlyInComeAnchorpane;


    public void initialize() throws Exception {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("OrderQty"));
        colSellingQuntity.setCellValueFactory(new PropertyValueFactory<>("sellingQty"));
        colDailyInCome.setCellValueFactory(new PropertyValueFactory<>("dailyIncome"));





    }

    public void ModifyOnAction(ActionEvent actionEvent) throws Exception {

    }

    public void MainformOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManageItems.fxml"))));
    }

    public void SearchOnAction(ActionEvent actionEvent) {
    }

    public void DailyInComeOnAction(ActionEvent actionEvent) {
    }

    public void MonthInComeOnAction(ActionEvent actionEvent) {
        AnnualIncomeAnchorpane.setVisible(false);
       MonthlyInComeAnchorpane.setVisible(true);
    }

    public void AnnualInComeOnAction(ActionEvent actionEvent) {
        AnnualIncomeAnchorpane.setVisible(true);
        MonthlyInComeAnchorpane.setVisible(false);
    }
}
