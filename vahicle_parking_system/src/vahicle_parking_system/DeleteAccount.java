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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteAccount extends JFrame {
	
	
	Connection con;
    ResultSet rs;

	private JPanel contentPane;
	private JTextField passTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccount frame = new DeleteAccount();
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
	public DeleteAccount() {
		
		con=SqlConnection.ConnectDatabase();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 494);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter your Password :");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(85, 63, 265, 25);
		contentPane.add(lblNewLabel);
		
		passTxt = new JTextField();
		passTxt.setBounds(348, 63, 172, 25);
		contentPane.add(passTxt);
		passTxt.setColumns(10);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uvpm", "root", "g12l8");

                    String query = "DELETE FROM user_info WHERE u_pass='"+passTxt.getText()+"'";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x > 0) {
                        JOptionPane.showMessageDialog(delete, " You have sucessfully deleted your account");
                        dispose();
                        LoginPage obj=new LoginPage();
       	                obj.setTitle("Vechile Parking Management");
       	                obj.setVisible(true);
       	                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	                obj.setResizable(true);
                    } else {
                        JOptionPane.showMessageDialog(delete,
                                "please enter your password");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
			}
		});
		delete.setForeground(Color.RED);
		delete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		delete.setBounds(313, 149, 99, 29);
		contentPane.add(delete);
	}
}
