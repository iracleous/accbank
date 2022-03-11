package gr.codehub.eshop.repository;

import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.model.Entity;

import java.util.ArrayList;
import java.util.List;


public  class RepositoryImpl<T extends Entity> implements Repository<T>{
    private final List<T> tList = new ArrayList<>();

      @Override
    public boolean create(T t) {
       if (t == null )
           return false;
        tList.add(t);
        return true;
    }

    @Override
    public T read(int id) {

          for(T t : tList){
              if (t.getId() == id)
                  return t;
          }
         return null;
    }

    @Override
    public List<T> read() {
        /* deep copy of the list */
         List<T> returntList = new ArrayList<>();
        for(T t : tList) {
            returntList.add(t);
        }
        return returntList;


       //  return customers;
    }

    @Override
    public boolean update(int id, String newValue) {
        T t = read (id);
        if(t == null)
            return false;
        t.setValue(newValue);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        T t = read (id);
        if(t == null)
            throw new Exception("The customer does not exist");
        tList.remove(t);

        return true;
    }
}
