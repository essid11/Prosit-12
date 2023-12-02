import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Etudiant> studentList = new ArrayList<>();
        studentList.add(new Etudiant(1, 22, "Yassine"));
        studentList.add(new Etudiant(2, 21, "Nebrass"));
        studentList.add(new Etudiant(3, 16, "Yasmine"));

        StudentManagement studentManagement = new StudentManagement();


        studentManagement.displayStudents(studentList, System.out::println);

        studentManagement.displayStudentsByFilter(studentList, student -> student.getAge() > 20, System.out::println);

        String names = studentManagement.returnStudentsNames(studentList, Etudiant::getNom);
        System.out.println("Student Names: " + names);

        Etudiant newStudent = studentManagement.createStudent(() -> new Etudiant(4, 20, "Taj"));
        System.out.println("New Student: " + newStudent);

        List<Etudiant> sortedList = studentManagement.sortStudentsById(studentList, Comparator.comparingInt(Etudiant::getId));
        System.out.println("Sorted List by ID: " + sortedList);

        Stream<Etudiant> studentStream = studentManagement.convertToStream(studentList);
        studentStream.forEach(System.out::println);
    }
}

