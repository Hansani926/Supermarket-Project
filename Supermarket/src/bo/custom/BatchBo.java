package bo.custom;

import dto.BatchDTO;
import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BatchBo {
    public boolean saveBatch(BatchDTO dto)throws Exception;
    public boolean updateBatch(BatchDTO dto)throws Exception;
    public boolean deletBatch(String id)throws Exception;
    public BatchDTO getBatch(String PropertyID)throws Exception;

    public ArrayList<BatchDTO> getAllBatchs() throws Exception;

    public String getProductID()throws Exception;

    Boolean isBatchExist(String id) throws SQLException, ClassNotFoundException;


    public boolean UpdateStockWhenOrder(ArrayList<OrderDetailDTO> orderDetailDTOS ) throws Exception;
    public boolean UpdateStockWhenOrder(OrderDetailDTO detailDTO) throws Exception;
}
