package entity;

public class OrderDetail implements SuperEntity{
    private String OrderID;
    private String PropertyID;
    private  int OrderQty;
    private Double Amount;

    public OrderDetail() {
    }

    public OrderDetail(String orderID, String propertyID, int orderQty, Double amount) {
        OrderID = orderID;
        PropertyID = propertyID;
        OrderQty = orderQty;
        Amount = amount;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(String propertyID) {
        PropertyID = propertyID;
    }

    public int getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(int orderQty) {
        OrderQty = orderQty;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "OrderID='" + OrderID + '\'' +
                ", PropertyID='" + PropertyID + '\'' +
                ", OrderQty=" + OrderQty +
                ", Amount=" + Amount +
                '}';
    }
}
