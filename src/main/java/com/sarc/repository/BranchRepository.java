package com.sarc.repository;

import com.sarc.bean.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
//    Branch findByBranch(String subcompany_branch_name);
        }
