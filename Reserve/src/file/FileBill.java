package file;




import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FileBill extends JFrame implements ActionListener{
	
	private JPanel p1;
	private JLabel lblDivision, lblContent;
	private JComboBox<String> cbDivision, cbContent;
	private JButton btnSearch, btnReset;
	private String[] cbStr1 = {"거래서", "품목", "발주 리스트"};
	private String[] cbStr2 = {"추가", "수정", "삭제"};
	private String[][] data = {{"1", "정지현", "010-6679-3306"}};
	private String[] title = {"번호", "이름","휴대폰"};
	private JTable table;
	private JScrollPane scroll;
	
	
	public FileBill()
	{
		setTitle("물품 주문 관리");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 500);
		
		// Initialization panels
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
		
		// Initialization a table and scroll pane
		table = new JTable(data, title);
		scroll = new JScrollPane(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		
		// Initialization labels
		lblDivision = new JLabel("구분");
		lblContent = new JLabel("내용");
		
		// Initialization Combo boxes
		cbDivision = new JComboBox<String>();
		cbContent = new JComboBox<String>();
		
		// Initialization Buttons
		btnSearch = new JButton("검색");
		btnReset = new JButton("초기화");
		btnSearch.addActionListener(this);
		btnReset.addActionListener(this);
		
		// initialization combo boxes
		
		for(int i = 0 ; i < cbStr1.length ; i++)
		{
			cbDivision.addItem(cbStr1[i]);
		}
		
		for(int i = 0 ; i < cbStr2.length ; i++)
		{
			cbContent.addItem(cbStr2[i]);
		}
		
		// To initialize combo boxes to be empty
		cbDivision.setSelectedIndex(-1);
		cbContent.setSelectedIndex(-1);
		
		// Adding components to p1
		p1.add(lblDivision);
		p1.add(cbDivision);
		p1.add(lblContent);
		p1.add(cbContent);
		p1.add(btnSearch);
		p1.add(btnReset);
		p1.add(scroll);
		
		// JPanel 1
		add(p1);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btnReset)
		{
			cbContent.setSelectedItem(null);
			cbDivision.setSelectedItem(null);
		}
		else if(obj == btnSearch)
		{
			if(cbContent.getSelectedIndex() == -1 && cbDivision.getSelectedIndex() == -1)
			{
				JOptionPane.showMessageDialog(null, "검색 조건을 입력하세요 미친놈아.", "Error이다 새끼야", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
