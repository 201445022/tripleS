package file;




import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileBill extends JFrame{
	
	private JPanel pTest;
	private JLabel lblTest;
	
	public FileBill()
	{
		setTitle("물품 주문 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setSize(500, 500);
		
		setVisible(true);
	}
}
