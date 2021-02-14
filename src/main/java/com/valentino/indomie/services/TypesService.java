package com.valentino.indomie.services;

import com.valentino.indomie.entitys.Types;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypesService {
    public Types saveType(Types types);
    public Types updateType(Types types);
    public void deleteType(String id);
    public Page<Types> getAllTypes(Pageable pageable);
}
