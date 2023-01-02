package PersonPackage;

public class Citizen {


    final private String NAME;
    private short age;

    public Citizen(String NAME, short age) {
        this.NAME = NAME;
        this.age = age;
    }

    public String getNAME() {
        return NAME;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        if(age>=0){
            this.age = age;
        }else{
            System.out.println("Age cannot be negative!");
        }
    }
}
