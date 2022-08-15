package net.idrok.oquvmarkaz.repository;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.idrok.oquvmarkaz.entity.Oqituvchi;

@Repository
public interface OqituvchiRepository extends JpaRepository<Oqituvchi, Long>{

    Page<Oqituvchi> findAll(Pageable pageable);

    @Query("FROM Oqituvchi o WHERE UPPER(o.ism) like '%' || UPPER(:key) || '%' or UPPER(o.familiya) like '%' || UPPER(:key) || '%' or UPPER(o.fan) like '%' || UPPER(:key) || '%' or UPPER(o.info) like '%' || UPPER(:key) || '%'")
    Page<Oqituvchi> getAllWithKey(@Param("key") String key, Pageable pageable);

//    Page<Oqituvchi> findAllByActive(Boolean active, Pageable pageable);




}
