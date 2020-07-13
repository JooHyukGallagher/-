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
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode curNode = head;
        while(curNode != null) {
            length++;
            curNode = curNode.next;
        }
        
        int[] arr = new int[length];
        curNode = head;
        for(int i=0; i<length; i++) {
           arr[i] = curNode.val;
           curNode = curNode.next;
        }
        
        boolean answer = true;
        for(int i=0; i<length/2; i++) {
            if(arr[i] != arr[length-1-i]) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}