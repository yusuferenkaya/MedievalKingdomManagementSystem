package PersonPackage;

public class King extends Noble{


    int prestige;

    public King(String NAME, short age, String FAMILY_NAME, int prestige) {
        super(NAME, age, FAMILY_NAME);
        this.prestige = prestige;
    }

    public int getPrestige() {
        return prestige;
    }

    public void setPrestige(int prestige) {
        if(prestige>=0){
            this.prestige = prestige;
        }else{
            System.out.println("Prestige cannot be less than 0!");
        }
    }

}
