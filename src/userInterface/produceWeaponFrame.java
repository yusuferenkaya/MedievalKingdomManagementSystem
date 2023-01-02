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

public class produceWeaponFrame extends JFrame {

	Game game;
	private JPanel contentPane;
	private JTextField tfAmountBattalion;
	private JComboBox cBWeaponType;
	private static JLabel lblCurrentAmountBow;
	private static JLabel lblCurrentAmountSpear;
	private static JLabel lblCurrentAmountSword;
	private static JLabel lblCurrentAmountGold;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					produceWeaponFrame  frame = new  produceWeaponFrame ();
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
	public  produceWeaponFrame () {
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
		
		JButton btnRecruit = new JButton("Produce");
		btnRecruit.setFocusable(false);
		btnRecruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int returnCheck = game.ourKingdom.produceWeapon(cBWeaponType.getSelectedItem().toString(), Integer.parseInt(tfAmountBattalion.getText()));
				
				if(returnCheck !=-1) {
					if(cBWeaponType.getSelectedItem().toString() == "Bow") {
						produceWeaponFrame.lblCurrentAmountBow.setText(String.valueOf(game.ourKingdom.getBow().getAmount()));
					    menuFrame.lblCurrentBowAmount.setText(String.valueOf(game.ourKingdom.getBow().getAmount()));
						JOptionPane.showMessageDialog(produceWeaponFrame.this,
		                        (returnCheck)+ " bows produced succesfully", "Produce Weapon",
		                        JOptionPane.INFORMATION_MESSAGE);
					}

					if(cBWeaponType.getSelectedItem().toString() == "Sword") {
						produceWeaponFrame.lblCurrentAmountSword.setText(String.valueOf(game.ourKingdom.getSword().getAmount()));
					    menuFrame.lblCurrentSwordAmount.setText(String.valueOf(game.ourKingdom.getSword().getAmount()));
						JOptionPane.showMessageDialog(produceWeaponFrame.this,
		                        (returnCheck)+ "  swords produced succesfully", "Produce Weapon",
		                        JOptionPane.INFORMATION_MESSAGE);
					}

					if(cBWeaponType.getSelectedItem().toString() == "Spear") {
						produceWeaponFrame.lblCurrentAmountSpear.setText(String.valueOf(game.ourKingdom.getSpear().getAmount()));
					    menuFrame.lblCurrentSpearAmount.setText(String.valueOf(game.ourKingdom.getSpear().getAmount()));
						JOptionPane.showMessageDialog(produceWeaponFrame.this,
		                        (returnCheck)+ " spears produced succesfully", "Produce Weapon",
		                        JOptionPane.INFORMATION_MESSAGE);
					}

				}else {
					JOptionPane.showMessageDialog(produceWeaponFrame.this,
	                        "Not enough money", "Produce Weapon",
	                        JOptionPane.ERROR_MESSAGE);
				}



				produceWeaponFrame.lblCurrentAmountGold.setText(String.valueOf(game.ourKingdom.getTreasure()));
			    menuFrame.lblCurrentGoldAmount.setText(String.valueOf(game.ourKingdom.getTreasure()));

				
			}
		});
		btnRecruit.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnRecruit.setToolTipText("");
		btnRecruit.setBounds(475, 329, 165, 43);
		panel.add(btnRecruit);
		
		JLabel lblAmountWeaponInput = new JLabel("Enter the amount of weapon");
		lblAmountWeaponInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountWeaponInput.setForeground(Color.WHITE);
		lblAmountWeaponInput.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblAmountWeaponInput.setBounds(340, 181, 408, 71);
		panel.add(lblAmountWeaponInput);
		
		final JLabel goldAmount= new JLabel("0");
		goldAmount.setHorizontalAlignment(SwingConstants.CENTER);
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(359, 382, 406, 43);
		panel.add(goldAmount);
		
		tfAmountBattalion = new JTextField();
		tfAmountBattalion.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		tfAmountBattalion.setBounds(414, 243, 279, 53);
		panel.add(tfAmountBattalion);
		tfAmountBattalion.setColumns(10);
		

			tfAmountBattalion.getDocument().addDocumentListener(new DocumentListener() {
				  public void changedUpdate(DocumentEvent a) {
					  try {
						  goldAmount.setText("+/-" + String.valueOf(Integer.parseInt(tfAmountBattalion.getText())*3));
					  }catch(NumberFormatException e) {
		                    JOptionPane.showMessageDialog(produceWeaponFrame.this,
		                            "You need to enter number","Try Again",
		                            JOptionPane.ERROR_MESSAGE);
					  }
				  }
				  public void removeUpdate(DocumentEvent a) {
					  
					  if(tfAmountBattalion.getText().equals("") || !isNumeric(tfAmountBattalion.getText())) {
						  return;
					  }
					  try {
						  goldAmount.setText("-" + String.valueOf(Integer.parseInt(tfAmountBattalion.getText())*3));
					  }catch(NumberFormatException e) {
		                    JOptionPane.showMessageDialog(produceWeaponFrame.this,
		                            "You need to enter number","Try Again",
		                            JOptionPane.ERROR_MESSAGE);
					  }
				  }
				  public void insertUpdate(DocumentEvent e) {
					  try {
						  goldAmount.setText("-" + String.valueOf(Integer.parseInt(tfAmountBattalion.getText())*3));
					  }catch(NumberFormatException a) {
		                    JOptionPane.showMessageDialog(produceWeaponFrame.this,
		                            "You need to enter number","Try Again",
		                            JOptionPane.ERROR_MESSAGE);
					  }
				  }

				});




		
		JLabel lblCurrentSword = new JLabel("Current amount of sword:");
		lblCurrentSword.setForeground(Color.WHITE);
		lblCurrentSword.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentSword.setBounds(20, 127, 222, 36);
		panel.add(lblCurrentSword);
		
		JLabel lblCurrentGoldAmount = new JLabel("Current gold amount:");
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(20, 336, 204, 36);
		panel.add(lblCurrentGoldAmount);
		
		lblCurrentAmountSpear = new JLabel(String.valueOf(Game.ourKingdom.getSpear().getAmount()));
		lblCurrentAmountSpear.setForeground(Color.WHITE);
		lblCurrentAmountSpear.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountSpear.setBounds(224, 260, 135, 36);
		panel.add(lblCurrentAmountSpear);
		
		lblCurrentAmountSword = new JLabel(String.valueOf(Game.ourKingdom.getSword().getAmount()));
		lblCurrentAmountSword.setForeground(Color.WHITE);
		lblCurrentAmountSword.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountSword.setBounds(237, 127, 122, 36);
		panel.add(lblCurrentAmountSword);
		
		cBWeaponType = new JComboBox();
		cBWeaponType.setFocusable(false);
		cBWeaponType.setModel(new DefaultComboBoxModel(new String[] {"Sword", "Spear", "Bow"}));
		cBWeaponType.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		cBWeaponType.setBounds(399, 143, 310, 43);
		panel.add(cBWeaponType);
		
		JLabel lblSelectTheWeapon = new JLabel("Select the weapon type");
		lblSelectTheWeapon.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheWeapon.setForeground(Color.WHITE);
		lblSelectTheWeapon.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblSelectTheWeapon.setBounds(357, 77, 408, 71);
		panel.add(lblSelectTheWeapon);
		
		JLabel lblCurrentSpear = new JLabel("Current amount of spear:");
		lblCurrentSpear.setForeground(Color.WHITE);
		lblCurrentSpear.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentSpear.setBounds(20, 260, 222, 36);
		panel.add(lblCurrentSpear);
		
		JLabel lblCurrentBow = new JLabel("Current amount of bow:");
		lblCurrentBow.setForeground(Color.WHITE);
		lblCurrentBow.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentBow.setBounds(20, 198, 222, 36);
		panel.add(lblCurrentBow);
		
		lblCurrentAmountBow = new JLabel(String.valueOf(Game.ourKingdom.getBow().getAmount()));
		lblCurrentAmountBow.setForeground(Color.WHITE);
		lblCurrentAmountBow.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountBow.setBounds(220, 198, 139, 36);
		panel.add(lblCurrentAmountBow);
		
		lblCurrentAmountGold = new JLabel(String.valueOf(game.ourKingdom.getTreasure()));
		lblCurrentAmountGold.setForeground(Color.WHITE);
		lblCurrentAmountGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountGold.setBounds(194, 336, 110, 36);
		panel.add(lblCurrentAmountGold);
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


