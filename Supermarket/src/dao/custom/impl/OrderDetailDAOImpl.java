package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDetailDAO;
import entity.OrderDetail;

import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetail orderDetail) throws Exception {
        return CrudUtil.execute("INSERT INTO OrderDetail VALUES (?,?,?,?)",orderDetail.getOrderID(),orderDetail.getPropertyID(),orderDetail.getOrderQty(),orderDetail.getAmount());
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String cid) throws Exception {
        return false;
    }

    @Override
    public OrderDetail get(String cid) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetail> getAll() throws Exception {
        return null;
    }
}
