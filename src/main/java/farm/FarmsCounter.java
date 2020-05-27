package farm;

public class FarmsCounter {
    public String count(Farm farm) {
        if (!farmValidator(farm)) {
            return "INPUT PARAMS ARE INCORRECT";
        }
        final double profit = calculateFarms(farm);
        return amountOfFarm(profit, farm.getCost());
    }

    private boolean farmValidator(Farm farm) {
        if (farm.getCost() < 500 || farm.getCost() > 1000) {
            return false;
        }
        if (farm.getCows().size() < 50 || farm.getCows().size() > 100) {
            return false;
        }
        for (Cow cow : farm.getCows()) {
            if (cow.getMilk() < 1 || cow.getMilk() > 5) {
                return false;
            }
        }
        for (Cow cow : farm.getCows()) {
            if (cow.getEat() < 5 || cow.getEat() > 10) {
                return false;
            }
        }
        if (farm.getFeedPrice() < 1 || farm.getFeedPrice() > 3) {
            return false;
        }
        if (farm.getMilkPrice() < 5 || farm.getMilkPrice() > 10) {
            return false;
        }
        if (farm.getIncomeTax() < 10 || farm.getIncomeTax() > 20) {
            return false;
        }
        if (farm.getMilkmaidSalary() < 5 || farm.getMilkmaidSalary() > 10) {
            return false;
        }
        return true;
    }

    private double calculateFarms(Farm farm) {
        double profit = 0;
        for (Cow cow : farm.getCows()) {
            double dirtyProfit = ((cow.getMilk() * farm.getMilkPrice()) - (cow.getEat() * farm.getFeedPrice()));
            double profitWithoutTax = dirtyProfit - (dirtyProfit * farm.getIncomeTax() / 100);
            profit = profit + ((profitWithoutTax - (profitWithoutTax * farm.getMilkmaidSalary() / 100)) * 365);
        }
        return profit;
    }

    private String amountOfFarm(double profit, double cost) {
        int amount = (int) (profit / cost);
        if (amount < 1) {
            return "NOT PROFITABLE. Amount of farms is " + amount;
        } else if (amount <= 3) {
            return "PROFITABLE. Amount of farms is " + amount ;
        } else {
            return "SUPER PROFITABLE. Amount of farms is " + amount;
        }
    }
}
