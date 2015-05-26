package com.stockanalyser.utils.crawler;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by wangshupeng on 27/5/15.
 */
public class Crawler {

    final String Url = "";

    String StockNum;
    String StartDate;
    String EndDate;

    public Crawler(String StockNum, String StartDate, String EndDate) {
        this.StockNum = StockNum;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public void GetContent(){

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(this.Url);

    }


}
