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

public class buildAllianceFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox cbOtherKingdoms;
	private static JLabel lblCurrentGoldAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buildAllianceFrame frame = new  buildAllianceFrame();
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
	public  buildAllianceFrame() {
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
		
		cbOtherKingdoms = new JComboBox();
		cbOtherKingdoms.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		for(Kingdom kingdom : Game.ourKingdom.getRelationsWithOtherKingdoms().keySet()) {

			cbOtherKingdoms.addItem(kingdom);
		}
		cbOtherKingdoms.setBounds(253, 206, 310, 37);
		panel.add(cbOtherKingdoms);
		
		JButton btnNewButton = new JButton("Build alliance");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int returnCheck = Game.ourKingdom.OrderBuildAlliance((Kingdom) cbOtherKingdoms.getSelectedItem());
				
				if(returnCheck == -1) {
					JOptionPane.showMessageDialog(buildAllianceFrame.this,"Not enough money!","Not Builded",JOptionPane.ERROR_MESSAGE);
					
				}else if(returnCheck == 0 ) {
					JOptionPane.showMessageDialog(buildAllianceFrame.this,"You have already has an ally!","Alliance Already Exists",JOptionPane.ERROR_MESSAGE);
				}else if(returnCheck < 80) {
					JOptionPane.showMessageDialog(buildAllianceFrame.this,"Alliance point should be greater than 80, current is " + (returnCheck),"Not Builded",JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(buildAllianceFrame.this,"Alliance is builded with " + ((Kingdom) cbOtherKingdoms.getSelectedItem())+ ", alliance point is " + (returnCheck),"Alliance Builded",JOptionPane.INFORMATION_MESSAGE);
					menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
					menuFrame.lblCurrentAllyName.setText(String.valueOf(Game.ourKingdom.getAllyKingdom()));
					buildAllianceFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
				}
			}
		});
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(316, 288, 165, 43);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select the kingdom you would like to build alliance\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNewLabel.setBounds(205, 125, 408, 71);
		panel.add(lblNewLabel);
		
		JLabel goldAmount= new JLabel("5000");
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(356, 362, 94, 24);
		panel.add(goldAmount);
		
		JLabel lblCurrentGold = new JLabel("Current Gold:");
		lblCurrentGold.setForeground(Color.WHITE);
		lblCurrentGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGold.setBounds(21, 24, 150, 50);
		panel.add(lblCurrentGold);
		
		lblCurrentGoldAmount = new JLabel(String.valueOf(Game.ourKingdom.getTreasure()));
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(138, 24, 125, 50);
		panel.add(lblCurrentGoldAmount);
	}
}


