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

public class manageTaxesFrame extends JFrame {

	Game game;
	private JPanel contentPane;
	private static JLabel lblCurrentAmountTaxesRate;
	private static JLabel lblCurrentAmountPrestige;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageTaxesFrame frame = new  manageTaxesFrame();
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
	public  manageTaxesFrame() {
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
		
		JButton btnIncrease = new JButton("Increase(+1)");
		btnIncrease.setFocusable(false);
		btnIncrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(Game.ourKingdom.getTaxRate() + 1 > 10)) {
					Game.ourKingdom.increaseTaxes(1);
					userInterface.manageTaxesFrame.lblCurrentAmountTaxesRate.setText(String.valueOf(Game.ourKingdom.getTaxRate()));
					userInterface.manageTaxesFrame.lblCurrentAmountPrestige.setText(String.valueOf(Game.ourKingdom.getKing().getPrestige()));
					menuFrame.lblCurrentTaxRateAmount.setText(String.valueOf(Game.ourKingdom.getTaxRate()));
					menuFrame.lblCurrentPrestigeAmount.setText(String.valueOf(Game.ourKingdom.getKing().getPrestige()));
					JOptionPane.showMessageDialog(manageTaxesFrame.this,
	                        "Tax rate increased successfully", "Tax Rate",
	                        JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(manageTaxesFrame.this,
	                        "Tax rate cannot be greater than 10", "Tax Rate",
	                        JOptionPane.ERROR_MESSAGE);
					
				}

           
			}
		});
		btnIncrease.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnIncrease.setToolTipText("");
		btnIncrease.setBounds(235, 309, 165, 43);
		panel.add(btnIncrease);
		
		JLabel lblText = new JLabel("Increase or decrease taxes");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblText.setBounds(221, 160, 408, 71);
		panel.add(lblText);
		
		JButton btnDecrease = new JButton("Decrease(-1)");
		btnDecrease.setFocusable(false);
		btnDecrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(Game.ourKingdom.getTaxRate() - 1 < 0)) {
					Game.ourKingdom.decreaseTaxes(1);
					userInterface.manageTaxesFrame.lblCurrentAmountTaxesRate.setText(String.valueOf(Game.ourKingdom.getTaxRate()));
					userInterface.manageTaxesFrame.lblCurrentAmountPrestige.setText(String.valueOf(Game.ourKingdom.getKing().getPrestige()));
					menuFrame.lblCurrentTaxRateAmount.setText(String.valueOf(Game.ourKingdom.getTaxRate()));
					menuFrame.lblCurrentPrestigeAmount.setText(String.valueOf(Game.ourKingdom.getKing().getPrestige()));
					JOptionPane.showMessageDialog(manageTaxesFrame.this,
	                        "Tax rate decreased successfully", "Tax Rate",
	                        JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(manageTaxesFrame.this,
	                        "Tax rate cannot be less than 0", "Tax Rate",
	                        JOptionPane.ERROR_MESSAGE);
					
				}
				
           
			}
		});
		btnDecrease.setToolTipText("");
		btnDecrease.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnDecrease.setBounds(452, 309, 165, 43);
		panel.add(btnDecrease);

		
		




		
		JLabel lblCurrentTax = new JLabel("Current amount of taxes:");
		lblCurrentTax.setForeground(Color.WHITE);
		lblCurrentTax.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentTax.setBounds(67, 31, 204, 36);
		panel.add(lblCurrentTax);
		
		JLabel lblCurrentPrestige = new JLabel("Current prestige point:");
		lblCurrentPrestige.setForeground(Color.WHITE);
		lblCurrentPrestige.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentPrestige.setBounds(500, 31, 204, 36);
		panel.add(lblCurrentPrestige);
		
		lblCurrentAmountTaxesRate = new JLabel(String.valueOf(Game.ourKingdom.getTaxRate()));
		lblCurrentAmountTaxesRate.setForeground(Color.WHITE);
		lblCurrentAmountTaxesRate.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountTaxesRate.setBounds(269, 31, 110, 36);
		panel.add(lblCurrentAmountTaxesRate);
		
		lblCurrentAmountPrestige = new JLabel(String.valueOf(game.ourKingdom.getKing().getPrestige()));
		lblCurrentAmountPrestige.setForeground(Color.WHITE);
		lblCurrentAmountPrestige.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountPrestige.setBounds(686, 31, 79, 36);
		panel.add(lblCurrentAmountPrestige);
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


