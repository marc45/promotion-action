package leet.code;

/**
 * 单链表反转
 */
public class ReverseLinkedList {

    private Node<String> header;

    private int size;

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        Node nodes = list.add("4");

        list.print(nodes);
        System.out.println("==============");
        nodes = list.reverse(nodes);
        list.print(nodes);
    }

    /**
     * 比如：1,2,4,5,3
     * 第一次：2,1,4,5,3
     * 第二次：2,4,1,5,3
     *
     * @param header
     * @return
     */
    public Node reverse(Node header) {
        if (null == header) {
            return header;
        }
        Node reHead = null;// 定义新链表头结点
        while (null != header) {
            Node cur = header.next; // 记录下一个节点
            header.next = reHead;   // 断链
            reHead = header;// 让rehead指向head
            header = cur;// 将head指向下一个节点
        }
        return reHead;
    }

    public Node<String> add(String e) {
        Node<String> newNode = new Node<String>(e);

        if (null == header) {
            header = newNode;
            size++;
            return newNode;
        }

        Node<String> temp = header;
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
        return header;
    }

    public void print(Node<String> header) {
        if (null == header) {
            return;
        }

        Node temp = header;
        while (null != temp) {
            System.out.println(temp.data + ",");
            temp = temp.next;
        }
    }

    //定义链表节点
    private static class Node<E> {
        private E data;         //节点元素
        private Node<E> next;   //指向下一个节点元素指针

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }
    }
}
