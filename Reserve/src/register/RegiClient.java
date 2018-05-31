package register;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegiClient extends JFrame{
	private JLabel lblCompany, lblManager, lblTel, lblFax, lblEmail;
	private JTextField tfCompany, tfManager;
	private JTextField tfTel_1, tfTel_2, tfTel_3;
	private JTextField tfFax_1, tfFax_2, tfFax_3;
	private JTextField tfEmail_1, tfEmail_2; 
	public RegiClient()
	{
		setTitle("거래처 등록");
		setSize(500, 500);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		
		// Visible
		setVisible(true);
	}
}
