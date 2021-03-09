package tema;

class HeadMaster{
    private static String gender;
    private static String name;
    private static String surname;

    private static final HeadMaster headmaster = new HeadMaster();

    private HeadMaster(){
        gender="Mrs.";
        name="Poppins";
        surname="Marry";
    }
    public static HeadMaster getHeadMaster(){
        return headmaster;
    }
    public void showHeadMaster(){
        System.out.println("The HeadMaster is "+gender+" "+name+" "+surname+".");
    }
}

public class Highschool {
    public static void main(String[] args) {
        //1
        Person p1 = new Person("Ion","Alexandru",21,123456789,"Student");
        Person p2 = new Person("Salaujeanu","Mariana",34,987654321,"Vanzatoare");
        System.out.println("Prima persoana se numeste " + p1.getName() + " "+ p1.getSurname()+". Are varsta de " + p1.getAge() + " de ani. Codul de identitate este "+p1.getIdentityNumber()+", iar tipul este de "+p1.getType()+".");
        System.out.println("A doua persoana se numeste " + p2.getName() + " "+ p2.getSurname()+". Are varsta de " + p2.getAge() + " de ani. Codul de identitate este "+p2.getIdentityNumber()+", iar tipul este de "+p2.getType()+".");
        System.out.println(p1);
        System.out.println();

        //2
        Room r1 = new Room(13,"Master Bedroom",1);
        Room r2 = new Room(56,"Apartment",5);
        System.out.println("Camera cu numarul "+r1.getRoomNumber()+ ", de la etajul "+r1.getRoomFloor()+", este de tipul "+r1.getRoomType()+".");
        System.out.println("Camera cu numarul "+r2.getRoomNumber()+ ", de la etajul "+r2.getRoomFloor()+", este de tipul "+r2.getRoomType()+".");
        System.out.println(r1);
        System.out.println();

        //3
        Person p = new Person("Vezure","Andrei",28,1234569456,"Profesor de Anatomie");
        Room r = new Room(87,"Laborator de Anatomie",8);
        Subject s = new Subject(r,27,p);
        System.out.println("Materia 1 este predata de "+s.getTeacher().getName()+" " +s.getTeacher().getSurname()+". Are varsta de "+s.getTeacher().getAge()+" de ani. Codul de indentitate este "+s.getTeacher().getIdentityNumber()+" si are statutul de "+s.getTeacher().getType()+". Se desfasoara in camera cu numarul "+s.getRoom().getRoomNumber()+" de la etajul "+s.getRoom().getRoomFloor()+", de tipul "+s.getRoom().getRoomType()+". Are un numar de "+ s.getNoOfStudents()+" studenti.");

        Person pp = new Person("Avram","Ana",29,666459456,"Profesor de Fizica");
        Room rr = new Room(61,"Laborator de Fizica",6);
        Subject ss = new Subject(rr,29,pp);
        System.out.println("Materia 2 este predata de "+ss.getTeacher().getName()+" " +ss.getTeacher().getSurname()+". Are varsta de "+ss.getTeacher().getAge()+" de ani. Codul de indentitate este "+ss.getTeacher().getIdentityNumber()+" si are statutul de "+ss.getTeacher().getType()+". Se desfasoara in camera cu numarul "+ss.getRoom().getRoomNumber()+" de la etajul "+ss.getRoom().getRoomFloor()+", de tipul "+ss.getRoom().getRoomType()+". Are un numar de "+ ss.getNoOfStudents()+" studenti.");
        System.out.println();

        System.out.println(s);
        System.out.println();

        //4
        HeadMaster.getHeadMaster().showHeadMaster();
    }
}
