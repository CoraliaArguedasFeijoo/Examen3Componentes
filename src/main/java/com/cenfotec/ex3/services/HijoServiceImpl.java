package com.cenfotec.ex3.services;

import com.cenfotec.ex3.domain.Hijo;
import com.cenfotec.ex3.repositories.HijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HijoServiceImpl implements HijoService {

    @Autowired
    HijoRepository contactRepo;
    @Override
    public List<Hijo> getAll() {
        return contactRepo.findAll();
    }

    @Override
    public Optional<Hijo> findById(Long id) {
        return contactRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Hijo> save(Hijo contact) {
        return Optional.of(contactRepo.save(contact));
    }

    @Override
    public  Optional<Hijo> update(Hijo contact) {
        Optional<Hijo> record = contactRepo.findById(contact.getId());
        if (record.isPresent()) {
            Hijo data = record.get();
            data.setNombre(contact.getNombre());
            data.setPlan(contact.getPlan());
            data.setAlergias(contact.getAlergias());
            data.setPadre(contact.getPadre());
            data.setMadre(contact.getMadre());
            return Optional.of(contactRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Hijo> result = contactRepo.findById(id);
        if (result.isPresent()){
            contactRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Hijo> findParentHijo(int keyword) {
        return contactRepo.findParentHijo(keyword);
    }
}
