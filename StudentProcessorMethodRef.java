import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentProcessorMethodRef {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82.5),
            new Student("Bob", 65.0),
            new Student("Carol", 91.0),
            new Student("David", 78.5),
            new Student("Eva", 72.0),
            new Student("Frank", 88.0)
        );
        
        System.out.println("All Students:");
        students.forEach(System.out::println);
        
        System.out.println("\nStudents with marks > 75% (sorted ascending):");
        List<Student> highScorersAsc = students.stream()
            .filter(s -> s.getMarks() > 75.0)
            .sorted(Comparator.comparingDouble(Student::getMarks))
            .collect(Collectors.toList());
        highScorersAsc.forEach(System.out::println);
        
        System.out.println("\nNames of top students (sorted descending):");
        List<String> topStudentNames = students.stream()
            .filter(s -> s.getMarks() > 75.0)
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .map(Student::getName)
            .collect(Collectors.toList());
        topStudentNames.forEach(System.out::println);
        
        System.out.println("\nDirect display using forEach:");
        students.stream()
            .filter(s -> s.getMarks() > 75.0)
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .map(Student::getName)
            .forEach(name -> System.out.println("Top Student: " + name));
    }
}
