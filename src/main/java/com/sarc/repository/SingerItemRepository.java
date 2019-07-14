package com.sarc.repository;

import com.sarc.bean.SingerItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerItemRepository extends JpaRepository<SingerItems, Integer> {

    SingerItems findBySerialNumber(String serialNumber);
}
