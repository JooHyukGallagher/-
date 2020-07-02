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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ArrayList<Integer> list = new ArrayList<>();
        while(l1 != null){
            list.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        
        if(list.size() == 0){
            return null;
        }
        
        ListNode currentNode = new ListNode(list.get(0), null);
        ListNode answerList = currentNode;
        ListNode newNode = null;
        for(int i=1; i<list.size(); i++){
            newNode = new ListNode(list.get(i), null);
            currentNode.next = newNode;
            currentNode = newNode;
        }
        
        return answerList;
    }
}