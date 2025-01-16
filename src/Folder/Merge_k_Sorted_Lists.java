
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode ans=null;
        for(int i=0;i<lists.length;i++){
            ans=helper(lists[i],ans);
        }
        return ans;
    }
    private ListNode helper(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<l2.val){
            l1.next= helper(l1.next,l2);
            return l1;
        }
        else{
            l2.next= helper(l2.next,l1);
            return l2;
        }
    }
}