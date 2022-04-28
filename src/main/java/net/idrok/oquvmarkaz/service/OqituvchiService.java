package net.idrok.oquvmarkaz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.oquvmarkaz.entity.Oqituvchi;
import net.idrok.oquvmarkaz.repository.OqituvchiRepository;


@Service
public class OqituvchiService {
    @Autowired
    OqituvchiRepository oqituvchiRepository;

    public Page<Oqituvchi> getAll(String key, Pageable pageable){
        return oqituvchiRepository.getAllWithKey(key, pageable);
    }
    public Oqituvchi create(Oqituvchi oqituvchi){
        if(oqituvchi.getId() == null){
            return oqituvchiRepository.save(oqituvchi);
        }
        throw new RuntimeException("O`qituvchida id bulishi shart");

    }
    public Oqituvchi update(Oqituvchi oqituvchi){
        if(oqituvchi.getId() != null){
            return oqituvchiRepository.save(oqituvchi);
        }
        throw new RuntimeException("O`qituvchida id bulmasligi shart");

    }
    public void deleteById(Long id){
        oqituvchiRepository.deleteById(id);
    }
}
