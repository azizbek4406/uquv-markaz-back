package net.idrok.oquvmarkaz.service;


import net.idrok.oquvmarkaz.entity.Oquvchi;
import net.idrok.oquvmarkaz.entity.Tulov;
import net.idrok.oquvmarkaz.repository.OquvchiRepository;
import net.idrok.oquvmarkaz.repository.TulovRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TulovService {

    private final TulovRepository tulovRepository;
    private final OquvchiRepository oquvchiRepository;

    public TulovService(TulovRepository tulovRepository, OquvchiRepository oquvchiRepository) {
        this.tulovRepository = tulovRepository;
        this.oquvchiRepository = oquvchiRepository;
    }

    public Page<Tulov> getAll(String key, Pageable pageable) {
        return tulovRepository.getAllWithKey(key, pageable);
    }

    public Tulov create(Tulov t) {
        if (t.getId() == null){
            if (t.getTulovTasdiq() == null){
                t.setTulovTasdiq(false);
            }

            Tulov tulov = tulovRepository.save(t);
            Oquvchi oquvchi = oquvchiRepository.getById(t.getOquvchi().getId());
            oquvchi.setTulovVaqtKeldi(true);
            oquvchiRepository.save(oquvchi);
            return tulov;
        }
        throw new RuntimeException("Id bulmaligi kerak");
    }

    public Tulov update(Tulov tulov) {
        if (tulov.getId() != null) return tulovRepository.save(tulov);
        throw new RuntimeException("id bulishi kerak");
    }

    public void deleteById(Long id){
        tulovRepository.deleteById(id);

    }

}
