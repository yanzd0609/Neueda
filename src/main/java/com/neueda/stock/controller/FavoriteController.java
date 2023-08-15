package com.neueda.stock.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.neueda.stock.entity.FavoriteRecord;
import com.neueda.stock.service.FavoriteService;
@CrossOrigin("http://localhost:8080/")
@RestController
@RequestMapping("/api/favoriteRecord")
public class FavoriteController {
	//create Logger
	Logger logger= LoggerFactory.getLogger(FavoriteController.class);
	
	@Autowired
	private FavoriteService favoriteService;
	
	//post request
	@PostMapping("/")
	public ResponseEntity<FavoriteRecord> addFavoriteRecord(@RequestBody FavoriteRecord fRecord){		
		FavoriteRecord favoriteRecord= favoriteService.add(fRecord);		
		if(favoriteRecord!=null)
			return new ResponseEntity<FavoriteRecord>(favoriteRecord,HttpStatus.CREATED);
		else
			return new ResponseEntity<FavoriteRecord>(favoriteRecord,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*get request
	 * get all favorited records
	 *  */  
	@GetMapping("/")
	public List<FavoriteRecord> getAllFavoriteRecord(){
		return favoriteService.getAll();
	}
	
	/*get request
	 * get the count of  favorited records
	 *  */ 
	@GetMapping("/count")
	public ResponseEntity<Integer>getCount (){
		int count= favoriteService.getCount();
		if(count>0)
			return new ResponseEntity<Integer>(count, HttpStatus.OK);
		else
			return new ResponseEntity<Integer>(count, HttpStatus.NOT_FOUND);
	}
	
	/*delete request
	 * delete a favorited records by stocksymbol
	 *  */
	@DeleteMapping("/{stocksymbol}")
	public ResponseEntity<String>deleteFavoriteRecord(@PathVariable String stocksymbol){
		boolean result = favoriteService.delete(stocksymbol);
		if(result) 
			return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<String>("NO user Found", HttpStatus.NOT_FOUND);		
	}
	
	
}
