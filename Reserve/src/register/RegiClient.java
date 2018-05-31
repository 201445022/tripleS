package register;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegiClient extends JFrame {
	private JLabel lblCompany, lblManager, lblTel, lblFax, lblEmail;
	private JTextField tfCompany, tfManager;
	private JTextField tfTel_1, tfTel_2, tfTel_3;
	private JTextField tfFax_1, tfFax_2, tfFax_3;
	private JTextField tfEmail_1, tfEmail_2;
	private JButton btnCheck_1, btnCheck_2, btnRegister, btnReset;
	private JPanel p1;

	public RegiClient() {
		setTitle("거래처 등록");
		setSize(400, 400);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLocationRelativeTo(null);

		// JLabel
		lblCompany = new JLabel("상호명");
		lblManager = new JLabel("담당자");
		lblTel = new JLabel("연락처");
		lblFax = new JLabel("FAX");
		lblEmail = new JLabel("E-MAIL");

		// JTextField
		tfCompany = new JTextField(10);
		tfCompany.setDocument((new JTextFieldLimit(10)));
		tfManager = new JTextField();
		tfTel_1 = new JTextField();
		tfTel_2 = new JTextField();
		tfTel_3 = new JTextField();
		tfFax_1 = new JTextField();
		tfFax_2 = new JTextField();
		tfFax_3 = new JTextField();
		tfEmail_1 = new JTextField();
		tfEmail_2 = new JTextField();

		// JButton
		btnCheck_1 = new JButton("중복확인");
		btnCheck_2 = new JButton("중복확인");
		btnRegister = new JButton("등록");
		btnReset = new JButton("초기화");

		// JPanel
		p1 = new JPanel();
		add(p1);
		p1.add(lblCompany);
		p1.add(tfCompany);
		p1.add(btnCheck_1);

		// Visible
		setVisible(true);
	}
}
