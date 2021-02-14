package com.valentino.indomie.services.impl;

import com.valentino.indomie.entitys.Indomie;
import com.valentino.indomie.repositories.IndomieRepository;
import com.valentino.indomie.services.IndomieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IndomieServiceImpl implements IndomieService {

    @Autowired
    IndomieRepository indomieRepository;

    @Override
    public Indomie saveIndomie(Indomie indomie) {
        return indomieRepository.save(indomie);
    }

    @Override
    public void deleteIndomie(String id) {
        indomieRepository.deleteById(id);
    }

    @Override
    public Indomie updateIndomie(Indomie indomie) {
        if(indomie.getId()!=null){
            return indomieRepository.save(indomie);
        }
        return null;
    }

    @Override
    public Page<Indomie> getAllIndomie(Pageable pageable) {
        return indomieRepository.findAll(pageable);
    }

    @Override
    public Page<Indomie> getIndomieByKeyword(Pageable pageable, String search) {
        return indomieRepository.findAllByName(pageable, search);
    }
}
