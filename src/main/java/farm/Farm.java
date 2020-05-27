package farm;

import java.util.List;

public class Farm {
    private double cost;
    private List<Cow> cows;
    private double feedPrice;
    private double milkPrice;
    private double incomeTax;
    private double milkmaidSalary;

    public Farm() {
    }

    public Farm(double cost, List<Cow> cows, double feedPrice, double milkPrice, double incomeTax, double milkmaidSalary) {
        this.cost = cost;
        this.cows = cows;
        this.feedPrice = feedPrice;
        this.milkPrice = milkPrice;
        this.incomeTax = incomeTax;
        this.milkmaidSalary = milkmaidSalary;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Cow> getCows() {
        return cows;
    }

    public void setCows(List<Cow> cows) {
        this.cows = cows;
    }

    public double getFeedPrice() {
        return feedPrice;
    }

    public void setFeedPrice(double feedPrice) {
        this.feedPrice = feedPrice;
    }

    public double getMilkPrice() {
        return milkPrice;
    }

    public void setMilkPrice(double milkPrice) {
        this.milkPrice = milkPrice;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getMilkmaidSalary() {
        return milkmaidSalary;
    }

    public void setMilkmaidSalary(double milkmaidSalary) {
        this.milkmaidSalary = milkmaidSalary;
    }
}
