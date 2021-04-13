package exersare;


import java.util.Comparator;

/**
 * In metoda de comparare, studentii vor fi comparati mai intai dupa medie, apoi dupa numele de familie, apoi dupa prenume.
 */
public class StudentComparator implements Comparator<Student> {
    // Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAverageGrade()!=o2.getAverageGrade()){
            if(o1.getAverageGrade()-o2.getAverageGrade()<0.0){
                return -1;
            }else{
                return 1;
            }
        }
        else{
            if(o1.getName().equals(o2.getName())!=true){
                return o1.getName().compareTo(o2.getName());
            }else{
                return o1.getSurname().compareTo(o2.getSurname());
            }
        }
    }
}