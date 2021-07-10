import java.util.Iterator;
import java.util.LinkedList;

public class MidElementLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);
        linkedList.add(11);


        System.out.println(getMiddleElement(linkedList).toString());



        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.add("aweawe");
        linkedList2.add("svwv");
        linkedList2.add("we");
        linkedList2.add("wekwvw");
        linkedList2.add(",zz");
        linkedList2.add("qwqp");
        linkedList2.add("qwq");
        linkedList2.add("qwqeq");
        linkedList2.add("acqwc");
        linkedList2.add("qwqe32");
        linkedList2.add("wew");
        System.out.println(getMiddleElement(linkedList2).toString());


    }

    public static <T> T getMiddleElement(LinkedList<T> linkedList) {
        Iterator<T> fast = linkedList.iterator();
        int length = 0;
        Iterator<T> middle = linkedList.iterator();
        T result = null;

        while (fast.hasNext()) {
            fast.next();
            length++;
            if (length % 2 == 0) {
                result = middle.next();
            }
        }

        if (length % 2 == 1) {
            result = middle.next();
        }

        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + result);
        return result;
    }
}
