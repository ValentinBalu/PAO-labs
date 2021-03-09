package tema;
//3
public class Subject {
    private Room room;

    private Integer noOfStudents;

    public Integer getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(Integer noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    private Person teacher;

    public Subject(Room room ,Integer noOfStudents,Person teacher) {
        this.room = room;
        this.noOfStudents=noOfStudents;
        this.teacher=teacher;
    }

    public Room getRoom() {
        return room;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String toString(){
        return "Subject("+
                "person "+teacher+
                ", room "+ room +'\''+
                ", noOfStudents " +noOfStudents + '\''+
                "}";
    }
}
