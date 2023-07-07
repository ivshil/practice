package p5.linked.list;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class DoublyLinkedListNode11 {
    public int data;
    public DoublyLinkedListNode11 next;
    public DoublyLinkedListNode11 prev;

    public DoublyLinkedListNode11(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList11 {
    public DoublyLinkedListNode11 head;
    public DoublyLinkedListNode11 tail;

    public DoublyLinkedList11() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode11(int nodeData) {
        DoublyLinkedListNode11 node = new DoublyLinkedListNode11(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper11 {
    public static void printList(DoublyLinkedListNode11 node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result11 {

    /*
     * Complete the 'sortedInsert' function below.
     *
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_DOUBLY_LINKED_LIST llist
     *  2. INTEGER data
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

    public static DoublyLinkedListNode11 sortedInsert(DoublyLinkedListNode11 llist, int data) {
        // Write your code here
        int pos = 0;
        DoublyLinkedListNode11 curNode = llist;
        DoublyLinkedListNode11 newNode = new DoublyLinkedListNode11(data);

        if (curNode == null) {
            return newNode;
        }

        while (true){
            pos++;
            if (curNode.data > data) {
                newNode.prev = curNode.prev;
                newNode.next = curNode;
                curNode.prev = newNode;
                if (pos == 1) {
                    llist = newNode;
                }
                break;
            } else if (curNode.data <= data) {
                if (curNode.next == null) {
                    newNode.prev = curNode;
                    newNode.next = null;
                    curNode.next = newNode;
                    break;
                } else if (curNode.next.data > data) {
                    newNode.prev = curNode;
                    newNode.next = curNode.next;
                    curNode.next.prev = newNode;
                    curNode.next = newNode;
                    break;
                } else {
                    curNode = curNode.next;
                }
            } else {
                curNode = curNode.next;
            }
        }
        return llist;
    }

}

public class Task11_InsertingANodeIntoASortedDoublyLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList11 llist = new DoublyLinkedList11();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode11(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int data = Integer.parseInt(bufferedReader.readLine().trim());

                DoublyLinkedListNode11 llist1 = Result11.sortedInsert(llist.head, data);

                DoublyLinkedListPrintHelper11.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

