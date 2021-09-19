package entity;

public class Batch implements SuperEntity{

    private String PropertyID;
    private String Batch;
    private Double Price;
    private Double Discount;
    private Boolean DiscountState;
    private  Boolean ActiveState;
    private int Quantity;
    private  String SystemDate;
    private String ProductID;

    public Batch(String propertyID) {
    }

    public Batch(String propertyID, String batch, Double price, Double discount, Boolean discountState, Boolean activeState, int quantity, String systemDate, String productID) {
        PropertyID = propertyID;
        Batch = batch;
        Price = price;
        Discount = discount;
        DiscountState = discountState;
        ActiveState = activeState;
        Quantity = quantity;
        SystemDate = systemDate;
        ProductID = productID;
    }

    public String getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(String propertyID) {
        PropertyID = propertyID;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public Boolean getDiscountState() {
        return DiscountState;
    }

    public void setDiscountState(Boolean discountState) {
        DiscountState = discountState;
    }

    public Boolean getActiveState() {
        return ActiveState;
    }

    public void setActiveState(Boolean activeState) {
        ActiveState = activeState;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getSystemDate() {
        return SystemDate;
    }

    public void setSystemDate(String systemDate) {
        SystemDate = systemDate;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "PropertyID='" + PropertyID + '\'' +
                ", Batch='" + Batch + '\'' +
                ", Price=" + Price +
                ", Discount=" + Discount +
                ", DiscountState=" + DiscountState +
                ", ActiveState=" + ActiveState +
                ", Quantity=" + Quantity +
                ", SystemDate='" + SystemDate + '\'' +
                ", ProductID='" + ProductID + '\'' +
                '}';
    }
}
