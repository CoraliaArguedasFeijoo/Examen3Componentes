package com.cenfotec.ex3.services;


import com.cenfotec.ex3.domain.Hijo;

import java.util.List;
import java.util.Optional;

public interface HijoService {
    public List<Hijo> getAll();
    public Optional<Hijo> findById(Long id);
    public  Optional<Hijo> save(Hijo contact);
    public  Optional<Hijo> update(Hijo contact);
    public boolean delete(Long id);

    public List<Hijo>findParentHijo(int keyword);
}
