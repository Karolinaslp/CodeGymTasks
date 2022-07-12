package big_task2909_refactoring_java.human;

import java.util.ArrayList;
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

    public Student getStudentWithAverageGrade() {
        // TODO:
        return null;
    }
}