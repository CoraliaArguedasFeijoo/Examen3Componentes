package com.cenfotec.ex3.services;

import com.cenfotec.ex3.domain.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    public List<Parent> getAll();
    public Optional<Parent> findById(int id);
    public  Optional<Parent> save(Parent contact);
    public  Optional<Parent> update(Parent contact);
    public boolean delete(int id);
    public List<Parent> getByKeyword(String keyword);
}
