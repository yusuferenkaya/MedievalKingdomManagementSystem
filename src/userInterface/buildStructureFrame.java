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

public class buildStructureFrame extends JFrame {

	Game game;
	private JPanel contentPane;
	private static JLabel lblCurrentAmountWall;
	private static JLabel lblCurrentAmountCastle;
	private JComboBox cBStructureType;
	private static JLabel lblCurrentAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buildStructureFrame frame = new  buildStructureFrame();
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
	public  buildStructureFrame() {
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
		
		JButton btnUpgrade = new JButton("Construct");
		btnUpgrade.setFocusable(false);
		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prevDefencePoint = game.ourKingdom.getKingdomDefence();
				int returnCheck = game.ourKingdom.constructStructure(cBStructureType.getSelectedItem().toString());
				
				if(returnCheck !=-1 && returnCheck != 0 ) {
					if(cBStructureType.getSelectedItem().toString() == "Castle") {
						buildStructureFrame.lblCurrentAmountCastle.setText("Yes");
					    menuFrame.lblCastleLevelAmount.setText("1");
						JOptionPane.showMessageDialog(buildStructureFrame.this,
		                        "Castle constructed succesfully, defence points earned: " + (returnCheck-prevDefencePoint), "Build Structure",
		                        JOptionPane.INFORMATION_MESSAGE);
					}
					
					else if(cBStructureType.getSelectedItem().toString() == "Wall") {
						buildStructureFrame.lblCurrentAmountWall.setText("Yes");
					    menuFrame.lblWallLevelAmount.setText("1");
						JOptionPane.showMessageDialog(buildStructureFrame.this,
		                        "Wall constructed succesfully, defence points earned: " +  (returnCheck-prevDefencePoint), "Build Structure",
		                        JOptionPane.INFORMATION_MESSAGE);
					}

				}else if (returnCheck == -1){
					JOptionPane.showMessageDialog(buildStructureFrame.this,
	                        "You have already had this structure", "Build Structure",
	                        JOptionPane.ERROR_MESSAGE);
				}
				else if (returnCheck == 0){
					JOptionPane.showMessageDialog(buildStructureFrame.this,
	                        "Not enough money", "Build Structure",
	                        JOptionPane.ERROR_MESSAGE);
				}




				buildStructureFrame.lblCurrentAmount.setText(String.valueOf(game.ourKingdom.getTreasure()));
			    menuFrame.lblCurrentGoldAmount.setText(String.valueOf(game.ourKingdom.getTreasure()));
			    menuFrame.lblCurrentAmountDefPoint.setText(String.valueOf(game.ourKingdom.getKingdomDefence()));
			    menuFrame.lblCurrentAmountAttPoint.setText(String.valueOf(game.ourKingdom.getKingdomAttack()));
			}
		});
		btnUpgrade.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnUpgrade.setToolTipText("");
		btnUpgrade.setBounds(475, 329, 165, 43);
		panel.add(btnUpgrade);
		
		final JLabel goldAmount= new JLabel("5000");
		goldAmount.setHorizontalAlignment(SwingConstants.CENTER);
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(359, 382, 406, 43);
		panel.add(goldAmount);




		
		JLabel lblCastleExist = new JLabel("Castle exist:");
		lblCastleExist.setForeground(Color.WHITE);
		lblCastleExist.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCastleExist.setBounds(20, 127, 222, 36);
		panel.add(lblCastleExist);
		
		JLabel lblCurrentGoldAmount = new JLabel("Current gold amount:");
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(20, 267, 204, 36);
		panel.add(lblCurrentGoldAmount);
		
		
		if(game.ourKingdom.getWall() != null) {
			lblCurrentAmountWall = new JLabel("Yes");
		}else {
			lblCurrentAmountWall = new JLabel("No");
		}
		lblCurrentAmountWall.setForeground(Color.WHITE);
		lblCurrentAmountWall.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountWall.setBounds(110, 198, 110, 36);
		panel.add(lblCurrentAmountWall);
		
		if(game.ourKingdom.getCastle() != null) {
			lblCurrentAmountCastle = new JLabel("Yes");
		}else {
			lblCurrentAmountCastle = new JLabel("No");
		}
		lblCurrentAmountCastle.setForeground(Color.WHITE);
		lblCurrentAmountCastle.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountCastle.setBounds(121, 127, 113, 36);
		panel.add(lblCurrentAmountCastle);
		
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
		
		JLabel lblWallExist = new JLabel("Wall exist:");
		lblWallExist.setForeground(Color.WHITE);
		lblWallExist.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblWallExist.setBounds(20, 198, 222, 36);
		panel.add(lblWallExist);
		
		lblCurrentAmount = new JLabel(String.valueOf(game.ourKingdom.getTreasure()));
		lblCurrentAmount.setForeground(Color.WHITE);
		lblCurrentAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmount.setBounds(197, 267, 159, 36);
		panel.add(lblCurrentAmount);
	}
}


