package com.valentino.indomie.repositories;

import com.valentino.indomie.entitys.Topings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopingRepository extends JpaRepository<Topings, String> {

    Page<Topings> findAllByName(Pageable pageable, String keyword);
}
