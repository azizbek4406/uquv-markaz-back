package net.idrok.oquvmarkaz.repository;

import net.idrok.oquvmarkaz.entity.Oquvchi;
import net.idrok.oquvmarkaz.entity.Tulov;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TulovRepository extends JpaRepository<Tulov, Long> {


    Page<Tulov> findAll(Pageable pageable);

    @Query("FROM Tulov t WHERE UPPER(t.oy) like '%' || UPPER(:key) || '%' or UPPER(t.oquvchi.ism) like '%' || UPPER(:key) || '%' or UPPER(t.oquvchi.familiya) like '%' || UPPER(:key) || '%' or UPPER(t.oy) like '%' || UPPER(:key) || '%'")
    Page<Tulov> getAllWithKey(@Param("key") String key, Pageable pageable);


    void deleteTulovByOquvchiId(Long id);
}
