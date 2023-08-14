package com.neueda.stock.entity;

import java.io.Serializable;

public class SRMultiKeys implements Serializable{
	protected String stocksymbol;
	protected String date;
	
	public SRMultiKeys() {
		
	}
	public SRMultiKeys(String stocksymbol, String date) {
		super();
		this.stocksymbol = stocksymbol;
		this.date = date;
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((stocksymbol == null) ? 0 : stocksymbol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SRMultiKeys other = (SRMultiKeys) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (stocksymbol == null) {
			if (other.stocksymbol != null)
				return false;
		} else if (!stocksymbol.equals(other.stocksymbol))
			return false;
		return true;
	}
	
	
	
	
	
}
