package com.sarc.repository;

import com.sarc.bean.TemporaryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TemporaryItemRepository extends JpaRepository<TemporaryItem, Integer> {
//    Branch findByBranch(String subcompany_branch_name);
}
