package farm;

public class Cow {
    private double milk;
    private double eat;

    public Cow() {
    }

    public Cow(double milk, double eat) {
        this.milk = milk;
        this.eat = eat;
    }

    public double getMilk() {
        return milk;
    }

    public void setMilk(double milk) {
        this.milk = milk;
    }

    public double getEat() {
        return eat;
    }

    public void setEat(double eat) {
        this.eat = eat;
    }
}
