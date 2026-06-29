package codingquestions;

class Node1{
int data;
Node1 next;
Node1(int data){
    this.data= data;
    this.next = null;
}
}

public class MiddleOfLinkedList {

    public static Node1 findMiddle(Node1 head){

        Node1 slow= head;
        Node1 fast = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
       return slow;
    }

    public static void main(String[] args) {
         Node1 head= new Node1(10);
         head.next= new Node1(20);
        head.next.next= new Node1(30);
        head.next.next.next= new Node1(40);
        //print list
        printList(head);
        //print middle element
        Node1 middle= findMiddle(head);
        System.out.println(middle.data);
    }

    //print linked list
    public static void printList(Node1 head){
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println("NULL");
    }
}
