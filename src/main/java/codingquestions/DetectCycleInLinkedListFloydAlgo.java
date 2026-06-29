package codingquestions;

class Node2{
    int data;
    Node2 next;
    Node2(int data){
        this.data= data;
        this.next = null;
    }
}

public class DetectCycleInLinkedListFloydAlgo {

    public static Boolean detectCycle(Node2 head){
        Node2 slow = head;
        Node2 fast= head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Node2 head= new Node2(10);
        head.next= new Node2(20);
        head.next.next= new Node2(30);
        head.next.next.next= new Node2(40);
        head.next.next.next.next= new Node2(40);
        //Create cycle
        head.next.next.next.next= head.next;

        //detect cycle
        System.out.println(detectCycle(head));

    }
}
