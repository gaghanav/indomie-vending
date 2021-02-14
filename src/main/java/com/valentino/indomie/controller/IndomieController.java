package com.valentino.indomie.controller;

import com.valentino.indomie.entitys.Indomie;
import com.valentino.indomie.services.IndomieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndomieController {

    @Autowired
    IndomieService indomieService;

    @PostMapping("/indomie_add")
    public Indomie saveIndomie(@RequestBody Indomie indomie){
        return indomieService.saveIndomie(indomie);
    }
    @PutMapping("/indomie_update")
    public Indomie updateIndomie(@RequestBody Indomie indomie){
        return indomieService.updateIndomie(indomie);
    }
    @GetMapping("/indomies")
    public Page<Indomie> getAllIndomie(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
//        indomieService.
        return indomieService.getAllIndomie(PageRequest.of(page-1, size));
    }
    @GetMapping("/indomie_search")
    public Page<Indomie> searchIndomie(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, @RequestParam(name = "keyword") String keyword){
        return indomieService.getIndomieByKeyword(PageRequest.of(page-1,size), keyword);
    }
    @DeleteMapping("/indomie_delete")
    public void deleteIndomie(@RequestParam(name = "id") String id){
        indomieService.deleteIndomie(id);
    }
}
