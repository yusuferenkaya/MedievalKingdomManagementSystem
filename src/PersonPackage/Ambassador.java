package PersonPackage;


import KingdomPackage.Kingdom;

import java.util.Random;

import GamePackage.Game;

public class Ambassador extends Noble{

    private boolean available;

    public Ambassador(String NAME, short age, String FAMILY_NAME) {
        super(NAME, age, FAMILY_NAME);
        available = true;
    }

    public boolean isAvailable(){
        return available;
    }

    public void declareWar(Kingdom ourKingdom, Kingdom kingdom){
        ourKingdom.getKing().setPrestige(ourKingdom.getKing().getPrestige() - 10);
        ourKingdom.setTreasure(ourKingdom.getTreasure() - 2000);
        ourKingdom.sethowManyYearsLeftAtWar(5);
        ourKingdom.atWar = true;
        ourKingdom.kingdomAtWarAgainst = kingdom;
        this.available = true;
    }

    public void makePeace(Kingdom ourKingdom){
        ourKingdom.getKing().setPrestige(ourKingdom.getKing().getPrestige() + 5);
        ourKingdom.setTreasure(ourKingdom.getTreasure() - 2000);
        ourKingdom.atWar = false;
        ourKingdom.kingdomAtWarAgainst = null;
        ourKingdom.sethowManyYearsLeftAtWar(0);
        this.available = true;
    }

    public int buildAlliance(Kingdom ourKingdom, Kingdom kingdom, int relation){

        int allianceLimit = relation;

        if(ourKingdom.getReligion().getReligionName().equals(kingdom.getReligion().getReligionName())){
            allianceLimit += 30;
        }
        Random random = new Random();
        int randomAlliancePoint = random.nextInt(20);

        allianceLimit += randomAlliancePoint;

        if(allianceLimit >= 80){
        	Game.ourKingdom.setTreasure(Game.ourKingdom.getTreasure()-5000);
        	Game.ourKingdom.setAllyKingdom(kingdom);
            return allianceLimit;
        }else{
            return allianceLimit;
        }

    }

    public void manageRelation(boolean increaseOrDecrease, Kingdom ourKingdom, Kingdom kingdom){
        if(increaseOrDecrease){
            ourKingdom.getRelationsWithOtherKingdoms().put(kingdom,ourKingdom.getRelationsWithOtherKingdoms().get(kingdom) + 10);
            ourKingdom.setTreasure(ourKingdom.getTreasure()-1000);
        }else{
            ourKingdom.getRelationsWithOtherKingdoms().put(kingdom,ourKingdom.getRelationsWithOtherKingdoms().get(kingdom) - 10);
            ourKingdom.setTreasure(ourKingdom.getTreasure()-1000);
        }
       
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    @Override
    public String toString() {
    	return "Ambassador " + getNAME() + " " + getFAMILY_NAME();
    }
}
