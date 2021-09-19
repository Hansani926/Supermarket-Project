package controller;

import bo.BoFactory;
import bo.custom.CustomerBo;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import view.tm.CustomerTM;

import java.util.List;
import java.util.Optional;

public class CustomerFormController {
    public TextField txCusID;
    public ComboBox cmbCustomerType;
    public TextField txCustomerName;
    public TextField txAddress;
    public TextField txProvince;
    public TextField txCity;
    public TextField txContact;
    public Button btnUpdate;
    public Button btnAddCustomer;
    public Button btnAddAll;
    public Button btnRemove;
    public TextField txCustomerType;


    private CustomerBo bo;
    ObservableList<CustomerTM> tmList = FXCollections.observableArrayList();


    public void initialize() throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BOType.CUSTOMER);
        loadAllCustomers();



    }


    private void setData(CustomerTM tm) {
        txCusID.setText(tm.getCustomerID());
        txCustomerType.setText(tm.getCustomeType());
        txCustomerName.setText(tm.getCustomerName());
        txAddress.setText(tm.getCustomerAddress());
        txCity.setText(tm.getCity());
        txProvince.setText(tm.getProvince());
        txContact.setText(tm.getContact() + "");
    }

    private void loadAllCustomers() {



    }


    public void AddCustomerOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved = bo.saveCustomer(new CustomerDTO(txCusID.getText(),
                        txCustomerType.getText(),
                        txCustomerName.getText(),
                        txAddress.getText(),
                        txCity.getText(),
                        txProvince.getText(),
                        Integer.parseInt(txContact.getText()))
        );
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Success").showAndWait();

        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Unsuccess").showAndWait();
        }
                txCusID.clear();
                txCustomerType.clear();
                txCustomerName.clear();
                txAddress.clear();
                txCity.clear();
                txProvince.clear();
                txContact.clear();
    }



    public void updateOnAction(ActionEvent actionEvent) throws Exception {

    }

    public void AddAllCustomerOnAction(ActionEvent actionEvent) {

    }

    public void RemoveOnAction(ActionEvent actionEvent) {

    }
}
