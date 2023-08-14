package com.neueda.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neueda.stock.entity.SRMultiKeys;
import com.neueda.stock.entity.StockRecord;

@Repository

public interface StockRecordRepo extends JpaRepository<StockRecord,SRMultiKeys>{

}
