package exersare;


import java.util.Objects;

/**
 * In metoda de comparare, studentii vor fi comparati mai intai dupa medie, apoi dupa numele de familie, apoi dupa prenume.
 */
public class Student implements Comparable<Student> {
    private Long id;
    private String name;
    private String surname;
    private double averageGrade;

    public Student(Long id, String name, String surname, double averageGrade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.averageGrade = averageGrade;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student: averageGrade=" + averageGrade +
                ", name=" + name +
                ", surname=" + surname + "\n";
    }

    // Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
    @Override
    public int compareTo(Student o) {
        return this.getSurname().compareTo(o.getSurname());
    }

    // TODO: Suprascrieti metodele equals si hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Double.compare(student.getAverageGrade(), getAverageGrade()) == 0 && getId().equals(student.getId()) && Objects.equals(getName(), student.getName()) && Objects.equals(getSurname(), student.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAverageGrade());
    }
}