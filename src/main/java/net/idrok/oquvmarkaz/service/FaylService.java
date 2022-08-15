package net.idrok.oquvmarkaz.service;

import net.idrok.oquvmarkaz.entity.Fayl;
import net.idrok.oquvmarkaz.repository.FaylRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaylService {

    private final FaylRepository faylRepository;

    public FaylService(FaylRepository faylRepository) {
        this.faylRepository = faylRepository;
    }

    public Page<Fayl> getAll(String key, Pageable pageable) {
        return faylRepository.findAll(pageable);
    }

    public List<Fayl> getAll() {
        return faylRepository.findAll();
    }

    public List<Fayl> getAllEntity() {
        return faylRepository.findAll();
    }

    public Optional<Fayl> getById(Long id) {
        return faylRepository.findById(id);
    }

    public Fayl create(Fayl fayl) {
        return faylRepository.save(fayl);
    }

    public Fayl update(Fayl fayl) {
        return faylRepository.save(fayl);
    }

    public void deleteById(Long id) {
        faylRepository.deleteById(id);
    }
}