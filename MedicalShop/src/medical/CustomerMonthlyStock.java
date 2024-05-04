package medical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class CustomerMonthlyStock {

	private JFrame frame;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4;
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMonthlyStock window = new CustomerMonthlyStock();
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
	public CustomerMonthlyStock() {
		initialize();
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicalShop","root","");
		}
		catch(Exception on) {
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 566, 54);
		panel.setBackground(new Color(0, 128, 128));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		 lblNewLabel = new JLabel("MONTHLY SALES REPORT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(141, 10, 276, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 86, 566, 233);
		panel_1.setBackground(new Color(0, 128, 128));
		frame.getContentPane().add(panel_1);
		 panel_1.setLayout(null);
		
		 lblNewLabel_1 = new JLabel("Total Sales(Price) :");
		 lblNewLabel_1.setBounds(100, 20, 163, 38);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("0.0");
		 lblNewLabel_2.setBounds(336, 27, 101, 25);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel_2);
		
		 lblNewLabel_3 = new JLabel("Monthly Customer :");
		 lblNewLabel_3.setBounds(88, 101, 175, 25);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel_3);
		
		 lblNewLabel_4 = new JLabel("0.0");
		 lblNewLabel_4.setBounds(335, 101, 45, 25);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Medicine Sold :");
		lblNewLabel_5.setBounds(88, 169, 145, 25);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("0.0");
		lblNewLabel_6.setBounds(324, 169, 45, 25);
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(91, 329, 399, 74);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						ps=con.prepareStatement("select sum(mcost),count(cname),sum(mid) from customer");
						rs=ps.executeQuery();
						if(rs.next())
						{
							lblNewLabel_2.setText(rs.getString(1));
							lblNewLabel_4.setText(rs.getString(2));
							lblNewLabel_6.setText(rs.getString(3));
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(26, 23, 141, 41);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int e1=JOptionPane.showConfirmDialog(frame,"sure u want exit");
				if(e1==JOptionPane.YES_OPTION)
				{
					frame.dispose();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(236, 23, 119, 41);
		panel_2.add(btnNewButton_1);
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
