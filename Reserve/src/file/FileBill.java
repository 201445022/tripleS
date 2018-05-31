package file;




import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileBill extends JFrame implements ActionListener{
	
	private JPanel p1;
	private JLabel lblDivision, lblContent;
	private JComboBox<String> cbDivision, cbContent;
	private JButton btnSearch, btnReset;
	private String[] cbStr = {"거래서", "품목", "발주 리스트"};
	
	public FileBill()
	{
		setTitle("물품 주문 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setSize(500, 500);
		
		// Initialization panels, labels and buttons
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
		lblDivision = new JLabel("구분");
		lblContent = new JLabel("내용");
		cbDivision = new JComboBox();
		cbContent = new JComboBox();
		btnSearch = new JButton("검색");
		btnReset = new JButton("초기화");
		
		// initialization combo box
		
		for(int i = 0 ; i < cbStr.length ; i++)
		{
			cbDivision.addItem(cbStr[i]);
		}
		
		
		// Adding components to p1
		p1.add(lblDivision);
		p1.add(cbDivision);
		p1.add(lblContent);
		p1.add(cbContent);
		p1.add(btnSearch);
		p1.add(btnReset);
		
		// JPanel 1
		add(p1);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
