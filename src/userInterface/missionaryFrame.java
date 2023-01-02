package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GamePackage.Game;
import KingdomPackage.Kingdom;
import KingdomPackage.Religion;

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

public class missionaryFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					missionaryFrame frame = new missionaryFrame();
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
	public missionaryFrame() {
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
			comboBox.addItem(kingdom.getReligion());
		}
		comboBox.setBounds(135, 218, 546, 56);
		panel.add(comboBox);
		

		
		JLabel lblNewLabel = new JLabel("Select the religion you would like to convert");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNewLabel.setBounds(205, 125, 408, 71);
		panel.add(lblNewLabel);
		
		JLabel lblCurrentPiety = new JLabel("Current Piety:");
		lblCurrentPiety.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentPiety.setForeground(Color.WHITE);
		lblCurrentPiety.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentPiety.setBounds(10, 11, 182, 71);
		panel.add(lblCurrentPiety);
		
	    final JLabel lblCurrentPietyAmount = new JLabel("0");
		lblCurrentPietyAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentPietyAmount.setForeground(Color.WHITE);
		lblCurrentPietyAmount.setText(String.valueOf(Game.ourKingdom.getPiety()));
		lblCurrentPietyAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentPietyAmount.setBounds(135, 11, 182, 71);
		panel.add(lblCurrentPietyAmount);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean isConverted= Game.ourKingdom.OrderConvertReligion((Religion)comboBox.getSelectedItem());
				if(!isConverted)
				{
					JOptionPane.showMessageDialog(missionaryFrame.this,"Your piety is higher than 50. So religion is not converted.","Not Converted",JOptionPane.INFORMATION_MESSAGE);

				}
				else
				{
					lblCurrentPietyAmount.setText(String.valueOf(Game.ourKingdom.getPiety()));
					JOptionPane.showMessageDialog(missionaryFrame.this,"Your new religion is: "+Game.ourKingdom.getReligion() ,"Converted",JOptionPane.INFORMATION_MESSAGE);
					userInterface.menuFrame.lblCurrentReligionName.setText(String.valueOf(Game.ourKingdom.getReligion()));
				}
			}
		});
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(316, 308, 165, 43);
		panel.add(btnNewButton);
	}
}


