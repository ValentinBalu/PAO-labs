package tema;
//1
public class Person {
    private String name;

    private String surname;

    private int age;

    private long identityNumber;

    private String type;

    public Person(String name,String surname,int age,long identityNumber, String type) {
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.identityNumber = identityNumber;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return "Person("+
                "name "+name+
                ", surname "+ surname +'\''+
                ", age " +age + '\''+
                ", identityNumber " +identityNumber + '\''+
                ", type " +type + '\''+
                "}";
    }
}
