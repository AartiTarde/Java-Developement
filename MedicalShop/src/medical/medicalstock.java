package medical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class medicalstock {

	private JFrame frmMedicalStockReport;
	private JTable table;
	private JLabel lblNewLabel_2,lblNewLabel_3;
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
					medicalstock window = new medicalstock();
					window.frmMedicalStockReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public medicalstock() {
		initialize();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicalShop","root","");
		}
		catch(Exception on)
		{
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedicalStockReport = new JFrame();
		frmMedicalStockReport.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		frmMedicalStockReport.setTitle("MEDICAL STOCK REPORT ");
		frmMedicalStockReport.setResizable(false);
		frmMedicalStockReport.setBackground(new Color(0, 0, 0));
		frmMedicalStockReport.setBounds(100, 100, 750, 500);
		frmMedicalStockReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedicalStockReport.getContentPane().setLayout(null);
		frmMedicalStockReport.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(90, 399, 537, 54);
		panel.setBackground(new Color(0, 128, 128));
		frmMedicalStockReport.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Show Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					ps=con.prepareStatement("select mname,mstock,(mstock*mcost) as price from medicine");
					rs=ps.executeQuery();
					
					while(rs.next())
					{
						
						String tbdata[]= {rs.getString(1),rs.getString(2),rs.getString(3)};
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						model.addRow(tbdata);
					}
					
					ps=con.prepareStatement("select sum(mstock),sum((mstock*mcost)) as price from medicine");
					ResultSet r=ps.executeQuery();
					while(r.next())
					{
						lblNewLabel_2.setText(r.getString(1));
						lblNewLabel_3.setText(r.getString(2));
					}
					
				}
				catch(Exception n)
				{}
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 19));
		btnNewButton.setBounds(64, 10, 142, 34);
		panel.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int e1=JOptionPane.showConfirmDialog(frmMedicalStockReport,"sure u want exit");
				if(e1==JOptionPane.YES_OPTION)
				{
					frmMedicalStockReport.dispose();
				}
			
			}
		});
		btnExit.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 19));
		btnExit.setBounds(329, 10, 142, 34);
		panel.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 716, 255);
		frmMedicalStockReport.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine Name", "Stock", "Price"
			}
		));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel_1.setBounds(10, 275, 716, 114);
		frmMedicalStockReport.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Stock Available :");
		lblNewLabel.setBounds(10, 45, 192, 25);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("In Price :");
		lblNewLabel_1.setBounds(473, 41, 94, 32);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("0.0");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(228, 45, 82, 32);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("0.0");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(565, 45, 141, 25);
		panel_1.add(lblNewLabel_3);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setResizable(false);
	}

	protected static void dispose() {
		// TODO Auto-generated method stub
		
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frmMedicalStockReport;
	}
}
