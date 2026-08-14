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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;
        
        int index = 1;
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        while (curr != null && curr.next != null) {
            
            // Check if curr is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {
                
                // First critical point
                if (first == -1) {
                    first = index;
                }
                
                // If we already found a critical point
                if (last != -1) {
                    minDistance = Math.min(minDistance, index - last);
                }
                
                last = index;
            }
            
            prev = curr;
            curr = curr.next;
            index++;
        }
        
        // Fewer than two critical points
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }
        
        int maxDistance = last - first;
        
        return new int[]{minDistance, maxDistance};
    }
}