package net.idrok.oquvmarkaz.repository;


import net.idrok.oquvmarkaz.entity.Guruh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.idrok.oquvmarkaz.entity.Oquvchi;

import java.util.List;
import java.util.Optional;

@Repository
public interface OquvchiRepository extends JpaRepository<Oquvchi, Long>{

    Page<Oquvchi> findAll(Pageable pageable);

    @Query("FROM Oquvchi o WHERE UPPER(o.ism) like '%' || UPPER(:key) || '%' or UPPER(o.familiya) like '%' || UPPER(:key) || '%' or UPPER(o.guruh.nom) like '%' || UPPER(:key) || '%'  or UPPER(o.info) like '%' || UPPER(:key) || '%' or UPPER(o.jins) like '%' || UPPER(:key) || '%'")
    Page<Oquvchi> getAllWithKey(@Param("key") String key, Pageable pageable);
    Long countByGuruhId(Long id);

//    Page<Oquvchi> findAllByActive(Boolean active, Pageable pageable);

    Page<Oquvchi> findAllByGuruhId(Long id, Pageable pageable);

    List<Oquvchi> findAll();

    Oquvchi getById(Long id);
}
