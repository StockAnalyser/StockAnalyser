package com.stockanalyser.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Window.Type;
import java.util.Date;

import javax.swing.border.BevelBorder;

import com.stockanalyser.model.Stock;
import com.stockanalyser.model.TrendGraphPanel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBeginY;
	private JTextField textFieldBeginM;
	private JTextField textFieldBeginD;
	private JTextField textFieldEndY;
	private JTextField textFieldEndM;
	private JTextField textFieldEndD;
	JToolBar toolBar = new JToolBar();
	JMenuItem mntmHideToolbar = new JMenuItem("Hide Toolbar");
	boolean toolbarOn=true;
	JComboBox comboBoxPriceWay = new JComboBox();
	private JTextField textField_1;
	JButton btnDraw = new JButton("  Draw");
	TrendGraphPanel panel = new TrendGraphPanel();
	
	int width=400;
	int height=400;
	int extw=0;
	int exth=0;
	
	Dimension actualSize=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Stock Analyser");
		init();
		addFrameListeners();
		initPriceType();
	}
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 689);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setPreferredSize(new Dimension(40, 40));
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setPreferredSize(new Dimension(85, 31));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setPreferredSize(new Dimension(79, 40));
		mnFile.add(mntmExit);
		
		JMenu mnWindow = new JMenu("Window");
		mnWindow.setPreferredSize(new Dimension(80, 40));
		menuBar.add(mnWindow);
		mntmHideToolbar.setPreferredSize(new Dimension(170, 40));
		
		mnWindow.add(mntmHideToolbar);
		
		JMenu mnChartType = new JMenu("Graph Type");
		mnChartType.setPreferredSize(new Dimension(147, 40));
		mnWindow.add(mnChartType);
		
		JMenuItem mntmLineChart = new JMenuItem("Line Graph");
		mntmLineChart.setPreferredSize(new Dimension(137, 40));
		mnChartType.add(mntmLineChart);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setPreferredSize(new Dimension(50, 40));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About StockAnalyser");
		mntmAbout.setPreferredSize(new Dimension(219, 40));
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		toolBar.setPreferredSize(new Dimension(13, 30));
		contentPane.add(toolBar,BorderLayout.NORTH);
		
		JLabel lblStockId = new JLabel("Stock ID:");
		toolBar.add(lblStockId);
		
		textField_1 = new JTextField();
		toolBar.add(textField_1);
		textField_1.setColumns(9);
		
		//toolBar.setLayout(new GridBagLayout());
		
		JLabel lblNewLabel_1 = new JLabel("Y:");
		lblNewLabel_1.setPreferredSize(new Dimension(16, 30));
		toolBar.add(lblNewLabel_1);
		
		textFieldBeginY = new JTextField();
		textFieldBeginY.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar.add(textFieldBeginY);
		textFieldBeginY.setColumns(4);
		
		JLabel lblM = new JLabel("M:");
		lblM.setPreferredSize(new Dimension(18, 30));
		toolBar.add(lblM);
		
		textFieldBeginM = new JTextField();
		toolBar.add(textFieldBeginM);
		textFieldBeginM.setColumns(2);
		
		JLabel lblD = new JLabel("D:");
		toolBar.add(lblD);
		
		textFieldBeginD = new JTextField();
		toolBar.add(textFieldBeginD);
		textFieldBeginD.setColumns(2);
		
		JLabel lblTo = new JLabel("To Y:");
		toolBar.add(lblTo);
		
		textFieldEndY = new JTextField();
		toolBar.add(textFieldEndY);
		textFieldEndY.setColumns(4);
		
		JLabel lblNewLabel = new JLabel("M:");
		toolBar.add(lblNewLabel);
		
		textFieldEndM = new JTextField();
		toolBar.add(textFieldEndM);
		textFieldEndM.setColumns(2);
		
		JLabel lblD_1 = new JLabel("D:");
		toolBar.add(lblD_1);
		
		textFieldEndD = new JTextField();
		toolBar.add(textFieldEndD);
		textFieldEndD.setColumns(2);
		
		JLabel lblNewLabel_2 = new JLabel("  Price way");
		toolBar.add(lblNewLabel_2);
		
		toolBar.add(comboBoxPriceWay);
		
		btnDraw.setBorder(new CompoundBorder());
		toolBar.add(btnDraw);
		
		JTextField textField = new JTextField();
		textField.setBorder(null);
		textField.setEditable(false);
		toolBar.add(textField);
		textField.setColumns(60);
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		statusPanel.setPreferredSize(new Dimension(10, 30));
		contentPane.add(statusPanel, BorderLayout.SOUTH);
	}
	private void addFrameListeners(){
		mntmHideToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toolbarOn==true){
					toolBar.hide();
					toolbarOn=false;
					mntmHideToolbar.setText("Show Toolbar");
				}else{
					mntmHideToolbar.setText("Hide Toolbar");
					toolBar.show();
					toolbarOn=true;
				}
			}
		});
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaintCenterPanel();
			}
		});
	}
	private void initPriceType(){
		comboBoxPriceWay.addItem("Open price");
		comboBoxPriceWay.addItem("Close price");
		comboBoxPriceWay.addItem("Average price");
	}
	
	private Stock createStock(){
		Stock stock=new Stock("600000.SS", "2006", "01", "01", "2007", "01", "01");
		stock.addDayData(new Date(2006,01,01), 13.4, 18.9, 11.1, 12.9, 2, 2.3);
		stock.addDayData(new Date(2006,01,02), 14.5, 18.9, 11.1, 11.9, 2, 2.3);
		return stock;
	}
	
	private void repaintCenterPanel(){
		Stock stock=createStock();
		panel.repaint(stock);
		actualSize=this.getContentPane().getSize();
		panel.setBounds(extw, exth, actualSize.width, actualSize.height);
	}
	void initExt(){
		int reqWidth = 600;
		int reqHeight = 500;

		// first set the size
		this.setSize(reqWidth, reqHeight);

		// This is not the actual-sized frame. get the actual size
		actualSize = this.getContentPane().getSize();

		int extraW = reqWidth - actualSize.width;
		extw=extraW;
		int extraH = reqHeight - actualSize.height;
		exth=extraH;

		// Now set the size.
		this.setSize(reqWidth + extraW, reqHeight + extraH);
	}
}
