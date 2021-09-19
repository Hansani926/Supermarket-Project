package controller;

import bo.BoFactory;
import bo.custom.ItemBo;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RemoveItemController {
    public TextField txtProductID;
    public TextField txtProductName;
    public TextField txtDescription;
    public TextField txtSpecification;
    public TextField txtDisplayName;
    public TextField txtAvaliability;
    public TextField txtActiveState;
    public TextField txtAvailableBrands;
    public Button btnRemove;

    private ItemBo bo;

    public void initialize() throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BOType.ITEM);




    }

    public void RemoveOnAction(ActionEvent actionEvent) {



    }
}
