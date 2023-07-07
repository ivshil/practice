package p5.linked.list;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class DoublyLinkedListNode12 {
    public int data;
    public DoublyLinkedListNode12 next;
    public DoublyLinkedListNode12 prev;

    public DoublyLinkedListNode12(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList12 {
    public DoublyLinkedListNode12 head;
    public DoublyLinkedListNode12 tail;

    public DoublyLinkedList12() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode12 node = new DoublyLinkedListNode12(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper12 {
    public static void printList(DoublyLinkedListNode12 node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result12 {

    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */

    public static DoublyLinkedListNode12 reverse(DoublyLinkedListNode12 llist) {

        DoublyLinkedListNode12 tempNode1 =  null;
        DoublyLinkedListNode12 tempNode2 = llist;

        while (true) {
            tempNode1 = tempNode2.next;
            tempNode2.prev = tempNode2.next;
            tempNode2.next =  tempNode1;
            tempNode2 = tempNode2.prev;
            if (tempNode2 == null) {
                break;
            }
        }

        return tempNode1.prev;

//        DoublyLinkedListNode12 nextNode = llist.next;
//        DoublyLinkedListNode12 revNode = llist;
//        revNode.next = null;
//        while (true) {
//            if (nextNode.next != null) {
//                revNode.prev = nextNode;
//                DoublyLinkedListNode12 tempNode = revNode;
//                DoublyLinkedListNode12 tempNode2 = nextNode.next;
//                revNode = nextNode;
//                revNode.next = tempNode;
//                nextNode = tempNode2;
//            } else {
//                DoublyLinkedListNode12 tempNode = revNode;
//                revNode.prev = nextNode;
//                revNode = nextNode;
//                revNode.next = tempNode;
//                revNode.prev = null;
//                break;
//            }
//        }
//        return revNode;
    }

}

public class Task12_ReverseADoublyLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList12 llist = new DoublyLinkedList12();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                DoublyLinkedListNode12 llist1 = Result12.reverse(llist.head);

                DoublyLinkedListPrintHelper12.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

