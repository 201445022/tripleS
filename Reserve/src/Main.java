import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import file.FileBill;
import register.RegiClient;
import register.RegiItem;
import register.RegiOrder;

public class Main extends JFrame implements ActionListener {

   private JMenuBar mb;
   private JMenu fileMenu, listMenu, registerMenu, inquiryMenu;
   private JMenuItem f_bill, f_exit; // FileMenu
   private JMenuItem l_client, l_item, l_order; // ListMenu
   private JMenuItem r_client, r_item, r_orderList; // RegisterMenu
   private JMenuItem i_faq, i_obo;

   public Main() {
      // JFrame
      setTitle("물품 주문 관리");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // setLocationRelativeTo(null);
      setSize(500, 500);
      // JMenuBar
      mb = new JMenuBar();
      setJMenuBar(mb);
      // JMenu
      fileMenu = new JMenu("파일");
      listMenu = new JMenu("리스트");
      registerMenu = new JMenu("등록");
      inquiryMenu = new JMenu("문의");
      mb.add(fileMenu);
      mb.add(listMenu);
      mb.add(registerMenu);
      mb.add(inquiryMenu);

      // File Menu
      f_exit = new JMenuItem("종료");
      f_bill = new JMenuItem("내역서");
      f_exit.addActionListener(this);
      f_bill.addActionListener(this);
      fileMenu.add(f_bill);
      fileMenu.add(f_exit);

      // List Menu
      l_client = new JMenuItem("거래처");
      l_item = new JMenuItem("품목");
      l_order = new JMenuItem("주문");
      listMenu.add(l_client);
      listMenu.add(l_item);
      listMenu.add(l_order);
      // Register Menu
      r_client = new JMenuItem("거래처");
      r_item = new JMenuItem("품목");
      r_orderList = new JMenuItem("주문내역");
      registerMenu.add(r_client);
      registerMenu.add(r_item);
      registerMenu.add(r_orderList);
      r_client.addActionListener(this);
      r_item.addActionListener(this);
      r_orderList.addActionListener(this);
      // InquiryMenu
      i_faq = new JMenuItem("FAQ");
      i_obo = new JMenuItem("1:1문의");
      inquiryMenu.add(i_faq);
      inquiryMenu.add(i_obo);
      // Visible
      setVisible(true);
   }

   public static void main(String[] args) {
      new Main();
   }
   
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      Object obj = e.getSource();

      if (obj == f_exit) {
         System.exit(0);
      } else if (obj == f_bill) {
         new FileBill();

      } else if (obj == l_client) {
         
      } else if (obj == l_item) {

      } else if (obj == l_order) {

      } else if (obj == r_client) {
         //this.dispose();
         new RegiClient();
      } else if (obj == r_item) {
         new RegiItem();

      } else if (obj == r_orderList) {
         new RegiOrder();

      } else if (obj == i_faq) {

      } else if (obj == i_obo) {

      }
   }

}