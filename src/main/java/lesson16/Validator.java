package lesson16;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Validator {
    private static final String PATH_TO_MODEL_LIST = "/Users/kreeck/IdeaProjects/hillel/src/main/resources/lesson16/modellist.txt";
    private static final String PATH_TO_ID_LIST = "/Users/kreeck/IdeaProjects/hillel/src/main/resources/lesson16/idlist.txt";

    public static int checkId() {
        Random random = new Random();
        int id = random.nextInt(99) + 1;
        final ArrayList<Integer> ids = downloadIds();
        if (ids.size() > 100) {
            System.out.println("Service is busy. Try later.");
            return 0;
        }
        while (ids.contains(id)) {
            id = random.nextInt(99) + 1;
        }
        return id;
    }

    private static ArrayList<Integer> downloadIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        try(FileReader fileReader = new FileReader(PATH_TO_ID_LIST);
            Scanner scanner = new Scanner(fileReader)){
            while (scanner.hasNextLine()) {
                ids.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("Read file exception: ");
            e.printStackTrace();
        }
        return ids;
    }

    public static boolean checkModel(String model) {
        boolean exist = false;
        try(FileReader fileReader = new FileReader(PATH_TO_MODEL_LIST);
            Scanner scanner = new Scanner(fileReader)){
            while (scanner.hasNextLine()) {
                if (model.equalsIgnoreCase(scanner.next())) {
                    exist = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Read file exception: ");
            e.printStackTrace();
        }
        return exist;
    }

    public static boolean validateColour(String colour) {
        return colour != null
                && !colour.trim().isEmpty()
                && !colour.trim().contains(" ");
    }
}
