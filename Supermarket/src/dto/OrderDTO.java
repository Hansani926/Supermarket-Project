package dto;

public class OrderDTO {
    private String OrderID;
    private String OrderDate;
    private String CustomerID;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String orderDate,String customerID) {
        OrderID = orderID;
        OrderDate = orderDate;
        CustomerID = customerID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }


    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "OrderID='" + OrderID + '\'' +
                ", OrderDate='" + OrderDate + '\'' +
                ", CustomerID='" + CustomerID + '\'' +
                '}';
    }
}
