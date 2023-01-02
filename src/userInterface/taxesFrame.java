package userInterface;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GamePackage.Game;
import KingdomPackage.Kingdom;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class taxesFrame extends JFrame {

	Game game;
	
	menuFrame menuFrame;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taxesFrame frame = new taxesFrame();
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
	public taxesFrame() {
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
		
		JButton btnNewButton = new JButton("Collect Taxes");
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon(this.getClass().getResource("/pouch.png")));
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int moneyBeforeTaxes = Game.ourKingdom.getTreasure();
				if(Game.ourKingdom.collectTaxes()) {
					userInterface.menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
				JOptionPane.showMessageDialog(taxesFrame.this,
                        "You collected your taxes, collected taxes: " + (Game.ourKingdom.getTreasure()-moneyBeforeTaxes) , "Collect Taxes",
                        JOptionPane.INFORMATION_MESSAGE);
				
            }
			else {
				JOptionPane.showMessageDialog(taxesFrame.this,
                        "You cannot collect taxes, wait " + (10 - Game.taxesCounter) + " year(s) ","Collect Taxes",
                        JOptionPane.ERROR_MESSAGE);
            }
			}
		});
		btnNewButton.setBounds(269, 148, 229, 46);
		panel.add(btnNewButton);
		
		JButton btnIncreaseTaxes = new JButton("Manage taxes");
		btnIncreaseTaxes.setFocusable(false);
		btnIncreaseTaxes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageTaxesFrame manageTaxesFrame = new manageTaxesFrame();
			
			}
		});
		btnIncreaseTaxes.setIcon(new ImageIcon(this.getClass().getResource("/increase.png")));
		btnIncreaseTaxes.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnIncreaseTaxes.setBounds(269, 218, 229, 46);
		panel.add(btnIncreaseTaxes);
	}

}
