package bo.custom.impl;

import bo.custom.ItemBo;
import dao.DaoFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo {
    ItemDAO itemDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.ITEM);

    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        return itemDAO.save(new Item(dto.getProductID(), dto.getProductName(),dto.getDescription(),dto.getSpecification(),dto.getDisplayName(),dto.getAvaliability(),dto.getActiveState(),dto.getAvailableBrand()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        return itemDAO.update(new Item(dto.getProductID(), dto.getProductName(),dto.getDescription(),dto.getSpecification(),dto.getDisplayName(),dto.getAvaliability(),dto.getActiveState(),dto.getAvailableBrand()));
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return itemDAO.delete(id);
    }

    @Override
    public ItemDTO getItem(String ProductID) throws Exception {
        Item item = itemDAO.get(ProductID);
        if(item!=null){
            return new ItemDTO(item.getProductID(), item.getProductName(),item.getDescription(),item.getSpecification(),item.getDisplayName(),item.getAvaliability(),item.getActiveState(),item.getAvailableBrand());
        }
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws Exception {
        ArrayList<ItemDTO>arrayList=new ArrayList<>();
        List<Item> all=itemDAO.getAll();
        for (Item item: all){
            arrayList.add(new ItemDTO(item.getProductID(), item.getProductName(),item.getDescription(),item.getSpecification(),item.getDisplayName(),item.getAvaliability(),item.getActiveState(),item.getAvailableBrand()));

        }
        return arrayList;
    }

    @Override
    public String getProductID() throws Exception {
        return null;
    }

    @Override
    public Boolean isItemExist(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
