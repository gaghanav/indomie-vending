package com.valentino.indomie.repositories;

import com.valentino.indomie.entitys.Indomie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndomieRepository extends JpaRepository<Indomie, String> {
    Page<Indomie> findAllByNameContains(String keyword, Pageable pageable);
}
