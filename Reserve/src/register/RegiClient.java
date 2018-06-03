package register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import db.DB_Mgr;
import utility.JTextFieldLimit;

/*
 * 2018-06-03 조천우
 * DB연동, 중복확인 기능 넣어야 함!!!
 * */
public class RegiClient extends JFrame implements ActionListener {
	// Label
	private JLabel lblCompany, lblManager, lblTel, lblFax, lblEmail;
	private JLabel lblHyphen_1, lblHyphen_2, lblHyphen_3, lblHyphen_4, lblAt;
	// TextField
	private JTextField tfCompany, tfManager;
	private JTextField tfTel_1, tfTel_2, tfTel_3;
	private JTextField tfFax_1, tfFax_2, tfFax_3;
	private JTextField tfEmail_1, tfEmail_2;
	// Button
	private JButton btnCheck_1, btnCheck_2, btnRegister, btnReset;
	// ComboBox
	private String item[] = { "사용자입력", "naver.com", "daum.net", "hanmail.com", "hotmail.com", "gmail.com", "nate.com" };
	private JComboBox cbEmail = new JComboBox<String>(item);
	private DB_Mgr mgr; // DB
	private int flag_1, flag_2 = 0; // 중복확인

	public RegiClient() {
		setTitle("거래처 등록");
		setSize(700, 400);
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
		// JTextField , JTextFieldLimit 입력길이 제한
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
		// Label
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

		// 상호명
		this.add(tfCompany);
		tfCompany.setBounds(170, 50, 100, 20);
		this.add(btnCheck_1);
		btnCheck_1.setBounds(275, 50, 90, 20);

		// 담당자
		this.add(tfManager);
		tfManager.setBounds(170, 80, 100, 20);

		// 연락처
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

		// 팩스
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

		// 이메일
		this.add(tfEmail_1);
		tfEmail_1.setBounds(170, 170, 100, 20);
		this.add(lblAt); // '@'
		lblAt.setBounds(280, 170, 20, 20);
		this.add(tfEmail_2);
		tfEmail_2.setBounds(300, 170, 100, 20);
		this.add(cbEmail);
		cbEmail.addActionListener(this);
		cbEmail.setBounds(405, 170, 100, 20);
		this.add(btnCheck_2); // 중복확인 버튼
		btnCheck_2.setBounds(515, 170, 90, 20);
		this.add(btnRegister); // 등록 버튼
		btnRegister.setBounds(270, 220, 60, 20);
		this.add(btnReset); // 리셋 버튼
		btnReset.setBounds(335, 220, 80, 20);

		// 상호명과 이메일 내용이 바뀌면 다시 중복확인 하기 위해서 사용되는 이벤트
		tfCompany.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				flag_1 = 0;
			}

			public void insertUpdate(DocumentEvent e) {
				flag_1 = 0;
			}

			public void changedUpdate(DocumentEvent e) {
				flag_1 = 0;
			}
		});
		tfEmail_1.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				flag_2 = 0;
			}

			public void insertUpdate(DocumentEvent e) {
				flag_2 = 0;
			}

			public void changedUpdate(DocumentEvent e) {
				flag_2 = 0;
			}
		});
		tfEmail_2.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				flag_2 = 0;
			}

			public void insertUpdate(DocumentEvent e) {
				flag_2 = 0;
			}

			public void changedUpdate(DocumentEvent e) {
				flag_2 = 0;
			}
		});
		// Visible
		setVisible(true);
	}

	/*
	 * 버튼 클릭시 발생되는 이벤트
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnCheck_1) { // 상호명 중복확인
			if (tfCompany.getText().equals(""))
				JOptionPane.showMessageDialog(null, "상호명을 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				mgr = new DB_Mgr();
				int cnt = mgr.countCheck("company",tfCompany.getText()); // 상호명 중복체크
				if(cnt == 0) {
					JOptionPane.showMessageDialog(null, "가능한 상호명 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
					flag_1 = 1;	
				}
				else
					JOptionPane.showMessageDialog(null, "중복입니다.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (obj == btnCheck_2) { // 이메일 중복확인
			if (tfEmail_1.getText().equals("") || tfEmail_2.getText().equals(""))
				JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				mgr = new DB_Mgr();
				String email = tfEmail_1.getText().toString().trim() + "@" + tfEmail_2.getText().toString().trim();
				int cnt = mgr.countCheck("email", email);
				if(cnt == 0) {
					JOptionPane.showMessageDialog(null, "가능한 이메일 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
					flag_2 = 1;	
				}
				else
					JOptionPane.showMessageDialog(null, "중복입니다.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (obj == btnRegister) { // 등록
			if (tfCheck()) {
				mgr = new DB_Mgr();
				String company = tfCompany.getText().toString().trim();
				String manager = tfManager.getText().toString().trim();
				String phone = tfTel_1.getText().toString().trim() + "-" + tfTel_2.getText().toString().trim() + "-"
						+ tfTel_3.getText().toString().trim();
				String fax = tfFax_1.getText().toString().trim() + "-" + tfFax_2.getText().toString().trim() + "-"
						+ tfFax_3.getText().toString().trim();
				String email = tfEmail_1.getText().toString().trim() + "@" + tfEmail_2.getText().toString().trim();
				System.out.println(company + ", " + manager + ", " + phone + ", " + fax + ", " + email);
				mgr.insertAccount(company, manager, phone, fax, email);
			}
		} else if (obj == btnReset) {
			Clear(); // 입력 창 비워주기
		} else {
			if (cbEmail.getSelectedItem().equals("사용자입력")) {
				tfEmail_2.setText("");
				tfEmail_2.setEditable(true);
			} else {
				tfEmail_2.setText(cbEmail.getSelectedItem() + "");
				tfEmail_2.setEditable(false);
			}
		}
	}

	/*
	 * 입력이 되었는지 확인
	 */
	public boolean tfCheck() {
		if (flag_1 == 0) {
			JOptionPane.showMessageDialog(null, "상호명 중복확인 해주세요", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (tfManager.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "담당자를 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (tfTel_1.getText().equals("") || tfTel_2.getText().equals("") || tfTel_3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "연락처를 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (tfFax_1.getText().equals("") || tfFax_2.getText().equals("") || tfFax_3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "팩스를 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (flag_2 == 0) {
			JOptionPane.showMessageDialog(null, "이메일 중복확인 해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String strTel = tfTel_1.getText().toString().trim() + tfTel_2.getText().toString().trim()
					+ tfTel_3.getText().toString().trim();
			String strFax = tfFax_1.getText().toString().trim() + tfFax_2.getText().toString().trim()
					+ tfFax_3.getText().toString().trim();
			// 연락처와 팩스는 숫자로만 입력받아야 하기 때문에 확인
			for (char c : strTel.toCharArray()) {
				if (!Character.isDigit(c)) { // -true 연락처가 숫자가 아닐경우
					JOptionPane.showMessageDialog(null, "연락처는 숫자로만 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				} else { // 연락처가 숫자일 경우 팩스는 숫자인지 확인
					for (char c2 : strFax.toCharArray()) {
						if (!Character.isDigit(c2)) { // -true 팩스가 숫자가 아닐경우
							JOptionPane.showMessageDialog(null, "팩스는 숫자로만 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
							return false;
						}
					}
				}
			}
			return true;
		}
	}

	/*
	 * 입력 창 비워주기
	 */
	public void Clear() {
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
		cbEmail.setSelectedIndex(0);
	}
}
