package PersonPackage;

import KingdomPackage.Kingdom;
import KingdomPackage.Religion;

public class Missionary extends Noble{


    public Missionary(String NAME, short age, String FAMILY_NAME) {
        super(NAME, age, FAMILY_NAME);
    }

    public void convertReligion(Kingdom kingdom, Religion religion){

        Religion newReligion = new Religion(religion.getReligionName());
        kingdom.setReligion(newReligion);
    }
    @Override
    public String toString() {
    	return "Missionary " + getNAME() + " " + getFAMILY_NAME();
    }
}
