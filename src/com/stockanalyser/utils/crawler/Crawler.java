package com.stockanalyser.utils.crawler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by wangshupeng on 27/5/15.
 */
public class Crawler {

    static String Url = "http://real-chart.finance.yahoo.com/table.csv?s=StockNum&a=StartMonth&b=StartDate&c=StartYear&d=EndMonth&e=EndDate&f=EndYear&g=d&ignore=.csv";

    public static void GetContent(String StockNum, String StartDate, String EndDate) throws IOException,ParseException {

        Calendar Scal = Calendar.getInstance();
        Calendar Ecal = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("mm/dd/yy", Locale.ENGLISH);
        Scal.setTime(format.parse(StartDate));
        Ecal.setTime(format.parse(EndDate));


        String TargetUrl;
        TargetUrl = Url.replace("StockNum",StockNum);
        TargetUrl = TargetUrl.replace("StartMonth",Integer.toString(Scal.get(Calendar.MONTH)));
        TargetUrl = TargetUrl.replace("StartDate",Integer.toString(Scal.get(Calendar.DATE)));
        TargetUrl = TargetUrl.replace("StartYear",Integer.toString(Scal.get(Calendar.YEAR)));
        TargetUrl = TargetUrl.replace("EndMonth",Integer.toString(Ecal.get(Calendar.MONTH)));
        TargetUrl = TargetUrl.replace("EndDate",Integer.toString(Ecal.get(Calendar.MONTH)));
        TargetUrl = TargetUrl.replace("EndYear",Integer.toString(Ecal.get(Calendar.MONTH)));


        URL url = new URL(TargetUrl);
        //打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream。
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        reader.close();

    }


}
