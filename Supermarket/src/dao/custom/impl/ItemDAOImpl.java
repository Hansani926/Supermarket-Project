package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import entity.Item;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) throws Exception {
        return CrudUtil.execute("INSERT INTO product VALUES(?,?,?,?,?,?,?,?)",item.getProductID(),item.getProductName(),item.getDescription(),item.getSpecification(),item.getDisplayName(),item.getAvaliability(),item.getActiveState(),item.getAvailableBrand());
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtil.execute("UPDATE Product SET ProductName=?,Description=? ,Specification=?,DisplayName=?,Avaliability=?,ActiveState=?,AvailableBrands=? Where ProductID=?",item.getProductName(),item.getDescription(),item.getSpecification(),item.getDisplayName(),item.getAvaliability(),item.getActiveState(),item.getAvailableBrand(),item.getProductID());
    }

    @Override
    public boolean delete(String productid ) throws Exception {
        return CrudUtil.execute("DELETE FROM Product WHERE ProductID=?",productid);
    }

    @Override
    public Item get(String productid) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Product WHERE ProductID=?",productid);
        if (resultSet.next()) {
            return new Item(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getBoolean(6),resultSet.getBoolean(7),resultSet.getString(8));
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Product");
        ArrayList<Item> itemList = new ArrayList<>();
        while (resultSet.next()) {
            itemList.add(
                    new Item(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getBoolean(6),resultSet.getBoolean(7),resultSet.getString(8))
            );
        }
        return itemList;
    }

}
