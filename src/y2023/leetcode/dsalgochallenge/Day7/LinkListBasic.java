package y2023.leetcode.dsalgochallenge.Day7;

import java.util.*;

public class LinkListBasic {
    static LinkList head = null;

    public static void main(String[] args) {
        LinkListBasic obj = new LinkListBasic();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);
        obj.add(6);
        //   obj.print();
        //obj.removeElement(head, 6);
        obj.print(head);
        obj.reverse(head);
        obj.print(head);

    }

    LinkList add(int val) {
        LinkList node = head;
        LinkList newNode = new LinkList(val);
        if (head == null) {
            head = newNode;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }

        return node;
    }

    void print(LinkList list) {
        LinkList node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    LinkList removeElement(LinkList head, int val) {
        LinkList prev = new LinkList(0);
        LinkList cur = head;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else prev = cur;
            cur = cur.next;

        }
        return prev.next;
    }

    LinkList reverse(LinkList head) {

        if (head == null || head.next == null) {
            return head;
        }
        LinkList p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }
}

class LinkList {
    int val;
    LinkList next;

    LinkList(int val) {
        this.val = val;
        this.next = null;
    }
}