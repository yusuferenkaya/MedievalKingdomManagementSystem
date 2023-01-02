package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GamePackage.Game;
import PersonPackage.Ambassador;
import PersonPackage.Missionary;
import PersonPackage.Noble;
import PersonPackage.Spymaster;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class exileFrame extends JFrame {

	private JPanel contentPane;
	boolean isExiledDone = false;
	public static JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exileFrame frame = new exileFrame();
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
	public exileFrame() {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(43,54,60));
		panel.setBounds(0, 0, 786, 485);
		contentPane.add(panel);
		panel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		comboBox.setBounds(245, 218, 310, 37);
		panel.add(comboBox);
		final Ambassador ourAmbassador = Game.ourKingdom.getAmbassador();
		final Spymaster ourSpymaster = Game.ourKingdom.getSpymaster();
		final Missionary ourMissionary = Game.ourKingdom.getMissionary();
		comboBox.addItem(ourAmbassador);
		comboBox.addItem(ourSpymaster);
		comboBox.addItem(ourMissionary);
		JButton btnNewButton = new JButton("Exile");
		btnNewButton.setFocusable(false);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Noble chosenNoble = (Noble) comboBox.getSelectedItem();
				if (chosenNoble.equals(ourAmbassador)) {
					Game.ourKingdom.setAmbassador(null);
					JOptionPane.showMessageDialog(exileFrame.this, "Your " + ourAmbassador.toString() + " is exiled." +
							"Please assign a new ambassador for your court.","Exile",JOptionPane.INFORMATION_MESSAGE);
					String exiledRole = "Ambassador";
					comboBox.removeItem(ourAmbassador);
					}
				else if(chosenNoble.equals(ourSpymaster)) {
					Game.ourKingdom.setSpymaster(null);
					JOptionPane.showMessageDialog(exileFrame.this, "Your " + ourSpymaster.toString() + " is exiled." +
							"Please assign a new spymaster for your court.","Exile",JOptionPane.INFORMATION_MESSAGE);
					String exiledRole = "Spymaster";
					comboBox.removeItem(ourSpymaster);


					}
				else if(chosenNoble.equals(ourMissionary)) {
					Game.ourKingdom.setMissionary(null);
					JOptionPane.showMessageDialog(exileFrame.this, "Your " + ourMissionary.toString() + " is exiled." +
					"Please assign a new missionary for your court.","Exile",JOptionPane.INFORMATION_MESSAGE);
					String exiledRole = "Missionary";
					comboBox.removeItem(ourMissionary);

					}
				isExiledDone = true;
			
				assignANobleFrame assignANobleFrame = new assignANobleFrame();	
			}
		});
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(316, 308, 165, 43);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select person you would like to exile");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNewLabel.setBounds(236, 119, 331, 71);
		panel.add(lblNewLabel);
		
	
		

	}
}

