package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.execute("INSERT INTO Customer VALUES(?,?,?,?,?,?,?)",customer.getCustomerID(),customer.getCustomeType(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCity(),customer.getProvince(),customer.getContact());
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return CrudUtil.execute("UPDATE Customer SET CustomerType=?,CustomerName=?,CustomerAddress=?,City=?,Province=?,Contact=? Where CustomerID=?",customer.getCustomeType(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCity(),customer.getProvince(),customer.getContact(),customer.getCustomerID());

    }

    @Override
    public boolean delete(String cid) throws Exception {
        return CrudUtil.execute("DELETE FROM Customer WHERE  CustomerID=?",cid);
    }

    @Override
    public Customer get(String cid) throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM Customer WHERE CustomerID=?",cid);
        if(resultSet.next()) {
            return new Customer(
                    resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7 ));
        }else {
            return  null;
        }
    }

    @Override
    public List<Customer> getAll() throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> customerList=new ArrayList<>();
        while (resultSet.next()){
            customerList.add(new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7)));
        }
        return customerList;
    }
    }

