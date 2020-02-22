package lesson12;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
//        System.out.println("ArrayList size when create: " + list.size());
        if (!list.isEmpty()) {
            System.out.println(list.get(0));
        }

        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
//        System.out.println("ArrayList with elements: " + list.size());
//        System.out.println("List get method: " + list.get(1));
//
//        list.add(1, "InnerElement");
//        System.out.println("ArrayList with elements: " + list.size());
//        System.out.println("List get method: " + list.get(1));

        System.out.println("List element 0: " + list.get(0));
        System.out.println("ArrayList with elements: " + list.size());
        list.set(0, "SetElement");
        System.out.println("List element 0: " + list.get(0));
        System.out.println("ArrayList with elements: " + list.size());

        if (list.contains("SetElement")) {
            System.out.println("List c contains 'SetElement'");
        } else {
            System.out.println("List doesn't contains it");
        }

        System.out.println("List size before remove some element: " + list.size());
        list.remove("Element2");
        System.out.println("List size after remove some element: " + list.size());

        list.clear();
        System.out.println("List isEmpty after clear: " + list.isEmpty());

        LinkedList linkedList = new LinkedList();
        int[] array = {1, 2, 3, 4, 5};
        linkedList.addAll(list);
    }
}
