package dao;


import java.util.List;
import java.util.Optional;
 
public interface DAO<T> {
 
    List<T> getAll();
 
    Optional<T> get(int id);
 
    void insert(T t);
 
    void update(T t);
 
    void delete(T t);
}

