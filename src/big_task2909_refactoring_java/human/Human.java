package big_task2909_refactoring_java.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {

    public class Size {
        public int height;
        public int weight;
    }

    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected Size size;

    private BloodType bloodType;
    private List<Human> children = new ArrayList<>();


    public void setBloodType(BloodType code) {
        bloodType = code;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Height: " + size + " Weight: " + size);
    }

    public String getPosition() {
        return "Person";
    }

    public void printData() {
        System.out.println(this.getPosition() + ": " + name);
    }

    @Override
    public void live() {

    }

}