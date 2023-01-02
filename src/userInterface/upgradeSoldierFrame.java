package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ArmyPackage.Battalion;
import ArmyPackage.InfantryBattalion;
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

public class upgradeSoldierFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					upgradeSoldierFrame frame = new  upgradeSoldierFrame();
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
	public  upgradeSoldierFrame() {
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
		

		
		final JLabel goldAmount= new JLabel("5000");
		goldAmount.setHorizontalAlignment(SwingConstants.CENTER);
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(359, 382, 406, 43);
		panel.add(goldAmount);
		
		JLabel lblCurrentInfantryAttack = new JLabel("Current attack of infantry:");
		lblCurrentInfantryAttack.setForeground(Color.WHITE);
		lblCurrentInfantryAttack.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentInfantryAttack.setBounds(20, 127, 222, 36);
		panel.add(lblCurrentInfantryAttack);
		
		JLabel lblCurrentGoldAmount = new JLabel("Current gold amount:");
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(20, 336, 204, 36);
		panel.add(lblCurrentGoldAmount);
		
		final JLabel lblCurrentArcherAttackAmount = new JLabel("0");
		lblCurrentArcherAttackAmount.setForeground(Color.WHITE);
		lblCurrentArcherAttackAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentArcherAttackAmount.setBounds(255, 198, 110, 36);
		panel.add(lblCurrentArcherAttackAmount);
		
		final JLabel lblCurrentInfantryAttackAmount = new JLabel("0");
		lblCurrentInfantryAttackAmount.setForeground(Color.WHITE);
		lblCurrentInfantryAttackAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentInfantryAttackAmount.setBounds(252, 127, 113, 36);
		panel.add(lblCurrentInfantryAttackAmount);
		
		final JComboBox cBSoldierType = new JComboBox();
		cBSoldierType.setFocusable(false);
		cBSoldierType.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		cBSoldierType.setBounds(401, 225, 310, 43);
		panel.add(cBSoldierType);
		
		cBSoldierType.addItem(Game.ourKingdom.getInfantryBattalion());
		cBSoldierType.addItem(Game.ourKingdom.getArcherBattalion());
		cBSoldierType.addItem(Game.ourKingdom.getCavalryBattalion());
		
		JLabel lblSelectTheSoldierType = new JLabel("Select the soldier type");
		lblSelectTheSoldierType.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheSoldierType.setForeground(Color.WHITE);
		lblSelectTheSoldierType.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblSelectTheSoldierType.setBounds(359, 131, 408, 71);
		panel.add(lblSelectTheSoldierType);
		
		JLabel lblCurrentArcherAttack = new JLabel("Current attack of archer:");
		lblCurrentArcherAttack.setForeground(Color.WHITE);
		lblCurrentArcherAttack.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentArcherAttack.setBounds(20, 198, 222, 36);
		panel.add(lblCurrentArcherAttack);
		
		JLabel lblCurrentCavalryAttack = new JLabel("Current attack of cavalry:");
		lblCurrentCavalryAttack.setForeground(Color.WHITE);
		lblCurrentCavalryAttack.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentCavalryAttack.setBounds(20, 267, 222, 36);
		panel.add(lblCurrentCavalryAttack);
		
		final JLabel lblCurrentCavalryAttackAmount = new JLabel("0");
		lblCurrentCavalryAttackAmount.setForeground(Color.WHITE);
		lblCurrentCavalryAttackAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentCavalryAttackAmount.setBounds(242, 267, 110, 36);
		panel.add(lblCurrentCavalryAttackAmount);
		
		final JLabel lblCurrentAmountGold = new JLabel("0");
		lblCurrentAmountGold.setForeground(Color.WHITE);
		lblCurrentAmountGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountGold.setBounds(224, 336, 110, 36);
		panel.add(lblCurrentAmountGold);

		
		JLabel lblCurrentInfantryDefence = new JLabel("Current defence of infantry:");
		lblCurrentInfantryDefence.setForeground(Color.WHITE);
		lblCurrentInfantryDefence.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentInfantryDefence.setBounds(20, 156, 222, 36);
		panel.add(lblCurrentInfantryDefence);
		
		JLabel lblCurrentArcherDefence = new JLabel("Current defence of archer:");
		lblCurrentArcherDefence.setForeground(Color.WHITE);
		lblCurrentArcherDefence.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentArcherDefence.setBounds(20, 225, 222, 36);
		panel.add(lblCurrentArcherDefence);
		
		JLabel lblCurrentCavalryDefence = new JLabel("Current defence of cavalry:");
		lblCurrentCavalryDefence.setForeground(Color.WHITE);
		lblCurrentCavalryDefence.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentCavalryDefence.setBounds(20, 289, 222, 36);
		panel.add(lblCurrentCavalryDefence);
		
		final JLabel lblCurrentInfantryDefenceAmount = new JLabel("0");
		lblCurrentInfantryDefenceAmount.setForeground(Color.WHITE);
		lblCurrentInfantryDefenceAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentInfantryDefenceAmount.setBounds(252, 156, 113, 36);
		panel.add(lblCurrentInfantryDefenceAmount);
		
		final JLabel lblCurrentArcherDefenceAmount = new JLabel("0");
		lblCurrentArcherDefenceAmount.setForeground(Color.WHITE);
		lblCurrentArcherDefenceAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentArcherDefenceAmount.setBounds(255, 225, 110, 36);
		panel.add(lblCurrentArcherDefenceAmount);
		
		final JLabel lblCurrentCavalryDefenceAmount = new JLabel("0");
		lblCurrentCavalryDefenceAmount.setForeground(Color.WHITE);
		lblCurrentCavalryDefenceAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentCavalryDefenceAmount.setBounds(242, 289, 110, 36);
		panel.add(lblCurrentCavalryDefenceAmount);
		
		
		lblCurrentInfantryAttackAmount.setText(String.valueOf(Game.ourKingdom.getInfantryBattalion().getAttack()));
		lblCurrentInfantryDefenceAmount.setText(String.valueOf(Game.ourKingdom.getInfantryBattalion().getDefence()));
		lblCurrentArcherAttackAmount.setText(String.valueOf(Game.ourKingdom.getArcherBattalion().getAttack()));
		lblCurrentArcherDefenceAmount.setText(String.valueOf(Game.ourKingdom.getArcherBattalion().getDefence()));
		lblCurrentCavalryAttackAmount.setText(String.valueOf(Game.ourKingdom.getCavalryBattalion().getAttack()));
		lblCurrentCavalryDefenceAmount.setText(String.valueOf(Game.ourKingdom.getCavalryBattalion().getDefence()));
		lblCurrentAmountGold.setText(String.valueOf(Game.ourKingdom.getTreasure()));
		
		
		JButton btnUpgrade = new JButton("Upgrade");
		btnUpgrade.setFocusable(false);
		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isUpgraded=Game.ourKingdom.upgradeSoldierRank((Battalion)cBSoldierType.getSelectedItem());
				if(isUpgraded)
				{
					JOptionPane.showMessageDialog(upgradeSoldierFrame.this,"Your " + cBSoldierType.getSelectedItem().toString() + " Battalion is upgraded.","Upgraded",JOptionPane.INFORMATION_MESSAGE);

					lblCurrentInfantryAttackAmount.setText(String.valueOf(Game.ourKingdom.getInfantryBattalion().getAttack()));
					lblCurrentInfantryDefenceAmount.setText(String.valueOf(Game.ourKingdom.getInfantryBattalion().getDefence()));
					lblCurrentArcherAttackAmount.setText(String.valueOf(Game.ourKingdom.getArcherBattalion().getAttack()));
					lblCurrentArcherDefenceAmount.setText(String.valueOf(Game.ourKingdom.getArcherBattalion().getDefence()));
					lblCurrentCavalryAttackAmount.setText(String.valueOf(Game.ourKingdom.getCavalryBattalion().getAttack()));
					lblCurrentCavalryDefenceAmount.setText(String.valueOf(Game.ourKingdom.getCavalryBattalion().getDefence()));
					lblCurrentAmountGold.setText(String.valueOf(Game.ourKingdom.getTreasure()));
					menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
				}
				else
				{
					JOptionPane.showMessageDialog(upgradeSoldierFrame.this,"Your treasure is less than 5000.","Not Upgraded",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		

		btnUpgrade.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnUpgrade.setToolTipText("");
		btnUpgrade.setBounds(475, 329, 165, 43);
		panel.add(btnUpgrade);
	}
}


