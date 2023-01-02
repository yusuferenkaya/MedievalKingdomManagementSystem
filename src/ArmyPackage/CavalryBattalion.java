package ArmyPackage;

public class CavalryBattalion extends Battalion {


    public CavalryBattalion(int amount) {
        super.setNumberOfSoldiers(amount);
        this.attack = 3 * numberOfSoldiers;
        this.defence = 2 * numberOfSoldiers;
    }


    @Override
    public int[] upgradeSoldierRank() {
        this.attack +=3 * numberOfSoldiers;
        this.defence +=3 * numberOfSoldiers;
        return new int[]{3 * numberOfSoldiers, 3 * numberOfSoldiers};
    }
    @Override
    public String toString() {
    	return "Cavalry";
    }
}
