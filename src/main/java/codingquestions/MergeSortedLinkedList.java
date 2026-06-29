package codingquestions;

class ListNode{

    int data;
    ListNode next;

    ListNode(int data){
       this.data= data;
       this.next=null;
   }
}

public class MergeSortedLinkedList {

    public static ListNode mergeLists(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(list1!=null && list2!=null){
            if(list1.data<=list2.data){
                current.next= list1;
                list1= list1.next;
            }
            else{
                current.next= list2;
                list2=list2.next;
            }
            current = current.next;
        }
        if(list1!=null){
            current.next= list1;
        }
        if(list2!=null){
            current.next=list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        //create linked list 1
        ListNode list1 = new ListNode(1);
        list1.next= new ListNode(3);
        list1.next.next = new ListNode (5);

        //create linked list2
        ListNode list2 = new ListNode(2);
        list2.next= new ListNode(4);
        list2.next.next = new ListNode (6);

        ListNode result= mergeLists(list1,list2);
        printList(result);

    }
    // Print linked list
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.data+"->");
            head= head.next;
        }
        System.out.println("NULL");
    }
}
