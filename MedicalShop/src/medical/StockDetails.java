package medical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockDetails {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockDetails window = new StockDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StockDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 750, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(48, 86, 634, 132);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Click Here..");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicalstock m=new medicalstock();
				m.getFrame().setVisible(true); 
			}
		});
		btnNewButton.setBounds(452, 43, 157, 42);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel.add(btnNewButton);
		
		JLabel lblMonthlyMedicineStock = new JLabel("Monthly Medicine Stock");
		lblMonthlyMedicineStock.setForeground(Color.WHITE);
		lblMonthlyMedicineStock.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		lblMonthlyMedicineStock.setBounds(83, 43, 268, 42);
		panel.add(lblMonthlyMedicineStock);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(48, 257, 634, 119);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnTotalRevenue = new JButton("Click Here..");
		btnTotalRevenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerMonthlyStock m=new CustomerMonthlyStock();
				m.getFrame().setVisible(true); 
			}
		});
		btnTotalRevenue.setBounds(453, 35, 157, 42);
		btnTotalRevenue.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btnTotalRevenue);
		
		JLabel lblTotalMonthlyRevenue = new JLabel("Total Monthly Revenue");
		lblTotalMonthlyRevenue.setForeground(Color.WHITE);
		lblTotalMonthlyRevenue.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		lblTotalMonthlyRevenue.setBounds(72, 34, 268, 42);
		panel_1.add(lblTotalMonthlyRevenue);
		
		JLabel lblNewLabel = new JLabel("Monthly Stock");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(293, 22, 157, 31);
		frame.getContentPane().add(lblNewLabel);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
