package com.neueda.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.neueda.stock.entity.FavoriteRecord;
import com.neueda.stock.repo.FavoriteRecordRepo;

public class FavoriteService {
	
	@Autowired
	private FavoriteRecordRepo repo;
	
	/*add a favorited stock record
	 * return all stock record
	 * */
	public List<FavoriteRecord>add(FavoriteRecord frecord) {
		repo.save(frecord);// add the new favorite record
		return getAll();// return all the favorite records after add
	}
	
	//get all favorited stock record
	public List<FavoriteRecord> getAll(){
		return repo.findAll();
	}
	
	//count  favorited stock record
	public int getCount() {
		return (int)repo.count();
	}
	
	/*delete a favorited stock record
	 * return all stock record
	 * */
	public List<FavoriteRecord> delete(int id){
		if(repo.findById(id).isPresent()) { // whether the delete favorited record is exist
			repo.deleteById(id);// if it exists, delete it
			 return repo.findAll();//
		}
		else {
			return null;
		}
		
	}
	


}
