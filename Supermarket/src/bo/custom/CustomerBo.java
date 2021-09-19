package bo.custom;

import dto.BatchDTO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBo {



    public boolean saveCustomer(CustomerDTO dto)throws Exception;
    public boolean updateCustomer(CustomerDTO dto)throws Exception;
    public boolean deleteCustomer(String id)throws Exception;
    public CustomerDTO getCustomer(String CustomerID)throws Exception;

    public  ArrayList<CustomerDTO> getAllCustomers() throws Exception;

    public String getCustomerID()throws Exception;

    Boolean isCustomerExist(String id) throws SQLException, ClassNotFoundException;


}
