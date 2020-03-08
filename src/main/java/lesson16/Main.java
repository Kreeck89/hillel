package lesson16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to registration in Our AutoService!");
        final int resultId = Validator.checkId();
        if (resultId == 0) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your car model:");
        String model = scanner.next();
        if (!Validator.checkModel(model)) {
            System.out.println("We don't work with " + model + " model of cars, Sorry!");
            return;
        }

        System.out.println("Enter colour of your car:");
        String colour = scanner.next();
        while (!Validator.validateColour(colour)) {
            System.out.println("Sorry, but you entered wrong colour. Try again");
            colour = scanner.next();
        }

        final Car car = new Car(resultId, model, colour);
        System.out.println("Is it you car data correct? write: y/n");
        System.out.println(car.toString());
        final String result = scanner.next();

        if (result.equalsIgnoreCase("y")) {
            System.out.println("Your car registered!");
            //Add logic for update file with ids
        } else {
            System.out.println("Try again or see you later!");
        }
    }
}
