package com.valentino.indomie.controller;

import com.valentino.indomie.entitys.Types;
import com.valentino.indomie.services.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class TypeController {

    @Autowired
    TypesService typesService;

    @PostMapping("/type_save")
    public Types saveTypes(@RequestBody Types types){
        return typesService.saveType(types);
    }
    @PutMapping("/type_update")
    public Types updateTypes(@RequestBody Types types){
        return typesService.updateType(types);
    }
    @DeleteMapping("/type_delete")
    public void deleteTypes(@RequestParam(name = "id") String id){
        typesService.deleteType(id);
    }
    @GetMapping("/types")
    public Page<Types> getAllTypes(@RequestParam(name = "page") Integer page,@RequestParam(name = "size") Integer size){
        return typesService.getAllTypes(PageRequest.of(page-1,size));
    }
}
