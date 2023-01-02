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

public class structureFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					structureFrame frame = new structureFrame();
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
	public structureFrame() {
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
		
		JButton btnBuildStructure = new JButton("Build structure");
		btnBuildStructure.setFocusable(false);
		btnBuildStructure.setIcon(new ImageIcon(this.getClass().getResource("/buildStructure.png")));
		btnBuildStructure.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnBuildStructure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildStructureFrame buildStructureFrame = new buildStructureFrame();
			}
		});
		btnBuildStructure.setBounds(269, 148, 229, 46);
		panel.add(btnBuildStructure);
		
		JButton btnUpgradeStructure = new JButton("Upgrade structure");
		btnUpgradeStructure.setFocusable(false);
		btnUpgradeStructure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upgradeStructureFrame upgradeStructureFrame = new upgradeStructureFrame();
			}
		});
		btnUpgradeStructure.setIcon(new ImageIcon(this.getClass().getResource("/upgrade.png")));
		btnUpgradeStructure.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnUpgradeStructure.setBounds(269, 246, 229, 46);
		panel.add(btnUpgradeStructure);
	}

}
