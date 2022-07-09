package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class ForgotPassword extends JFrame {
	
	
	Connection con;
    ResultSet rs;
	

	private JPanel contentPane;
	private JTextField mobTxt;
	private JTextField passTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		
		con=SqlConnection.ConnectDatabase();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("Enter your Name :");
		name.setForeground(new Color(128, 0, 128));
		name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		name.setBounds(54, 90, 178, 43);
		contentPane.add(name);
		
		JTextArea nameTxt = new JTextArea();
		nameTxt.setLineWrap(true);
		nameTxt.setBounds(301, 90, 299, 33);
		contentPane.add(nameTxt);
		
		JLabel mob = new JLabel("Enter Mobile Number :");
		mob.setForeground(new Color(128, 0, 128));
		mob.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		mob.setBounds(54, 143, 195, 55);
		contentPane.add(mob);
		
		mobTxt = new JTextField();
		mobTxt.setBounds(301, 149, 299, 33);
		contentPane.add(mobTxt);
		mobTxt.setColumns(10);
		
		JLabel newPass = new JLabel("New Password :");
		newPass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		newPass.setForeground(new Color(128, 0, 128));
		newPass.setBounds(54, 208, 195, 33);
		contentPane.add(newPass);
		
		passTxt = new JTextField();
		passTxt.setBounds(301, 208, 299, 28);
		contentPane.add(passTxt);
		passTxt.setColumns(10);
		
		JButton change = new JButton("Change Password");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            
		            Statement s=con.createStatement();
		            String query="UPDATE user_info SET u_pass = '"+passTxt.getText()+"'WHERE u_name='"+nameTxt.getText()+"'AND u_mob='"+mobTxt.getText()+"'";
		            int x = s.executeUpdate(query);
                    if (x == 0) {
                    	String name=nameTxt.getText();
                        JOptionPane.showMessageDialog(change, "Please provide Correct Details...",name,JOptionPane.WARNING_MESSAGE);
                    } else {
                    	JOptionPane.showMessageDialog(change, "Password Changed");
	                	dispose();
	                	LoginPage obj=new LoginPage();
	                	obj.setTitle("Vechile Parking Management");
	                	obj.setVisible(true);
	                	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                	obj.setResizable(true);
	           
                    }
		            
		        } catch (Exception ex) {
		            System.out.println(ex);
		        }
			}
		});
		change.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		change.setForeground(new Color(0, 255, 0));
		change.setBounds(273, 310, 178, 43);
		contentPane.add(change);
	}
}
