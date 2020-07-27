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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode target = head;
        ListNode prevNode = null;
        ListNode curNode = null;
        while(target != null) {
            curNode = target;
            if(prevNode != null && prevNode.val == curNode.val){
                target = target.next;
                prevNode.next = target;
            } else {
                target = target.next;
                prevNode = curNode;
            }
        }
        
        return head;
    }
}