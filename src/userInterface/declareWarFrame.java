package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KingdomPackage.Kingdom;
import GamePackage.Game;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class declareWarFrame extends JFrame {


	private JPanel contentPane;
	Game game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Game game = new Game();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					declareWarFrame frame = new  declareWarFrame();
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
	public  declareWarFrame() {
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
		
		final JLabel lblCurrentAmountGold = new JLabel("0");
		lblCurrentAmountGold.setForeground(Color.WHITE);
		lblCurrentAmountGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountGold.setBounds(494, 41, 110, 36);
		panel.add(lblCurrentAmountGold);
		lblCurrentAmountGold.setText(String.valueOf(Game.ourKingdom.getTreasure()));
		
		JButton btnNewButton = new JButton("Declare war");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String declareWar = Game.ourKingdom.OrderDeclareWar((Kingdom)comboBox.getSelectedItem());
				if(declareWar.equals("War started")) {
					JOptionPane.showMessageDialog(declareWarFrame.this,"Now, you're at war with:"+comboBox.getSelectedItem(),"Declaring war",JOptionPane.INFORMATION_MESSAGE);
					userInterface.menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
					menuFrame.lblAtWarWith.setText(String.valueOf((Kingdom)comboBox.getSelectedItem()));
					menuFrame.lblLeftWarYear.setText(String.valueOf(game.ourKingdom.howManyYearsLeftAtWar));
					lblCurrentAmountGold.setText(String.valueOf(Game.ourKingdom.getTreasure()));
				}
				else {
					JOptionPane.showMessageDialog(declareWarFrame.this,declareWar,"Declaring war",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(316, 308, 165, 43);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select the kingdom you would like to declare war ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNewLabel.setBounds(205, 125, 408, 71);
		panel.add(lblNewLabel);
		
		JLabel goldAmount= new JLabel("2000");
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(362, 371, 94, 24);
		panel.add(goldAmount);
		
		JLabel lblCurrentGoldAmount = new JLabel("Current gold amount:");
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(306, 41, 204, 36);
		panel.add(lblCurrentGoldAmount);
		

	}
}


