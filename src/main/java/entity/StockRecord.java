package entity;

import org.springframework.stereotype.Component;

/* Stock Entity
 * */
@Component
public class StockRecord {
	private String date;  //stock date
	private float open;   //stock open price
	private float close;  //stock close price
	private float high;   //stock high price
	private float low;    //stock low price
	private long volume;  //The number of shares of that stock that were traded during that day.
	
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
	public void setVolumn(long volume) {
		this.volume = volume;
	}
	
	

}
