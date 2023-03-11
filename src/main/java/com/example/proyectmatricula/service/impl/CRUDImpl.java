package com.example.proyectmatricula.service.impl;
import com.example.proyectmatricula.exception.ModelNotFoundException;
import com.example.proyectmatricula.repo.IGenericRepo;
import com.example.proyectmatricula.service.ICRUD;
import java.util.List;
public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();
    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: "+ id));
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) {
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: "+ id));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: "+ id));
        getRepo().deleteById(id);
    }
}


