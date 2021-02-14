package com.valentino.indomie.services;

import com.valentino.indomie.entitys.Topings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopingsService {
    public Topings saveTopings(Topings topings);
    public Topings updateTopings(Topings topings);
    public void deleteTopings(String id);
    public Page<Topings> getAllTopings(Pageable pageable);
    public Page<Topings> getTopingsByKeyword(Pageable pageable, String keyword);
}
