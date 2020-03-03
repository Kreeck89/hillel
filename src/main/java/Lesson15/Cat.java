package Lesson15;

public class Cat extends Animal implements Action {
    @Override
    public void set() {
        System.out.println("Cat set action");
    }
}
