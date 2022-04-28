package net.idrok.oquvmarkaz.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.idrok.oquvmarkaz.entity.Guruh;

@Repository
public interface GuruhRepository extends JpaRepository<Guruh, Long>{

    Page<Guruh> findAll(Pageable pageable);

    @Query("FROM Guruh g WHERE UPPER(g.nom) like '%' || UPPER(:key) || '%' or UPPER(g.oqituvchi.ism) like '%' || UPPER(:key) || '%' or UPPER(g.oqituvchi.familiya) like '%' || UPPER(:key) || '%' or UPPER(g.info) like '%' || UPPER(:key) || '%'")
    Page<Guruh> getAllWithKey(@Param("key") String key, Pageable pageable);
}
