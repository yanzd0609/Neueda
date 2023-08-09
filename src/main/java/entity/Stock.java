package entity;

import jakarta.persistence.Entity;

@Entity
public class Stock {
	
	private int id;
	private String stocksymbol;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStocksymbol() {
		return stocksymbol;
	}
	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
	}
	
	

}
