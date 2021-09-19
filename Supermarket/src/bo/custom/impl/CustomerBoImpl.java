package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.DaoFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    CustomerDAO customerDAO= DaoFactory.getInstance().getDao(DaoFactory.DAOType.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.save(new Customer(dto.getCustomerID(),dto.getCustomeType(),dto.getCustomerName(),dto.getCustomerAddress(),dto.getCity(),dto.getProvince(),dto.getContact()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(dto.getCustomerID(),dto.getCustomeType(),dto.getCustomerName(),dto.getCustomerAddress(),dto.getCity(),dto.getProvince(),dto.getContact()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO getCustomer(String CustomerID) throws Exception {
        Customer customer =  customerDAO.get(CustomerID);
        if(customer!=null){
            return new CustomerDTO(customer.getCustomerID(),customer.getCustomeType(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCity(),customer.getProvince(),customer.getContact());
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<CustomerDTO> arrayList=new ArrayList<>();
        List<Customer> all=customerDAO.getAll();
        for(Customer customer:all) {
            System.out.println("in bo "+customer.getCustomerName());
            arrayList.add(new CustomerDTO(customer.getCustomerID(), customer.getCustomeType(), customer.getCustomerName(), customer.getCustomerAddress(),customer.getCity(),customer.getProvince(),customer.getContact()));
        }
        return  arrayList;
    }

    @Override
    public String getCustomerID() throws Exception {
        return null;

    }

    public CustomerDTO getCustomerID(String CustomerID) throws Exception {
        Customer customer =  customerDAO.get(CustomerID);
        if(customer!=null){
            return new CustomerDTO(customer.getCustomerID(), customer.getCustomeType(), customer.getCustomerName(), customer.getCustomerAddress(),customer.getCity(),customer.getProvince(), customer.getContact());
        }
        return null;
    }

    @Override
    public Boolean isCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
