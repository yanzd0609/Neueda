package com.neueda.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neueda.stock.entity.FavoriteRecord;

@Repository
public interface FavoriteRecordRepo extends JpaRepository<FavoriteRecord,Integer>{

}
