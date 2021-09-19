package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDAO;
import entity.Orders;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Orders orders) throws Exception {
        return CrudUtil.execute("INSERT INTO Orders VALUES (?,?,?)",orders.getOrderID(),orders.getOrderDate(),orders.getCustomerID());
    }

    @Override
    public boolean update(Orders orders) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String cid) throws Exception {
        return false;
    }

    @Override
    public Orders get(String cid) throws Exception {
        return null;
    }

    @Override
    public List<Orders> getAll() throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM Orders");
        ArrayList<Orders> orderList=new ArrayList<>();
        while (resultSet.next()){
            orderList.add(new Orders(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3)));
        }
        return orderList;
    }

}
