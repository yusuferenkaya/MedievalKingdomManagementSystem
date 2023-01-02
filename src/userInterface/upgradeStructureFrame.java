package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import GamePackage.Game;

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
import javax.swing.JTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.DefaultComboBoxModel;

public class upgradeStructureFrame extends JFrame {

	Game game;
	private JPanel contentPane;
	private JComboBox cBStructureType;
	private static JLabel lblCurrentLevelWall;
	private static JLabel lblCurrentLevelCastle;
	private static JLabel lblCurrentGold;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					upgradeStructureFrame frame = new upgradeStructureFrame();
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
	public  upgradeStructureFrame() {
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
		
		JButton btnUpgrade = new JButton("Upgrade");
		btnUpgrade.setFocusable(false);
		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int returnCheck = game.ourKingdom.upgradeStructureRank(cBStructureType.getSelectedItem().toString());
				
				if(returnCheck == -1) {
					JOptionPane.showMessageDialog(upgradeStructureFrame.this,
	                        "Not enough money!", "Upgrade Structure",
	                        JOptionPane.ERROR_MESSAGE);
				}else if (returnCheck == 0) {
					JOptionPane.showMessageDialog(upgradeStructureFrame.this,
	                        "Max level reached!", "Upgrade Structure",
	                        JOptionPane.ERROR_MESSAGE);
				}else if(returnCheck == 1) {
					JOptionPane.showMessageDialog(upgradeStructureFrame.this,
	                        "Firstly you need to construct!", "Upgrade Structure",
	                        JOptionPane.ERROR_MESSAGE);
				}else {
					if(cBStructureType.getSelectedItem() == "Castle") {
						upgradeStructureFrame.lblCurrentLevelCastle.setText(String.valueOf(game.ourKingdom.getCastle().getLevel()));
						upgradeStructureFrame.lblCurrentGold.setText(String.valueOf(game.ourKingdom.getTreasure()));
						menuFrame.lblCastleLevelAmount.setText(String.valueOf(game.ourKingdom.getCastle().getLevel()));
						menuFrame.lblCurrentAmountDefPoint.setText(String.valueOf(game.ourKingdom.getKingdomDefence()));
						userInterface.menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
						JOptionPane.showMessageDialog(upgradeStructureFrame.this,
			                        "Castle upgraded successfully", "Upgrade Structure",
			                        JOptionPane.INFORMATION_MESSAGE);
						}
				
					else if(cBStructureType.getSelectedItem() == "Wall") {
						upgradeStructureFrame.lblCurrentLevelWall.setText(String.valueOf(game.ourKingdom.getWall().getLevel()));
						upgradeStructureFrame.lblCurrentGold.setText(String.valueOf(game.ourKingdom.getTreasure()));
						menuFrame.lblWallLevelAmount.setText(String.valueOf(game.ourKingdom.getWall().getLevel()));
						menuFrame.lblCurrentAmountDefPoint.setText(String.valueOf(game.ourKingdom.getKingdomDefence()));
						userInterface.menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
						JOptionPane.showMessageDialog(upgradeStructureFrame.this,
								"Wall upgraded successfully", "Upgrade Structure",
			                        JOptionPane.INFORMATION_MESSAGE);
						}
				}
			}
		});
		btnUpgrade.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnUpgrade.setToolTipText("");
		btnUpgrade.setBounds(475, 329, 165, 43);
		panel.add(btnUpgrade);
		
		final JLabel goldAmount= new JLabel("2000");
		goldAmount.setHorizontalAlignment(SwingConstants.CENTER);
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(359, 382, 406, 43);
		panel.add(goldAmount);




		
		JLabel lblCurrentCastle = new JLabel("Current level of castle:");
		lblCurrentCastle.setForeground(Color.WHITE);
		lblCurrentCastle.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentCastle.setBounds(20, 127, 222, 36);
		panel.add(lblCurrentCastle);
		
		JLabel lblCurrentGoldAmount = new JLabel("Current gold amount:");
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(20, 267, 204, 36);
		panel.add(lblCurrentGoldAmount);
		
		if(game.ourKingdom.getWall() != null) {
			lblCurrentLevelWall = new JLabel(String.valueOf(game.ourKingdom.getWall().getLevel()));
		}else {
			lblCurrentLevelWall = new JLabel(String.valueOf(0));
		}
		lblCurrentLevelWall.setForeground(Color.WHITE);
		lblCurrentLevelWall.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentLevelWall.setBounds(198, 198, 110, 36);
		panel.add(lblCurrentLevelWall);
		
		if(game.ourKingdom.getCastle() != null) {
			lblCurrentLevelCastle = new JLabel(String.valueOf(game.ourKingdom.getCastle().getLevel()));
		}else {
			lblCurrentLevelCastle = new JLabel(String.valueOf(0));
		}
		lblCurrentLevelCastle.setForeground(Color.WHITE);
		lblCurrentLevelCastle.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentLevelCastle.setBounds(208, 127, 113, 36);
		panel.add(lblCurrentLevelCastle);
		
		cBStructureType = new JComboBox();
		cBStructureType.setFocusable(false);
		cBStructureType.setModel(new DefaultComboBoxModel(new String[] {"Castle", "Wall"}));
		cBStructureType.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		cBStructureType.setBounds(401, 225, 310, 43);
		panel.add(cBStructureType);

		
		JLabel lblSelectTheStructureType = new JLabel("Select the structure type");
		lblSelectTheStructureType.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheStructureType.setForeground(Color.WHITE);
		lblSelectTheStructureType.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblSelectTheStructureType.setBounds(359, 131, 408, 71);
		panel.add(lblSelectTheStructureType);
		
		JLabel lblCurrentWall = new JLabel("Current level of wall:");
		lblCurrentWall.setForeground(Color.WHITE);
		lblCurrentWall.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentWall.setBounds(20, 198, 222, 36);
		panel.add(lblCurrentWall);
		
		lblCurrentGold = new JLabel(String.valueOf(game.ourKingdom.getTreasure()));
		lblCurrentGold.setForeground(Color.WHITE);
		lblCurrentGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGold.setBounds(198, 267, 110, 36);
		panel.add(lblCurrentGold);
	}
}


