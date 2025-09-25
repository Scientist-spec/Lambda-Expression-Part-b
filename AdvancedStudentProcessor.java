import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedStudentProcessor {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82.5),
            new Student("Bob", 65.0),
            new Student("Carol", 91.0),
            new Student("David", 78.5),
            new Student("Eva", 72.0),
            new Student("Frank", 88.0),
            new Student("Grace", 95.5),
            new Student("Henry", 74.9)
        );
        
        System.out.println("=== STUDENT PROCESSING USING STREAMS ===");
        
        System.out.println("\n1. All students:");
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getMarks() + "%"));
        
        System.out.println("\n2. High achievers (>75%) sorted by marks (descending):");
        students.stream()
            .filter(s -> s.getMarks() > 75.0)
            .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
            .forEach(s -> System.out.println(s.getName() + " - " + s.getMarks() + "%"));
        
        System.out.println("\n3. Only names of high achievers:");
        String highAchieverNames = students.stream()
            .filter(s -> s.getMarks() > 75.0)
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .map(Student::getName)
            .collect(Collectors.joining(", "));
        System.out.println("High Achievers: " + highAchieverNames);
        
        System.out.println("\n4. Statistics:");
        long highAchieverCount = students.stream()
            .filter(s -> s.getMarks() > 75.0)
            .count();
        double averageMarks = students.stream()
            .mapToDouble(Student::getMarks)
            .average()
            .orElse(0.0);
        
        System.out.println("Total students: " + students.size());
        System.out.println("High achievers: " + highAchieverCount);
        System.out.println("Average marks: " + String.format("%.2f", averageMarks) + "%");
    }
}
