package register;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import utility.JTextFieldLimit;

public class RegiItem extends JFrame implements ActionListener{
   
   private JLabel lblName, lblCount, lblSize, lblPrice, lblWon;
   private JTextField tfName, tfCount, tfPrice;
   
   private ButtonGroup bg;
   private JRadioButton sizeXS, sizeS, sizeM, sizeL, sizeXL;
   
   private JButton btRegister, btReset;
   

   public RegiItem()
   {
      setTitle("물품 주문 관리");
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //setLocationRelativeTo(null);
      setSize(500, 400);
      
      //JLable
      lblName = new JLabel("품 명");
      lblCount = new JLabel("개 수");
      lblSize = new JLabel("사이즈");
      lblPrice = new JLabel("단 가");
      lblWon = new JLabel("원");
      //JTextField
      tfName = new JTextField();
      tfName.setDocument(new JTextFieldLimit(20));
      tfCount = new JTextField();
      tfCount.setDocument(new JTextFieldLimit(5));
      tfPrice = new JTextField();
      tfPrice.setDocument(new JTextFieldLimit(10));
      //JRadioButton
      sizeXL = new JRadioButton("XL");
      sizeL = new JRadioButton("L");
      sizeM = new JRadioButton("M");
      sizeS = new JRadioButton("S");
      sizeXS = new JRadioButton("XS");
      //ButtonGroup
      bg = new ButtonGroup();
      //JButton
      btRegister = new JButton("등록");
      btReset = new JButton("초기화");
      
      //Layout
      this.setLayout(null);
      
      this.add(lblName);
      lblName.setBounds(100, 50, 100, 20);
      this.add(lblCount);
      lblCount.setBounds(100, 80, 100, 20);
      this.add(lblSize);
      lblSize.setBounds(100,110, 100, 20);
      this.add(lblPrice);
      lblPrice.setBounds(100, 140, 100, 20);
      this.add(lblWon);
      lblWon.setBounds(280, 140, 20, 20);
      
      this.add(tfName);
      tfName.setBounds(170, 50, 100, 20);
      this.add(tfCount);
      tfCount.setBounds(170, 80, 100, 20);
      this.add(sizeXL);
      sizeXL.setBounds(170, 110, 40, 20);
      this.add(sizeL);
      sizeL.setBounds(210, 110, 40, 20);
      this.add(sizeM);
      sizeM.setBounds(250, 110, 40, 20);
      this.add(sizeS);
      sizeS.setBounds(290, 110, 40, 20);
      this.add(sizeXS);
      sizeXS.setBounds(330, 110, 50, 20);
      this.add(tfPrice);
      tfPrice.setBounds(170, 140, 100, 20);
      
      this.add(btRegister);
      btRegister.setBounds(130, 170, 100, 20);
      this.add(btReset);
      btReset.setBounds(250, 170, 100, 20);
      
      //ButtonGroup
      bg.add(sizeXL);
      bg.add(sizeL);
      bg.add(sizeM);
      bg.add(sizeS);
      bg.add(sizeXS);
      
      //ActionListener
      btReset.addActionListener(this);
      btRegister.addActionListener(this);
      
      sizeXL.addActionListener(this);
      sizeL.addActionListener(this);
      sizeM.addActionListener(this);
      sizeS.addActionListener(this);
      sizeXS.addActionListener(this);
 
      setVisible(true);
   }


   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      
      if(obj == btReset) {
         tfName.setText("");
         tfCount.setText("");
         bg.clearSelection();
         tfPrice.setText("");
      }
      else if(obj == btRegister)
      {
    	  if(tfCount.getText().equals("") || tfName.getText().equals("") ||
    			  tfPrice.getText().equals("") || bg.isSelected(null))
    	  {
    		  JOptionPane.showMessageDialog(null, "칸을 모두 작성해 개새끼야", "에러다 씹새끼야", JOptionPane.WARNING_MESSAGE);
    	  }
      }
   }
}