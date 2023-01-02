package KingdomPackage;

import ArmyPackage.ArcherBattalion;
import ArmyPackage.Battalion;
import ArmyPackage.CavalryBattalion;
import ArmyPackage.InfantryBattalion;
import GamePackage.Game;
import PersonPackage.*;
import StructurePackage.Castle;
import StructurePackage.Wall;
import WeaponPackage.Bow;
import WeaponPackage.Spear;
import WeaponPackage.Sword;
import userInterface.menuFrame;
import userInterface.recruitSoldierFrame;
import GamePackage.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import javax.swing.JOptionPane;

public class Kingdom implements KingdomInterface {

	Game game;
    private Castle castle;
    private Wall wall;
    private int population;
    private King king;
    private String kingdomName; 
    private Ambassador ambassador;
    private Heir heir;
    private Spymaster spymaster;
    private Missionary missionary;
    private Religion religion;
    private Queue regions;
    private int numberOfPeasants;
    private int numberOfSoldiers;
    private int numberOfWeapons;
    private static int treasure;
    private HashMap<Kingdom,Integer> relationsWithOtherKingdoms;
    private Kingdom allyKingdom;
    public boolean atWar;
    public int howManyYearsLeftAtWar;
    public Kingdom kingdomAtWarAgainst;
    private int taxRate;
    private int piety;
    private int kingdomDefence;
    private int kingdomAttack;
    private ArrayList<Noble> noblesAtCourt;

    
    
    private InfantryBattalion infantryBattalion;
    private ArcherBattalion archerBattalion;
    private CavalryBattalion cavalryBattalion;
    private Sword sword;
    private Bow bow;
    private Spear spear;


    public Kingdom(String kingdomName, King king, Ambassador ambassador, Heir heir, Spymaster spymaster,
                   Missionary missionary, Religion religion, Queue regions, int numberOfPeasants,
                   int numberOfSoldiers, int numberOfWeapons, int treasure, HashMap<Kingdom,Integer> relationsWithOtherKingdoms, int piety,
                   ArrayList<Noble> noblesAtCourt) {
        this.sword = new Sword(numberOfWeapons/3);
        this.bow = new Bow(numberOfWeapons/3);
        this.spear = new Spear(numberOfWeapons/3);
        this.infantryBattalion = new InfantryBattalion(numberOfSoldiers/3);
        this.archerBattalion = new ArcherBattalion(numberOfSoldiers/3);
        this.cavalryBattalion = new CavalryBattalion(numberOfSoldiers/3);
        this.king = king;
        this.ambassador = ambassador;
        this.heir = heir;
        this.kingdomName = kingdomName;
        this.spymaster = spymaster;
        this.missionary = missionary;
        this.religion = religion;
        this.regions = regions;
        this.numberOfPeasants = numberOfPeasants;
        this.numberOfSoldiers = numberOfSoldiers;
        this.numberOfWeapons = numberOfWeapons;
        this.treasure = treasure;
        this.relationsWithOtherKingdoms = relationsWithOtherKingdoms;
        this.atWar = false;
        this.kingdomAtWarAgainst = null;
        this.allyKingdom = null;
        this.taxRate = 1;
        this.population = calculatePopulation();
        this.piety = piety;
        calculateKingdomAttackAndDefence();
        /*this.kingdomAttack = (archerBattalion.getAttack()*archerBattalion.getNumberOfSoldiers()) + infantryBattalion.getAttack()*infantryBattalion.getNumberOfSoldiers() + cavalryBattalion.getAttack()*cavalryBattalion.getNumberOfSoldiers();
        this.kingdomDefence = archerBattalion.getDefence()*archerBattalion.getNumberOfSoldiers() + infantryBattalion.getDefence()*infantryBattalion.getNumberOfSoldiers() + cavalryBattalion.getDefence()*cavalryBattalion.getNumberOfSoldiers();
        */this.noblesAtCourt = noblesAtCourt;
    }
    
    
    public Kingdom(String kingdomName, King king, Ambassador ambassador, Heir heir, Spymaster spymaster,
            Missionary missionary, Religion religion, Queue regions, int numberOfPeasants,
            int numberOfSoldiers, int numberOfWeapons, int treasure, int piety) {
 this.sword = new Sword(numberOfWeapons/3);
 this.bow = new Bow(numberOfWeapons/3);
 this.spear = new Spear(numberOfWeapons/3);
 this.infantryBattalion = new InfantryBattalion(numberOfSoldiers/3);
 this.archerBattalion = new ArcherBattalion(numberOfSoldiers/3);
 this.cavalryBattalion = new CavalryBattalion(numberOfSoldiers/3);
 this.king = king;
 this.kingdomName = kingdomName;
 this.ambassador = ambassador;
 this.heir = heir;
 this.spymaster = spymaster;
 this.missionary = missionary;
 this.religion = religion;
 this.regions = regions;
 this.numberOfPeasants = numberOfPeasants;
 this.numberOfSoldiers = numberOfSoldiers;
 this.numberOfWeapons = numberOfWeapons;
 this.treasure = treasure;
 this.atWar = false;
 this.kingdomAtWarAgainst = null;
 this.allyKingdom = null;
 this.taxRate = 1;
 this.population = calculatePopulation();
 this.piety = piety;
 calculateKingdomAttackAndDefence();
 }

    public String OrderDeclareWar(Kingdom kingdom){
    	
    	String result = "";
        if(treasure>2000){
            if(ambassador != null){
                if(ambassador.isAvailable()){
                    if(relationsWithOtherKingdoms.get(kingdom)<=50){
                        if(!atWar) {
                            ambassador.setAvailable(false);
                            ambassador.declareWar(this, kingdom);
                            result = "War started";
                            
                        }else{
                            result = ("Currently the kingdom is at war!");
                        }
                    }else{
                        result = ("Relation is too high");
                    }
                }else{
                    result = ("Ambassador is not available");
                }
            }else{
                result = ("There is not an ambassador");
            }
        }else{
            result = ("Treasure is not enough!");
        }
        return result;
    }


    public String OrderMakePeace(){
    	String result = "";
        if(treasure>2000){
            if(ambassador != null){
                if(ambassador.isAvailable()){
                        if(atWar) {
                            ambassador.setAvailable(false);
                            ambassador.makePeace(this);
                            result = "AtWar";
                        }else{
                        	 result = ("Currently the kingdom is at peace!");
                        }

                }else{
                	 result = ("Ambassador is not available");
                }
            }else{
            	 result = ("There is not an ambassador");
            }
        }else{
            result = ("Treasure is not enough!");
        }
        return result;
    }


    public int OrderBuildAlliance(Kingdom kingdom){

    	
        int relation = relationsWithOtherKingdoms.get(kingdom);


        if(treasure>5000){
        	if(allyKingdom == null) {
                return ambassador.buildAlliance(this,kingdom,relation);
        	}else{
        		return 0;
        	}
        }else{
        	return -1;
        }

    }


    public boolean collectTaxes(){
    	if(Game.canCollectTaxes) {
            int collectedMoney;

            collectedMoney = taxRate * numberOfPeasants;

            treasure += collectedMoney;
            Game.canCollectTaxes = false;
            
            return true;
    	}
    	
    	return false;

    }

    public void increaseTaxes(int increaseAmount){

        taxRate += increaseAmount;
        king.setPrestige(king.getPrestige()-(5*increaseAmount));

    }

    public void decreaseTaxes(int decreaseAmount){

        taxRate -= decreaseAmount;
        king.setPrestige(king.getPrestige()+(5*decreaseAmount));

    }


    public boolean makeFeast(){

    	if(Game.canMakeFeast) {
            int neededMoney = population/10;

            if(treasure >= neededMoney){
                treasure -= neededMoney;
                king.setPrestige(king.getPrestige()+neededMoney/100); 
                Game.canMakeFeast = false;
                return true;
            }

            return false;
    	}

    	return false;
    }


    public int calculatePopulation(){
        int population = numberOfPeasants + numberOfSoldiers + 1;
        if(spymaster != null){
            population++;
        }
        if(heir != null){
            population++;
        }

        if(missionary != null){
            population++;
        }

        if(ambassador != null){
            population++;
        }

        return population;
    }



    public boolean OrderConvertReligion(Religion religion){

        if(piety < 50){
        	setPiety(getPiety()+20);
            missionary.convertReligion(this,religion);
            return true;
        }else{
            return false;
        }
    }

    public boolean sendSpymaster(Kingdom kingdom){
        if(treasure > 2000){
            spymaster.placeOfSpymaster = kingdom;
            setTreasure(getTreasure()-2000);
            return true;
        }
        return false;
    }
    public boolean orderManageRelations(Kingdom kingdom, boolean increaseOrDecrease){ //increase true, decrease false
    
    	
        if(treasure>1000){
        	ambassador.manageRelation(increaseOrDecrease,this,kingdom);  
        	return true;
        }else{
            return false;
        }
    }


    public boolean exile(Noble noble){

        Random random = new Random();

        int randomNumber = random.nextInt(10);

        if(randomNumber == 1){
            System.out.println("Exile failed!");
            return false;
        }

        if(noble instanceof Missionary){
            missionary = null;
        }
        else if(noble instanceof Heir){
            heir = null;
        }
        else if(noble instanceof Ambassador){
            ambassador = null;
        }
        else if(noble instanceof Spymaster){
            spymaster = null;
        }

        return true;
    }

    public int recruitSoldier(String soldierType, int numberOfBattalions){

        int newSoldierAmount = numberOfBattalions * 100;
        int neededMoney = newSoldierAmount * 3 ;
        if(neededMoney <= treasure) {

            if (soldierType.equals("Cavalry") || soldierType.equals("Archer") || soldierType.equals("Infantry")) {
                if (newSoldierAmount <= sword.getAmount() && soldierType.equals("Infantry")) {
                    numberOfSoldiers += newSoldierAmount;
                    infantryBattalion.setNumberOfSoldiers(infantryBattalion.getNumberOfSoldiers()+newSoldierAmount);
                    treasure -= neededMoney;
                    sword.setAmount(sword.getAmount()-newSoldierAmount);
                    return newSoldierAmount;
                } else if (newSoldierAmount <= spear.getAmount() && soldierType.equals("Cavalry")) {
                    numberOfSoldiers += newSoldierAmount;
                    cavalryBattalion.setNumberOfSoldiers(cavalryBattalion.getNumberOfSoldiers()+newSoldierAmount);
                    treasure -= neededMoney;
                    spear.setAmount(spear.getAmount()-newSoldierAmount);
                    return newSoldierAmount;
                } else if (newSoldierAmount <= bow.getAmount() && soldierType.equals("Archer")) {
                    numberOfSoldiers += newSoldierAmount;
                    archerBattalion.setNumberOfSoldiers(archerBattalion.getNumberOfSoldiers()+newSoldierAmount);
                    treasure -= neededMoney;
                    bow.setAmount(bow.getAmount()-newSoldierAmount);
                    return newSoldierAmount;
                }else{
                    System.out.println("Not enough weapon!");
                	return 0;
                }
            }else {
            	return 0;
            }
        }else{
            System.out.println("Not enough money!");
        	return -1;
        }
    }


    public int produceWeapon(String weaponType, int numberOfWeaponUnit){

    	int newWeaponsAmount = 0;
        newWeaponsAmount = numberOfWeaponUnit;
        if(newWeaponsAmount*3 < treasure) {

                if (weaponType.equals("Sword")) {
                    numberOfWeapons += newWeaponsAmount;
                    sword.setAmount(sword.getAmount()+ newWeaponsAmount);
                    treasure -= newWeaponsAmount * 3;
                } else if (weaponType.equals("Spear")) {
                    numberOfWeapons+= newWeaponsAmount;
                    spear.setAmount(spear.getAmount()+ newWeaponsAmount);
                    treasure -= newWeaponsAmount * 3;
                } else if (weaponType.equals("Bow")) {
                    numberOfWeapons += newWeaponsAmount;
                    bow.setAmount(bow.getAmount()+ newWeaponsAmount);
                    treasure -= newWeaponsAmount * 3;
                }
              
                
        }else{
        	return -1;
        }
        
        return newWeaponsAmount;
        
    }


    public boolean upgradeSoldierRank(Battalion soldierType){

        if(treasure > 5000){
            if(soldierType instanceof CavalryBattalion)
            {
                int[] upgradedAttackAndDefenceValues=cavalryBattalion.upgradeSoldierRank();
                kingdomAttack += upgradedAttackAndDefenceValues[0];
                kingdomDefence += upgradedAttackAndDefenceValues[1];
            }
            else if(soldierType instanceof InfantryBattalion)
            {   int[] upgradedAttackAndDefenceValues =infantryBattalion.upgradeSoldierRank();
                kingdomAttack += upgradedAttackAndDefenceValues[0];
                kingdomDefence += upgradedAttackAndDefenceValues[1];
            }
            else if(soldierType instanceof ArcherBattalion)
            	{   int[] upgradedAttackAndDefenceValues =archerBattalion.upgradeSoldierRank();
                kingdomAttack += upgradedAttackAndDefenceValues[0];
                kingdomDefence += upgradedAttackAndDefenceValues[1];
            }
            setTreasure(getTreasure()-5000);
            return true;
        }
        return false;
    }



    public int upgradeStructureRank(String structureType){

        if(treasure > 2000){
            if(structureType.equals("Castle")){
            	if(castle != null ) {
                	if(castle.getLevel()+1 != 11) {
                        castle.incrementLevel();
                        castle.setDefence(castle.getDefence()+10000);
                        kingdomDefence += 5000;
                        setTreasure(getTreasure()-2000);
                        return kingdomDefence;
                	}else {
                		return 0;//max level reached
                	}
            	}else {
            		return 1;//if not constructed yet
            	}

            }
            else if(structureType.equals("Wall")){
            	if(wall != null ) {
                	if(wall.getLevel()+1 != 11) {
                		wall.incrementLevel();
                		wall.setDefence(wall.getDefence()+7500);
                        kingdomDefence += 5000;
                        return kingdomDefence;
                	}else {
                		return 0;//max level reached
                	}
            	}else {
            		return 1;//if not constructed yet
            	}

            }else {
            	return -1;
            }
        }else{
            return -1;//money not enough
        }
        


    }



    public int constructStructure(String structureType){

        if (treasure > 5000) {

            if (structureType.equals("Castle") && castle == null) {
                castle = new Castle();
                kingdomDefence += castle.getDefence();
                treasure -= 5000;
                return kingdomDefence;
            } else if (structureType.equals("Wall") && wall == null) {
                wall = new Wall();
                kingdomDefence += wall.getDefence();
                treasure -= 5000;
                return kingdomDefence;
            }
            else {
            	return -1;
            }
        }else{
        	return 0;
        }

    }
    public void calculateKingdomAttackAndDefence()
    {
    	
    	kingdomAttack = archerBattalion.getAttack()*archerBattalion.getNumberOfSoldiers() + infantryBattalion.getAttack()*infantryBattalion.getNumberOfSoldiers() + cavalryBattalion.getAttack()*cavalryBattalion.getNumberOfSoldiers();
    	kingdomDefence = archerBattalion.getDefence()*archerBattalion.getNumberOfSoldiers() + infantryBattalion.getDefence()*infantryBattalion.getNumberOfSoldiers() + cavalryBattalion.getDefence()*cavalryBattalion.getNumberOfSoldiers();
    	if(castle!=null)
    		kingdomDefence+=castle.getDefence()*1000;
    	if(wall!=null)
    		kingdomDefence+=wall.getDefence()*1000;
    	kingdomAttack/=1000;
    	kingdomDefence/=1000;

    }
    public void decreaseMilitaryPower()
    {
    	if(this==game.ourKingdom)
    	{

    		archerBattalion.setNumberOfSoldiers((int)(archerBattalion.getNumberOfSoldiers()*(1-(float)((int)(kingdomAtWarAgainst.kingdomAttack*0.07f+kingdomAtWarAgainst.kingdomDefence*0.03f))/100000)));
    		infantryBattalion.setNumberOfSoldiers((int)(infantryBattalion.getNumberOfSoldiers()*(1-(float)((int)(kingdomAtWarAgainst.kingdomAttack*0.07f+kingdomAtWarAgainst.kingdomDefence*0.03f))/100000)));
    		cavalryBattalion.setNumberOfSoldiers((int)(cavalryBattalion.getNumberOfSoldiers()*(1-(float)((int)(kingdomAtWarAgainst.kingdomAttack*0.07f+kingdomAtWarAgainst.kingdomDefence*0.03f))/100000)));
    		sword.setAmount((int)(sword.getAmount()*(1-(float)((int)(kingdomAtWarAgainst.kingdomAttack*0.07f+kingdomAtWarAgainst.kingdomDefence*0.03f))/100000)));
    		spear.setAmount((int)(spear.getAmount()*(1-(float)((int)(kingdomAtWarAgainst.kingdomAttack*0.07f+kingdomAtWarAgainst.kingdomDefence*0.03f))/100000)));
    		bow.setAmount((int)(bow.getAmount()*(1-(float)((int)(kingdomAtWarAgainst.kingdomAttack*0.07f+kingdomAtWarAgainst.kingdomDefence*0.03f))/100000)));

    		calculateKingdomAttackAndDefence();
    		/*kingdomAttack-= (int)(kingdomAtWarAgainst.kingdomAttack*0.07f+kingdomAtWarAgainst.kingdomDefence*0.03f);
    		kingdomDefence-= (int)(kingdomAtWarAgainst.kingdomAttack*0.07f);*/
    	}
    	else
    	{
    		archerBattalion.setNumberOfSoldiers((int)(archerBattalion.getNumberOfSoldiers()*(1-(float)((int)(game.ourKingdom.kingdomAttack*0.07f+game.ourKingdom.kingdomDefence*0.03f))/100000)));
    		infantryBattalion.setNumberOfSoldiers((int)(infantryBattalion.getNumberOfSoldiers()*(1-(float)((int)(game.ourKingdom.kingdomAttack*0.07f+game.ourKingdom.kingdomDefence*0.03f))/100000)));
    		cavalryBattalion.setNumberOfSoldiers((int)(cavalryBattalion.getNumberOfSoldiers()*(1-(float)((int)(game.ourKingdom.kingdomAttack*0.07f+game.ourKingdom.kingdomDefence*0.03f))/100000)));
    		sword.setAmount((int)(sword.getAmount()*(1-(float)((int)(game.ourKingdom.kingdomAttack*0.07f+game.ourKingdom.kingdomDefence*0.03f))/100000)));
    		spear.setAmount((int)(spear.getAmount()*(1-(float)((int)(game.ourKingdom.kingdomAttack*0.07f+game.ourKingdom.kingdomDefence*0.03f))/100000)));
    		bow.setAmount((int)(bow.getAmount()*(1-(float)((int)(game.ourKingdom.kingdomAttack*0.07f+game.ourKingdom.kingdomDefence*0.03f))/100000)));

    		calculateKingdomAttackAndDefence();
    		/*kingdomAttack-= (int)(game.ourKingdom.kingdomAttack *0.07f+game.ourKingdom.kingdomDefence*0.03f);
    		kingdomDefence-= (int)(game.ourKingdom.kingdomAttack*0.07f);*/
    	}
    }

    public int getNumberOfWeapons() {
        return numberOfWeapons;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Ambassador getAmbassador() {
        return ambassador;
    }

    public void setAmbassador(Ambassador ambassador) {
        this.ambassador = ambassador;
    }

    public Heir getHeir() {
        return heir;
    }

    public void setHeir(Heir heir) {
        this.heir = heir;
    }

    public Spymaster getSpymaster() {
        return spymaster;
    }

    public void setSpymaster(Spymaster spymaster) {
        this.spymaster = spymaster;
    }

    public Missionary getMissionary() {
        return missionary;
    }

    public void setMissionary(Missionary missionary) {
        this.missionary = missionary;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Queue getRegions() {
        return regions;
    }

    public void setRegions(Queue regions) {
        this.regions = regions;
    }

    public int getNumberOfPeasants() {
        return numberOfPeasants;
    }

    public void setNumberOfPeasants(int numberOfPeasants) {
        if(numberOfPeasants>0){
            this.numberOfPeasants = numberOfPeasants;
        }
    }

    public int getNumberOfSoldiers() {
        return numberOfSoldiers;
    }

    public void setNumberOfSoldiers(int numberOfSoldiers) {
        if(numberOfSoldiers>0){
            this.numberOfSoldiers = numberOfSoldiers;
        }
    }


    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        if(treasure>0){
            this.treasure = treasure;
        }
    }

    public HashMap<Kingdom, Integer> getRelationsWithOtherKingdoms() {
        return relationsWithOtherKingdoms;
    }

    public void setRelationsWithOtherKingdoms(HashMap<Kingdom, Integer> relationsWithOtherKingdoms) {
        this.relationsWithOtherKingdoms = relationsWithOtherKingdoms;
    }
    
    
    public String getKingdomName() {
        return kingdomName;
    }
    
    public int getTaxRate() {
    	return taxRate;
    }
    
    public ArrayList<Noble> getNoblesAtCourt(){
    	return noblesAtCourt;
    }
    
    public void setNoblesAtCourt(ArrayList<Noble> noblesAtCourt) {
    	this.noblesAtCourt = noblesAtCourt;
    }


	public InfantryBattalion getInfantryBattalion() {
		return infantryBattalion;
	}


	public void setInfantryBattalion(InfantryBattalion infantryBattalion) {
		this.infantryBattalion = infantryBattalion;
	}


	public ArcherBattalion getArcherBattalion() {
		return archerBattalion;
	}


	public void setArcherBattalion(ArcherBattalion archerBattalion) {
		this.archerBattalion = archerBattalion;
	}


	public CavalryBattalion getCavalryBattalion() {
		return cavalryBattalion;
	}


	public void setCavalryBattalion(CavalryBattalion cavalryBattalion) {
		this.cavalryBattalion = cavalryBattalion;
	}
	
	public int getPiety() {
		return piety;
	}


	public void setPiety(int amount) {
		if(amount>=0)
			piety=amount;
		
	}
	
	
    public Sword getSword() {
		return sword;
	}




	public Bow getBow() {
		return bow;
	}



	public Spear getSpear() {
		return spear;
	}



	@Override
    public String toString() {
    	return kingdomName;
    }


	public Castle getCastle() {
		return castle;
	}


	public Wall getWall() {
		return wall;
	}


	public int getKingdomDefence() {
		return kingdomDefence;
	}



	public int getKingdomAttack() {
		return kingdomAttack;
	}
	
	public void sethowManyYearsLeftAtWar(int amount)
	{
		if(amount>=0)
		howManyYearsLeftAtWar=amount;
	}
	
	public int gethowManyYearsLeftAtWar() {
		return howManyYearsLeftAtWar;
	}


	public Kingdom getAllyKingdom() {
		return allyKingdom;
	}


	public void setAllyKingdom(Kingdom allyKingdom) {
		if(allyKingdom != null) {
			this.allyKingdom = allyKingdom;
		}
	}


	public void setTaxRate(int taxRate) {
		if(taxRate >= 0) {
			this.taxRate = taxRate;
		}

	}


	public int getPopulation() {
		return population;
	}


	public void setPopulation(int population) {
		if(population >= 0) {
			this.population = population;
		}
	}
	
	
	
	
	


	


	




	
    
}
