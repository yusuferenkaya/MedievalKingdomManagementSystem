package StructurePackage;

public class Wall extends Structure{

    public Wall() {
        super.setDefence(15000*getLevel());
    }


}
