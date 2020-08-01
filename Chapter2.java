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
     public static void removeNode(Node node)
     {
          //set node equal to the values of its next node
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

     /** Question 4
     * Write code to partition a linked list around a value x, such that all nodes less than x come
     * before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
     * to be after the elements less than x (see below). The partition element x can appear anywhere in the
     * "right partition"; it does not need to appear between the left and right partitions.
     **/
     public ListNode partition(ListNode head, int x)
     {
          //use dummy node and 2 tracking pointers, both with a previous tracker.
          ListNode h = new ListNode(0, head);
          ListNode p1 = head;
          ListNode p2 = head;
          ListNode prev1 = h;
          ListNode prev2 = h;

          //go through whole list
          while(p1 != null)
          {
               //if we find a value greater than the partition value, do some pointer manipulation
               if(p1.val >= x)
               {
                    //start scanning from next node over and set the prev of the scanner
                    p2 = p1.next;
                    prev2 = p1;

                    //iterate scanner until end of list or we find a value less than the partition value
                    while(p2 != null && p2.val >= x)
                    {
                         prev2 = p2;
                         p2 = p2.next;
                    }

                    //if we reached the end of the list, return the head
                    if(p2 == null) return h.next;

                    //set the previous node of the position tracker's next node to the new node we found.
                    prev1.next = p2;

                    //set the previous node of the new found node's next node to the found node's next. This "deletes" the new found node which we already put in the correct location.
                    prev2.next = p2.next;

                    //Now we set the new found node's next node to the current position tracker. Now our list looks like this: prev1 -> p2 -> p1 -> rest of the list, with p2 in the correct spot.
                    p2.next = p1;

                    //reset p1 to the correct spot
                    p1 = prev1.next;
               }

               //advance p1 and its prev pointer
               prev1 = p1;
               p1 = p1.next;
          }

          return h.next;
     }

     public static void main(String[] args)
     {
          Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
          head = kthToLast(head, 2);
          printList(head);
     }
}
