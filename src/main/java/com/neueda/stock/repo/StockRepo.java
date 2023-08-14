package com.neueda.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neueda.stock.entity.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock,Integer>{

}
