package com.cenfotec.ex3.repositories;

import com.cenfotec.ex3.domain.Hijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HijoRepository extends JpaRepository<Hijo, Long> {
    @Query(value = "select * from Hijo s where s.madre=:keyword or s.padre=:keyword", nativeQuery = true)
    List<Hijo>findParentHijo(@Param("keyword") int keyword);
}
