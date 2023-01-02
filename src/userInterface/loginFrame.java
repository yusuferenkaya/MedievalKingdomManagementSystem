package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.swing.DropMode;
import java.awt.Component;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame(){
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Enchanted Land.otf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(43,54,60));
		leftPanel.setForeground(Color.WHITE);
		leftPanel.setBounds(0, 0, 240, 475);
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 47));
		lblNewLabel.setBounds(38, 156, 180, 68);
		leftPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Kingdom");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Enchanted Land", Font.PLAIN, 55));
		lblNewLabel_1.setBounds(10, 212, 272, 62);
		leftPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(this.getClass().getResource("/kingGif.gif")));
		lblNewLabel_4.setBounds(38, 301, 131, 164);
		leftPanel.add(lblNewLabel_4);
		
		final JPanel midPanel = new JPanel();
		midPanel.setBackground(new Color(80,224,252));
		midPanel.setBounds(244, 0, 80, 475);
		contentPane.add(midPanel);
		midPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/swordGif.gif")));
		lblNewLabel_2.setBounds(10, 10, 61, 455);
		midPanel.add(lblNewLabel_2);
		
		final JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(254,254,254));
		rightPanel.setBounds(328, 0, 458, 475);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmail.setText("");
			}
		});
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Enchanted Land", Font.PLAIN, 22));
		txtEmail.setText("Email");
		txtEmail.setBounds(88, 232, 259, 27);
		rightPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword.setText("Password");
		pwdPassword.setBounds(88, 284, 259, 27);
		rightPanel.add(pwdPassword);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(this.getClass().getResource("/castleGif.gif")));
		lblNewLabel_3.setBounds(131, 45, 152, 116);
		rightPanel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setFocusable(false);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 38));
		btnNewButton.setBounds(148, 377, 152, 38);
		rightPanel.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 786, 475);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				
				
				  	String email = txtEmail.getText();
	                String password = String.valueOf(pwdPassword.getPassword());

	                boolean loginState = checkLogin(email,password);

	                if(loginState){
	                    int reply = JOptionPane.showConfirmDialog(null, "Would you like to continue on your save", "Game Mode", JOptionPane.YES_NO_OPTION);
	                    if (reply == JOptionPane.YES_OPTION) {
		                    menuFrame menuFrame = new menuFrame(true);
		                    menuFrame.show();
	                    } else {
		                    menuFrame menuFrame = new menuFrame(false);
		                    menuFrame.show();
	                    }
	                    dispose();
	                }else{
	                    JOptionPane.showMessageDialog(loginFrame.this,
	                            "Email or Password Invalid","Try Again",
	                            JOptionPane.ERROR_MESSAGE);
	                }

	            }
			
			}
		);

	}


private boolean checkLogin(String email, String password){
    return Objects.equals(User.getEmail(), email) && Objects.equals(User.getPassword(), password);
}
}
