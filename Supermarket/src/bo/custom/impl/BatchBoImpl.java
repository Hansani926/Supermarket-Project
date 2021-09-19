package bo.custom.impl;

import bo.custom.BatchBo;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.BatchDAO;
import dto.BatchDTO;
import dto.ItemDTO;
import dto.OrderDetailDTO;
import entity.Batch;
import entity.Customer;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchBoImpl implements BatchBo {
    BatchDAO batchDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.BATCH);


    @Override
    public boolean saveBatch(BatchDTO dto) throws Exception {
        return batchDAO.save(new Batch(dto.getPropertyID(),dto.getBatch(),dto.getPrice(),dto.getDiscount(),dto.getDiscountState(),dto.getActiveState(),dto.getQuantity(),dto.getSystemDate(),dto.getProductID()));
    }

    @Override
    public boolean updateBatch(BatchDTO dto) throws Exception {
        return batchDAO.update(new Batch(dto.getPropertyID(),dto.getBatch(),dto.getPrice(),dto.getDiscount(),dto.getDiscountState(),dto.getActiveState(),dto.getQuantity(),dto.getSystemDate(),dto.getProductID()));
    }

    @Override
    public boolean deletBatch(String id) throws Exception {
        return batchDAO.delete(id);
    }

    @Override
    public BatchDTO getBatch(String PropertyID) throws Exception {
        Batch batch = batchDAO.get(PropertyID);
        if(batch!=null){
            return new BatchDTO(batch.getPropertyID(),batch.getBatch(),batch.getPrice(),batch.getDiscount(),batch.getDiscountState(),batch.getActiveState(),batch.getQuantity(),batch.getSystemDate(),batch.getProductID());
        }
        return null;
    }

    @Override
    public ArrayList<BatchDTO> getAllBatchs() throws Exception {
        ArrayList<BatchDTO>arrayList=new ArrayList<>();
        List<Batch> all=batchDAO.getAll();
        for (Batch batch: all){
            arrayList.add(new BatchDTO(batch.getPropertyID(),batch.getBatch(),batch.getPrice(),batch.getDiscount(),batch.getDiscountState(),batch.getActiveState(),batch.getQuantity(),batch.getSystemDate(),batch.getProductID()));

        }
        return arrayList;
    }

    @Override
    public String getProductID() throws Exception {
        return null;
    }

    @Override
    public Boolean isBatchExist(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean UpdateStockWhenOrder(ArrayList<OrderDetailDTO> orderDetailDTOS) throws Exception{
        for (OrderDetailDTO orderDetailDTO : orderDetailDTOS) {
            boolean b = UpdateStockWhenOrder(orderDetailDTO);
            if(!b){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean UpdateStockWhenOrder(OrderDetailDTO detailDTO) throws Exception {
      return true;
    }


}
