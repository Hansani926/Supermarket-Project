package dao;

import dao.custom.impl.*;

public class DaoFactory {
    private  static DaoFactory daoFactory;
    private DaoFactory(){
    }
    public static DaoFactory getInstance(){
        return (daoFactory==null)?(daoFactory=new DaoFactory()):(daoFactory);

    }
    public  enum  DAOType{
       CUSTOMER,ITEM,BATCH,ORDER,ORDERDETAIL,QUERY
    }
    public <T> T getDao(DAOType type){
        switch (type){

            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case BATCH:
                return (T) new BatchDAOImpl();

            case ORDER:
                return (T) new OrderDAOImpl();
            case ORDERDETAIL:
                return (T) new OrderDetailDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return  null;

        }
    }
}
