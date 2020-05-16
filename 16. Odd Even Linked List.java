/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode oddEvenList(ListNode head) {
      if(head==null)return null;
      
      ListNode oddNext = head;
      if(head.next==null)return head;
      ListNode evenNext = head.next;
      while(evenNext!=null && evenNext.next!=null){
          ListNode startOfEvenNodes = oddNext.next;
          oddNext.next = evenNext.next;
          evenNext.next = oddNext.next.next;
          oddNext.next.next = startOfEvenNodes;
          evenNext = evenNext.next;
          oddNext = oddNext.next;
      }
      return head;
  }
}