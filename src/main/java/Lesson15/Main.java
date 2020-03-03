package Lesson15;


import java.util.*;

public class Main {
    public static void main(String[] args) {
//        setExample();

//        dynamicCheck(new Dog());
//        dynamicCheck(new Cat());
//
//        ArrayList<Animal> animals = new ArrayList<>();
//        animals.add(new Cat());
//        animals.add(new Dog());
//
//        ArrayList<Dog> dogs = new ArrayList<>();
//        ArrayList<Cat> cats = new ArrayList<>();
//        wildcardsExample(animals, dogs);
//        wildcardsExample(animals, cats);
//
//        ArrayList<Dog> dogs1 = new ArrayList<>();
//        dogs1.add(new Dog());
//        dogs1.add(new Cat());


        //Пример исользования Дженериков для коллекций, внутри которых дополнительные коллекции заданы
        final HashMap<String, HashMap<String, ArrayList<Boolean>>> schoolTests = new HashMap<>();
        final HashMap<String, ArrayList<Boolean>> classMap = new HashMap<>();

        test(classMap);
        test(classMap);

        schoolTests.put("777School", classMap);
        System.out.println(schoolTests.toString());
        //{777School={Alex=[true, true], Bob=[true, false]}}
    }

    private static void test(HashMap<String, ArrayList<Boolean>> classMap) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your name:");
        final String name = scanner.next();
        final ArrayList<Boolean> answers = writeAnswers();

        classMap.put(name, answers);
    }

    private static ArrayList<Boolean> writeAnswers() {
        ArrayList<Boolean> answers = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a man?");
        final boolean isMan = scanner.nextBoolean();
        System.out.println("Is adult");
        final boolean adult = scanner.nextBoolean();

        answers.add(isMan);
        answers.add(adult);
        return answers;
    }

    /**
     * Повторно рассмотрели применени Wildcards и отличия между extends & super в них
     */
    private static void wildcardsExample(ArrayList<? super Dog> animals, ArrayList<? extends Animal> collection) {
//        collection.add(new Dog());

        animals.add(new Dog());
        animals.add(new Husky());
    }

    /**
     * Пример использования динамической диспетчиризации.
     * Рассмотрели на пример Interface, не только наследование от классов.
     */
    private static void dynamicCheck(Action action) {
        action.set();
    }

    /**
     * Пример  использования Iterator in Set
     */
    private static void setExample() {
        HashSet<String> set = new HashSet<>();
        set.add("First");
        set.add("Second");
        set.add("Third");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.equals("Second")) {
                iterator.remove();
            } else {
                System.out.println(string);
            }
        }
        System.out.println(set.size());

//        for (int i = 0; i < set.size(); i++) {
//            System.out.println(iterator.next());
//        }
//        iterator.next();
    }
}
