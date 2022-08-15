package net.idrok.oquvmarkaz.controller;


import net.idrok.oquvmarkaz.entity.Oquvchi;
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

import net.idrok.oquvmarkaz.entity.Oqituvchi;
import net.idrok.oquvmarkaz.service.OqituvchiService;

@RestController
@RequestMapping("/api/oqituvchi")
@CrossOrigin(maxAge = 3600)
public class OqituvchiController {

    @Autowired
    OqituvchiService oqituvchiService;

    @GetMapping
    public Page<Oqituvchi> getAll(@RequestParam(value = "key", required = false) String key, Pageable pageable) {
        if(key == null) key = "";
        return oqituvchiService.getAll(key, pageable);
    }

//    @GetMapping("/active/{active}")
//    public Page<Oqituvchi> getAllByActive(@PathVariable Boolean active, Pageable pageable) {
//        return oqituvchiService.getAllByActive(active, pageable);
//    }

    @PostMapping
    public Oqituvchi create(@RequestBody Oqituvchi oqituvchi){
        return oqituvchiService.create(oqituvchi);
    }
    
    @PutMapping
    public Oqituvchi update(@RequestBody Oqituvchi oqituvchi){
        return oqituvchiService.update(oqituvchi);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        oqituvchiService.deleteById(id);
    }
    
    
}
