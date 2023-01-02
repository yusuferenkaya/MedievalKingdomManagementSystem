package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class spyFrame extends JFrame {

	private JPanel contentPane;
	private static JLabel lblCurrentAmountGold;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 spyFrame frame = new  spyFrame();
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
	public  spyFrame() {
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
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		for(Kingdom kingdom : Game.ourKingdom.getRelationsWithOtherKingdoms().keySet()) {
			comboBox.addItem(kingdom);
		}
		comboBox.setBounds(245, 218, 310, 43);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Send spy");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isSpySent= Game.ourKingdom.sendSpymaster((Kingdom)comboBox.getSelectedItem());
				if(isSpySent)
				{
					JOptionPane.showMessageDialog(spyFrame.this,Game.ourKingdom.getSpymaster().showInformations(),"Observing",JOptionPane.INFORMATION_MESSAGE);
					menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
					spyFrame.lblCurrentAmountGold.setText(String.valueOf(Game.ourKingdom.getTreasure()));
				}
				else
				{
					JOptionPane.showMessageDialog(spyFrame.this,"Your total treasure is less than 2000.","Not Observed",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(316, 308, 165, 43);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select the kingdom you would like to send spy ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNewLabel.setBounds(205, 125, 408, 71);
		panel.add(lblNewLabel);
		
		
		JLabel goldAmount= new JLabel("2000");
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(362, 366, 94, 24);
		panel.add(goldAmount);
		
		JLabel lblCurrentGoldAmount = new JLabel("Current gold amount:");
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(26, 31, 204, 36);
		panel.add(lblCurrentGoldAmount);
		
		lblCurrentAmountGold = new JLabel(String.valueOf(Game.ourKingdom.getTreasure()));
		lblCurrentAmountGold.setForeground(Color.WHITE);
		lblCurrentAmountGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountGold.setBounds(205, 31, 110, 36);
		panel.add(lblCurrentAmountGold);
	}
	
	
}


