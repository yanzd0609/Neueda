package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import entity.StockRecord;

@Service
public class StockService {
	
	
	/*add a stock record 
	 * return all stock record
	 * */ 
	public List<StockRecord> addStockRecord(StockRecord stockR) {
		return ;
	}

	//get a stock's  all record by symbol
	public List<StockRecord> getAllStockRecord(String stocksymbol){
		return ;
	}
	
	//get a stock record by stock symbol and  by date
	public StockRecord getStockRecord(String stocksymbol,String date) {
		return ;
		
	}
	
	//update a stock record by date
	public StockRecord updateStockRecord(String date) {
		return ;
		
	}
	
	// delete a stock record by date
	public void deleteStockRecord(String stocksymbol,String date) {
		
	}

		

}
