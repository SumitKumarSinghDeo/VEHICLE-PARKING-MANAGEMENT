package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStatus extends JFrame {
	
	
	Connection con;
    ResultSet rs;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStatus frame = new ViewStatus();
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
	public ViewStatus() {
		
		con=SqlConnection.ConnectDatabase();
		
		String name="";
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 134, 681, 73);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			Statement s=con.createStatement();
			name=Store.name;
            String query="select * from register_vechile where s_name='"+name+"' ;";
            ResultSet rs=s.executeQuery(query);
		
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
            	HomeStudent obj=new HomeStudent();
            	obj.setTitle("Vechile Parking Management");
            	obj.setVisible(true);
            	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	obj.setResizable(true);
			}
		});
		back.setForeground(Color.BLUE);
		back.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 18));
		back.setBounds(48, 372, 104, 28);
		contentPane.add(back);
		}
		catch (Exception e){
			
		}
	}
}
