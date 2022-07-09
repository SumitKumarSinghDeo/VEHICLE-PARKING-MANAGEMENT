package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;

public class HomeAdmin extends JFrame {
	
	Connection con;
    ResultSet rs;


	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin frame = new HomeAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeAdmin() {
		
		con=SqlConnection.ConnectDatabase();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 648);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String name=Store.name;
		JLabel wel = new JLabel("Welcome  Mr. "+name);
		wel.setForeground(Color.GREEN);
		wel.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 20));
		wel.setBounds(10, 10, 346, 34);
		contentPane.add(wel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 70, 238, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton home = new JButton("HOME");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				home.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				home.setBackground(new Color(255, 140, 0));
			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
            	HomeAdmin obj=new HomeAdmin();
            	
            	obj.setVisible(true);
			}
		});
		home.setFont(new Font("Times New Roman", Font.BOLD, 20));
		home.setForeground(Color.WHITE);
		home.setBackground(new Color(255, 140, 0));
		home.setBounds(10, 23, 218, 48);
		panel.add(home);
		
		JButton application = new JButton("APPLICATION");
		application.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ApplicantList obj=new ApplicantList();
					obj.setVisible(true);
			}
		});
		application.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				application.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				application.setBackground(Color.YELLOW);
			}
		});
		application.setFont(new Font("Times New Roman", Font.BOLD, 20));
		application.setBackground(Color.YELLOW);
		application.setBounds(10, 133, 218, 48);
		panel.add(application);
		
		JButton btnNewButton_3 = new JButton("LOGOUT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
            	LoginPage obj=new LoginPage();
            	obj.setTitle("Vechile Parking Management");
            	obj.setVisible(true);
            	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	obj.setResizable(true);
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBounds(10, 483, 218, 48);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(HomeAdmin.class.getResource("/uvpm/img/icons8_search_26px.png")));
		lblNewLabel.setBounds(33, 238, 45, 38);
		panel.add(lblNewLabel);
		
		JButton search = new JButton("SEARCH");
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				search.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				search.setBackground(Color.CYAN);
			}
		});
		search.setFont(new Font("Times New Roman", Font.BOLD, 20));
		search.setForeground(Color.WHITE);
		search.setBackground(Color.CYAN);
		search.setBounds(10, 238, 218, 38);
		panel.add(search);
		
		
		
		
		
		
		
		
		
	}
}
