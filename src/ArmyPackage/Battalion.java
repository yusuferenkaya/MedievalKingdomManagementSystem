package ArmyPackage;

public abstract class Battalion{

    int numberOfSoldiers;

    int attack;
    int defence;

    public int getNumberOfSoldiers() {
        return numberOfSoldiers;
    }

    public void setNumberOfSoldiers(int numberOfSoldiers) {
        if(numberOfSoldiers>0){
            this.numberOfSoldiers = numberOfSoldiers;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if(attack>0){
            this.attack = attack;
        }
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        if(defence>0){
            this.defence = defence;
        }
    }

    public abstract int[] upgradeSoldierRank();


}
