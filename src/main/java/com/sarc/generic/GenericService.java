package com.sarc.generic;

import java.util.List;

/**
 * @author Ram Alapure
 * @since 05-04-2017
 */

public interface GenericService<T extends Object> {

	T save(T entity);
    
    T update(T entity);
  
    void delete(T entity);

    void deleteInBatch(List<T> entities);
  
    List<T> findAll();

    T find(int id);

}
