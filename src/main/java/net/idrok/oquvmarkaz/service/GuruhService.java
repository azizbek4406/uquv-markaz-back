package net.idrok.oquvmarkaz.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.oquvmarkaz.entity.Guruh;
import net.idrok.oquvmarkaz.repository.GuruhRepository;
import net.idrok.oquvmarkaz.repository.OquvchiRepository;
import net.idrok.oquvmarkaz.service.dto.GuruhDTO;

@Service
public class GuruhService {

    private final GuruhRepository guruhRepository;
    private final OquvchiRepository oquvchiRepository;

    public GuruhService(GuruhRepository guruhRepository, OquvchiRepository oquvchiRepository) {
        this.guruhRepository = guruhRepository;
        this.oquvchiRepository = oquvchiRepository;
    }

    public Page<GuruhDTO> getAll(String key, Pageable pageable){
        Page<Guruh> g = guruhRepository.getAllWithKey(key, pageable);
        return g.map(t -> {
                GuruhDTO gd = new GuruhDTO(t);
                gd.setOquvchiSon(oquvchiRepository.countByGuruhId(t.getId()));
                return gd;
         });

    }
//    public Page<GuruhDTO> getAllByActive(Boolean active, Pageable pageable) {
//        Page<Guruh> g = guruhRepository.findAllByActive(active, pageable);
//        return g.map(t -> {
//            GuruhDTO gd = new GuruhDTO(t);
//            gd.setOquvchiSon(oquvchiRepository.countByGuruhId(t.getId()));
//            return gd;
//        });
//    }

    public Page<GuruhDTO> getAllByOqituvchiId(Long id, Pageable pageable) {
        Page<Guruh> g = guruhRepository.findAllByOqituvchiId(id, pageable);
        return g.map(t -> {
            GuruhDTO gd = new GuruhDTO(t);
            gd.setOquvchiSon(oquvchiRepository.countByGuruhId(t.getId()));
            return gd;
        });
    }

    public Guruh create(Guruh guruh){
        if(guruh.getId() == null){
            return guruhRepository.save(guruh);
        }
        throw new RuntimeException("O`quvchida id bulishi shart");

    }
    public Guruh update(Guruh guruh){
        if(guruh.getId() != null){
            return guruhRepository.save(guruh);
        }
        throw new RuntimeException("Guruhda id bulmasligi shart");

    }
    public void deleteById(Long id){
        guruhRepository.deleteById(id);
    }
}
