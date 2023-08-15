package com.neueda.stock.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neueda.stock.entity.SRMultiKeys;
import com.neueda.stock.entity.StockRecord;

@Repository

public interface StockRecordRepo extends JpaRepository<StockRecord,SRMultiKeys>{
	@Query("SELECT sr from StockRecord sr where sr.stocksymbol=?1")
	List<StockRecord> getStockRecordByStocksymbol(String stocksymbol);
	
	@Query("SELECT sr from StockRecord sr where sr.stocksymbol=:symbol and sr.date like :date%")
	List<StockRecord> getStockRecordByDate(@Param("symbol") String symbol,@Param("date") String date);
}
