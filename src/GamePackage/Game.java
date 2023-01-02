package GamePackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import KingdomPackage.Kingdom;
import KingdomPackage.Region;
import KingdomPackage.Religion;
import PersonPackage.Ambassador;
import PersonPackage.Heir;
import PersonPackage.King;
import PersonPackage.Missionary;
import PersonPackage.Noble;
import PersonPackage.Spymaster;
import userInterface.menuFrame;

public class Game {
	public static Game GameInstance;
	public static Kingdom ourKingdom;
	public static int year;
	public static int taxesCounter;
	public static int feastCounter;
	public static boolean canMakeFeast;
	public static boolean canCollectTaxes;
	public static boolean isSavedGame = false;
	
	

	public Game(boolean save) {
		
		this.year = 1000;
		this.taxesCounter = 0;
		this.feastCounter = 0;
		this.canCollectTaxes = true;
		this.canMakeFeast = true;
		read(save);
		readNoblesAtCourt();
		
		
	}
	
	
	
	
	
	
	
	private void read(boolean save) {
		boolean ourKingdomRead = false;
	      File fileAmbassador = new File("src\\inputTxts\\ambassador.csv");
	      File fileHeirs = new File("src\\inputTxts\\heirs.csv");
	      File fileKing = new File("src\\inputTxts\\king.csv");
	      File fileMissionary = new File("src\\inputTxts\\missionary.csv");
	      File fileReligions = new File("src\\inputTxts\\religions.csv");
	      File fileSpyMaster = new File("src\\inputTxts\\spyMaster.csv");
	      File fileKingdom = new File("src\\inputTxts\\kingdom.csv");
	      File fileRegions= new File("src\\inputTxts\\regions.csv");
	      Scanner sc1 = null;
	      Scanner sc2 = null;
	      Scanner sc3 = null;
	      Scanner sc4 = null;
	      Scanner sc5 = null;
	      Scanner sc6 = null;
	      Scanner sc7 = null;
	      Scanner sc8 = null;
          try {
              sc1 = new Scanner(fileAmbassador);
              sc2 = new Scanner(fileHeirs );
              sc3 = new Scanner(fileKing);
              sc4 = new Scanner(fileMissionary);
              sc5 = new Scanner(fileReligions);
              sc6 = new Scanner(fileSpyMaster);
              sc7 = new Scanner(fileKingdom);
              while (sc1.hasNextLine()) {
                  String[] str1 = sc1.nextLine().split(";");
                  String[] str2 = sc2.nextLine().split(";");
                  String[] str3 = sc3.nextLine().split(";");
                  String[] str4 = sc4.nextLine().split(";");
                  String str5 = sc5.nextLine();    
                  String[] str6 = sc6.nextLine().split(";");
                  String[] str7 = sc7.nextLine().split(";");
                  
                  
                  
                 
                  Ambassador ambassador = new Ambassador(str1[0],Short.parseShort(str1[1]),str1[2]);
                  Heir heir = new Heir(str2[0],Short.parseShort(str2[1]),str2[2]);
                  King king = new King(str3[0],Short.parseShort(str3[1]),str3[2],Integer.parseInt(str3[3]));
                  Missionary missionary = new Missionary(str4[0],Short.parseShort(str4[1]),str4[2]);
                  Religion religion = new Religion(str5);
                  Spymaster spymaster = new Spymaster(str6[0],Short.parseShort(str6[1]),str6[2]);
                  
                  if(!ourKingdomRead) {
                	  ourKingdom = new Kingdom(str7[0],king,ambassador,heir,spymaster,missionary,religion,new Queue(3),Integer.parseInt(str7[1]),Integer.parseInt(str7[2]),Integer.parseInt(str7[3]),Integer.parseInt(str7[4]),new HashMap<Kingdom,Integer>(),Integer.parseInt(str7[5]),
                			  new ArrayList<Noble>());
                	  ourKingdomRead = true;
                  }else {
                	  Kingdom kingdom = new Kingdom(str7[0],king,ambassador,heir,spymaster,missionary,religion,new Queue(3),Integer.parseInt(str7[1]),Integer.parseInt(str7[2]),Integer.parseInt(str7[3]),Integer.parseInt(str7[4]),Integer.parseInt(str7[5]));
                	  Random random = new Random();
                	  ourKingdom.getRelationsWithOtherKingdoms().put(kingdom,random.nextInt(100));
                  }

                  
              }

          } catch (IOException exp) {
              exp.printStackTrace();
          }

         
          sc1.close();
          sc2.close();
          sc3.close();
          sc4.close();
          sc5.close();
          sc6.close();
          sc7.close();
          
          try {
			sc8 = new Scanner(fileRegions);
			
	
			for(Kingdom kingdom : ourKingdom.getRelationsWithOtherKingdoms().keySet()) {
				Queue regions = kingdom.getRegions();
				
				if(sc8.hasNextLine()) {
					String[] str = sc8.nextLine().split(";");
					Region region = new Region(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
					regions.enqueue(region);
					str = sc8.nextLine().split(";");
					region = new Region(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
					regions.enqueue(region);
					str = sc8.nextLine().split(";");
					region = new Region(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
					regions.enqueue(region);
					
					kingdom.setRegions(regions);
					
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          if(save) {
        	  loadFromSave();
          }
          
	}
	
	public void loadFromSave() {
        try {
            File ourKingdomFile = new File("src\\inputTxts\\ourKingdom.txt");
            Scanner scanner = new Scanner(ourKingdomFile);
            String[] parsedLine = scanner.nextLine().split(",");
            ourKingdom.setTreasure(Integer.parseInt(parsedLine[0]));
            ourKingdom.getInfantryBattalion().setNumberOfSoldiers(Integer.parseInt(parsedLine[1]));
            ourKingdom.getArcherBattalion().setNumberOfSoldiers(Integer.parseInt(parsedLine[2]));
            ourKingdom.getCavalryBattalion().setNumberOfSoldiers(Integer.parseInt(parsedLine[3]));
            ourKingdom.setPiety(Integer.parseInt(parsedLine[4]));
            ourKingdom.getKing().setPrestige(Integer.parseInt(parsedLine[5]));
            year = Integer.parseInt(parsedLine[6]);
            ourKingdom.getSword().setAmount((Integer.parseInt(parsedLine[7])));
            ourKingdom.getBow().setAmount((Integer.parseInt(parsedLine[8])));
            ourKingdom.getSpear().setAmount((Integer.parseInt(parsedLine[9])));
            Religion religion = new Religion(parsedLine[10]);
            ourKingdom.setReligion(religion);
            ourKingdom.setTaxRate((Integer.parseInt(parsedLine[11])));
            ourKingdom.setPopulation((Integer.parseInt(parsedLine[12])));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("The file could not be found.");
            System.exit(0);
        }

    }

    public static void saveData() {
        File kingdomFile = new File("src\\inputTxts\\ourKingdom.txt");
        try {
            FileWriter writer = new FileWriter(kingdomFile);
            writer.write(ourKingdom.getTreasure()+","+ourKingdom.getInfantryBattalion().getNumberOfSoldiers()+","+ourKingdom.getArcherBattalion().getNumberOfSoldiers()+","+ourKingdom.getCavalryBattalion().getNumberOfSoldiers()+","+ourKingdom.getPiety()+","+ourKingdom.getKing().getPrestige()+","+year
            		+ "," + ourKingdom.getSword().getAmount() + "," + ourKingdom.getBow().getAmount() + "," + ourKingdom.getSpear().getAmount()+ "," + ourKingdom.getReligion().getReligionName()+
            		"," + ourKingdom.getTaxRate() + "," + ourKingdom.calculatePopulation());
            isSavedGame = true;
            writer.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
	
	public static void spendAYear() {
		year += 1;
		ourKingdom.setPiety(ourKingdom.getPiety()-3);
		ourKingdom.getKing().setAge((short) (ourKingdom.getKing().getAge()+1));
		//upgradeOtherKingdomsStatusByYear();
		if(ourKingdom.atWar)
		{
			ourKingdom.howManyYearsLeftAtWar--;
			menuFrame.lblLeftWarYear.setText(String.valueOf(ourKingdom.howManyYearsLeftAtWar));
			ourKingdom.decreaseMilitaryPower();
			ourKingdom.kingdomAtWarAgainst.decreaseMilitaryPower();
			
		}
		if(!canCollectTaxes) {
			taxesCounter +=1;
			if(taxesCounter == 10) {
				taxesCounter = 0;
				canCollectTaxes = true;
			}
		
		}
		if(!canMakeFeast) {
			feastCounter +=1;
			if(feastCounter == 10) {
				feastCounter = 0;
				canMakeFeast = true;
			}
		
		}
		if(ourKingdom.getKing().getAge() >= 85) {
			
			King king = new King(ourKingdom.getHeir().getNAME(),ourKingdom.getHeir().getAge(),ourKingdom.getHeir().getFAMILY_NAME(),50);
			ourKingdom.setKing(king);
			menuFrame.lblKingName.setText(ourKingdom.getKing().getNAME()+ " " + ourKingdom.getKing().getFAMILY_NAME());
		}

	}
	/*public static void upgradeOtherKingdomsStatusByYear()
	{
		Set<Kingdom> kingdoms= ourKingdom.getRelationsWithOtherKingdoms().keySet();
		for(Kingdom i : kingdoms) {
			i.getArcherBattalion().setNumberOfSoldiers((int)(i.getArcherBattalion().getNumberOfSoldiers()*1.02f));
			i.getInfantryBattalion().setNumberOfSoldiers((int)(i.getInfantryBattalion().getNumberOfSoldiers()*1.02f));
			i.getCavalryBattalion().setNumberOfSoldiers((int)(i.getCavalryBattalion().getNumberOfSoldiers()*1.02f));
		}
		
	}*/
	public static void readNoblesAtCourt() {
		File nobleFile = new File("src\\inputTxts\\nobles.csv");
		Scanner scanner = null;
		try {
			scanner = new Scanner(nobleFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Noble> noblesAtCourt = ourKingdom.getNoblesAtCourt();
		while(scanner.hasNextLine()) {
			String[] splitLine = scanner.nextLine().split(",");
			if(splitLine.length == 3) {
				Noble newNoble = new Noble(splitLine[0],Short.parseShort(splitLine[1]),splitLine[2]);
				noblesAtCourt.add(newNoble);
				}
		}
		ourKingdom.setNoblesAtCourt(noblesAtCourt);
		
	}
	
}
