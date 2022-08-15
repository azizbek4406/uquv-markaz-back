package net.idrok.oquvmarkaz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;
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

import net.idrok.oquvmarkaz.entity.Oquvchi;
import net.idrok.oquvmarkaz.service.OquvchiService;

import java.util.List;

@RestController
@RequestMapping("/api/oquvchi")
@CrossOrigin(maxAge = 3600)
public class OquvchiController{

    @Autowired
    OquvchiService oquvchiService;

    @GetMapping
    public Page<Oquvchi> getAll(@RequestParam(value = "key", required = false) String key,Pageable pageable){
        if(key == null) key = "";
        return oquvchiService.getAll(key,pageable);
    }

//    @GetMapping("/active/{active}")
//    public Page<Oquvchi> getAllByActive(@PathVariable Boolean active, Pageable pageable) {
//        return oquvchiService.getAllByActive(active, pageable);
//    }

    @GetMapping("/gr/{id}")
    public Page<Oquvchi> getAllByGuruhId(@PathVariable Long id, Pageable pageable) {
        return oquvchiService.getAllByGuruhIdAndActive(id, pageable);
    }

    @GetMapping("/update")
    public Boolean updateMoney() {
        return oquvchiService.updateMoney();
    }

    @PostMapping
    public Oquvchi create(@RequestBody Oquvchi oquvchi){
        return oquvchiService.create(oquvchi);
    }
    @PutMapping
    public Oquvchi update(@RequestBody Oquvchi oquvchi){
        return oquvchiService.update(oquvchi);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        oquvchiService.deleteById(id);
    }
}