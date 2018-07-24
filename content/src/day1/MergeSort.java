package day1;

/**
 * LinkedList Merge Sort Program
 */
public class MergeSort {

    public static Node push(Node head, int data) {

        Node node = new Node(data, null);

        node.setNext(head);

        return node;
    }

    public static Node getMiddle(Node head) {

        if ((head == null) || (head.getNext() == null))
            return head;

        Node slow, fast;
        slow = head;
        fast = head.getNext();

        while (fast != null) {

            fast = fast.getNext();

            if (fast != null) {

                fast = fast.getNext();
                slow = slow.getNext();

            }
        }

        return slow;
    }

    public static Node sort(Node head) {

        if ((head == null) || (head.getNext() == null))
            return head;

        Node middle = getMiddle(head);

        Node left = head;
        Node right = middle.getNext();
        middle.setNext(null);

        left = sort(left);
        right = sort(right);

        Node newHead = sortedMerge(left, right);

        return newHead;
    }

    public static Node sortedMerge(Node left, Node right) {

        if (left == null)
            return right;

        if (right == null)
            return left;

        Node result;

        if (left.getValue() < right.getValue()) {

            result = left;
            result.setNext(sortedMerge(left.getNext(), right));
        }
        else {
            result = right;
            result.setNext(sortedMerge(left, right.getNext()));
        }

        return result;
    }

    public static void print(Node head) {

        Node ptr = head;

        while (ptr != null) {

            System.out.print(ptr.getValue() + " -> ");

            ptr = ptr.getNext();
        }

        System.out.print("null\n");
    }

    public static void execute() {

        Node head = push(null, 1);
        head = push(head, 2);
        head = push(head, 3);
        head = push(head, 4);

        System.out.println("\n Before sorting ... \n");
        print(head);

        head = sort(head);

        System.out.println("\n After sorting ... \n");
        print(head);
    }
}
