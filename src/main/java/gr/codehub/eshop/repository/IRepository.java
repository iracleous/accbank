package gr.codehub.eshop.repository;

import java.util.List;

public interface IRepository<E> {

    //CRUD
    boolean create(E t);
    E read(int id);
    List<E> read();
    boolean update(int id, String newValue);
    boolean delete(int id) throws Exception;
      
}
