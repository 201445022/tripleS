package register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import db.JDBC_Ex;
import utility.JTextFieldLimit;

public class RegiClient extends JFrame implements ActionListener {
	private JLabel lblCompany, lblManager, lblTel, lblFax, lblEmail;
	private JLabel lblHyphen_1, lblHyphen_2, lblHyphen_3, lblHyphen_4, lblAt;
	private JTextField tfCompany, tfManager;
	private JTextField tfTel_1, tfTel_2, tfTel_3;
	private JTextField tfFax_1, tfFax_2, tfFax_3;
	private JTextField tfEmail_1, tfEmail_2;
	private JButton btnCheck_1, btnCheck_2, btnRegister, btnReset;
	private String item[] = { "사용자입력", "naver.com", "daum.net", "hanmail.com", "hotmail.com", "gmail.com", "nate.com" };
	private JComboBox cbEmail = new JComboBox<String>(item);
	private JDBC_Ex db;
	public RegiClient() {
		setTitle("거래처 등록");
		setSize(700, 400);
		// DataBase
		db = new JDBC_Ex();

		// JLabel
		lblCompany = new JLabel("상호명");
		lblManager = new JLabel("담당자");
		lblTel = new JLabel("연락처");
		lblFax = new JLabel("FAX");
		lblEmail = new JLabel("E-MAIL");
		lblHyphen_1 = new JLabel("-");
		lblHyphen_2 = new JLabel("-");
		lblHyphen_3 = new JLabel("-");
		lblHyphen_4 = new JLabel("-");
		lblAt = new JLabel("@");
		// JTextField
		tfCompany = new JTextField();
		tfCompany.setDocument((new JTextFieldLimit(10)));
		tfManager = new JTextField();
		tfManager.setDocument((new JTextFieldLimit(10)));
		tfTel_1 = new JTextField();
		tfTel_1.setDocument((new JTextFieldLimit(3)));
		tfTel_2 = new JTextField();
		tfTel_2.setDocument((new JTextFieldLimit(4)));
		tfTel_3 = new JTextField();
		tfTel_3.setDocument((new JTextFieldLimit(4)));
		tfFax_1 = new JTextField();
		tfFax_1.setDocument((new JTextFieldLimit(3)));
		tfFax_2 = new JTextField();
		tfFax_2.setDocument((new JTextFieldLimit(4)));
		tfFax_3 = new JTextField();
		tfFax_3.setDocument((new JTextFieldLimit(4)));
		tfEmail_1 = new JTextField();
		tfEmail_1.setDocument((new JTextFieldLimit(15)));
		tfEmail_2 = new JTextField();
		tfEmail_2.setDocument((new JTextFieldLimit(15)));
		// JButton
		btnCheck_1 = new JButton("중복확인");
		btnCheck_1.addActionListener(this);
		btnCheck_2 = new JButton("중복확인");
		btnCheck_2.addActionListener(this);
		btnRegister = new JButton("등록");
		btnRegister.addActionListener(this);
		btnReset = new JButton("초기화");
		btnReset.addActionListener(this);

		// Layout
		this.setLayout(null);
		this.add(lblCompany);
		lblCompany.setBounds(100, 50, 100, 20);
		this.add(lblManager);
		lblManager.setBounds(100, 80, 100, 20);
		this.add(lblTel);
		lblTel.setBounds(100, 110, 100, 20);
		this.add(lblFax);
		lblFax.setBounds(100, 140, 100, 20);
		this.add(lblEmail);
		lblEmail.setBounds(100, 170, 100, 20);

		this.add(tfCompany);
		tfCompany.setBounds(170, 50, 100, 20);
		this.add(btnCheck_1);
		btnCheck_1.setBounds(275, 50, 90, 20);

		this.add(tfManager);
		tfManager.setBounds(170, 80, 100, 20);

		this.add(tfTel_1);
		tfTel_1.setBounds(170, 110, 70, 20);
		this.add(lblHyphen_1);
		lblHyphen_1.setBounds(250, 110, 10, 20);
		this.add(tfTel_2);
		tfTel_2.setBounds(265, 110, 70, 20);
		this.add(lblHyphen_2);
		lblHyphen_2.setBounds(345, 110, 10, 20);
		this.add(tfTel_3);
		tfTel_3.setBounds(360, 110, 70, 20);

		this.add(tfFax_1);
		tfFax_1.setBounds(170, 140, 70, 20);
		this.add(lblHyphen_3);
		lblAt.setBounds(250, 140, 10, 20);
		this.add(tfFax_2);
		tfFax_2.setBounds(265, 140, 70, 20);
		this.add(lblHyphen_4);
		lblHyphen_4.setBounds(345, 140, 10, 20);
		this.add(tfFax_3);
		tfFax_3.setBounds(360, 140, 70, 20);

		this.add(tfEmail_1);
		tfEmail_1.setBounds(170, 170, 100, 20);
		this.add(lblAt);
		lblAt.setBounds(280, 170, 20, 20);
		this.add(tfEmail_2);
		tfEmail_2.setBounds(300, 170, 100, 20);
		this.add(cbEmail);
		cbEmail.setBounds(405, 170, 100, 20);
		this.add(btnCheck_2);
		btnCheck_2.setBounds(515, 170, 90, 20);
		this.add(btnRegister);
		btnRegister.setBounds(270, 220, 60, 20);
		this.add(btnReset);
		btnReset.setBounds(335, 220, 80, 20);

		// Visible
		setVisible(true);
	}
	/*
	 * 버튼 클릭시 발생되는 이벤트
	 * */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnCheck_1) {

		} else if (obj == btnCheck_2) {

		} else if (obj == btnRegister) {

		} else if (obj == btnReset) {
			tfClear(); // 입력 창 비워주기
		}
	}
	/*
	 * 입력 창 비워주기
	 * */
	public void tfClear() {
		tfCompany.setText("");
		tfManager.setText("");
		tfTel_1.setText("");
		tfTel_2.setText("");
		tfTel_3.setText("");
		tfFax_1.setText("");
		tfFax_2.setText("");
		tfFax_3.setText("");
		tfEmail_1.setText("");
		tfEmail_2.setText("");
	}
}
