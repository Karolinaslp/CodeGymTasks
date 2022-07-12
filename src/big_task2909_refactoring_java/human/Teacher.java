package big_task2909_refactoring_java.human;


public class Teacher extends UniversityPerson {
    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public void printData() {
        System.out.println("Teacher: " + name);
    }

    public int getCourse() {
        return course;
    }
}