package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class makePeaceFrame extends JFrame {

	private JPanel contentPane;
	private static JLabel lblAtWarName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					makePeaceFrame frame = new  makePeaceFrame();
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
	public  makePeaceFrame() {
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
		final JLabel lblCurrentAmountGold = new JLabel("0");
		lblCurrentAmountGold.setForeground(Color.WHITE);
		lblCurrentAmountGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountGold.setBounds(461, 135, 110, 36);
		panel.add(lblCurrentAmountGold);
		lblCurrentAmountGold.setText(String.valueOf(Game.ourKingdom.getTreasure()));
		JButton btnNewButton = new JButton("Make peace");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = Game.ourKingdom.OrderMakePeace();
				if(result.equals("AtWar"))
				{
	    	    	menuFrame.lblAtWarWith.setText("None");
	    			menuFrame.lblLeftWarYear.setText("0");
	    			lblAtWarName.setText("None");
					JOptionPane.showMessageDialog(makePeaceFrame.this,
		                    "Now you're in peace.", "Peace",
		                    JOptionPane.INFORMATION_MESSAGE);
					userInterface.menuFrame.lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
					lblCurrentAmountGold.setText(String.valueOf(Game.ourKingdom.getTreasure()));

				}
				else
					JOptionPane.showMessageDialog(makePeaceFrame.this,
		                    result, "Peace",
		                    JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(316, 288, 165, 43);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("You are at war with:\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNewLabel.setBounds(197, 181, 302, 71);
		panel.add(lblNewLabel);
		
		JLabel goldAmount= new JLabel("2000");
		goldAmount.setForeground(Color.WHITE);
		goldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		goldAmount.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		goldAmount.setBounds(356, 362, 94, 24);
		panel.add(goldAmount);
		
		lblAtWarName = new JLabel("None");
		lblAtWarName.setForeground(Color.WHITE);
		lblAtWarName.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblAtWarName.setBounds(461, 206, 288, 21);
		panel.add(lblAtWarName);
		if(Game.ourKingdom.atWar)
		{
			lblAtWarName.setText(Game.ourKingdom.kingdomAtWarAgainst.getKingdomName());
		}
		
		JLabel lblCurrentGoldAmount = new JLabel("Current gold amount:");
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(268, 135, 204, 36);
		panel.add(lblCurrentGoldAmount);
		


	}
}


