package exersare;


import javax.swing.text.Style;
import java.util.*;

public class Ex1 {

    public static void main(String[] args) {
        Student s1 = new Student(1L, "Popescu", "Alina", 9.00);
        Student s2 = new Student(2L, "Ionescu", "Maria", 7.50);
        Student s3 = new Student(3L, "Marinescu", "Ana", 7.50);
        Student s4 = new Student(4L, "Ungurescu", "Silvia", 6.20);
        Student s5 = new Student(5L, "Ungurescu", "Cornelia", 6.20);

        // TODO: adaugati cele 5 obiecte de tip student intr-un ArrayList si apoi sortati-l (folosind ambele interfete)

        List<Student> studenti = new ArrayList<Student>(5);
        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);
        studenti.add(s5);

        for(Student student : studenti){
            System.out.println(student.toString());
        }
        //sortare folosind comparable
        System.out.println("sortare folosind comparable:");
        Collections.sort(studenti);

        for(Student student : studenti){
            System.out.println(student.toString());
        }
        //sortare folosind comparator
        System.out.println("sortare folosind comparator:");
        StudentComparator comparator = new StudentComparator();
        Collections.sort(studenti,comparator);
        for(Student student : studenti){
            System.out.println(student.toString());
        }

        // TODO: folositi un Map<Student, List<String>>, in care se vor adauga perechi: Student, lista de materii si afisati rezultatul
        Map<Student, List<String>> studentHashMap = new HashMap<>();

        List<String> l1 = new ArrayList<>();
        l1.add("Romana");
        l1.add("Matematica");
        studentHashMap.put(s1,l1);

        List<String> l2 = new ArrayList<>();
        l2.add("Geografie");
        l2.add("Istorie");
        l2.add("Fizica");
        studentHashMap.put(s2,l2);

        studentHashMap.putIfAbsent(s3,Arrays.asList("Sport","Chimie"));

        for(Map.Entry<Student, List<String>> pair : studentHashMap.entrySet()){
            System.out.println("student : " + pair.getKey() + "materii : " );
            for(String materie : pair.getValue()){
                System.out.println(materie);
            }
            System.out.println();
        }
    }
}