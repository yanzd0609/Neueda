package entity;

import org.springframework.stereotype.Component;

@Component
public class FavoriteRecord {
	
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
