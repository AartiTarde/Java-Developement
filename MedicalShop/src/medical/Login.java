package medical;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;

import login.Mainwindows;

import java.awt.Color;
import java.sql.*;
import java.awt.Toolkit;
public class Login implements ActionListener
{

	private JFrame frmLogin;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton,btnNewButton_1;
	private JRadioButton rdbtnNewRadioButton,rdbtnUser;
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setAlwaysOnTop(true);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aarti\\Downloads\\logo2.png"));
		frmLogin.getContentPane().setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		frmLogin.getContentPane().setBackground(new Color(0, 128, 128));
		frmLogin.setTitle("Medical Login");
		frmLogin.setLocationRelativeTo(null);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setLocationRelativeTo(null);
		//frmMedicalshopdesktop.setLocationRelativeTo(null);

		frmLogin.setBounds(100, 100, 500, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(92, 37, 94, 31);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(98, 106, 88, 31);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("Manager");
		rdbtnNewRadioButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		rdbtnNewRadioButton.setBounds(286, 175, 103, 21);
		frmLogin.getContentPane().add(rdbtnNewRadioButton);
		
		 rdbtnUser = new JRadioButton("User");
		rdbtnUser.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		rdbtnUser.setBounds(120, 175, 66, 21);
		frmLogin.getContentPane().add(rdbtnUser);
		
		 btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(115, 216, 85, 37);
		frmLogin.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Sign In");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_1.setBounds(276, 216, 85, 34);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setToolTipText("Enter User Name\r\n");
		textField.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		textField.setBounds(250, 39, 153, 26);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter Password");
		textField_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		textField_1.setBounds(250, 108, 153, 26);
		frmLogin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton.addActionListener(this);	
		btnNewButton_1.addActionListener(this);
		
		rdbtnUser.addActionListener(this); //user
		rdbtnNewRadioButton.addActionListener(this); //manager
		
		
		//load class and connection path
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicalShop","root","");
		}
		catch(Exception on)
		{
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username=textField.getText();
		String password=textField_1.getText();
		String type="";
		
		try
		{
			//validation start 
			if(e.getSource()==btnNewButton)
			{
				if(username.equals(""))
				{
					JOptionPane.showMessageDialog(btnNewButton,"username Field Is Empty", "username Field", 0);
				}
				else if(password.equals(""))
				{
					JOptionPane.showMessageDialog(btnNewButton,"Password Field Is Empty", "Password Field", 0);

				}
				
				if(rdbtnNewRadioButton.isSelected()==false && rdbtnUser.isSelected()==false)
				{
					JOptionPane.showMessageDialog(btnNewButton,"Please,Selected Radio Button", "Select Option", 0);

				}
				
				if(rdbtnNewRadioButton.isSelected())
				{
					type="manager";
				}
				else if(rdbtnUser.isSelected())
				{
					type="user";
				}
				//validation end
				
				//connection and queries state using prepared statement
				
				ps=con.prepareStatement("select musername,mpassword,mtype from mlogin where musername=? and mpassword=? and mtype=?");
				ps.setString(1,username);
				ps.setString(2,password);
				ps.setString(3,type);
				rs=ps.executeQuery();
				
				if(rs.next())
				{
					JOptionPane.showMessageDialog(btnNewButton,"Login Succesfully");	
					frmLogin.dispose();
					MainWindowDesk m=new MainWindowDesk();
					m.getFrame().setVisible(true); 
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton,"not", "Select Option", 0);
				}
			}
			//sign in button 
			if(e.getSource()==btnNewButton_1)
			{
				SignIn m=new SignIn();
				((Window) m.getFrame()).setVisible(true); 
				
			}
		}
		catch(Exception on)
		{
		}
	}


	public Window getFrame() {
		// TODO Auto-generated method stub
		return frmLogin;
	}


	
}
