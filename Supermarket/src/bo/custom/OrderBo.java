package bo.custom;

import dto.OrderDTO;
import dto.OrderDetailDTO;

import java.util.ArrayList;

public interface OrderBo {
    public String getOrderID() throws Exception;
    public boolean saveOrder(OrderDTO dto, ArrayList<OrderDetailDTO> detailDTOS) throws Exception ;


    public ArrayList<OrderDTO> getAllOrders()throws Exception;
}
