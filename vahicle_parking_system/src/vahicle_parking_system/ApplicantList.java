package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ApplicantList extends JFrame {

	Connection con;
    ResultSet rs;
	
	private JPanel contentPane;
	private JTable table;
	private JLabel vId;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantList frame = new ApplicantList();
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
	public ApplicantList() {
		
		con=SqlConnection.ConnectDatabase();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 574);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		vId = new JLabel("Enter Vechile ID :");
		vId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		vId.setForeground(new Color(0, 0, 128));
		vId.setBounds(55, 403, 125, 38);
		contentPane.add(vId);
		
		id = new JTextField();
		id.setBounds(174, 411, 196, 27);
		contentPane.add(id);
		id.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 134, 681, 73);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(10, 79, 723, 310);
		contentPane.add(table);
		scrollPane.setViewportView(table);
		
		try {
		Statement s=con.createStatement();
        String query="select * from register_vechile where approval='Waiting' ;";
        ResultSet rs=s.executeQuery(query);
	
	    table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception z) {
			System.out.println(z);
		}
		
		JButton approve = new JButton("Approve");
		approve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String a="Approved";
					int veId=Integer.parseInt(id.getText());
					Statement s=con.createStatement();
			        String query="update register_vechile set approval='"+a+"' where v_id='"+veId+"';";
			        int x = s.executeUpdate(query);
			        if (x > 0) {
                  
                    } else {
                        JOptionPane.showMessageDialog(approve,
                                "Please insert valid vechile Id");
			}
				}catch(Exception z) {
					System.out.println(z);
				}
				HomeAdmin obj=new HomeAdmin();
				obj.setVisible(true);
			}
		});
		approve.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		approve.setForeground(Color.GREEN);
		approve.setBounds(105, 470, 125, 38);
		contentPane.add(approve);
		
		
	}

}
