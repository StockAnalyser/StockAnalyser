package com.stockanalyser.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Stock {

	String stockId="";
	String stockCompany="";
	public List<StockDayData> stockPeriodData=new LinkedList<StockDayData>();
	
	Date availabilityStart=null;
	
	String beginY="";
	String beginM="";
	String beginD="";
	String endY="";
	String endM="";
	String endD="";
	
	int priceType=0;
	public static final int TYPE_PRICE_OPEN=0;
	public static final int TYPE_PRICE_CLOSE=1;
	public static final int TYPE_PRICE_AVERAGE=2;
	
	public Stock(String stockId,String beginY,String beginM,String beginD,String endY,String endM,String endD){
		
	}
	
	public void addDayData(Date date,double open,double high,double low,double close,int volume,double adjClose){
		StockDayData sdd=new StockDayData();
		sdd.date=date;
		sdd.open=open;
		sdd.close=close;
		stockPeriodData.add(sdd);
	}
	
	public void addDayData(StockDayData sdd){
		
	}
	
	public StockDayData getDayData(Date d){
		StockDayData sdd=new StockDayData();
		
		return sdd;
	}
	
	public double getDayPrice(Date d){
		
		return 0.0;
	}
	
	public double getDayPrice(int index){
		
		return 0.0;
	}
	
	public List<StockDayData> downloadPeriodData(Date begin,Date end){
		//List<StockDayData> sdds=new LinkedList<StockDayData>();
		
		return stockPeriodData;
	}
}
