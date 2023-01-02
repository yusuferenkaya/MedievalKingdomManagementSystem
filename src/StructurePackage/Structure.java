package StructurePackage;

public abstract class Structure {

    private int defence;
    private int level = 1;


    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        if(defence>0){
            this.defence = defence;
        }
    }

    public int getLevel() {
        return level;
    }

    public void incrementLevel() {
        this.level++;
    }

	public void setLevel(int level) {
		this.level = level;
	}
    
    
}
