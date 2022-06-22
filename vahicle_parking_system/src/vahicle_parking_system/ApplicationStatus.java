package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;

public class ApplicationStatus extends JFrame {
	
	
	Connection con;
    ResultSet rs;


	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationStatus frame = new ApplicationStatus();
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
	public ApplicationStatus() {
		
		con=SqlConnection.ConnectDatabase();
		
		String vechileNo="";
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 504);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "STATUS VIEW", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), "STATUS VIEW", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 50, 868, 92);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			Statement s=con.createStatement();
			vechileNo=Store.vechileNo;
            String query="select * from register_vechile where vechile_number='"+vechileNo+"' ;";
            ResultSet rs=s.executeQuery(query);
		
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
            	HomeSecurity obj=new HomeSecurity();
            	obj.setTitle("Vechile Parking Management");
            	obj.setVisible(true);
            	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	obj.setResizable(true);
			}
		});
		back.setForeground(Color.BLUE);
		back.setFont(new Font("Times New Roman", Font.BOLD, 25));
		back.setBounds(48, 372, 104, 28);
		contentPane.add(back);
		
		JButton btnNewButton = new JButton("Add Parking Slot");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(80, 238, 181, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View All Records");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(312, 239, 190, 47);
		contentPane.add(btnNewButton_1);
		}
		catch (Exception e){
			
		}
		
	}
}
