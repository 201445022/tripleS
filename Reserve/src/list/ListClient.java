package list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.Bean;
import db.DB_Mgr;

public class ListClient extends JFrame implements ActionListener{
	
	private JPanel p1;
	private JLabel lblCompany, lblManager;
	private JTable table;
	private JTextField tfCompany, tfManager;
	private JButton btnSearch, btnDelete;
	private JScrollPane scroll;
	private String[] col = {"No", "상호명", "담당자", "연락처",
			"FAX", "E-MAIL"
	};
	
	private String[][] row = {{"1", "Commasf", "Manager", "telet",
			"fasfas", "sad@afns.com"}};
	
	
	public ListClient()
	{
		setTitle("물품 주문 관리");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setSize(500, 500);
		DB_Mgr mgr = new DB_Mgr();
		Bean bean;
		////////////////////////////// test 삭제해도됨
		ArrayList<Bean> list = mgr.selectAccount();
		for(int i=0; i<list.size(); i++) {
			bean = list.get(i);
			System.out.println("상호명 : "+bean.getStrCompany());
			System.out.println("담당자 : "+bean.getStrManager());
			System.out.println("연락처 : "+bean.getStrTel());
			System.out.println("팩스 : "+bean.getStrFax());
			System.out.println("이메일 : "+bean.getStrEmail());
		}
		////////////////////////////////
		
		// Panel Initialization
		p1 = new JPanel();
		
		// Label Initialization
		lblManager = new JLabel("담당자");
		lblCompany = new JLabel("상호명");
		
		// Text Field Initialization
		tfCompany = new JTextField(10);
		tfManager = new JTextField(10);
		
		// Button Initialization
		btnSearch = new JButton("검색");
		btnDelete = new JButton("삭제");
		
		// Table and Scroll Initialization
		table = new JTable(row, col);
		scroll = new JScrollPane(table);
		
		// Adding components to panel
		p1.add(lblCompany);
		p1.add(tfCompany);
		p1.add(lblManager);
		p1.add(tfManager);
		p1.add(btnSearch);
		p1.add(btnDelete);
		p1.add(scroll);
		
		// Adding panel to Frame
		add(p1);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
