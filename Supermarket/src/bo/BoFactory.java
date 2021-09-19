package bo;

import bo.custom.impl.*;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){

    }
    public static  BoFactory getInstance(){
        return (boFactory==null)?(boFactory=new BoFactory()):(boFactory);

    }
    public  enum BOType{
        CUSTOMER,ITEM,BATCH,ORDER,ORDERDETAIL
    }
    public <T> T getBo(BOType type){
        switch (type){

            case CUSTOMER:
                return (T)new CustomerBoImpl();

            case ITEM:
                return (T)new ItemBoImpl();

            case BATCH:
                return (T)new BatchBoImpl();
            case ORDER:
                return (T)new OrderBoImpl();
            case ORDERDETAIL:
                return (T) new OrderDetailBoImpl();
            default:
                return  null;
        }
    }
}
