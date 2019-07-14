package com.sarc.repository;

import com.sarc.bean.Item_Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item_BrandRepository extends JpaRepository<Item_Brand, Integer> {

}
