package entity;

public class Customer implements SuperEntity{
    private String CustomerID;
    private String CustomeType;
    private String CustomerName;
    private String CustomerAddress;
    private String City;
    private String Province;
    private int Contact;

    public Customer() {
    }

    public Customer(String customerID, String customeType, String customerName, String customerAddress, String city, String province, int contact) {
        CustomerID = customerID;
        CustomeType = customeType;
        CustomerName = customerName;
        CustomerAddress = customerAddress;
        City = city;
        Province = province;
        Contact = contact;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCustomeType() {
        return CustomeType;
    }

    public void setCustomeType(String customeType) {
        CustomeType = customeType;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", CustomeType='" + CustomeType + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", City='" + City + '\'' +
                ", Province='" + Province + '\'' +
                ", Contact=" + Contact +
                '}';
    }
}
