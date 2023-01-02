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

public class recruitSoldierFrame extends JFrame {

	Game game;
	private JPanel contentPane;
	private JTextField tfAmountBattalion;
	private JComboBox cBSoldierType;
	private static JLabel lblCurrentGoldAmount;
	private static JLabel lblCurrentAmountArch;
	private static JLabel lblCurrentAmountInf;
	private static JLabel lblCurrentAmountCav;
	private static JLabel lblCurrentAmountGold;
	private static JLabel lblCurrentAmountSword;
	private static JLabel lblCurrentAmountBow;
	private static JLabel lblCurrentAmountSpear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recruitSoldierFrame frame = new  recruitSoldierFrame();
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
	public  recruitSoldierFrame() {
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
		
		JButton btnRecruit = new JButton("Recruit");
		btnRecruit.setFocusable(false);
		btnRecruit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int returnCheck = game.ourKingdom.recruitSoldier(cBSoldierType.getSelectedItem().toString(),Integer.parseInt(tfAmountBattalion.getText()));
				
				if(returnCheck == -1) {
					
					JOptionPane.showMessageDialog(recruitSoldierFrame.this,
	                        "Not enough money!", "Recruit Soldier",
	                        JOptionPane.ERROR_MESSAGE);
					
					
				}else if(returnCheck == 0) {
					JOptionPane.showMessageDialog(recruitSoldierFrame.this,
	                        "Not enough weapon!", "Recruit Soldier",
	                        JOptionPane.ERROR_MESSAGE);
					
				}else{
					
					if(cBSoldierType.getSelectedItem().toString() == "Archer") {
						recruitSoldierFrame.lblCurrentAmountArch.setText(String.valueOf(game.ourKingdom.getArcherBattalion().getNumberOfSoldiers()));
						recruitSoldierFrame.lblCurrentAmountBow.setText(String.valueOf(game.ourKingdom.getBow().getAmount()));
					    menuFrame.lblNumberArcherAmount.setText(String.valueOf(game.ourKingdom.getArcherBattalion().getNumberOfSoldiers()));
					    menuFrame.lblCurrentBowAmount.setText(String.valueOf(game.ourKingdom.getBow().getAmount()));
					    

						JOptionPane.showMessageDialog(recruitSoldierFrame.this,
		                        (returnCheck)+ " archer(s) recruited succesfully", "Recruit Soldier",
		                        JOptionPane.INFORMATION_MESSAGE);
					}
					else if(cBSoldierType.getSelectedItem().toString() == "Infantry") {
						recruitSoldierFrame.lblCurrentAmountInf.setText(String.valueOf(game.ourKingdom.getInfantryBattalion().getNumberOfSoldiers()));
					    menuFrame.lblNumberInfantryAmount.setText(String.valueOf(game.ourKingdom.getInfantryBattalion().getNumberOfSoldiers()));
					    menuFrame.lblCurrentSwordAmount.setText(String.valueOf(game.ourKingdom.getSword().getAmount()));
						recruitSoldierFrame.lblCurrentAmountSword.setText(String.valueOf(game.ourKingdom.getSword().getAmount()));
						JOptionPane.showMessageDialog(recruitSoldierFrame.this,
		                        (returnCheck)+ " infantry(s) recruited succesfully", "Recruit Soldier",
		                        JOptionPane.INFORMATION_MESSAGE);
					}
					else if(cBSoldierType.getSelectedItem().toString() == "Cavalry") {
						recruitSoldierFrame.lblCurrentAmountCav.setText(String.valueOf(game.ourKingdom.getCavalryBattalion().getNumberOfSoldiers()));
					    menuFrame.lblNumberCavalryAmount.setText(String.valueOf(game.ourKingdom.getCavalryBattalion().getNumberOfSoldiers()));
					    menuFrame.lblCurrentSpearAmount.setText(String.valueOf(game.ourKingdom.getSpear().getAmount()));
						recruitSoldierFrame.lblCurrentAmountSpear.setText(String.valueOf(game.ourKingdom.getSpear().getAmount()));
						JOptionPane.showMessageDialog(recruitSoldierFrame.this,
		                        (returnCheck)+ " cavalry(s) recruited succesfully", "Recruit Soldier",
		                        JOptionPane.INFORMATION_MESSAGE);
					}
					game.ourKingdom.calculateKingdomAttackAndDefence();
					menuFrame.lblCurrentAmountAttPoint.setText(String.valueOf(game.ourKingdom.getKingdomAttack()));
					menuFrame.lblCurrentAmountDefPoint.setText(String.valueOf(game.ourKingdom.getKingdomDefence()));
				}


				recruitSoldierFrame.lblCurrentAmountGold.setText(String.valueOf(game.ourKingdom.getTreasure()));
			    menuFrame.lblCurrentGoldAmount.setText(String.valueOf(game.ourKingdom.getTreasure()));

			}
		});
		btnRecruit.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnRecruit.setToolTipText("");
		btnRecruit.setBounds(477, 346, 165, 43);
		panel.add(btnRecruit);
		
		JLabel lblAmountBattalionInput = new JLabel("Enter the amount of battalions");
		lblAmountBattalionInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountBattalionInput.setForeground(Color.WHITE);
		lblAmountBattalionInput.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblAmountBattalionInput.setBounds(340, 181, 425, 71);
		panel.add(lblAmountBattalionInput);
		
		final JLabel goldAmount= new JLabel("0");
		goldAmount.setHorizontalAlignment(SwingConstants.CENTER);
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(359, 399, 406, 43);
		panel.add(goldAmount);
		
		tfAmountBattalion = new JTextField();
		tfAmountBattalion.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		tfAmountBattalion.setBounds(419, 283, 279, 53);
		panel.add(tfAmountBattalion);
		tfAmountBattalion.setColumns(10);
		

			tfAmountBattalion.getDocument().addDocumentListener(new DocumentListener() {
				  public void changedUpdate(DocumentEvent a) {
					  try {
						  goldAmount.setText(String.valueOf(Integer.parseInt(tfAmountBattalion.getText())*3*100));
					  }catch(NumberFormatException e) {
		                    JOptionPane.showMessageDialog(recruitSoldierFrame.this,
		                            "You need to enter number","Try Again",
		                            JOptionPane.ERROR_MESSAGE);
					  }
				  }
				  public void removeUpdate(DocumentEvent a) {
					  
					  if(tfAmountBattalion.getText().equals("") || !isNumeric(tfAmountBattalion.getText())) {
						  return;
					  }
					  try {
						  goldAmount.setText( String.valueOf(Integer.parseInt(tfAmountBattalion.getText())*3*100));
					  }catch(NumberFormatException e) {
		                    JOptionPane.showMessageDialog(recruitSoldierFrame.this,
		                            "You need to enter number","Try Again",
		                            JOptionPane.ERROR_MESSAGE);
					  }
				  }
				  public void insertUpdate(DocumentEvent e) {
					  try {
						  goldAmount.setText(String.valueOf(Integer.parseInt(tfAmountBattalion.getText())*3*100));
					  }catch(NumberFormatException a) {
		                    JOptionPane.showMessageDialog(recruitSoldierFrame.this,
		                            "You need to enter number","Try Again",
		                            JOptionPane.ERROR_MESSAGE);
					  }
				  }

				});




		
		JLabel lblCurrentInfantry = new JLabel("Current amount of infantry:");
		lblCurrentInfantry.setForeground(Color.WHITE);
		lblCurrentInfantry.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentInfantry.setBounds(20, 217, 222, 36);
		panel.add(lblCurrentInfantry);
		
		lblCurrentGoldAmount = new JLabel("Current gold amount:");
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(20, 366, 204, 36);
		panel.add(lblCurrentGoldAmount);
		
		lblCurrentAmountArch = new JLabel(String.valueOf(game.ourKingdom.getArcherBattalion().getNumberOfSoldiers()));
		lblCurrentAmountArch.setForeground(Color.WHITE);
		lblCurrentAmountArch.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountArch.setBounds(255, 262, 110, 36);
		panel.add(lblCurrentAmountArch);
		
		lblCurrentAmountInf = new JLabel(String.valueOf(game.ourKingdom.getInfantryBattalion().getNumberOfSoldiers()));
		lblCurrentAmountInf.setForeground(Color.WHITE);
		lblCurrentAmountInf.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountInf.setBounds(252, 217, 113, 36);
		panel.add(lblCurrentAmountInf);
		
		cBSoldierType = new JComboBox();
		cBSoldierType.setFocusable(false);
		cBSoldierType.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		cBSoldierType.setBounds(399, 143, 310, 43);
		panel.add(cBSoldierType);
		cBSoldierType.addItem("Infantry");
		cBSoldierType.addItem("Archer");
		cBSoldierType.addItem("Cavalry");
		
		JLabel lblSelectTheSoldier = new JLabel("Select the soldier type");
		lblSelectTheSoldier.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheSoldier.setForeground(Color.WHITE);
		lblSelectTheSoldier.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblSelectTheSoldier.setBounds(357, 77, 408, 71);
		panel.add(lblSelectTheSoldier);
		
		JLabel lblCurrentArcher = new JLabel("Current amount of archer:");
		lblCurrentArcher.setForeground(Color.WHITE);
		lblCurrentArcher.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentArcher.setBounds(20, 263, 222, 36);
		panel.add(lblCurrentArcher);
		
		JLabel lblCurrentCavalry = new JLabel("Current amount of cavalry:");
		lblCurrentCavalry.setForeground(Color.WHITE);
		lblCurrentCavalry.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentCavalry.setBounds(20, 309, 222, 36);
		panel.add(lblCurrentCavalry);
		
		lblCurrentAmountCav = new JLabel(String.valueOf(game.ourKingdom.getCavalryBattalion().getNumberOfSoldiers()));
		lblCurrentAmountCav.setForeground(Color.WHITE);
		lblCurrentAmountCav.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountCav.setBounds(252, 309, 110, 36);
		panel.add(lblCurrentAmountCav);
		
		lblCurrentAmountGold = new JLabel(String.valueOf(game.ourKingdom.getTreasure()));
		lblCurrentAmountGold.setForeground(Color.WHITE);
		lblCurrentAmountGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountGold.setBounds(205, 366, 110, 36);
		panel.add(lblCurrentAmountGold);
		
		JLabel lblBatttalion = new JLabel("1 Battalion = 100 Soldier");
		lblBatttalion.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatttalion.setForeground(Color.WHITE);
		lblBatttalion.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblBatttalion.setBounds(350, 232, 425, 71);
		panel.add(lblBatttalion);
		
		JLabel lblCurrentSword = new JLabel("Current amount of sword:");
		lblCurrentSword.setForeground(Color.WHITE);
		lblCurrentSword.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentSword.setBounds(20, 24, 222, 36);
		panel.add(lblCurrentSword);
		
		JLabel lblCurrentBow = new JLabel("Current amount of bow:");
		lblCurrentBow.setForeground(Color.WHITE);
		lblCurrentBow.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentBow.setBounds(20, 77, 222, 36);
		panel.add(lblCurrentBow);
		
		JLabel lblCurrentSpear = new JLabel("Current amount of spear:");
		lblCurrentSpear.setForeground(Color.WHITE);
		lblCurrentSpear.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentSpear.setBounds(20, 123, 222, 36);
		panel.add(lblCurrentSpear);
		
		lblCurrentAmountSword = new JLabel(String.valueOf(game.ourKingdom.getSword().getAmount()));
		lblCurrentAmountSword.setForeground(Color.WHITE);
		lblCurrentAmountSword.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountSword.setBounds(252, 24, 113, 36);
		panel.add(lblCurrentAmountSword);
		
		lblCurrentAmountBow = new JLabel(String.valueOf(game.ourKingdom.getBow().getAmount()));
		lblCurrentAmountBow.setForeground(Color.WHITE);
		lblCurrentAmountBow.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountBow.setBounds(252, 77, 113, 36);
		panel.add(lblCurrentAmountBow);
		
		lblCurrentAmountSpear = new JLabel(String.valueOf(game.ourKingdom.getSpear().getAmount()));
		lblCurrentAmountSpear.setForeground(Color.WHITE);
		lblCurrentAmountSpear.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountSpear.setBounds(252, 123, 113, 36);
		panel.add(lblCurrentAmountSpear);
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}


