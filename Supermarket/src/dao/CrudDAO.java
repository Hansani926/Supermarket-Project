package dao;

import entity.SuperEntity;

import java.util.List;

public interface CrudDAO<T extends SuperEntity,CustomerID> extends SuperDAO{
    public  boolean save(T t)throws Exception;
    public boolean update(T t)throws Exception;
    public boolean delete(CustomerID cid)throws Exception;
    public T get(CustomerID cid)throws Exception;
    public List<T> getAll()throws Exception;
}
