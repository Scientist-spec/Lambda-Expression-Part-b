import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
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
        
        System.out.println("\nStudents with marks > 75%:");
        List<Student> highScorers = students.stream()
            .filter(student -> student.getMarks() > 75.0)
            .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
            .collect(Collectors.toList());
        highScorers.forEach(System.out::println);
        
        System.out.println("\nNames of students with marks > 75% (sorted by marks descending):");
        List<String> highScorerNames = students.stream()
            .filter(student -> student.getMarks() > 75.0)
            .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
            .map(Student::getName)
            .collect(Collectors.toList());
        highScorerNames.forEach(System.out::println);
        
        System.out.println("\nUsing forEach to display directly:");
        students.stream()
            .filter(student -> student.getMarks() > 75.0)
            .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
            .map(Student::getName)
            .forEach(System.out::println);
    }
}
