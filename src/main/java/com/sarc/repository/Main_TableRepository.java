package com.sarc.repository;

import com.sarc.bean.Main_Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Main_TableRepository extends JpaRepository<Main_Table, Integer> {
}
