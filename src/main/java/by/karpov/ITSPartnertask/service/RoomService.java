package by.karpov.ITSPartnertask.service;

import by.karpov.ITSPartnertask.exception.ValidationException;

import java.util.List;

public interface RoomService<T> {

    T save(T entity);

    List<T> getAll();

    T findById(Long id) throws ValidationException;

    void delete(T entity);

}
