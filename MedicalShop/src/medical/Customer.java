package medical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollBar;

public class Customer implements ActionListener
{

	private JFrame frmCustomerDetails;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_6;
	private JComboBox comboBox;
	private JButton bill,btnShow;
	private JButton btnNewButton_1;
	private JTextArea textArea;
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	private JScrollPane scrollPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
					window.frmCustomerDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Customer() {
		initialize();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicalShop","root","");
		}
		catch(Exception e)
		{
			
		}
	}

	private void initialize() {
		frmCustomerDetails = new JFrame();
		frmCustomerDetails.setResizable(false);
		frmCustomerDetails.getContentPane().setBackground(new Color(0, 0, 0));
		frmCustomerDetails.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aarti\\Downloads\\logo3.jpg"));
		frmCustomerDetails.setTitle("Customer Details");
		frmCustomerDetails.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		frmCustomerDetails.setBounds(100, 100,1300,800);
		
		frmCustomerDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerDetails.getContentPane().setLayout(null);
		frmCustomerDetails.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1266, 220);
		panel.setBackground(new Color(0, 128, 128));
		frmCustomerDetails.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Customer Name :");
		lblNewLabel.setBounds(10, 15, 135, 23);
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(155, 11, 358, 31);
		textField.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No :");
		lblMobileNo.setBounds(676, 15, 88, 23);
		lblMobileNo.setForeground(new Color(255, 250, 250));
		lblMobileNo.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblMobileNo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(805, 10, 249, 33);
		textField_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(78, 82, 39, 23);
		lblAge.setForeground(new Color(255, 250, 250));
		lblAge.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 78, 128, 31);
		textField_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(387, 80, 71, 27);
		lblGender.setForeground(new Color(255, 250, 250));
		lblGender.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblGender);
		
		String s[]= {"Male","Female","Others"};
		 comboBox = new JComboBox(s);
		 comboBox.setBounds(489, 73, 212, 32);
		comboBox.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(comboBox);
		
		JLabel lblProblem = new JLabel("Problem :");
		lblProblem.setBounds(753, 76, 71, 27);
		lblProblem.setForeground(new Color(255, 250, 250));
		lblProblem.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblProblem);
		
		textField_3 = new JTextField();
		textField_3.setBounds(856, 73, 237, 33);
		textField_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JLabel lblMedicineName = new JLabel("Medicine Id:");
		lblMedicineName.setBounds(33, 164, 94, 27);
		lblMedicineName.setForeground(new Color(255, 250, 250));
		lblMedicineName.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblMedicineName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(155, 164, 146, 27);
		textField_4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblMedicineCost = new JLabel("Medicine Cost :");
		lblMedicineCost.setBounds(718, 164, 114, 27);
		lblMedicineCost.setForeground(new Color(255, 250, 250));
		lblMedicineCost.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblMedicineCost);
		
		textField_5 = new JTextField();
		textField_5.setBounds(861, 162, 109, 31);
		textField_5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		//btnNewButton = new JButton("Add");
		btnNewButton_1 = new JButton("Add");
		
		
		
		btnNewButton_1.setBounds(1128, 10, 114, 51);
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(btnNewButton_1);
		
		
		bill = new JButton("Bill");
		bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("******************************\n Medical Bill\n*********************************");

				textArea.setText(textField_5.getText());
				
			}
		});
		bill.setBounds(1128, 146, 114, 51);
		bill.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(bill);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(387, 164, 76, 27);
		lblQuantity.setForeground(new Color(255, 250, 250));
		lblQuantity.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblQuantity);
		
		textField_6 = new JTextField();
		textField_6.setBounds(489, 164, 146, 27);
		textField_6.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_6.setColumns(10);
		panel.add(textField_6);
		
		
		
		 btnShow = new JButton("show");
		 btnShow.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try
				{
					ps=con.prepareStatement("select cname,mno,age,gender,problem,quantity,mcost,mid from customer");
					rs=ps.executeQuery();
					
					while(rs.next())
					{
						String tbdata[]= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						model.addRow(tbdata);
					}
				}
				catch(Exception n)
				{}
		 	}
		 });
		btnShow.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		btnShow.setBounds(1128, 78, 114, 51);
		panel.add(btnShow);
		
	
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 240, 966, 513);
		panel_1.setBackground(new Color(0, 128, 128));
		frmCustomerDetails.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 946, 493);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer Name", "Mobile Number", "Age", "Gender", "Problem", "Medicine Id", "Medicine Cost", "Quantity"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(93);
		table.getColumnModel().getColumn(7).setPreferredWidth(88);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(new Color(0, 0, 0));
		scrollBar.setBounds(890, 71, 23, 48);
		panel_1.add(scrollBar);
		
		textArea = new JTextArea();

		textArea.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		textArea.setBounds(986, 240, 290, 500);
		frmCustomerDetails.getContentPane().add(textArea);

		btnNewButton_1.addActionListener((ActionListener) this);
	}
	public void actionPerformed(ActionEvent er)
	{
		if(er.getSource()==btnNewButton_1)
		{
			String cname=textField.getText();
			String mno=textField_1.getText();
			String age=textField_2.getText();
			String gender=comboBox.getSelectedItem().toString();
			String problem=textField_3.getText();
			int quantity=Integer.parseInt(textField_4.getText());
			int mcost=Integer.parseInt(textField_5.getText());
			int id=Integer.parseInt(textField_6.getText());
			
			try
			{
				while(true)
				{
					ps=con.prepareStatement("INSERT INTO customer(cname,mno,age,gender,problem,quantity,mcost,mid) VALUES (?,?,?,?,?,?,?,?)");
					ps.setString(1,cname);
					ps.setString(2,mno);
					ps.setString(3,age);
					ps.setString(4,gender);
					ps.setString(5,problem);
					ps.setInt(6,quantity);
					ps.setInt(7,mcost);
					ps.setInt(8,id);
					
					
					int r=ps.executeUpdate();
					
					if(r>0)
					{
						//JOptionPane.showMessageDialog(btnNewButton_1,"succes", "Select Option",0);
						JOptionPane.showConfirmDialog(null,
					             "choose one", "choose one", JOptionPane.YES_NO_OPTION);
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton_1,"not succes", "Select Option", 0);	
					}
					String query = "UPDATE medicine SET mstock = mstock - ? WHERE mid = ?";
					 ps = con.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(textField_6.getText())); // Assuming textField_6 holds the quantity used/sold
					ps.setInt(2, Integer.parseInt(textField_4.getText())); // Assuming textField_4 holds the quantity from which to subtract
					ps.executeUpdate();


					
					
					//****************************
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
				
					
				}
								}
			catch(Exception n)
			{}
		}
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frmCustomerDetails;
	}
}



