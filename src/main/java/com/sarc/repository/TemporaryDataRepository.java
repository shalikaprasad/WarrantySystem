package com.sarc.repository;

import com.sarc.bean.TemporaryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TemporaryDataRepository extends JpaRepository<TemporaryData, Integer> {
    TemporaryData findAllById(int id);
}