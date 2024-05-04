package medical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JScrollPane;
import java.awt.Toolkit;;

public class MedicineStock 
{

	private JFrame frmAddmedicinestock;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JButton btnNewButton,btnShowStock;
	
	static Connection con=null;
	static PreparedStatement ps=null;
	private JScrollPane scrollPane;
	static ResultSet rs=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                MedicineStock window = new MedicineStock();
	                window.frmAddmedicinestock.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}


	/**
	 * Create the application.
	 */
	public MedicineStock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddmedicinestock = new JFrame();
		frmAddmedicinestock.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aarti\\Downloads\\logo3.jpg"));
		frmAddmedicinestock.setResizable(false);
		frmAddmedicinestock.getContentPane().setBackground(new Color(0, 0, 0));
		frmAddmedicinestock.setTitle("AddMedicineStock");
		frmAddmedicinestock.setBounds(100, 100, 900, 650);
		frmAddmedicinestock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddmedicinestock.getContentPane().setLayout(null);
		frmAddmedicinestock.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(10, 10, 866, 187);
		frmAddmedicinestock.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Medicine Id :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(26, 14, 93, 21);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField.setBounds(129, 9, 105, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Medicine Name :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(319, 14, 129, 20);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_1.setBounds(448, 9, 207, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Medicine Stock :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(25, 113, 120, 21);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_2.setBounds(163, 108, 110, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Medicine Cost :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(319, 113, 110, 21);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_3.setBounds(457, 108, 110, 30);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		 btnNewButton = new JButton("Add Stock");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int mid=Integer.parseInt(textField.getText());
				String mname=textField_1.getText();
				int mstock=Integer.parseInt(textField_2.getText());
				int mcost=Integer.parseInt(textField_3.getText());

				try
				{
					
					while(true)
					{
						ps=con.prepareStatement("insert into medicine(mid,mname,mstock,mcost) values(?,?,?,?)");
						ps.setInt(1, mid);
						ps.setString(2,mname);
						ps.setInt(3, mstock);
						ps.setInt(4, mcost);
						
						int r=ps.executeUpdate();
						
						if(r>0)
						{
							JOptionPane.showMessageDialog(btnNewButton,"succes", "Select Option", 0);

						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton,"not succes", "Select Option", 0);

						}
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");

						ps=con.prepareStatement("select mid,mname,mstock,mcost from medicine");
						rs=ps.executeQuery();
						
						while(rs.next())
						{
							String tbdata[]= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
							DefaultTableModel model=(DefaultTableModel) table.getModel();
							model.addRow(tbdata);
						}
						
					}
					
												
				}
				catch(Exception on) {}
			}
		 });
		 btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setToolTipText("Add Stock");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(728, 10, 110, 40);
		panel.add(btnNewButton);
		
		 btnShowStock = new JButton("Show ");
		 btnShowStock.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 			ps=con.prepareStatement("select mid,mname,mstock,mcost from medicine");
					rs=ps.executeQuery();
					
					while(rs.next())
					{
						String tbdata[]= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						model.addRow(tbdata);
					}
					
					
		 		}
		 		catch(Exception on)
		 		{}
		 		
		 		
		 	}
		 });
		 btnShowStock.setForeground(new Color(0, 0, 0));
		btnShowStock.setToolTipText("Show Medicine Stock");
		btnShowStock.setBackground(new Color(255, 255, 255));
		btnShowStock.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		btnShowStock.setBounds(733, 102, 105, 40);
		panel.add(btnShowStock);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(10, 208, 866, 395);
		frmAddmedicinestock.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 846, 375);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Id", "Medicine Name", "Total Stock", "Cost"
			}
		));
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicalShop","root","");
		}
		catch(Exception e)
		{}
	}


	public Window getFrame() {
		// TODO Auto-generated method stub
		return frmAddmedicinestock;
	}
}
