package com.sarc.repository;

import com.sarc.bean.TemporaryCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TemporaryCustomerRepository extends JpaRepository<TemporaryCustomer, Integer> {
    TemporaryCustomer findAllById(int id);
}
