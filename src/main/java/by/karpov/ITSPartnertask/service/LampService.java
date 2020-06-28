package by.karpov.ITSPartnertask.service;

public interface LampService<T> {

    T updateLampCondition(T entity, String condition);
}
