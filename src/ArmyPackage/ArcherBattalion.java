package ArmyPackage;

public class ArcherBattalion extends Battalion {

    public ArcherBattalion(int amount) {
        super.setNumberOfSoldiers(amount);
        this.attack = 3 * numberOfSoldiers;
        this.defence = 1 * numberOfSoldiers;
    }

    @Override
    public int[] upgradeSoldierRank() {
        this.attack += 3 * numberOfSoldiers;
        this.defence += 2 * numberOfSoldiers;
        return new int[]{3 * numberOfSoldiers, 2 * numberOfSoldiers};
    }
    @Override
    public String toString() {
    	return "Archer";
    }
}
