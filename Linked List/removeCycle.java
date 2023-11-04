public class removeCycle{

    public static class Node{
        int data; 
        Node next;

        // Constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // head and tail of list are static 
    public static Node head;
    public static Node tail;

    public static boolean isCycle() {   // Floyd's Cycle Finding Algorithm
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;   // sow +1
            fast = fast.next.next;  // fast +2
            if(slow == fast){
                return true;    // cycle exist
            }
        }
        return false;   // cycle not exist
    }

    public static void removeCircularList(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                cycle = true;
                break;
            } 
        }
        
        if(cycle == false){
            return;
        }        

        // find meeting point
        slow = head;
        Node prev = null;   // last node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;   // remove cycle
    }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1-->2-->3-->1
        System.out.println(isCycle());
        removeCircularList();
        System.out.println(isCycle());
    }
}
