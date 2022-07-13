package big_task2909_refactoring_java.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {
    String name;
    int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        return students.stream()
                .filter(student -> student.getAverageGrade() == averageGrade)
                .findFirst()
                .orElse(null);
    }

    public Student getStudentWithHighestAverageGrade() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade))
                .orElse(null);
    }

    public Student getStudentWithLowestAverageGrade() {
        return students.stream()
                .min(Comparator.comparingDouble(Student::getAverageGrade))
                .orElse(null);
    }

    public void expel(Student student) {
        students.remove(student);
    }
}