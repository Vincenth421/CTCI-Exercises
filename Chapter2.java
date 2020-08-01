public class Chapter2
{
     private static class Node{
          int val;
          Node next;

          public Node(int val, Node next)
          {
               this.val = val;
               this.next = next;
          }

          public Node(int val)
          {
               this(val, null);
          }
     }

     /** Question 1
     * Write code to remove duplicates from an unsorted linked list.
     **/
     public static Node removeDups(Node head)
     {
          //Use dummy node and intialize 2 pointers, one to track position, one to move through the array to check duplicates
          Node h = new Node(0, head);
          Node p = head;
          Node p2 = p;

          //iterate through whole list
          while(p != null)
          {
               //keep track of current value
               int currVal = p.val;

               //start checking on the next node
               p2 = p.next;

               //set previous node to current for now
               Node prev = p;

               //iterate p2 checker node through whole list
               while(p2 != null)
               {
                    //if we find duplicate, delete the node
                    if(p2.val == currVal)
                    {
                         prev.next = p2.next;
                    }

                    //set the previous node to the current position, and advance p2
                    prev = p2;
                    p2 = p2.next;
               }

               //advance position pointer
               p = p.next;
          }

          //make sure to return dummy node next
          return h.next;
     }

     /** Question 2
     * Implement an algorithm to find the kth to last element of a singly linked list.
     **/
     public static Node kthToLast(Node head, int k)
     {
          //The algorithm uses the fact that when there is one pointer k nodes away from another, when the 2nd pointer reaches the end, the 1st will be kth from last.
          //Initialize our utility pointer nodes
          Node h = new Node(0, head);
          Node p = head;
          Node p2 = head;
          Node prev = h;

          //advance our p2 by k nodes from the head
          while(k > 0 && p2 != null)
          {
               p2 = p2.next;
               k--;
          }

          //if we reach the end of the list but k is not 0, k is too big so we return the original list.
          if(k > 0 && p2 == null) return head;

          //iterate until p2 is null at the end of the list.
          while(p2 != null)
          {
               prev = p;
               p = p.next;
               p2 = p2.next;
          }

          //skip the current node p is pointing at, which is going to be the kth to last node.
          prev.next = p.next;
          return h.next;
     }

     /** Question 3
     * Implement an algorithm to delete a node in the middle (i.e., any node but
     * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
     * that node.
     **/
     public static Node removeNode(Node node)
     {
          node.val = node.next.val;
          node.next = node.next.next;
     }

     private static void printList(Node head){
          Node p = head;

          while(p != null)
          {
               System.out.print(p.val + " ");
               p = p.next;
          }

          System.out.println();
     }

     public static void main(String[] args)
     {
          Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
          head = kthToLast(head, 2);
          printList(head);
     }
}
