package com.abc.ecommerce.repository;

import com.abc.ecommerce.entity.CachedLogistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogisticRepository extends JpaRepository<CachedLogistic, Long> {

    @Query(value = "SELECT SQL_CACHE * FROM cached_logistic WHERE hash = :hashKey", nativeQuery = true)
    List<CachedLogistic> findByHashKey(@Param("hashKey") String hashKey);

}
