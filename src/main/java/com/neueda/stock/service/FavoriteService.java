package com.neueda.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neueda.stock.entity.FavoriteRecord;
import com.neueda.stock.repo.FavoriteRecordRepo;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRecordRepo repo;
	
	//*add a favorited stock record
	public FavoriteRecord add(FavoriteRecord frecord) {
		return repo.save(frecord);// add the new favorite record
	}
	
	//get all favorited stock record
	public List<FavoriteRecord> getAll(){
		return repo.findAll();
	}
	
	//count  favorited stock record
	public int getCount() {
		return (int)repo.count();
	}
	
	/*delete a favorited stock record by
	 * return all stock record
	 * */
	public boolean delete(String stocksymbol){
		if(repo.findById(stocksymbol).isPresent()) { // whether the delete favorited record is exist
			repo.deleteById(stocksymbol);// if it exists, delete it
			return true;
		}
		else {
			return false;
		}
		
	}
	


}
