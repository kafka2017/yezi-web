/**
 * @description:
 *          Implement a LinkedList data structure using one of your preferred language
 * @author:wxf
 * @date:2020/2/27
 * @version:
 */
public class ListNodeDemo {

    class ListNode{

        int val;

        ListNode next;

        ListNode (int x){
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head){

        if(head == null){

            return null;
        }
        // head 为奇链表头结点，even 为奇链表尾节点
        ListNode odd = head,even = head.next,evenHead = even;

        while (even != null && even.next != null){

            odd.next = even.next;

            odd = odd.next;

            even.next = odd.next;

            even = even.next;

        }

        odd.next = evenHead;

        return head;
    }

    /**
     * 输出
     */
    public void outListNode(ListNode listNode){

        ListNode ln = listNode;

        while(ln != null){

            System.out.println(ln.next);

            if(ln.next != null){

                System.out.println("-->");
            }

            ln = ln.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {



    }
}
