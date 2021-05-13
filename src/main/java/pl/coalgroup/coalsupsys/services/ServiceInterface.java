package pl.coalgroup.coalsupsys.services;

import java.util.List;

public interface ServiceInterface<T> {
    T save(T t);
    T findById(Long id);
    T delete(Long id);
    void update(Object t, Long id);
    List <T> findAll();
}

