package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BatchDAO;
import entity.Batch;
import entity.Item;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BatchDAOImpl implements BatchDAO {
    @Override
    public boolean save(Batch batch) throws Exception {
        return CrudUtil.execute("INSERT INTO Batch VALUES(?,?,?,?,?,?,?,?,?)",batch.getPropertyID(),batch.getBatch(),batch.getPrice(),batch.getDiscount(),batch.getDiscountState(),batch.getActiveState(),batch.getQuantity(),batch.getSystemDate(),batch.getProductID());
    }

    @Override
    public boolean update(Batch batch) throws Exception {
        return CrudUtil.execute("UPDATE Batch SET Batch=?, Price=?,Discount=?,DiscountState=?,ActiveState=?,Quantity=?,SystemDate, Where PropertyID=?",batch.getBatch(),batch.getPrice(),batch.getDiscount(),batch.getDiscountState(),batch.getActiveState(),batch.getQuantity(),batch.getSystemDate(),batch.getProductID(),batch.getPropertyID());
    }

    @Override
    public boolean delete(String  propertyID) throws Exception {
        return CrudUtil.execute("DELETE FROM Batch WHERE  PropertyID=?", propertyID);
    }

    @Override
    public Batch get(String propertyID) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Batch WHERE PropertyID=?",propertyID);
        if (resultSet.next()) {
            return new Batch(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4),resultSet.getBoolean(5),resultSet.getBoolean(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9));
        } else {
            return null;
        }
    }

    @Override
    public List<Batch> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Batch");
        ArrayList<Batch> batchList = new ArrayList<>();
        while (resultSet.next()) {
            batchList.add(
                    new Batch(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4),resultSet.getBoolean(5),resultSet.getBoolean(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9))
            );
        }
        return batchList;
    }


}
