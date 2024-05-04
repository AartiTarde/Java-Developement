package medical;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.*;
import java.sql.DriverManager;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Toolkit;

public class SignIn implements ActionListener
{

	private JFrame frmSignIn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	static Connection con=null;
	static PreparedStatement ps=null;
	
	private JButton btnNewButton,btnNewButton_1;
	
	String name="",gmail="",username="",password="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.frmSignIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignIn = new JFrame();
		frmSignIn.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aarti\\Downloads\\logo2.png"));
		frmSignIn.getContentPane().setBackground(new Color(0, 128, 128));
		frmSignIn.setBackground(SystemColor.activeCaption);
		frmSignIn.setTitle("Sign In");
		frmSignIn.setResizable(false);
		frmSignIn.setBounds(100, 100, 800,550);
		frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignIn.getContentPane().setLayout(null);
		frmSignIn.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Name : ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(226, 41, 68, 29);
		frmSignIn.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField.setBounds(328, 41, 232, 29);
		frmSignIn.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Gmail : ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(226, 113, 68, 21);
		frmSignIn.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_1.setBounds(328, 109, 232, 29);
		frmSignIn.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("UserName :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(197, 184, 106, 21);
		frmSignIn.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_2.setBounds(328, 179, 232, 29);
		frmSignIn.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(189, 262, 98, 21);
		frmSignIn.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		textField_3.setBounds(328, 257, 232, 29);
		frmSignIn.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("Sign In");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(246, 442, 106, 35);
		frmSignIn.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(435, 442, 106, 35);
		frmSignIn.getContentPane().add(btnNewButton_1);
		
		
		String s[] ={"user","manager"};
		comboBox = new JComboBox(s);
		comboBox.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		comboBox.setBounds(328, 347, 193, 29);
		frmSignIn.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Type : ");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(216, 351, 60, 21);
		frmSignIn.getContentPane().add(lblNewLabel_4);
		
		//add button for action listeners
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);

		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicalShop","root","");
		}
		catch(Exception on)
		{
		}
	}

	public Object getFrame() {
		// TODO Auto-generated method stub
		return frmSignIn;
	}

	void getValidation()
	{
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(btnNewButton,"Name Field is Empty", "Name Field", 0);
		}
		else if(username.isEmpty())
		{
			JOptionPane.showMessageDialog(btnNewButton,"Username Field is Empty", "Username Field", 0);

		}
		else if(password.isEmpty())
		{
			JOptionPane.showMessageDialog(btnNewButton,"Password Field is Empty", "Password Field", 0);

		}
		
		
		if(gmail.isEmpty())
		{
			JOptionPane.showMessageDialog(btnNewButton,"Gmail Field is Empty", "Gmaill Field", 0);
			
		}
	
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		name=textField.getText();
		gmail=textField_1.getText();
		username=textField_2.getText();
		password=textField_3.getText();
		String type=comboBox.getSelectedItem().toString();

		try
		{
			if(e.getSource()==btnNewButton)
			{
				getValidation();
				
				ps=con.prepareStatement("INSERT INTO mlogin(musername,mpassword,mtype,name,mgmail) VALUES (?,?,?,?,?)");
				ps.setString(1,username);
				ps.setString(2,password);
				ps.setString(3,type);
				ps.setString(4,name);
				ps.setString(5,gmail);
				
				int p=ps.executeUpdate();
				
				if(p>0)
				{
					JOptionPane.showMessageDialog(btnNewButton,"Succes", "SignIn", 0);

				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton,"not Succes", "SignIn", 0);

				}

			}
			
			if(e.getSource()==btnNewButton_1)
			{
				Login m=new Login();
				m.getFrame().setVisible(true); 
			}
		}
		catch(Exception on)
		{
			
		}
	}
}
