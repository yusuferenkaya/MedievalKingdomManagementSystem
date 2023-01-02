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

public class manageRelationFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox cbKingdoms;
	private static JLabel lblCurrentGoldAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageRelationFrame frame = new  manageRelationFrame();
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
	public  manageRelationFrame() {
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
		
		cbKingdoms = new JComboBox();
		cbKingdoms.setFocusable(false);
		cbKingdoms.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		for(Kingdom kingdom : Game.ourKingdom.getRelationsWithOtherKingdoms().keySet()) {
			cbKingdoms.addItem(kingdom);
		}
		
		cbKingdoms.setBounds(253, 206, 310, 37);
		panel.add(cbKingdoms);
		
		JButton btnIncrease = new JButton("Increase(+10)");
		btnIncrease.setFocusable(false);
		btnIncrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Game.ourKingdom.getRelationsWithOtherKingdoms().get(cbKingdoms.getSelectedItem())+10 <=100) {
					if(Game.ourKingdom.orderManageRelations((Kingdom)cbKingdoms.getSelectedItem(), true)) {
						menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
						manageRelationFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
						JOptionPane.showMessageDialog(manageRelationFrame.this,
		                        "The relation between your kingdom and " + (cbKingdoms.getSelectedItem().toString()) + " has been increased by 10, new relation is " + (Game.ourKingdom.getRelationsWithOtherKingdoms().get((Kingdom)cbKingdoms.getSelectedItem())), "Manage Relations",
		                        JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(manageRelationFrame.this,
		                        "Not enough money!", "Manage Relations",
		                        JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(manageRelationFrame.this,
	                        "Relation cannot be greater than 100!", "Manage Relations",
	                        JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnIncrease.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnIncrease.setToolTipText("");
		btnIncrease.setBounds(177, 309, 165, 43);
		panel.add(btnIncrease);
		
		JLabel lblNewLabel = new JLabel("Select the kingdom you manage relations");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNewLabel.setBounds(205, 125, 408, 71);
		panel.add(lblNewLabel);
		
		JButton btnDecrease = new JButton("Decrease(-10)");
		btnDecrease.setFocusable(false);
		btnDecrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Game.ourKingdom.getRelationsWithOtherKingdoms().get(cbKingdoms.getSelectedItem())-10 >=0) {
					if(Game.ourKingdom.orderManageRelations((Kingdom)cbKingdoms.getSelectedItem(), false)) {
						menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
						manageRelationFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
						JOptionPane.showMessageDialog(manageRelationFrame.this,
								"The relation between your kingdom and " + (cbKingdoms.getSelectedItem().toString()) + " has been decreased by 10, new relation is " + (Game.ourKingdom.getRelationsWithOtherKingdoms().get((Kingdom)cbKingdoms.getSelectedItem())), "Manage Relations",
		                        JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(manageRelationFrame.this,
		                        "Not enough money!", "Manage Relations",
		                        JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(manageRelationFrame.this,
	                        "Relation cannot be less than 0!", "Manage Relations",
	                        JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnDecrease.setToolTipText("");
		btnDecrease.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnDecrease.setBounds(473, 309, 165, 43);
		panel.add(btnDecrease);
		
		JLabel goldAmount= new JLabel("1000");
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(375, 318, 94, 24);
		panel.add(goldAmount);
		
		JLabel lblCurrentGold = new JLabel("Current Gold:");
		lblCurrentGold.setForeground(Color.WHITE);
		lblCurrentGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGold.setBounds(20, 24, 150, 50);
		panel.add(lblCurrentGold);
		
		lblCurrentGoldAmount = new JLabel(String.valueOf(Game.ourKingdom.getTreasure()));
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(138, 24, 125, 50);
		panel.add(lblCurrentGoldAmount);
		
		
	}
}


