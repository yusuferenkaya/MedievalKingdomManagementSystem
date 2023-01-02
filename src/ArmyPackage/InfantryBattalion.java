package ArmyPackage;

public class InfantryBattalion extends Battalion {

    public InfantryBattalion(int amount) {
        super.setNumberOfSoldiers(amount);
        this.attack = 1 * numberOfSoldiers;
        this.defence = 2 * numberOfSoldiers;
    }

    @Override
    public int[] upgradeSoldierRank() {
        this.attack +=2 * numberOfSoldiers;
        this.defence +=2 * numberOfSoldiers;
        return new int[]{2 * numberOfSoldiers, 2 * numberOfSoldiers};
    }
    @Override
    public String toString() {
    	return "Infantry";
    }
}
