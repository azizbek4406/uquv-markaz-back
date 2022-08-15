package net.idrok.oquvmarkaz.service;


import net.idrok.oquvmarkaz.repository.TulovRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.oquvmarkaz.entity.Oquvchi;
import net.idrok.oquvmarkaz.repository.OquvchiRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OquvchiService {

    private final OquvchiRepository oquvchiRepository;

    private final TulovRepository tulovRepository;

    public OquvchiService(OquvchiRepository oquvchiRepository, TulovRepository tulovRepository, TulovRepository tulovRepository1) {
        this.oquvchiRepository = oquvchiRepository;
        this.tulovRepository = tulovRepository1;
    }

    public Page<Oquvchi> getAll(String key, Pageable pageable){
        return oquvchiRepository.getAllWithKey(key, pageable);
    }

//    public Page<Oquvchi> getAllByActive(Boolean active, Pageable pageable) {
//        return oquvchiRepository.findAllByActive(active, pageable);
//    }

    public Page<Oquvchi> getAllByGuruhIdAndActive(Long id, Pageable pageable) {
        return oquvchiRepository.findAllByGuruhId(id, pageable);
    }

    public Boolean updateMoney() {
        try {
            List<Oquvchi> oquvchis = oquvchiRepository.findAll();

            oquvchis.forEach(o -> {
                try {
                    Thread.sleep(500);
                    o.setTulovVaqtKeldi(false);
                    oquvchiRepository.save(o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Oquvchi create(Oquvchi oquvchi){
        if(oquvchi.getId() == null){

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

    @Transactional
    public void deleteById(Long id){
        tulovRepository.deleteTulovByOquvchiId(id);
        oquvchiRepository.deleteById(id);


    }

    public Long getGuruhSoni(long guruhId){
        return oquvchiRepository.countByGuruhId(guruhId);
    }

}
