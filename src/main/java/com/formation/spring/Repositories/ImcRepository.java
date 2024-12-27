package com.formation.spring.Repositories;

import com.formation.spring.Entities.ImcDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImcRepository extends CrudRepository<ImcDataEntity, Long> {
    ImcDataEntity findByUserUserId(String userId);
}