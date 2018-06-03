package list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import db.Bean;
import db.DB_Mgr;

public class ListClient extends JFrame implements ActionListener{
	
	
	
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
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
