package WeaponPackage;

public class Bow extends Weapon{

    public Bow(int amount) {
        if(amount>0){
            super.setAmount(amount);
        }
    }


}
