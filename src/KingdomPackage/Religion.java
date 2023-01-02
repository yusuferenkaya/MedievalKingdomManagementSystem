package KingdomPackage;

public class Religion {


    private String religionName = null;

    public Religion(String religionName) {

        if(religionName.matches("[a-zA-Z]+")){
            this.religionName = religionName;
        }
    }

    public String getReligionName() {
        return religionName;
    }
    @Override
    public String toString() {
    	return religionName;
    }
}
