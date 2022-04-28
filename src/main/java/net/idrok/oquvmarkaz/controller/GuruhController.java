package net.idrok.oquvmarkaz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.oquvmarkaz.entity.Guruh;
import net.idrok.oquvmarkaz.service.GuruhService;
import net.idrok.oquvmarkaz.service.dto.GuruhDTO;

@RestController
@RequestMapping("/api/guruh")
@CrossOrigin(maxAge = 3600)
public class GuruhController{

    @Autowired
    GuruhService guruhService;

    

    @GetMapping
    public Page<GuruhDTO> getAll(@RequestParam(value = "key", required = false) String key, Pageable pageable){
        if(key == null) key = "";
        return guruhService.getAll(key,pageable);
    }
    @PostMapping
    public Guruh create(@RequestBody Guruh guruh){
        return guruhService.create(guruh);
    }
    @PutMapping
    public Guruh update(@RequestBody Guruh guruh){
        return guruhService.update(guruh);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        guruhService.deleteById(id);
    }
}