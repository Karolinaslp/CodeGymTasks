package big_task2909_refactoring_java.human;

public class Soldier extends Human{

    private int course;

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }

    public void fight() {
    }

    public int getCourse() {
        return course;
    }
}
