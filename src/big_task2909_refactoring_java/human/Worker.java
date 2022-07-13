package big_task2909_refactoring_java.human;

public class Worker extends Human {
    private double salary;
    public String company;

    public Worker(String name, int age) {
        super(name, age);
    }

    public void live() {
        live();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}