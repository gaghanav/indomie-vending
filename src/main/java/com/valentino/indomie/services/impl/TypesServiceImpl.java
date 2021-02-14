package com.valentino.indomie.services.impl;

import com.valentino.indomie.entitys.Types;
import com.valentino.indomie.repositories.TypesRepository;
import com.valentino.indomie.services.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    TypesRepository typesRepository;
    @Override
    public Types saveType(Types types) {
        return typesRepository.save(types);
    }

    @Override
    public Types updateType(Types types) {
        if(types.getId()!=null){
            return typesRepository.save(types);
        }
        return null;
    }

    @Override
    public void deleteType(String id) {
        typesRepository.deleteById(id);
    }

    @Override
    public Page<Types> getAllTypes(Pageable pageable) {
        return typesRepository.findAll(pageable);
    }
}
