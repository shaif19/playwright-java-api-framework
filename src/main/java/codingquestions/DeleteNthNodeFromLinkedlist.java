//First, make a gap of N nodes between them.
//Then move both together.
//When fast reaches the end,
//slow will be standing just before the node to delete.

package codingquestions;

class Node3{
    int data;
    Node3 next;
    Node3(int data){
        this.data= data;
        this.next = null;
    }
}

public class DeleteNthNodeFromLinkedlist {

    public static Node3 removeNthNode(Node3 head, int n) {

        Node3 dummy = new Node3(-1);
        dummy.next = head;

        Node3 slow = dummy;
        Node3 fast = dummy;
        //Move fast n+1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //Move fast & slow together
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Remove nth node
        slow.next = slow.next.next;
        return dummy.next;

    }

    // Print linked list
    public static void printList(Node3 head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node3 head = new Node3(10);
        head.next = new Node3(20);
        head.next.next = new Node3(30);
        head.next.next.next = new Node3(40);
        head.next.next.next.next = new Node3(50);
        head = removeNthNode(head, 2);
        printList(head);


    }
}