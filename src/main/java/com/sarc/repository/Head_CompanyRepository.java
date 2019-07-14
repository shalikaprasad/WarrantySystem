package com.sarc.repository;

import com.sarc.bean.Head_Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Head_CompanyRepository extends JpaRepository<Head_Company, Integer> {
    //Head_Company findByCompanyName(String headcompany_name);
}
