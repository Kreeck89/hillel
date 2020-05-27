package farm;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FarmsCounterTest {
    private static Farm notProfitableFarm;
    private static Farm ProfitableFarm;
    private static Farm superProfitableFarm;
    private static Farm wrongFarm;
    private static FarmsCounter counter;
    private static ArrayList<Cow> cows;

    @BeforeClass
    public static void init() {
        final ArrayList<Cow> cows = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            cows.add(new Cow(5, 9));
        }
        notProfitableFarm = new Farm(1000, cows, 3, 5, 20, 10);
        ProfitableFarm = new Farm(1000, cows, 3, 5.45, 20, 10);
        superProfitableFarm = new Farm(1000, cows, 3, 6, 20, 10);
        counter = new FarmsCounter();
    }

    @Before
    public void setUp() {
        cows = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            cows.add(new Cow(5, 9));
        }
        wrongFarm = new Farm(1000, cows, 3, 6, 20, 10);
    }

    @Test
    public void countFarmsWithNotProfitableFarm() {
        final String count = counter.count(notProfitableFarm);
        assertThat(count, equalTo("NOT PROFITABLE. Amount of farms is -26"));
    }

    @Test
    public void countFarmsWithProfitableFarm() {
        final String count = counter.count(ProfitableFarm);
        assertThat(count, equalTo("PROFITABLE. Amount of farms is 3"));
    }

    @Test
    public void countFarmsWithSuperProfitableFarm() {
        final String count = counter.count(superProfitableFarm);
        assertThat(count, equalTo("SUPER PROFITABLE. Amount of farms is 39"));
    }

    @Test
    public void checkFarmValidatorCostFieldUnderPermissible() {
        wrongFarm.setCost(499.99);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorCostFieldOverPermissible() {
        wrongFarm.setCost(1000.01);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorCowsFieldUnderPermissible() {
        wrongFarm.getCows().remove(0);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorCowsFieldOverPermissible() {
        for (int i = 0; i < 51; i++) {
            cows.add(new Cow(5, 9));
        }
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorCowsMilkFieldUnderPermissible() {
        for (Cow cow : wrongFarm.getCows()) {
            cow.setMilk(0.99);
        }
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorCowsMilkFieldOverPermissible() {
        for (Cow cow : wrongFarm.getCows()) {
            cow.setMilk(5.01);
        }
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorCowsEatFieldUnderPermissible() {
        for (Cow cow : wrongFarm.getCows()) {
            cow.setEat(4.99);
        }
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorCowsEatFieldOverPermissible() {
        for (Cow cow : wrongFarm.getCows()) {
            cow.setEat(10.01);
        }
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorFeedPriceFieldUnderPermissible() {
        wrongFarm.setFeedPrice(0.99);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorFeedPriceFieldOverPermissible() {
        wrongFarm.setFeedPrice(3.01);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorMilkPriceFieldUnderPermissible() {
        wrongFarm.setMilkPrice(4.99);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorMilkPriceFieldOverPermissible() {
        wrongFarm.setMilkPrice(10.01);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorIncomeTaxFieldUnderPermissible() {
        wrongFarm.setIncomeTax(9.99);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorIncomeTaxFieldOverPermissible() {
        wrongFarm.setIncomeTax(20.01);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorMilkmaidSalaryFieldUnderPermissible() {
        wrongFarm.setMilkmaidSalary(4.99);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }

    @Test
    public void checkFarmValidatorMilkmaidSalaryFieldOverPermissible() {
        wrongFarm.setMilkmaidSalary(10.01);
        final String count = counter.count(wrongFarm);
        assertThat(count, equalTo("INPUT PARAMS ARE INCORRECT"));
    }
}