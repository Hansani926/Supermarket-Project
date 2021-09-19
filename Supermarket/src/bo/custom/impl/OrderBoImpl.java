package bo.custom.impl;

import bo.BoFactory;
import bo.custom.BatchBo;
import bo.custom.ItemBo;
import bo.custom.OrderBo;
import bo.custom.OrderDetailBo;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.OrderDAO;
import db.DBConnection;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Orders;

import java.util.ArrayList;
import java.util.List;

public class OrderBoImpl  implements OrderBo {
   /* QueryDAO queryDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);*/
    OrderDAO orderDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.ORDER);
    OrderDetailBo detailBo = BoFactory.getInstance().getBo(BoFactory.BOType.ORDERDETAIL);
    ItemBo itemBo = BoFactory.getInstance().getBo(BoFactory.BOType.ITEM);
    BatchBo batchBo=BoFactory.getInstance().getBo(BoFactory.BOType.BATCH);

    @Override
    public String getOrderID() throws Exception {
        return null;
    }

    @Override
    public boolean saveOrder(OrderDTO dto, ArrayList<OrderDetailDTO> detailDTOS) throws Exception {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isSaved = orderDAO.save(new Orders(dto.getOrderID(),dto.getOrderDate(),dto.getCustomerID()));
            if(isSaved) {

                boolean isDetailSaved = detailBo.addOrderDetail(detailDTOS);
                if(isDetailSaved) {

                    boolean isUpdated=batchBo.UpdateStockWhenOrder(detailDTOS);
                    if(isUpdated) {

                            DBConnection.getInstance().getConnection().commit();
                            return true;

                        } else {

                        DBConnection.getInstance().getConnection().rollback();
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
            /*  boolean isUpdated = itemBo.UpdateStockWhenOrder(detailDTOS);*/

        }finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<OrderDTO> getAllOrders() throws Exception {
        ArrayList<OrderDTO>arrayList=new ArrayList<>();
        List<Orders> all=orderDAO.getAll();
        for (Orders order: all){
            arrayList.add(new OrderDTO(order.getOrderID(),order.getOrderDate(),order.getCustomerID()));

        }
        return arrayList;
    }
}
