import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Attendance mathClass = new Math();
        Attendance Italian = new Italian();

        Person student1 = new Student("Prince", "david");
        Person student2 = new Student("hana", "debay");
        Person teacher1 = new Teacher("eng.", "huseyin");

        mathClass.takeAttendance(student1);
        mathClass.takeAttendance(teacher1);

        Italian.takeAttendance(student1);
        Italian.takeAttendance(student2);

        System.out.println("Math Class Attendance:");
        for (String attendance : mathClass.getAttendance()) {
            System.out.println(attendance);
        }

        System.out.println("Italian Class Attendance:");
        for (String attendance : Italian.getAttendance()) {
            System.out.println(attendance);
        }


    }
}

interface Person {
    String getAttendanceString();
}

interface Attendance {
    void takeAttendance(Person person);
    List<String> getAttendance();
}

class Math implements Attendance {
    List<String> attendanceList;

    public Math() {
        attendanceList = new ArrayList<>();
    }

    @Override
    public void takeAttendance(Person person) {
        attendanceList.add(person.getAttendanceString());
    }

    @Override
    public List<String> getAttendance() {
        return attendanceList;
    }
}
class Italian implements Attendance {
    List<String> attendanceList;

    public Italian() {
        attendanceList = new ArrayList<>();
    }

    @Override
    public void takeAttendance(Person person) {
        attendanceList.add(person.getAttendanceString());
    }

    @Override
    public List<String> getAttendance() {
        return attendanceList;
    }
}

class Student implements Person {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getAttendanceString() {
        return "Student: " + firstName + " " + lastName;
    }
}

class Teacher implements Person {
    private String firstName;
    private String lastName;

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getAttendanceString() {
        return "Teacher: " + firstName + " " + lastName;
    }
}
