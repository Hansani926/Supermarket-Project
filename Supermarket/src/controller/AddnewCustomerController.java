package controller;

import bo.BoFactory;
import bo.custom.BatchBo;
import bo.custom.CustomerBo;
import bo.custom.ItemBo;
import bo.custom.OrderBo;
import bo.custom.impl.CustomerBoImpl;
import com.sun.deploy.net.MessageHeader;
import dto.*;
import entity.Customer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.util.Duration;
import view.tm.BatchTM;
import view.tm.CustomerTM;
import view.tm.ItemTM;
import view.tm.OrderTM;

import javax.swing.table.TableModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class AddnewCustomerController  {
    public Label lblOrderID;
    public ComboBox cmbcusid;
    public TextField txtCustomerType;
    public TextField txtCustomerName;
    public TextField txtProvince;
    public TextField txtCity;
    public TextField txtAddress;
    public TextField txtContact;
    public AnchorPane AnchCustable;
    public TableView<CustomerTM>tblCustomer;
    public TableColumn colCusid;
    public TableColumn colCusType;
    public TableColumn colCusName;
    public TableColumn colAddress;
    public TableColumn colProvince;
    public TableColumn colCity;
    public TableColumn colContact;
    public Button btnCustomer;
    public AnchorPane root;
    public Button btnCustomertable;
    public TextField txtSearch;
    public TextField txCusID;
    public TableColumn colPropertyID;
    public TableColumn colBatch;
    public TableColumn colPrice;
    public TableColumn colDiscount;
    public TableColumn colDiscountState;
    public TableColumn colActiveState;
    public TableColumn colQuantity;
    public TableColumn colSystemDate;
    public TableColumn colProductID;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnBatch;
    public Button btnAddAll;
    public ComboBox cmbProductID;
    public TextField txtBatch;
    public TextField txtDiscount;
    public TextField txtPrice;
    public TextField txtDiscountState;
    public TextField txtActiveState;
    public TextField txtQuantity;
    public TextField txtSystemDate;
    public TextField txtPropertyID;
    public Button btnRemove;
    public TableView <BatchTM>tblBatch;
    public AnchorPane DashBordAnchor;
    public Button btnOrder;
    public AnchorPane AddNewCustomerAnchorPane;

    public AnchorPane OrderAnchorpane;
    public TextField txtOrderDate;
    public TextField txtOrderID;
    public TextField txtOrderDescription;
    public ComboBox cmbOrderProductID;
    public ComboBox cmbOrderCustomerID;
    public TextField txtOrderCustomerName;
    public TextField txtOrderQuanity;
    public TextField txtOrderQty;
    public TextField txtOrderPrice;
    public TableColumn colOrderProductID;
    public TableColumn colOrderDescription;
    public TableColumn colOrderQty;
    public TableColumn colAmount;
    public TableColumn colOrderPrice;
    public Button btnOrderADD;
    public Button btnOrderRemove;
    public Button btnPlaceOrder;
    public ComboBox cmbOrderPropertyID;
    public Label lblTime;
    public Label lblDate;
    public TableColumn colOrderPropertyID;
    public TableColumn colOrderAmount;
    public TableView<OrderTM> tblOrder;
    public Label lblAmount;
    public Button btnCustomerUpdate;
    public Button btnCustomerRemove;
    public Button btnCustomerAddALL;
    public ComboBox cmbCustomerID;
    public TableColumn colOperator;
    public Button btngotoLogin;
    public TextField txtCustomerID;

    ItemBo itemBo;
    private CustomerBo bo;
     BatchBo batchBo;
     OrderBo orderBo;


    ObservableList<CustomerTM> tmList = FXCollections.observableArrayList();
    ObservableList<ItemTM> itemtm = FXCollections.observableArrayList();
    ObservableList<BatchTM> batchtm = FXCollections.observableArrayList();

   public void initialize() throws Exception{
       lblDate.setText((String.valueOf(LocalDate.now())));
       setLblTime();

      bo = BoFactory.getInstance().getBo(BoFactory.BOType.CUSTOMER);
       itemBo = BoFactory.getInstance().getBo(BoFactory.BOType.ITEM);
       batchBo= BoFactory.getInstance().getBo(BoFactory.BOType.BATCH);
       orderBo = BoFactory.getInstance().getBo(BoFactory.BOType.ORDER);

        txtOrderDate.setText(LocalDate.now().toString());
       loadCustomerIDCmb();
       loadOrderProductIDCmb();
       loadPropertyIDCmb();

       try {
           loadOrderID();
       } catch (Exception e) {
           e.printStackTrace();
       }

       colCusid.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        colCusType.setCellValueFactory(new PropertyValueFactory<>("CustomeType"));
        colCusName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("CustomerAddress"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("Province"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
       colOperator.setCellValueFactory(new PropertyValueFactory<>("button"));

        bo = BoFactory.getInstance().getBo(BoFactory.BOType.CUSTOMER);
    try {
        loadAllCustomers();

        } catch (Exception e) {
            e.printStackTrace();
        }


   tblCustomer.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setDataCustomer((CustomerTM) newValue);
                });
       Search();
tblBatch.getSelectionModel().selectedItemProperty().
               addListener((observable, oldValue, newValue) -> {
                   setBatchData((BatchTM) newValue);
               });
       loadProductCmb();

       colPropertyID.setCellValueFactory(new PropertyValueFactory<>("PropertyID"));
       colBatch.setCellValueFactory(new PropertyValueFactory<>("Batch"));
       colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
       colDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
       colDiscountState.setCellValueFactory(new PropertyValueFactory<>("DiscountState"));
       colActiveState.setCellValueFactory(new PropertyValueFactory<>("ActiveState"));
       colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
       colSystemDate.setCellValueFactory(new PropertyValueFactory<>("SystemDate"));
       colProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));


      SearchBatch();
   loadCustomerID();

   }



    private void loadOrderID() throws Exception {
        String OrderID = orderBo.getOrderID();
        txtOrderID.setText(OrderID);
    }

    private void loadOrderProductIDCmb() {
        try {
            List<ItemDTO> list = itemBo.getAllItems();
            for (ItemDTO dto : list) {
                cmbOrderProductID.getItems().addAll(dto.getProductID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPropertyIDCmb() {
        try {
            List<BatchDTO> list = batchBo.getAllBatchs();
            for (BatchDTO dto : list) {
                cmbOrderPropertyID.getItems().addAll(dto.getPropertyID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCustomerIDCmb() {
        try {
            List<CustomerDTO> list = bo.getAllCustomers();
            for (CustomerDTO dto : list) {
                cmbOrderCustomerID.getItems().addAll(dto.getCustomerID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void setBatchData(BatchTM tm) {
        if(tm!=null){
            txtPropertyID.setText(tm.getPropertyID());
            txtBatch.setText(tm.getBatch());
            txtPrice.setText(tm.getPrice()+" ");
            txtDiscount.setText(tm.getDiscount()+" ");
            txtDiscountState.setText(tm.getDiscountState()+"");
            txtActiveState.setText(tm.getActiveState()+"");
            txtQuantity.setText(tm.getQuantity()+"");
            txtSystemDate.setText(tm.getSystemDate());

        }

    }

    private void SearchBatch() {
       FilteredList<BatchTM> filteredListdata = new FilteredList<>(batchtm, e -> true);
        txtSearch.setOnKeyReleased(e -> {
            txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {
                filteredListdata.setPredicate((Predicate<? super BatchTM>) part -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowercasefilter = newValue.toLowerCase();
                    if (part.getBatch().contains(newValue)) {

                        return true;
                    } else if (part.getSystemDate().toLowerCase().contains(lowercasefilter)) {

                        return true;
                    } else if (part.getPropertyID().toLowerCase().contains(lowercasefilter)) {

                        return true;
                    }
                    return false;
                });
            }));
            SortedList<BatchTM> sortedList = new SortedList<>(filteredListdata);
            sortedList.comparatorProperty().bind(tblBatch.comparatorProperty());
            tblBatch.setItems(sortedList);
        });

    }

    private void BatchtableLoad() throws Exception {
        tblBatch.getItems().clear();
        List<BatchDTO> allBatchs = batchBo.getAllBatchs();

        if (allBatchs != null) {
            for (BatchDTO dto :allBatchs) {
                System.out.println("allBatchs" + dto.getPropertyID());

                Button btn = new Button("Delete");

                batchtm.add(new BatchTM(dto.getPropertyID(),dto.getBatch(),dto.getPrice(),dto.getDiscount(),dto.getDiscountState(),dto.getActiveState(),dto.getQuantity(),dto.getSystemDate(),dto.getProductID()));
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
                            if (bo.deleteCustomer(dto.getPropertyID())) {
                                new Alert(Alert.AlertType.CONFIRMATION,
                                        "Deleted", ButtonType.OK).show();

                                BatchtableLoad();
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
            tblBatch.setItems(batchtm);
        }

    }

    private void loadProductCmb() {
        try {
            List<ItemDTO> list = itemBo.getAllItems();
            for (ItemDTO dto : list) {
                cmbProductID.getItems().addAll(dto.getProductID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Search() {
        FilteredList<CustomerTM> filteredListdata = new FilteredList<>(tmList, e -> true);
        txtSearch.setOnKeyReleased(e -> {
            txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {
                filteredListdata.setPredicate((Predicate<? super CustomerTM>) part -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowercasefilter = newValue.toLowerCase();
                    if (part.getCustomeType().contains(newValue)) {

                        return true;
                    } else if (part.getCustomerName().toLowerCase().contains(lowercasefilter)) {

                        return true;
                    } else if (part.getCustomerID().toLowerCase().contains(lowercasefilter)) {

                        return true;
                    }
                    return false;
                });
            }));
            SortedList<CustomerTM> sortedList = new SortedList<>(filteredListdata);
            sortedList.comparatorProperty().bind(tblCustomer.comparatorProperty());
            tblCustomer.setItems(sortedList);
        });


    }





   private void  loadAllCustomers() throws Exception {
      /*tblCustomer.refresh();*/
       /*tmList.removeAll();*/
       tmList.clear();

     /*  tblCustomer.getItems().clear();*/
//       ObservableList<CustomerTM> tmList = FXCollections.observableArrayList();
        List<CustomerDTO> allCustomers = bo.getAllCustomers();

       if (allCustomers != null) {
           for (CustomerDTO dto : allCustomers) {
               Button btn = new Button("Delete");

                tmList.add(new CustomerTM(dto.getCustomerID(), dto.getCustomeType(), dto.getCustomerName(), dto.getCustomerAddress(), dto.getCity(), dto.getProvince(), dto.getContact(),btn));
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
                            if (bo.deleteCustomer(dto.getCustomerID())) {
                                new Alert(Alert.AlertType.CONFIRMATION,
                                        "Deleted", ButtonType.OK).show();

                             loadAllCustomers();
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
            tblCustomer.setItems(tmList);
        }

    }


    private void setDataCustomer(CustomerTM tm) {
if (tm != null){ txtCustomerID.setText(tm.getCustomerID());
    txtCustomerType.setText(tm.getCustomeType());
    txtCustomerName.setText(tm.getCustomerName());
    txtAddress.setText(tm.getCustomerAddress());
    txtCity.setText(tm.getCity());
    txtProvince.setText(tm.getProvince());
    txtContact.setText(tm.getContact() + "");
}


    }


    private void loadCustomerID() throws Exception {
        String CID = bo.getCustomerID();
        txtCustomerID.setText(CID);
    }


    public void CustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();



    }


    public void CustomertableOnAction(ActionEvent actionEvent) throws Exception {

        OrderAnchorpane.setVisible(false);
        root.setVisible(true);
        tblCustomer.setVisible(true);
        tblBatch.setVisible(false);
    }


    public void AddOnAction(ActionEvent actionEvent) throws Exception {

       /* boolean isSaved = batchBo.saveBatch(txtPropertyID.getText(),txtBatch.getText(),Double.parseDouble(txtPrice.getText())
       ,Double.parseDouble(txtDiscount.getText()),Boolean.parseBoolean(txtDiscountState.getText()),
       Boolean.parseBoolean(txtActiveState.getText()),Integer.parseInt(txtQuantity.getText()),
       txtSystemDate.getText(),cmbProductID.getSelectionModel().getSelectedItem());*/
        boolean isSaved = batchBo.saveBatch(getBatch());
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Success").showAndWait();

        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Unsuccess").showAndWait();
        }
        txtPropertyID.clear();
        txtBatch.clear();
        txtPrice.clear();
        txtDiscount.clear();
        txtDiscountState.clear();
        txtActiveState.clear();
        txtQuantity.clear();
        txtSystemDate.clear();

    }
    private BatchDTO getBatch() {
        String pid = txtPropertyID.getText();
        String batch = txtBatch.getText();
        Double price= Double.parseDouble(txtPrice.getText());
        Double discount=Double.parseDouble(txtDiscount.getText());
        Boolean discountState=Boolean.parseBoolean(txtDiscountState.getText());
         Boolean activeState=Boolean.parseBoolean(txtActiveState.getText());
        int quantity=Integer.parseInt(txtQuantity.getText());
          String systemDate= txtSystemDate.getText();
         String productID=String.valueOf(cmbProductID.getValue());




        return new BatchDTO(pid, batch, price,discount,discountState,activeState,quantity,systemDate,productID);
    }


    public void UpdateOnAction(ActionEvent actionEvent) throws Exception {
       /* boolean isUpdate = batchBo.
                updateBatch(
                        new BatchDTO(txtPropertyID.getText(),txtBatch.getText(),Double.parseDouble(txtPrice.getText())
                                ,Double.parseDouble(txtDiscount.getText()),Boolean.parseBoolean(txtDiscountState.getText()),
                                Boolean.parseBoolean(txtActiveState.getText()),Integer.parseInt(txtQuantity.getText()),
                                txtSystemDate.getText(),String.valueOf(cmbProductID.getValue())));*/

        /*boolean isUpdate = batchBo.updateBatch(getBatch());*/
        boolean isUpdate = batchBo.
                updateBatch(
                        new BatchDTO(txtPropertyID.getText(),
                                txtBatch.getText(),
                                Double.parseDouble(txtPrice.getText()),
                                Double.parseDouble(txtDiscount.getText()),
                                Boolean.parseBoolean(txtDiscountState.getText()),
                                Boolean.parseBoolean(txtActiveState.getText()),
                                Integer.parseInt(txtQuantity.getText()),
                              txtSystemDate.getText(),
                                String.valueOf(cmbProductID.getValue())

                        )
                );

        if (isUpdate) {
            System.out.println("Hello batchekt load una");
        BatchtableLoad();

            new Alert(Alert.AlertType.CONFIRMATION, "Success").showAndWait();

        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Unsuccess").showAndWait();
            System.out.println(isUpdate);
        }


    }

    public void BatchOnAction(ActionEvent actionEvent) {
        tblCustomer.setVisible(false);
        tblBatch.setVisible(true);

    }

    public void AddAllOnAction(ActionEvent actionEvent) {
        try {
            BatchtableLoad();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ProductOnAction(ActionEvent actionEvent) throws Exception {
        ItemDTO dto = itemBo.getItem(String.valueOf(cmbProductID.getValue()));
    }

    public void RemoveOnAction(ActionEvent actionEvent) {

    }

    public void OrderOnAction(ActionEvent actionEvent) throws IOException {
        OrderAnchorpane.setVisible(true);
        root.setVisible(false);
    }
    
    //////////////////Order//////////////
    ObservableList<OrderTM> observableList = FXCollections.observableArrayList();

    public void btnOrderRemoveOnAction(ActionEvent actionEvent) {
        OrderTM selectedItem = tblOrder.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            observableList.remove(selectedItem);
            tblOrder.getItems().remove(selectedItem);
            getSubTotal();
        } else {
            new Alert(Alert.AlertType.WARNING, "Please Select Row that You Want to Remove !").show();
            tblOrder.requestFocus();
        }
    }

    public void OrderAddOnAction(ActionEvent actionEvent) {
       colOrderPropertyID.setCellValueFactory(new PropertyValueFactory<>("PropertyID"));
       colOrderDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colOrderQty.setCellValueFactory(new PropertyValueFactory<>("OrderQty"));
        colOrderPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colOrderAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));

        String PropertyID=String.valueOf(cmbOrderPropertyID.getValue());
        String Description = txtOrderDescription.getText();
        int qty = Integer.parseInt(txtOrderQty.getText());
        double Price = Double.parseDouble(txtOrderPrice.getText());

        if (!observableList.isEmpty()) { // check observableList is empty
            for (int i = 0; i < tblOrder.getItems().size(); i++) { // check all rows in table
                if (colOrderPropertyID.getCellData(i).equals(PropertyID)) { // check  itemcode in table == itemcode we enter
                    int temp = (int) colOrderQty.getCellData(i); // get qty in table for temp
                    temp += qty; // add new qty to old qty
                    double tot = (temp * Price); // get new total
                    observableList.get(i).setOrderQty(temp); // set new qty to observableList
                    observableList.get(i).setAmount(tot); // set new total to observableList
                    getSubTotal();
                    tblOrder.refresh(); // refresh table
                    return;
                }
            }
        }
        observableList.add(new OrderTM(PropertyID,Description, qty, Price, ((qty * Price))));
        tblOrder.setItems(observableList); // if their is no list or, no matched itemcode
        getSubTotal();

    }

    private void getSubTotal() {
        double tot = 0.0;
        for (OrderTM orderTM : observableList) {
            tot += orderTM.getAmount();
        }
       lblAmount.setText(String.valueOf(tot));
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
     try {
            boolean isSaved = orderBo.saveOrder(getOrder(),getOrderDetail());
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Not Saved", ButtonType.OK).show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "error", ButtonType.OK).show();
        }
    }

    private OrderDTO getOrder() {
        String OrderID=txtOrderID.getText();
        String OrderDate=txtOrderDate.getText();
        String CustomerID=String.valueOf(cmbOrderCustomerID.getValue());


        return new OrderDTO(OrderID,OrderDate,CustomerID);
    }

    private  ArrayList<OrderDetailDTO>  getOrderDetail() {
        String orderid = txtOrderID.getText();
        int qty=Integer.parseInt(txtOrderQty.getText());
        ArrayList<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();

        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            OrderTM orderTM = observableList.get(i);
            orderDetailDTOS.add(new OrderDetailDTO(orderid,orderTM.getPropertyID(),qty,orderTM.getPrice()));
        }

        return orderDetailDTOS;
    }


    public void cmbOrderPropertyIDOnAction(ActionEvent actionEvent) throws Exception {
        BatchDTO dto = batchBo.getBatch(String.valueOf(cmbOrderPropertyID.getValue()));
        if (dto != null) {
            txtOrderPrice.setText(String.valueOf(dto.getPrice()));
            txtOrderQuanity.setText(String.valueOf(dto.getQuantity()));
        }
    }

    public void cmborderCustomerIDOnAction(ActionEvent actionEvent) throws Exception {
        CustomerDTO dto = bo.getCustomer(String.valueOf(cmbOrderCustomerID.getValue()));
        if (dto != null) {
            txtOrderCustomerName.setText(dto.getCustomerName());
        }
    }

    public void cmbOrderProductIDOnAction(ActionEvent actionEvent) throws Exception {
        ItemDTO dto = itemBo.getItem(String.valueOf(cmbOrderProductID.getValue()));
        if (dto != null) {
            txtOrderDescription.setText(dto.getDescription());


        }
    }

    public void CustomerUpdateOnAction(ActionEvent actionEvent) throws Exception {
        boolean isUpdate = bo.
                updateCustomer(
                        new CustomerDTO(txtCustomerID.getText(),
                                txtCustomerType.getText(),
                                txtCustomerName.getText(),
                                txtAddress.getText(),
                                txtCity.getText(),
                                txtProvince.getText(),
                                Integer.parseInt(txtContact.getText()
                                )
                        )
                );

        if (isUpdate) {

       loadAllCustomers();
            new Alert(Alert.AlertType.CONFIRMATION, "Success").showAndWait();

        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Unsuccess").showAndWait();
            System.out.println(isUpdate);
        }
    }

  public void CustomerRemoveOnAction(ActionEvent actionEvent) throws Exception {

    loadAllCustomers();

      }



    public void CustomerIDOnAction(ActionEvent actionEvent) throws Exception {

    }

    public void btnLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Login.fxml"))));
    }

    public void getDataOnAction(ActionEvent actionEvent) throws Exception {
        CustomerDTO dto = bo.getCustomer(txtCustomerID.getText());
        if (dto != null) {
            txtCustomerID.setText(dto.getCustomerID());
            txtCustomerType.setText(dto.getCustomeType());
            txtCustomerName.setText(dto.getCustomerName());
            txtAddress.setText(dto.getCustomerAddress());
            txtCity.setText(dto.getCity());
            txtProvince.setText(dto.getProvince());
            txtContact.setText(dto.getContact() + "");

        }
    }
}
