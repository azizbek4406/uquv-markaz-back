package net.idrok.oquvmarkaz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.oquvmarkaz.entity.Oquvchi;
import net.idrok.oquvmarkaz.repository.OquvchiRepository;

@Service
public class OquvchiService {
    @Autowired
    OquvchiRepository oquvchiRepository;

    public Page<Oquvchi> getAll(String key, Pageable pageable){
        return oquvchiRepository.getAllWithKey(key, pageable);
    }
    public Oquvchi create(Oquvchi oquvchi){
        if(oquvchi.getId() == null){
            if (oquvchi.getTulov() == null){
                oquvchi.setTulov(false);
            }
            return oquvchiRepository.save(oquvchi);
        }
        throw new RuntimeException("O`quvchida id bulishi shart");

    }
    public Oquvchi update(Oquvchi oquvchi){
        if(oquvchi.getId() != null){
            return oquvchiRepository.save(oquvchi);
        }
        throw new RuntimeException("O`quvchida id bulmasligi shart");

    }
    public void deleteById(Long id){
        oquvchiRepository.deleteById(id);
    }

    public Long getGuruhSoni(long guruhId){
        return oquvchiRepository.countByGuruhId(guruhId);
    }
}
