package bo.custom;

import dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {
    public boolean saveItem(ItemDTO dto)throws Exception;
    public boolean updateItem(ItemDTO dto)throws Exception;
    public boolean deleteItem(String id)throws Exception;
    public ItemDTO getItem(String ProductID)throws Exception;

    public ArrayList<ItemDTO> getAllItems() throws Exception;

    public String getProductID()throws Exception;

    Boolean isItemExist(String id) throws SQLException, ClassNotFoundException;


}
