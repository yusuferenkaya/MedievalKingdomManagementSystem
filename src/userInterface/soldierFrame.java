package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class soldierFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					soldierFrame frame = new soldierFrame();
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
	public soldierFrame() {
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
		
		JButton btnRecruitSoldier = new JButton("Recruit soldier");
		btnRecruitSoldier.setFocusable(false);
		btnRecruitSoldier.setIcon(new ImageIcon(this.getClass().getResource("/recruit.png")));
		btnRecruitSoldier.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnRecruitSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recruitSoldierFrame recruitSoldierFrame = new recruitSoldierFrame();
			}
		});
		btnRecruitSoldier.setBounds(269, 148, 229, 46);
		panel.add(btnRecruitSoldier);
		
		JButton btnUpgradeSoldier = new JButton("Upgrade soldier");
		btnUpgradeSoldier.setFocusable(false);
		btnUpgradeSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upgradeSoldierFrame upgradeSoldierFrame = new upgradeSoldierFrame();
			}
		});
		btnUpgradeSoldier.setIcon(new ImageIcon(this.getClass().getResource("/upgrade.png")));
		btnUpgradeSoldier.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnUpgradeSoldier.setBounds(269, 246, 229, 46);
		panel.add(btnUpgradeSoldier);
		
		JLabel lblSoldierPhoto = new JLabel("");
		lblSoldierPhoto.setIcon(new ImageIcon(this.getClass().getResource("/soldier1.png")));
		lblSoldierPhoto.setBounds(-407, -15, 750, 1500);
		panel.add(lblSoldierPhoto);
		
		JLabel lblSoldierPhoto2 = new JLabel("");
		lblSoldierPhoto2.setIcon(new ImageIcon(this.getClass().getResource("/soldier2.png")));
		lblSoldierPhoto2.setBounds(279, -51, 720, 960);
		panel.add(lblSoldierPhoto2);
	}

}
