package com.sarc.repository;

import com.sarc.bean.Sub_Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sub_CompanyRepository extends JpaRepository<Sub_Company, Integer> {
}
