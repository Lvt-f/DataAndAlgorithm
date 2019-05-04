
/**
 * 递归的使用
 * */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val,int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("call :remove " + val + " in " + head);
        if(head == null) {
            System.out.print(depthString);
            System.out.println("return: "+head);
            return head;
        }
//        //头节点跟着的那个元素删除后剩下的链表
//        ListNode result =removeElements(head.next,val);
//        if(head.val == val)
//            return result;
//        else {
//            head.next = result;
//            return head;
//        }
        ListNode result = removeElements(head.next,val,depth+1);
        System.out.print(depthString);
        System.out.println("After remove "+val+ " :"+result);

        ListNode ret;
        if(head.val == val){
            ret = result;
        }else {
            head.next = result;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: "+ret);
        return ret;
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <depth ; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args){
        int[] num = {1,2,3,4,5,6,7,8};
        ListNode head = new ListNode(num);
        System.out.println(head);

        ListNode res = new Solution3().removeElements(head,4,0);
        System.out.println(res);
    }
}
