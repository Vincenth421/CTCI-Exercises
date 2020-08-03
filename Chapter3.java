public class Chapter3
{
     /** Question 1
     * Describe how you could use a single array to implement three stacks.
     **/
     //Divide array into 3 and use pointers to track start and end of each.

     /** Question 2
     * How would you design a stack which, in addition to push and pop, has a function min
     * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
     **/
     class MinStack {

          private Node head;

          public void push(int x) {

               //if the stack is empty, push x and set x as min
               if(head == null) head = new Node(x, x);

               //otherwise push x and set min to be the most recent min
               else head = new Node(x, Math.min(x, head.min), head);
          }

          //set head to next element
          public void pop() {
               head = head.next;
          }

          //return head value
          public int top() {
               return head.val;
          }

          //get the minimum currently stored at head
          public int getMin() {
               return head.min;
          }

          //Node stores current value and most recent min it has seen.
          private class Node {
               int val;
               int min;
               Node next;

               private Node(int val, int min) {
                    this(val, min, null);
               }

               private Node(int val, int min, Node next) {
                    this.val = val;
                    this.min = min;
                    this.next = next;
               }
          }
     }

     /** Question 3 **/

     /** Question 4
     * Implement a MyQueue class which implements a queue using two stacks.
     **/
     class MyQueue {
          //s1 is for pushing, s2 is for peek and pop
          Stack<Integer> s1;
          Stack<Integer> s2;

          /** Initialize your data structure here. */
          public MyQueue() {
               s1 = new Stack<>();
               s2 = new Stack<>();
          }

          /** Push element x to the back of queue. */
          public void push(int x) {

               //transfer elements from s2 to s1 before pushing
               while(!s2.empty())
               {
                    s1.push(s2.pop());
               }

               s1.push(x);
          }

          /** Removes the element from in front of queue and returns that element. */
          public int pop() {

               //transfer elements from s1 to s2 for popping
               while(!s1.empty())
               {
                    s2.push(s1.pop());
               }

               return s2.pop();
          }

          /** Get the front element. */
          public int peek() {

               //transfer elements from s1 to s2 for peeking
               while(!s1.empty())
               {
                    s2.push(s1.pop());
               }

               return s2.peek();
          }

          /** Returns whether the queue is empty. */
          public boolean empty() {

               //if both stacks are empty, then queue is empty
               return s1.empty() && s2.empty();
          }
     }


     public static void main(String[] args)
     {

     }
}
