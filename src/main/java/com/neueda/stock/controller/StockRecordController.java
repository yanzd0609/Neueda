package com.neueda.stock.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.stock.entity.StockRecord;
import com.neueda.stock.service.StockRecordService;

@RestController
@RequestMapping("/api/sr")
public class StockRecordController {
	//create Logger
	Logger logger= LoggerFactory.getLogger(StockRecordController.class);
	@Autowired
	private StockRecordService service;
	
	@GetMapping("/{symbol}")
	public ResponseEntity<Object> getAllRecordBySymbol(@PathVariable String symbol){
		logger.info("getAllRecordBySymbol:"+symbol);
		List<StockRecord> records = service.getAllStockRecord(symbol);
		if(records.isEmpty()) {
			return new ResponseEntity<Object>("No Record Available",HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<Object>(records,HttpStatus.OK);
		}
	}
	
	@GetMapping("/{symbol}/{date}")
	public ResponseEntity<StockRecord>getStockRecordByDate (@PathVariable String symbol,@PathVariable String date){
		logger.info("getAllRecordByDate:"+symbol+" "+date);

		StockRecord record= service.getStockRecord(symbol, date);
		
		if(record!=null)
			return new ResponseEntity<StockRecord>(record, HttpStatus.OK);
		else
			return new ResponseEntity<StockRecord>(record, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/tendays/{symbol}")
	public ResponseEntity<Object> getTenRecordBySymbol(@PathVariable String symbol){
		logger.info("getTenRecordBySymbol:"+symbol);
		List<StockRecord> records = service.getRecord_ten(symbol);
		if(records.isEmpty()) {
			return new ResponseEntity<Object>("No Record Available",HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<Object>(records,HttpStatus.OK);
		}
	}
	
	@GetMapping("/month/{symbol}")
	public ResponseEntity<Object> getMonthRecordBySymbol(@PathVariable String symbol){
		logger.info("getMonthRecordBySymbol:"+symbol);
		List<StockRecord> records = service.getRecord_month(symbol);
		if(records.isEmpty()) {
			return new ResponseEntity<Object>("No Record Available",HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<Object>(records,HttpStatus.OK);
		}
	}
	
	@GetMapping("/year/{symbol}")
	public ResponseEntity<Object> getYearRecordBySymbol(@PathVariable String symbol){
		logger.info("getYearRecordBySymbol:"+symbol);
		List<StockRecord> records = service.getRecord_year(symbol);
		if(records.isEmpty()) {
			return new ResponseEntity<Object>("No Record Available",HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<Object>(records,HttpStatus.OK);
		}
	}
	@GetMapping("/stocklist")
	public ResponseEntity<Object> getStockList(){
		logger.info("getStockList");
		List<String> stocklist = service.getStockList();
		if(stocklist.isEmpty()) {
			return new ResponseEntity<Object>("No Stock Symbol Available",HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<Object>(stocklist,HttpStatus.OK);
		}

	}
	
	
}
