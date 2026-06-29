package codingquestions;

import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;

class Node{
       int data;
       Node next;
       Node(int data){
           this.data= data;
           this.next= null;
       }
}

public class ReverseLinkedList {
    // Reverse the linked list
    public static Node reverse(Node head) {

        Node current = head;
        Node prev = null;
        Node next = null;
        while(current!=null){

            // Step 1: Save next node
            next = current.next;
            // Step 2: Reverse current node
            current.next= prev;
            // Step 3: Move prev one step ahead, “I have finished this node."
            prev= current;
            // Step 4: Move current one step ahead, "Now move to the next node."
            current= next;

        }
        return prev;
    }
    // Print linked list
    public static void printList(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
                    head=head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Create: 10 -> 20 -> 30 -> NULL
        Node head = new Node(10);
        head.next= new Node(20);
        head.next.next= new Node(30);
        System.out.println("Original list");
        printList(head);
        System.out.println("Reversed list");
        head= reverse(head);
        printList(head);
        System.out.println("new head");
        System.out.println(head.data);

    }
}

