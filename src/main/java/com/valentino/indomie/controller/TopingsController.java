package com.valentino.indomie.controller;

import com.valentino.indomie.entitys.Topings;
import com.valentino.indomie.services.TopingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopingsController {

    @Autowired
    TopingsService topingsService;

    @GetMapping("/topings")
    public Page<Topings> getAllTopings(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        return topingsService.getAllTopings(PageRequest.of(page-1,size));
    }
    @GetMapping("/topings_search")
    public Page<Topings> getAllTopingsByKeyword(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, @RequestParam(name = "keyword") String keyword){
        return topingsService.getTopingsByKeyword(PageRequest.of(page-1,size), keyword);
    }
    @PostMapping("/toping_add")
    public Topings saveToping(@RequestBody Topings topings){
        return topingsService.saveTopings(topings);
    }
    @PutMapping("/toping_update")
    public Topings updateToping(@RequestBody Topings topings){
        return topingsService.updateTopings(topings);
    }
    @DeleteMapping("/toping_delete")
    public void deleteToping(@RequestParam(name = "id") String id){
        topingsService.deleteTopings(id);
    }

}
