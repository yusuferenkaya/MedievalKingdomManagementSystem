package WeaponPackage;

public abstract class Weapon {

    private int amount;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if(amount >= 0){
            this.amount = amount;
        }
    }
}
