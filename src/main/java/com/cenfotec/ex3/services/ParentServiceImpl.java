package com.cenfotec.ex3.services;

import com.cenfotec.ex3.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import com.cenfotec.ex3.domain.Parent;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService{
    @Autowired
    ParentRepository contactRepo;

    @Override
    public List<Parent> getAll() {
        return contactRepo.findAll();
    }

    @Override
    public Optional<Parent> findById(int id) {
        return contactRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Parent> save(Parent contact) {
        return Optional.of(contactRepo.save(contact));
    }

    @Override
    public  Optional<Parent> update(Parent contact) {
        Optional<Parent> record = contactRepo.findById(contact.getCedula());
        if (record.isPresent()) {
            Parent data = record.get();
            data.setNombre(contact.getNombre());
            data.setApellido(contact.getApellido());
            data.setDireccion(contact.getDireccion());
            data.setTelefonoPrimario(contact.getTelefonoPrimario());
            data.setTelefonoSecundario(contact.getTelefonoSecundario());
            return Optional.of(contactRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        Optional<Parent> result = contactRepo.findById(id);
        if (result.isPresent()){
            contactRepo.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Parent> getByKeyword(String keyword) {
        return contactRepo.findByKeyword(keyword);
    }
}
