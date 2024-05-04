package medical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowDesk {

	private JFrame frmMedicalshopdesktop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowDesk window = new MainWindowDesk();
					window.frmMedicalshopdesktop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindowDesk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedicalshopdesktop = new JFrame();
		frmMedicalshopdesktop.setBackground(SystemColor.controlDkShadow);
		frmMedicalshopdesktop.setTitle("MedicalShopDesktop");
		frmMedicalshopdesktop.setResizable(false);
		frmMedicalshopdesktop.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frmMedicalshopdesktop.setBounds(100, 100, 1500, 750);
		frmMedicalshopdesktop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedicalshopdesktop.getContentPane().setLayout(null);
		frmMedicalshopdesktop.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 240));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(153, 180, 209), new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(310, 10, 1166, 50);
		frmMedicalshopdesktop.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M  E  D  I  C  A  L      S  H  O  P");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(361, 10, 380, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(10, 10, 290, 625);
		frmMedicalshopdesktop.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.setBounds(43, 60, 203, 51);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer m=new Customer();
				m.getFrame().setVisible(true); 
			}
			
		});
		panel_1.setLayout(null);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Medicine Stock");
		btnNewButton_1.setBounds(43, 230, 203, 51);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicineStock m=new MedicineStock();
				m.getFrame().setVisible(true); 
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Monthly Stock");
		btnNewButton_1_1.setBounds(43, 398, 203, 51);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockDetails m=new StockDetails();
				m.getFrame().setVisible(true); 
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("LogOut");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int e1=JOptionPane.showConfirmDialog(frmMedicalshopdesktop,"Are You sure want to exit MainWindow??");
				if(e1==JOptionPane.YES_OPTION)
				{
					frmMedicalshopdesktop.dispose();
				}
			}
		});
		btnNewButton_2.setToolTipText("logout");
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(79, 548, 98, 33);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(SystemColor.desktop));
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(10, 645, 1466, 58);
		frmMedicalshopdesktop.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CopyRight@MedicalShop");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setBounds(1286, 10, 170, 20);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("9545388004");
		lblNewLabel_1_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(1350, 28, 80, 20);
		panel_2.add(lblNewLabel_1_1);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frmMedicalshopdesktop;
	}
}
