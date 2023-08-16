package com.neueda.stock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neueda.stock.entity.SRMultiKeys;
import com.neueda.stock.entity.StockRecord;
import com.neueda.stock.repo.StockRecordRepo;

@Service
public class StockRecordService {
	
	@Autowired
	private StockRecordRepo repo;
	/*add a stock record 
	 * */ 
	public StockRecord addStockRecord(StockRecord stockR) {
		return repo.save(stockR);
	}

	//get a stock's  all record by symbol
	public List<StockRecord> getAllStockRecord(String stocksymbol){
		return repo.getStockRecordByStocksymbol(stocksymbol);
	}
	
	//get a stock record by stock symbol and  by date
	public StockRecord getStockRecord(String stocksymbol,String date) {
		List<StockRecord> records = repo.getStockRecordByDate(stocksymbol,date);
		if(records.isEmpty()) {
			return null;
		}else {
			return records.get(0);
		}		
	}
	
	//update a stock record 
	public StockRecord updateStockRecord(StockRecord newStockRecord) {
		if(repo.findById(new SRMultiKeys(newStockRecord.getStocksymbol(),newStockRecord.getDate())).isPresent()) {
			StockRecord old = repo.findById(new SRMultiKeys(newStockRecord.getStocksymbol(),newStockRecord.getDate())).get();
			old.setOpen(newStockRecord.getOpen());
			old.setClose(newStockRecord.getClose());
			old.setHigh(newStockRecord.getHigh());
			old.setLow(newStockRecord.getLow());
			old.setVolume(newStockRecord.getVolume());
			return repo.save(old);
		}else {
			return null;
		}
		
	}
	
	// delete a stock record by date
	public boolean deleteStockRecord(String stocksymbol,String date) {
		if(repo.findById(new SRMultiKeys(stocksymbol,date)).isPresent()) {
			repo.deleteById(new SRMultiKeys(stocksymbol,date));
			return true;
		}else {
			return false;
		}
	}
	
	//modify the date format
	private void modifyDate(List<StockRecord> list) {
		
		for(int i=0;i<list.size();i++) {
			String oldDate = list.get(i).getDate();
			list.get(i).setDate(oldDate.substring(0, 10));
		}
	}
	
	//get records from the past ten days
	public List<StockRecord> getRecord_ten(String stocksymbol){
		List<StockRecord> allrecords = repo.getStockRecordByStocksymbol(stocksymbol);
		List<StockRecord> result = new ArrayList<StockRecord>();
		if(allrecords.size()<10) {
			result = allrecords;
		}else {
			result =  allrecords.subList(allrecords.size()-10, allrecords.size());
		}
		this.modifyDate(result);
		return result;
	}
	//get records from the past 30 days
	public List<StockRecord> getRecord_month(String stocksymbol){
		List<StockRecord> allrecords = repo.getStockRecordByStocksymbol(stocksymbol);
		List<StockRecord> result = new ArrayList<StockRecord>();
		if(allrecords.size()<30) {
			result = allrecords;
		}else {
			result =  allrecords.subList(allrecords.size()-30, allrecords.size());
		}
		this.modifyDate(result);
		return result;
	}
	//get records from the past one year
	public List<StockRecord> getRecord_year(String stocksymbol){
		List<StockRecord> allrecords = repo.getStockRecordByStocksymbol(stocksymbol);
		List<StockRecord> result = new ArrayList<StockRecord>();
		if(allrecords.size()<365) {
			result = allrecords;
		}else {
			result =  allrecords.subList(allrecords.size()-365, allrecords.size());
		}
		this.modifyDate(result);
		return result;
	}	
	//get stock symbol list
	public List<String> getStockList(){
		return repo.getStockList();
	}
	
	
}
