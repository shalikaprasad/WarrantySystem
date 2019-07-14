package com.sarc.repository;

import com.sarc.bean.Item_Sell_Amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item_Sell_AmountRepository extends JpaRepository<Item_Sell_Amount, Integer> {

}
