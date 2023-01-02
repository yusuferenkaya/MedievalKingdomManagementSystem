package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GamePackage.Game;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ambassadorFrame extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ambassadorFrame frame = new ambassadorFrame();
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
	public ambassadorFrame() {
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
		panel.setBounds(0, 0, 799, 485);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDeclareWar = new JButton("Declare war");
		btnDeclareWar.setFocusable(false);
		btnDeclareWar.setIcon(new ImageIcon(this.getClass().getResource("/war.png")));
		btnDeclareWar.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnDeclareWar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				declareWarFrame declareWarFrame = new declareWarFrame();
			}
		});
		btnDeclareWar.setBounds(158, 250, 229, 46);
		panel.add(btnDeclareWar);
		
		JButton btnIncreaseRelations = new JButton("Manage relations");
		btnIncreaseRelations.setFocusable(false);
		btnIncreaseRelations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageRelationFrame manageRelationFrame = new manageRelationFrame();
			}
		});
		btnIncreaseRelations.setIcon(new ImageIcon(this.getClass().getResource("/increase.png")));
		btnIncreaseRelations.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnIncreaseRelations.setBounds(158, 329, 229, 46);
		panel.add(btnIncreaseRelations);
		
		JButton btnBuildAlliance = new JButton("Build alliance");
		btnBuildAlliance.setFocusable(false);
		btnBuildAlliance.setIcon(new ImageIcon(this.getClass().getResource("/alliance.png")));
		btnBuildAlliance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildAllianceFrame buildAllianceFrame = new buildAllianceFrame();
			}
		});
		btnBuildAlliance.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnBuildAlliance.setBounds(426, 329, 229, 46);
		panel.add(btnBuildAlliance);
		
		JButton btnMakePeace = new JButton("Make peace");
		btnMakePeace.setFocusable(false);
		btnMakePeace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makePeaceFrame makePeaceFrame = new makePeaceFrame();
			}
		});
		btnMakePeace.setIcon(new ImageIcon(this.getClass().getResource("/peace.png")));
		btnMakePeace.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnMakePeace.setBounds(426, 250, 229, 46);
		panel.add(btnMakePeace);
		
		JLabel lblCurrentAmbassador = new JLabel("Current Ambassador:");
		lblCurrentAmbassador.setForeground(Color.WHITE);
		lblCurrentAmbassador.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmbassador.setBounds(227, 41, 204, 36);
		panel.add(lblCurrentAmbassador);
		
		JLabel lblCurrentAmbassadorName = new JLabel("0");
		lblCurrentAmbassadorName.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmbassadorName.setForeground(Color.WHITE);
		lblCurrentAmbassadorName.setBounds(422, 41, 274, 36);
		panel.add(lblCurrentAmbassadorName);
		
		lblCurrentAmbassadorName.setText(Game.ourKingdom.getAmbassador().getNAME()+" "+Game.ourKingdom.getAmbassador().getFAMILY_NAME());
		
		JLabel lblAmbassador = new JLabel("");
		lblAmbassador.setIcon(new ImageIcon(this.getClass().getResource("/ambassador2.png")));
		lblAmbassador.setBounds(316, 88, 200, 310);
		panel.add(lblAmbassador);
	}

}
