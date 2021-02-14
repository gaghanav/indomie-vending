package com.valentino.indomie.services;

import com.valentino.indomie.entitys.Indomie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IndomieService {
    public Indomie saveIndomie(Indomie indomie);
    public void deleteIndomie(String id);
    public Indomie updateIndomie(Indomie indomie);
    public Page<Indomie> getAllIndomie(Pageable pageable);
    public Page<Indomie> getIndomieByKeyword(Pageable pageable, String search);
}
