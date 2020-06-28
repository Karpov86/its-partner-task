package by.karpov.ITSPartnertask.service;

import java.util.List;

public interface RoomService<T> {

    T save(T entity);

    List<T> getAll();

    T findById(Long id);

    void delete(T entity);

}
