package com.valentino.indomie.services.impl;

import com.valentino.indomie.entitys.Topings;
import com.valentino.indomie.repositories.TopingRepository;
import com.valentino.indomie.services.TopingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopingServiceImpl implements TopingsService {

    @Autowired
    TopingRepository topingRepository;

    @Override
    public Topings saveTopings(Topings topings) {
        return topingRepository.save(topings);
    }

    @Override
    public Topings updateTopings(Topings topings) {
        if(topings.getId()!=null){
            return topingRepository.save(topings);
        }
        return null;
    }

    @Override
    public void deleteTopings(String id) {
        topingRepository.deleteById(id);
    }

    @Override
    public Page<Topings> getAllTopings(Pageable pageable) {
        return topingRepository.findAll(pageable);
    }

    @Override
    public Page<Topings> getTopingsByKeyword(Pageable pageable, String keyword) {
        return topingRepository.findAllByNameContains(keyword, pageable);
    }
}
