package net.idrok.oquvmarkaz.controller;

import net.idrok.oquvmarkaz.entity.Oquvchi;
import net.idrok.oquvmarkaz.entity.Tulov;
import net.idrok.oquvmarkaz.service.TulovService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tulov")
@CrossOrigin(value = "*", maxAge = 3600)
public class TulovController {

    private final TulovService tulovService;

    public TulovController( TulovService tulovService) {
        this.tulovService = tulovService;
    }

    @GetMapping
    public Page<Tulov> getAll(@RequestParam(value = "key", required = false) String key, Pageable pageable){
        if(key == null) key = "";
        return tulovService.getAll(key,pageable);
    }

    @PostMapping
    public Tulov create(@RequestBody Tulov tulov) {
        return tulovService.create(tulov);
    }

    @PutMapping
    public Tulov update(@RequestBody Tulov tulov) {
        return tulovService.update(tulov);
    }

//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Long id){
//        tulovService.deleteById(id);
//    }
}

