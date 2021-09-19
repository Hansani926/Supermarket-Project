package view.tm;

public class OrderTM {
    private String PropertyID;
    private String  Description;
    private int OrderQty;
    private Double Price;
    private Double  Amount;

    public OrderTM() {
    }

    public OrderTM(String propertyID, String description, int orderQty, Double price, Double amount) {
        PropertyID = propertyID;
        Description = description;
        OrderQty = orderQty;
        Price = price;
        Amount = amount;
    }

    public String getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(String propertyID) {
        PropertyID = propertyID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(int orderQty) {
        OrderQty = orderQty;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    @Override
    public String  toString() {
        return "OrderTM{" +
                "PropertyID='" + PropertyID + '\'' +
                ", Description='" + Description + '\'' +
                ", OrderQty=" + OrderQty +
                ", Price=" + Price +
                ", Amount=" + Amount +
                '}';
    }
}
