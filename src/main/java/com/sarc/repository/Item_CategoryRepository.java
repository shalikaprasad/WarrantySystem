package com.sarc.repository;

import com.sarc.bean.Item_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item_CategoryRepository extends JpaRepository<Item_Category, Integer> {

}
