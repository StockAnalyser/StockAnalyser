package com.stockanalyser.model;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class TrendGraphPanel extends JPanel{

	int graphType=0;
	public static final int TYPE_GRAPH_LINE=0;
	
	String chartTitle = "Objects Movement Chart";
    String xAxisLabel = "X";
    String yAxisLabel = "Y";
	
	public TrendGraphPanel(){
		//this.setSize(400, 400);
	}
	
	public void repaint(Stock stock){
		this.removeAll();
		if(graphType==TYPE_GRAPH_LINE){
			XYDataset dataset = createDataset(stock);
			
			JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, 
		            xAxisLabel, yAxisLabel, dataset);
			this.add(new ChartPanel(chart),BorderLayout.CENTER);
		}
	}

	private XYDataset createDataset(Stock stock) {
        // creates an XY dataset...
        // returns the dataset
		if(graphType==TYPE_GRAPH_LINE){
			TimeSeriesCollection dataset = new TimeSeriesCollection();
			TimeSeries  series1 = new TimeSeries("Object 1");
	
		    for(int i=0;i<stock.stockPeriodData.size();i++){
		    	
		    	series1.add(new Day(stock.stockPeriodData.get(i).date),stock.stockPeriodData.get(i).open);
		    	System.out.println(new Day(stock.stockPeriodData.get(i).date));
		    	System.out.println(stock.stockPeriodData.get(i).open);
		    }
		 
		  
		 
		    dataset.addSeries(series1);
	
		 
		    return dataset;
		}else{
			return null;
		}

    }

}
