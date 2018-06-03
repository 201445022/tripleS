package list;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListOrder extends JFrame{

	   private JPanel panel;
	   private String column[]= {"발주일","상호","품명","수량","금액"};
	   private String data[][]= {{"2018/06/02","다은","옷","293","10000"}};
	   private JTable table;
	   private JScrollPane scroll;

	   public ListOrder()
	   {
	      setTitle("주문 내역");
	      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      //setLocationRelativeTo(null);
	      setSize(500, 500);   
	      
	      //panel
	      panel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
	      
	      //table, scrollpane
	      table = new JTable(data,column);
	      scroll = new JScrollPane(table);
	        

	      panel.add(scroll);
	      add(panel);
	      
	      
	   }
	      
}
