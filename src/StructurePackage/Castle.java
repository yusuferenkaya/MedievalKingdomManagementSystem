package StructurePackage;

public class Castle extends Structure{

    public Castle() {
        super.setDefence(20000*getLevel());
    }
}
