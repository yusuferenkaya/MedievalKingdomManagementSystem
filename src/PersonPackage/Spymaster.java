package PersonPackage;

import KingdomPackage.Kingdom;

import java.util.Arrays;

import GamePackage.Game;

public class Spymaster extends Noble{

    public Kingdom placeOfSpymaster;

    public Spymaster(String NAME, short age, String FAMILY_NAME) {
        super(NAME, age, FAMILY_NAME);
    }

    public String showInformations(){
        return "King: " + placeOfSpymaster.getKing().getNAME() + " " + placeOfSpymaster.getKing().getFAMILY_NAME()+"\n"+
        "Regions: " + placeOfSpymaster.getRegions().getFirst3() +"\n"+
        "Religion: " + placeOfSpymaster.getReligion().getReligionName()+"\n"+
        "Number of soldiers: " + placeOfSpymaster.getNumberOfSoldiers()+"\n"+
        "Number of weapons: " + placeOfSpymaster.getNumberOfWeapons()+"\n"+
        "Treasure: " + placeOfSpymaster.getTreasure()+"\n"+
        "Population: " + placeOfSpymaster.calculatePopulation()+"\n"+
        "Attack Point: " + placeOfSpymaster.getKingdomAttack()+"\n"+
        "Defence Point: " + placeOfSpymaster.getKingdomDefence()+"\n"+
        "Relation with this kingdom is " + Game.ourKingdom.getRelationsWithOtherKingdoms().get(placeOfSpymaster);
    }
    
    @Override
    public String toString() {
    	return "Spymaster  " + getNAME() + " " + getFAMILY_NAME();
    }
}
