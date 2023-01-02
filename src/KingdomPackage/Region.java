package KingdomPackage;

public class Region{

    private String name;
    private int treasureInRegion;
    private int area;

    public Region(String name, int treasureInRegion, int area) {
        this.name = name;

        if(treasureInRegion>0){
            this.treasureInRegion = treasureInRegion;
        }

        if(area>0){
            this.area = area;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTreasureInRegion() {
        return treasureInRegion;
    }

    public void setTreasureInRegion(int treasureInRegion) {
        if(treasureInRegion>0){
            this.treasureInRegion = treasureInRegion;
        }
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        if(area>0){
            this.area = area;
        }
    }
    @Override
    public String toString() {
    	return name;
    }
}
