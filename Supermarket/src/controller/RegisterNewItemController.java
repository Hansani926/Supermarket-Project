package controller;

import bo.BoFactory;
import bo.custom.ItemBo;
import dto.CustomerDTO;
import dto.ItemDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.BatchTM;
import view.tm.CustomerTM;
import view.tm.ItemTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class RegisterNewItemController {
    public TextField txtDescription;
    public TextField txtProductID;
    public TextField txtProductName;
    public TextField txtSpecification;
    public TextField txtDisplayName;
    public TextField txtAvaliability;
    public TextField txtActiveState;
    public TextField txtAvailableBrands;
    public Button btnRegister;
    public TextField txtSearch;
    public Button btnModifyItem;
    public Button btnRemoveItem;
    public TableView<ItemTM> tblItem;
    public TableColumn colProductID;
    public TableColumn colProductName;
    public TableColumn colDescription;
    public TableColumn colSpecification;
    public TableColumn colDisplayName;
    public TableColumn colAvailability;
    public TableColumn colActiveState;
    public TableColumn colAvailableBrands;
    public Button btnAddAllItems;
    public TableColumn colOperator;
    public AnchorPane root;
    public Button btngotoMainForm;

    private ItemBo bo;

    ObservableList<ItemTM> itemtm = FXCollections.observableArrayList();

    public void initialize() throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BOType.ITEM);


        colProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colSpecification.setCellValueFactory(new PropertyValueFactory<>("Specification"));
        colDisplayName.setCellValueFactory(new PropertyValueFactory<>("DisplayName"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("Avaliability"));
        colActiveState.setCellValueFactory(new PropertyValueFactory<>("ActiveState"));
        colAvailableBrands.setCellValueFactory(new PropertyValueFactory<>("AvailableBrand"));
        colOperator.setCellValueFactory(new PropertyValueFactory<>("button"));

       SearchItem();

        tblItem.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setItemData((ItemTM) newValue);
                });

    }

    private void setItemData(ItemTM tm) {
        if(tm!=null){ txtProductID.setText(tm.getProductID());
            txtProductName.setText(tm.getProductName());
            txtDescription.setText(tm.getDescription());
            txtSpecification.setText(tm.getSpecification());
            txtDisplayName.setText(tm.getDisplayName());
            txtAvaliability.setText(tm.getAvaliability()+" ");
            txtActiveState.setText(tm.getActiveState()+"");
            txtAvailableBrands.setText(tm.getAvailableBrand());  }

    }

    private void SearchItem() {
        FilteredList<ItemTM> filteredListdata = new FilteredList<>(itemtm, e -> true);
        txtSearch.setOnKeyReleased(e -> {
            txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {
                filteredListdata.setPredicate((Predicate<? super ItemTM>) part -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowercasefilter = newValue.toLowerCase();
                    if (part.getProductID().contains(newValue)) {

                        return true;
                    } else if (part.getProductName().toLowerCase().contains(lowercasefilter)) {

                        return true;
                    } else if (part.getDescription().toLowerCase().contains(lowercasefilter)) {

                        return true;
                    }
                    return false;
                });
            }));
            SortedList<ItemTM> sortedList = new SortedList<>(filteredListdata);
            sortedList.comparatorProperty().bind(tblItem.comparatorProperty());
            tblItem.setItems(sortedList);
        });

    }

    public void RegisterNewItemOnAction(ActionEvent actionEvent) throws Exception {

        boolean isSaved = bo.saveItem(
                new ItemDTO(txtProductID.getText(),txtProductName.getText(),txtDescription.getText(),txtSpecification.getText(),txtDisplayName.getText(),Boolean.parseBoolean(txtAvaliability.getText()),Boolean.parseBoolean(txtActiveState.getText()),txtAvailableBrands.getText()
                 ));
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Success").showAndWait();

        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccess").showAndWait();
        }
        txtProductID.clear();
        txtProductName.clear();
        txtDescription.clear();
        txtSpecification.clear();
        txtDisplayName.clear();
        txtAvaliability.clear();
        txtActiveState.clear();
        txtAvailableBrands.clear();
    }

    public void ModyfyitemDetailsOnAction(ActionEvent actionEvent) throws Exception {
        boolean isUpdate = bo.updateItem(
                        new ItemDTO(txtProductID.getText(),
                                txtProductName.getText(),
                                txtDescription.getText(),
                                txtSpecification.getText(),
                                txtDisplayName.getText(),
                               Boolean.parseBoolean(txtAvaliability.getText()),
                                Boolean.parseBoolean(txtActiveState.getText()),
                                txtAvailableBrands.getText()

                        )
                );

        if (isUpdate) {
            ItemTblLoad();
            new Alert(Alert.AlertType.CONFIRMATION, "Success").showAndWait();

        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Unsuccess").showAndWait();
            System.out.println(isUpdate);
        }

    }

    public void RemoveItemOnAction(ActionEvent actionEvent) {
    }

    public void AddAllItrmsOnAction(ActionEvent actionEvent) throws Exception {
        ItemTblLoad();
    }

    private void ItemTblLoad() throws Exception {
        tblItem.getItems().clear();
        List<ItemDTO> allItems = bo.getAllItems();

        if (allItems != null) {
            for (ItemDTO dto : allItems) {


                Button btn = new Button("Delete");

                itemtm.add(new ItemTM(dto.getProductID(), dto.getProductName(),dto.getDescription(),dto.getSpecification(),dto.getDisplayName(),dto.getAvaliability(),dto.getActiveState(),dto.getAvailableBrand(),btn));
                btn.setOnAction((e) -> {
                    try {
                        ButtonType ok = new ButtonType("OK",
                                ButtonBar.ButtonData.OK_DONE);
                        ButtonType no = new ButtonType("NO",
                                ButtonBar.ButtonData.CANCEL_CLOSE);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "Are You Sure ?", ok, no);
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.orElse(no) == ok) {
                            if (bo.deleteItem(dto.getProductID())) {
                                new Alert(Alert.AlertType.CONFIRMATION,
                                        "Deleted", ButtonType.OK).show();

                                ItemTblLoad();
                                return;
                            }
                            new Alert(Alert.AlertType.WARNING,
                                    "Try Again", ButtonType.OK).show();
                        } else {

                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
            }
            tblItem.setItems(itemtm);
        }
    }

    public void mainFormGotoOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManageItems.fxml"))));
    }
}
