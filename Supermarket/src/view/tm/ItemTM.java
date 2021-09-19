package view.tm;

import javafx.scene.control.Button;

public class ItemTM {
    private String ProductID;
    private String ProductName;
    private String Description;
    private   String Specification;
    private  String DisplayName;
    private  Boolean Avaliability;
    private Boolean ActiveState;
    private String AvailableBrand;
    private Button button;
    public ItemTM() {
    }

    public ItemTM(String productID, String productName, String description, String specification, String displayName, Boolean avaliability, Boolean activeState, String availableBrand, Button button) {
        ProductID = productID;
        ProductName = productName;
        Description = description;
        Specification = specification;
        DisplayName = displayName;
        Avaliability = avaliability;
        ActiveState = activeState;
        AvailableBrand = availableBrand;
        this.button = button;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public Boolean getAvaliability() {
        return Avaliability;
    }

    public void setAvaliability(Boolean avaliability) {
        Avaliability = avaliability;
    }

    public Boolean getActiveState() {
        return ActiveState;
    }

    public void setActiveState(Boolean activeState) {
        ActiveState = activeState;
    }

    public String getAvailableBrand() {
        return AvailableBrand;
    }

    public void setAvailableBrand(String availableBrand) {
        AvailableBrand = availableBrand;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "ItemTM{" +
                "ProductID='" + ProductID + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", Description='" + Description + '\'' +
                ", Specification='" + Specification + '\'' +
                ", DisplayName='" + DisplayName + '\'' +
                ", Avaliability=" + Avaliability +
                ", ActiveState=" + ActiveState +
                ", AvailableBrand='" + AvailableBrand + '\'' +
                ", button=" + button +
                '}';
    }
}
