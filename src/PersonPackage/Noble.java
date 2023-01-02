package PersonPackage;

public class Noble extends Citizen{

    final private String FAMILY_NAME;

    public Noble(String NAME, short age, String FAMILY_NAME) {
        super(NAME, age);
        this.FAMILY_NAME = FAMILY_NAME;
    }

    public String getFAMILY_NAME() {
        return FAMILY_NAME;
    }

    public Noble assignARole(String roleName){
        if(roleName == null){
            return null;
        }
        if(roleName.equalsIgnoreCase("SPYMASTER")){
            return new Spymaster(super.getNAME(),super.getAge(),getFAMILY_NAME());
        } else if(roleName.equalsIgnoreCase("HEIR")){
            return new Heir(super.getNAME(),super.getAge(),getFAMILY_NAME());
        } else if(roleName.equalsIgnoreCase("AMBASSADOR")){
            return new Ambassador(super.getNAME(),super.getAge(),getFAMILY_NAME());
        } else if(roleName.equalsIgnoreCase("MISSIONARY")){
            return new Missionary(super.getNAME(),super.getAge(),getFAMILY_NAME());
        }
        return null;
    }
    
    public String toString() {
		return getNAME() + " " + FAMILY_NAME + " " + "(Age:" + getAge() + ")";
    	
    }

}

