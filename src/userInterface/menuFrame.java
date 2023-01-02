package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import GamePackage.Game;
import KingdomPackage.Kingdom;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class menuFrame extends JFrame {
	
	public static JLabel lblCurrentYearAmount;
	public static JLabel lblCurrentGoldAmount;
	public static JLabel lblCurrentTaxRateAmount;
	public static JLabel lblCurrentPrestigeAmount;
	public static JLabel lblNumberArcherAmount;
	public static JLabel lblNumberInfantryAmount;
	public static JLabel lblNumberCavalryAmount;
	public static JLabel lblCurrentReligionName;
	public static JLabel lblCurrentSwordAmount;
	public static JLabel lblCurrentBowAmount;
	public static JLabel lblCurrentSpearAmount;
	public static JLabel lblCurrentAmountCastle;
	public static JLabel lblCurrentAmountWall;
	public static JLabel lblCurrentAmountDefPoint;
	public static JLabel lblCurrentAmountAttPoint;
	public static JLabel lblCastleLevelAmount;
	public static JLabel lblWallLevelAmount;
	public static JLabel lblAtWarWith;
	public static JLabel lblLeftWarYear;
	public static JLabel lblCurrentAllyName;
	public static  JLabel lblKingdomName;
	public static  JLabel lblKingName;

	private JPanel contentPane;
	JPanel panelSecondPage = new JPanel();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public menuFrame(boolean save) {
		final Game Game = new Game(save);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1027, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Enchanted Land.otf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		
		final JPanel panelFirstPage = new JPanel();
		panelFirstPage.setBackground(new Color(43,54,60));
		panelFirstPage.setBounds(0, 0, 238, 476);
		contentPane.add(panelFirstPage);
		panelFirstPage.setLayout(null);
		
		JButton btnAmbassador = new JButton("Ambassador");
		btnAmbassador.setFocusable(false);
		btnAmbassador.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnAmbassador.setIcon(new ImageIcon(this.getClass().getResource("/ambassador.png")));
		btnAmbassador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Game.ourKingdom.getAmbassador() != null) {
					ambassadorFrame ambassadorFrame = new ambassadorFrame();

				}
				else {
					JOptionPane.showMessageDialog(menuFrame.this, "You do not have an ambassador, so you can't progress further.");
					}
				}
		});
		btnAmbassador.setBackground(Color.WHITE);
		btnAmbassador.setBounds(0, 180, 238, 56);
		panelFirstPage.add(btnAmbassador);
		
		JButton btnSoldier = new JButton("Soldier");
		btnSoldier.setFocusable(false);
		btnSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				soldierFrame soldierFrame = new soldierFrame();
			}
		});
		btnSoldier.setIcon(new ImageIcon(this.getClass().getResource("/soldier.png")));
		btnSoldier.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnSoldier.setBackground(Color.WHITE);
		btnSoldier.setBounds(0, 234, 238, 56);
		panelFirstPage.add(btnSoldier);
		
		JButton btnWeapon = new JButton("Weapon");
		btnWeapon.setFocusable(false);
		btnWeapon.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnWeapon.setIcon(new ImageIcon(this.getClass().getResource("/weapon.png")));
		btnWeapon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produceWeaponFrame produceWeaponFrame = new produceWeaponFrame();
			}
		});
		btnWeapon.setBackground(Color.WHITE);
		btnWeapon.setBounds(0, 285, 238, 56);
		panelFirstPage.add(btnWeapon);
		
		JButton btnStructure = new JButton("Structure");
		btnStructure.setFocusable(false);
		btnStructure.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnStructure.setIcon(new ImageIcon(this.getClass().getResource("/structure.png")));
		btnStructure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				structureFrame structureFrame = new structureFrame();
				
		
			}
		});
		btnStructure.setBackground(Color.WHITE);
		btnStructure.setBounds(0, 340, 238, 56);
		panelFirstPage.add(btnStructure);
		
		JButton btnTaxes = new JButton("Taxes");
		btnTaxes.setFocusable(false);
		btnTaxes.setIcon(new ImageIcon(this.getClass().getResource("/taxes.png")));
		btnTaxes.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnTaxes.setBackground(Color.WHITE);
		btnTaxes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taxesFrame taxesFrame = new taxesFrame();
				
			}
		});
		btnTaxes.setBounds(0, 125, 238, 56);
		panelFirstPage.add(btnTaxes);
		
		JButton btnSpendAYear = new JButton("Spend a year");
		btnSpendAYear.setFocusable(false);
		btnSpendAYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int oldKingdomAttack=0;
				int oldKingdomDefence=0;
				int oldKingdomAttackEnemy=0;
				int oldKingdomDefenceEnemy=0;
				if(Game.ourKingdom.atWar)
				{
	    		 oldKingdomAttack=Game.ourKingdom.getKingdomAttack();
	    		 oldKingdomDefence=Game.ourKingdom.getKingdomDefence();
	    		 oldKingdomAttackEnemy=Game.ourKingdom.kingdomAtWarAgainst.getKingdomAttack();
	    		 oldKingdomDefenceEnemy=Game.ourKingdom.kingdomAtWarAgainst.getKingdomDefence();
				}
				Game.spendAYear();
				lblCurrentYearAmount.setText(String.valueOf(Game.year));
				lblCurrentAmountAttPoint.setText(String.valueOf(Game.ourKingdom.getKingdomAttack()));
				lblCurrentAmountDefPoint.setText(String.valueOf(Game.ourKingdom.getKingdomDefence()));
				lblNumberCavalryAmount.setText(String.valueOf(Game.ourKingdom.getCavalryBattalion().getNumberOfSoldiers()));
			    lblCurrentSpearAmount.setText(String.valueOf(Game.ourKingdom.getSpear().getAmount()));
			    lblNumberInfantryAmount.setText(String.valueOf(Game.ourKingdom.getInfantryBattalion().getNumberOfSoldiers()));
			    lblCurrentSwordAmount.setText(String.valueOf(Game.ourKingdom.getSword().getAmount()));
			    lblNumberArcherAmount.setText(String.valueOf(Game.ourKingdom.getArcherBattalion().getNumberOfSoldiers()));
			    lblCurrentBowAmount.setText(String.valueOf(Game.ourKingdom.getBow().getAmount()));
			    if(Game.ourKingdom.atWar)
				{
	    		oldKingdomAttack-=Game.ourKingdom.getKingdomAttack();
	    		oldKingdomDefence-=Game.ourKingdom.getKingdomDefence();
	    		oldKingdomAttackEnemy-=Game.ourKingdom.kingdomAtWarAgainst.getKingdomAttack();
	    		oldKingdomDefenceEnemy-=Game.ourKingdom.kingdomAtWarAgainst.getKingdomDefence();
				}
	    		if(Game.ourKingdom.atWar)
	    		{
	    	    JOptionPane.showMessageDialog(menuFrame.this,
	                    "You have lost "+oldKingdomAttack+" kingdom attack and "+oldKingdomDefence+" kingdom defence.\n"
	                    +"Your enemy have lost "+oldKingdomAttackEnemy+" kingdom attack and "+oldKingdomDefenceEnemy+" kingdom defence.", "War",
	                    JOptionPane.INFORMATION_MESSAGE);
	    	    if(Game.ourKingdom.howManyYearsLeftAtWar==0)
	    	    {

					Game.ourKingdom.atWar=false;
					Game.ourKingdom.kingdomAtWarAgainst = null;
					if(oldKingdomAttack>=oldKingdomAttackEnemy)
					{
						JOptionPane.showMessageDialog(menuFrame.this,
			                    "You have lost the war. Your have lost "+(int)(Game.ourKingdom.getTreasure()*0.2f)+" treasure.", "War Finished",
			                    JOptionPane.INFORMATION_MESSAGE);
						Game.ourKingdom.setTreasure((int)(Game.ourKingdom.getTreasure()*0.8f));
					}
					else
					{
						JOptionPane.showMessageDialog(menuFrame.this,
			                    "You have won the war. Your have gained "+(int)(Game.ourKingdom.getTreasure()*0.2f)+" treasure.", "War Finished",
			                    JOptionPane.INFORMATION_MESSAGE);
						Game.ourKingdom.setTreasure((int)(Game.ourKingdom.getTreasure()*1.2f));
					}
					lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
					
	    	    	menuFrame.lblAtWarWith.setText("None");
	    		}
	    	    }
	    	}
		});
		btnSpendAYear.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnSpendAYear.setIcon(new ImageIcon(this.getClass().getResource("/time.png")));
		btnSpendAYear.setBackground(Color.WHITE);
		btnSpendAYear.setBounds(0, 45, 238, 56);
		panelFirstPage.add(btnSpendAYear);
		
		JButton btnNext = new JButton("");
		btnNext.setFocusable(false);
		btnNext.setIcon(new ImageIcon(this.getClass().getResource("/next.png")));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFirstPage.setVisible(false);
				panelSecondPage.setBounds(0, 0, 238, 486);
				panelSecondPage.setVisible(true);
				
			}
		});
		btnNext.setBackground(Color.WHITE);
		btnNext.setBounds(126, 406, 75, 56);
		panelFirstPage.add(btnNext);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(43,54,60));
		panelInfo.setBounds(236, 0, 777, 476);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblCurrentYear = new JLabel("Current Year:");
		lblCurrentYear.setForeground(Color.WHITE);
		lblCurrentYear.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentYear.setBounds(21, 42, 150, 50);
		panelInfo.add(lblCurrentYear);
		
		lblCurrentYearAmount = new JLabel(String.valueOf(Game.year));
		lblCurrentYearAmount.setForeground(Color.WHITE);
		lblCurrentYearAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentYearAmount.setBounds(140, 42, 108, 50);
		panelInfo.add(lblCurrentYearAmount);
		
		JLabel lblCurrentGold = new JLabel("Current Gold:");
		lblCurrentGold.setForeground(Color.WHITE);
		lblCurrentGold.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGold.setBounds(21, 102, 150, 50);
		panelInfo.add(lblCurrentGold);
		
	    lblCurrentGoldAmount = new JLabel(String.valueOf(Game.ourKingdom.getTreasure()));
		lblCurrentGoldAmount.setForeground(Color.WHITE);
		lblCurrentGoldAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentGoldAmount.setBounds(140, 102, 120, 50);
		panelInfo.add(lblCurrentGoldAmount);
		
		JLabel lblCurrentPrestige = new JLabel("Current Prestige:");
		lblCurrentPrestige.setForeground(Color.WHITE);
		lblCurrentPrestige.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentPrestige.setBounds(21, 162, 150, 50);
		panelInfo.add(lblCurrentPrestige);
		
		lblCurrentPrestigeAmount = new JLabel(String.valueOf(Game.ourKingdom.getKing().getPrestige()));
		lblCurrentPrestigeAmount.setForeground(Color.WHITE);
		lblCurrentPrestigeAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentPrestigeAmount.setBounds(167, 162, 82, 50);
		panelInfo.add(lblCurrentPrestigeAmount);
		
		JLabel lblCurrentTaxRate = new JLabel("Current Tax Rate:");
		lblCurrentTaxRate.setForeground(Color.WHITE);
		lblCurrentTaxRate.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentTaxRate.setBounds(21, 222, 150, 50);
		panelInfo.add(lblCurrentTaxRate);
		
		lblCurrentTaxRateAmount = new JLabel(String.valueOf(Game.ourKingdom.getTaxRate()));
		lblCurrentTaxRateAmount.setForeground(Color.WHITE);
		lblCurrentTaxRateAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentTaxRateAmount.setBounds(177, 222, 73, 50);
		panelInfo.add(lblCurrentTaxRateAmount);
		
		JLabel lblNumberOfArchers = new JLabel("Number of Archers:");
		lblNumberOfArchers.setForeground(Color.WHITE);
		lblNumberOfArchers.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberOfArchers.setBounds(485, 102, 211, 50);
		panelInfo.add(lblNumberOfArchers);
		
		JLabel lblNumberOfInfantries = new JLabel("Number of Infantries:");
		lblNumberOfInfantries.setForeground(Color.WHITE);
		lblNumberOfInfantries.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberOfInfantries.setBounds(485, 42, 211, 50);
		panelInfo.add(lblNumberOfInfantries);
		
		JLabel lblNumberOfCavalries = new JLabel("Number of Cavalries:");
		lblNumberOfCavalries.setForeground(Color.WHITE);
		lblNumberOfCavalries.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberOfCavalries.setBounds(485, 162, 211, 50);
		panelInfo.add(lblNumberOfCavalries);
		
		lblNumberArcherAmount = new JLabel(String.valueOf(Game.ourKingdom.getArcherBattalion().getNumberOfSoldiers()));
		lblNumberArcherAmount.setForeground(Color.WHITE);
		lblNumberArcherAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberArcherAmount.setBounds(669, 102, 105, 50);
		panelInfo.add(lblNumberArcherAmount);
		
		lblNumberInfantryAmount = new JLabel(String.valueOf(Game.ourKingdom.getInfantryBattalion().getNumberOfSoldiers()));
		lblNumberInfantryAmount.setForeground(Color.WHITE);
		lblNumberInfantryAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberInfantryAmount.setBounds(669, 42, 105, 50);
		panelInfo.add(lblNumberInfantryAmount);
		
		lblNumberCavalryAmount = new JLabel(String.valueOf(Game.ourKingdom.getCavalryBattalion().getNumberOfSoldiers()));
		lblNumberCavalryAmount.setForeground(Color.WHITE);
		lblNumberCavalryAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberCavalryAmount.setBounds(669, 162, 105, 50);
		panelInfo.add(lblNumberCavalryAmount);

		JLabel lblCurrentReligion = new JLabel("Current Religion: ");
		lblCurrentReligion.setForeground(Color.WHITE);
		lblCurrentReligion.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentReligion.setBounds(21, 282, 211, 50);
		panelInfo.add(lblCurrentReligion);
		
		lblCurrentReligionName = new JLabel(Game.ourKingdom.getReligion().getReligionName());
		lblCurrentReligionName.setForeground(Color.WHITE);
		lblCurrentReligionName.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentReligionName.setBounds(167, 282, 89, 50);
		panelInfo.add(lblCurrentReligionName);
		
		JLabel lblNumberOfBow = new JLabel("Number of Bows:");
		lblNumberOfBow.setForeground(Color.WHITE);
		lblNumberOfBow.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberOfBow.setBounds(485, 282, 211, 50);
		panelInfo.add(lblNumberOfBow);
		
		JLabel lblNumberOfSwords = new JLabel("Number of Swords:");
		lblNumberOfSwords.setForeground(Color.WHITE);
		lblNumberOfSwords.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberOfSwords.setBounds(485, 222, 211, 50);
		panelInfo.add(lblNumberOfSwords);
		
		JLabel lblNumberOfSpears = new JLabel("Number of Spears:");
		lblNumberOfSpears.setForeground(Color.WHITE);
		lblNumberOfSpears.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblNumberOfSpears.setBounds(485, 343, 211, 50);
		panelInfo.add(lblNumberOfSpears);
		
		lblCurrentBowAmount = new JLabel(String.valueOf(Game.ourKingdom.getBow().getAmount()));
		lblCurrentBowAmount.setForeground(Color.WHITE);
		lblCurrentBowAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentBowAmount.setBounds(637, 282, 108, 50);
		panelInfo.add(lblCurrentBowAmount);
		
		lblCurrentSwordAmount = new JLabel(String.valueOf(Game.ourKingdom.getSword().getAmount()));
		lblCurrentSwordAmount.setForeground(Color.WHITE);
		lblCurrentSwordAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentSwordAmount.setBounds(654, 222, 105, 50);
		panelInfo.add(lblCurrentSwordAmount);
		
		lblCurrentSpearAmount = new JLabel(String.valueOf(Game.ourKingdom.getSpear().getAmount()));
		lblCurrentSpearAmount.setForeground(Color.WHITE);
		lblCurrentSpearAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentSpearAmount.setBounds(647, 342, 120, 50);
		panelInfo.add(lblCurrentSpearAmount);
		

		
		JLabel lblDefencePoint = new JLabel("Defence Point:");
		lblDefencePoint.setForeground(Color.WHITE);
		lblDefencePoint.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblDefencePoint.setBounds(253, 222, 211, 50);
		panelInfo.add(lblDefencePoint);
		
		JLabel lblTtackPoint = new JLabel("Attack Point:");
		lblTtackPoint.setForeground(Color.WHITE);
		lblTtackPoint.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblTtackPoint.setBounds(253, 162, 211, 50);
		panelInfo.add(lblTtackPoint);
		
		lblCurrentAmountAttPoint = new JLabel(String.valueOf(Game.ourKingdom.getKingdomAttack()));
		lblCurrentAmountAttPoint.setForeground(Color.WHITE);
		lblCurrentAmountAttPoint.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountAttPoint.setBounds(378, 162, 117, 50);
		panelInfo.add(lblCurrentAmountAttPoint);
		
		lblCurrentAmountDefPoint = new JLabel(String.valueOf(Game.ourKingdom.getKingdomDefence()));
		lblCurrentAmountDefPoint.setForeground(Color.WHITE);
		lblCurrentAmountDefPoint.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAmountDefPoint.setBounds(388, 222, 117, 50);
		panelInfo.add(lblCurrentAmountDefPoint);
		
		JLabel lblCastleLevel = new JLabel("Castle level:");
		lblCastleLevel.setForeground(Color.WHITE);
		lblCastleLevel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCastleLevel.setBounds(253, 42, 222, 49);
		panelInfo.add(lblCastleLevel);
		
		JLabel lblWallLevel = new JLabel("Wall level:");
		lblWallLevel.setForeground(Color.WHITE);
		lblWallLevel.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblWallLevel.setBounds(253, 101, 222, 51);
		panelInfo.add(lblWallLevel);
		
		
		if(Game.ourKingdom.getCastle() != null) {
			lblCastleLevelAmount = new JLabel(String.valueOf(Game.ourKingdom.getCastle().getLevel()));
		}else {
			lblCastleLevelAmount  = new JLabel("0");
		}
		lblCastleLevelAmount.setForeground(Color.WHITE);
		lblCastleLevelAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCastleLevelAmount.setBounds(355, 42, 117, 50);
		panelInfo.add(lblCastleLevelAmount);
		
		if(Game.ourKingdom.getWall() != null) {
			lblWallLevelAmount = new JLabel(String.valueOf(Game.ourKingdom.getWall().getLevel()));
		}else {
			lblWallLevelAmount = new JLabel("0");
		}
		
		lblWallLevelAmount.setForeground(Color.WHITE);
		lblWallLevelAmount.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblWallLevelAmount.setBounds(340, 102, 117, 50);
		panelInfo.add(lblWallLevelAmount);
		
		JLabel lblAtWar = new JLabel("War Against: ");
		lblAtWar.setForeground(Color.WHITE);
		lblAtWar.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblAtWar.setBounds(21, 342, 211, 50);
		panelInfo.add(lblAtWar);
		
		if(Game.ourKingdom.kingdomAtWarAgainst !=null) {
			lblAtWarWith = new JLabel(Game.ourKingdom.kingdomAtWarAgainst.toString());
		}else {
			lblAtWarWith = new JLabel("None");
		}

		lblAtWarWith.setForeground(Color.WHITE);
		lblAtWarWith.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblAtWarWith.setBounds(140, 343, 211, 50);
		panelInfo.add(lblAtWarWith);
		
		
		JLabel lblRemainingWar = new JLabel("Remaining war year: ");
		lblRemainingWar.setForeground(Color.WHITE);
		lblRemainingWar.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblRemainingWar.setBounds(21, 402, 211, 50);
		panelInfo.add(lblRemainingWar);
		
		if(!Game.ourKingdom.atWar) {
			lblLeftWarYear = new JLabel("0");
		}else {
			lblLeftWarYear = new JLabel(String.valueOf(Game.ourKingdom.howManyYearsLeftAtWar));
		}
		lblLeftWarYear.setForeground(Color.WHITE);
		lblLeftWarYear.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblLeftWarYear.setBounds(196, 402, 89, 50);
		panelInfo.add(lblLeftWarYear);
		
		JLabel lblCurrentAlly = new JLabel("Ally:");
		lblCurrentAlly.setForeground(Color.WHITE);
		lblCurrentAlly.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAlly.setBounds(485, 403, 211, 50);
		panelInfo.add(lblCurrentAlly);
		
		if(Game.ourKingdom.getAllyKingdom() != null) {
			lblCurrentAllyName = new JLabel(Game.ourKingdom.getAllyKingdom().toString());
		}else {
			lblCurrentAllyName = new JLabel("None");
		}
		lblCurrentAllyName.setForeground(Color.WHITE);
		lblCurrentAllyName.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCurrentAllyName.setBounds(537, 403, 208, 50);
		panelInfo.add(lblCurrentAllyName);
		
		JLabel lblCastle = new JLabel("");
		lblCastle.setIcon(new ImageIcon(this.getClass().getResource("/castle.png")));
		lblCastle.setForeground(Color.WHITE);
		lblCastle.setFont(new Font("Enchanted Land", Font.PLAIN, 30));
		lblCastle.setBounds(295, 222, 239, 184);
		panelInfo.add(lblCastle);
		
		lblKingdomName = new JLabel(String.valueOf(Game.ourKingdom.getKingdomName()));
		lblKingdomName.setHorizontalAlignment(SwingConstants.CENTER);
		lblKingdomName.setForeground(Color.WHITE);
		lblKingdomName.setFont(new Font("Enchanted Land", Font.PLAIN, 25));
		lblKingdomName.setBounds(242, 376, 211, 50);
		panelInfo.add(lblKingdomName);
		
		lblKingName = new JLabel(String.valueOf(Game.ourKingdom.getKing().getNAME() + Game.ourKingdom.getKing().getFAMILY_NAME()));
		lblKingName.setHorizontalAlignment(SwingConstants.CENTER);
		lblKingName.setForeground(Color.WHITE);
		lblKingName.setFont(new Font("Enchanted Land", Font.PLAIN, 25));
		lblKingName.setBounds(242, 416, 211, 50);
		panelInfo.add(lblKingName);
		

		
		panelSecondPage.setVisible(false);
		panelSecondPage.setBounds(236, 0, 238, 476);
		contentPane.add(panelSecondPage);
		panelSecondPage.setBackground(new Color(43,54,60));
		panelSecondPage.setLayout(null);
		
		JButton btnSpendAYear_1 = new JButton("Spend a year");
		btnSpendAYear_1.setFocusable(false);
		btnSpendAYear_1.setIcon(new ImageIcon(this.getClass().getResource("/time.png")));
		btnSpendAYear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.spendAYear();
				lblCurrentYearAmount.setText(String.valueOf(Game.year));
				
			}
		});
		btnSpendAYear_1.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnSpendAYear_1.setBackground(Color.WHITE);
		btnSpendAYear_1.setBounds(0, 45, 238, 56);
		panelSecondPage.add(btnSpendAYear_1);
		
		JButton btnExile = new JButton("Exile");
		btnExile.setFocusable(false);
		btnExile.setIcon(new ImageIcon(this.getClass().getResource("/exile.png")));
		btnExile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exileFrame exileFrame = new exileFrame();
			}
		});
		btnExile.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnExile.setBackground(Color.WHITE);
		btnExile.setBounds(0, 125, 238, 56);
		panelSecondPage.add(btnExile);
		
		JButton btnMissionary = new JButton("Missionary");
		btnMissionary.setFocusable(false);
		btnMissionary.setIcon(new ImageIcon(this.getClass().getResource("/missionary.png")));
		btnMissionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				missionaryFrame missionaryFrame = new missionaryFrame();
			}
		});
		btnMissionary.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnMissionary.setBackground(Color.WHITE);
		btnMissionary.setBounds(0, 180, 238, 56);
		panelSecondPage.add(btnMissionary);
		
		JButton btnFeast = new JButton("Feast");
		btnFeast.setFocusable(false);
		btnFeast.setIcon(new ImageIcon(this.getClass().getResource("/feast.png")));
		btnFeast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prestigeBeforeFeast = Game.ourKingdom.getKing().getPrestige();
				if(Game.ourKingdom.makeFeast()) {
					lblCurrentPrestigeAmount.setText(String.valueOf(Game.ourKingdom.getKing().getPrestige()));
					JOptionPane.showMessageDialog(menuFrame.this,
                            "You made your feast, prestige increased with "+ (Game.ourKingdom.getKing().getPrestige()-prestigeBeforeFeast), "Make Feast",
                            JOptionPane.INFORMATION_MESSAGE);
					lblCurrentGoldAmount.setText(String.valueOf(Game.ourKingdom.getTreasure()));
                }
				else {
					JOptionPane.showMessageDialog(menuFrame.this,
                            "You cannot make feast, wait " + (10 - Game.feastCounter) + " year(s) ","Make Feast",
                            JOptionPane.ERROR_MESSAGE);
                }
			
			}
			
		});
		btnFeast.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnFeast.setBackground(Color.WHITE);
		btnFeast.setBounds(0, 234, 238, 56);
		panelSecondPage.add(btnFeast);
		
		JButton btnSpy = new JButton("Spy");
		btnSpy.setFocusable(false);
		btnSpy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spyFrame spyFrame = new spyFrame();

			}
		});
		btnSpy.setIcon(new ImageIcon(this.getClass().getResource("/spy.png")));
		btnSpy.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnSpy.setBackground(Color.WHITE);
		btnSpy.setBounds(0, 288, 238, 56);
		panelSecondPage.add(btnSpy);
		
		JButton btnBack = new JButton("");
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFirstPage.setVisible(true);
				panelSecondPage.setVisible(false);
				panelSecondPage.setBounds(236, 0, 238, 476);
			}
		});
		btnBack.setIcon(new ImageIcon(this.getClass().getResource("/back.png")));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(39, 406, 75, 56);
		panelSecondPage.add(btnBack);
		
		
		JButton btnExit = new JButton("Save & Exit");
		btnExit.setIcon(new ImageIcon(this.getClass().getResource("/button_exit.png")));
		btnExit.setFocusable(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GamePackage.Game.saveData();
				dispose();
			}
		});
		btnExit.setFont(new Font("Enchanted Land", Font.PLAIN, 20));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(0, 340, 238, 56);
		panelSecondPage.add(btnExit);

	}
}
