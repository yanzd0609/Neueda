package com.neueda.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FavoriteRecord {
	@Id
	@Column(name="stocksymbol")
	private String stocksymbol;// favorited stock symbol
	private String Date;       // favorite stock date
	
	public String getStocksymbol() {
		return stocksymbol;
	}
	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	

}
