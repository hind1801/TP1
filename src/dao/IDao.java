package dao;

public interface IDao<T,ID> {
    T findById(ID id);


}
