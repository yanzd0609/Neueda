package com.neueda.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/* Stock Entity
 * */
@Table(name="stock_record")
@Entity
@IdClass(SRMultiKeys.class)
public class StockRecord {
	@Id
	@Column(name="stock_symbol")
	private String stocksymbol;  
	@Id
	@Column(name="date")
	private String date;  //stock date
	@Column(name="open")
	private float open;   //stock open price
	@Column(name="close")
	private float close;  //stock close price
	@Column(name="high")
	private float high;   //stock high price
	@Column(name="low")
	private float low;    //stock low price
	@Column(name="volume")
	private long volume;  //The number of shares of that stock that were traded during that day.
	
	public String getStocksymbol() {
		return stocksymbol;
	}
	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	
	

}
