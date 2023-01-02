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

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class assignANobleFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					assignANobleFrame frame = new assignANobleFrame();
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
	public assignANobleFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 512);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(43, 54, 60));
		panel.setBounds(0, 0, 786, 485);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		comboBox.setBounds(229, 152, 312, 44);
		panel.add(comboBox);
		for (Noble aNoble : Game.ourKingdom.getNoblesAtCourt()) {
			comboBox.addItem(aNoble);
		}
		
		
		JLabel lblNewLabel = new JLabel("Assign a new role for your exiled noble.");
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNewLabel.setBounds(149, 20, 627, 53);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Noble> noblesAtCourt = Game.ourKingdom.getNoblesAtCourt();
				Noble chosenNoble = (Noble) comboBox.getSelectedItem();
				noblesAtCourt.remove(chosenNoble);
				if (Game.ourKingdom.getAmbassador() == null) {
					Ambassador newOne = (Ambassador) chosenNoble.assignARole("AMBASSADOR");
					Game.ourKingdom.setAmbassador(newOne);
					exileFrame.comboBox.addItem(newOne);
					JOptionPane.showMessageDialog(assignANobleFrame.this,"Your new " + newOne.toString() + " is assigned.","Assigning",JOptionPane.INFORMATION_MESSAGE);
				}
				else if (Game.ourKingdom.getSpymaster() == null) {
					Spymaster newOne = (Spymaster) chosenNoble.assignARole("SPYMASTER");
					Game.ourKingdom.setSpymaster(newOne);
					exileFrame.comboBox.addItem(newOne);
					JOptionPane.showMessageDialog(assignANobleFrame.this,"Your new " + newOne.toString() + " is assigned.","Assigning",JOptionPane.INFORMATION_MESSAGE);
				}
				else if (Game.ourKingdom.getMissionary() == null) {
					Missionary newOne = (Missionary) chosenNoble.assignARole("MISSIONARY");
					Game.ourKingdom.setMissionary(newOne);
					exileFrame.comboBox.addItem(newOne);
					JOptionPane.showMessageDialog(assignANobleFrame.this,"Your new " + newOne.toString() + " is assigned.","Assigning",JOptionPane.INFORMATION_MESSAGE);
				}
				setVisible(false);
				dispose();
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}
			
		});
		btnNewButton.setBounds(307, 284, 160, 53);
		panel.add(btnNewButton);
	}
}
