package com.cenfotec.ex3.repositories;

import com.cenfotec.ex3.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Integer> {

    @Query(value = "select * from Parent s where s.nombre like %:keyword% or s.apellido like %:keyword%", nativeQuery = true)
    List<Parent> findByKeyword(@Param("keyword") String keyword);

}
