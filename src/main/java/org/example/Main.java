package org.example;

public class Main {


    public static void main(String[] args) {
        // Crear y configurar la lista doblemente enlazada con múltiples niveles
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.prev = head.next.next.child;
        head.next.next.child.next.next = new Node(9);
        head.next.next.child.next.next.prev = head.next.next.child.next;
        head.next.next.child.next.next.next = new Node(10);
        head.next.next.child.next.next.next.prev = head.next.next.child.next.next;
        head.next.next.child.child = new Node(11);
        head.next.next.child.child.next = new Node(12);
        head.next.next.child.child.next.prev = head.next.next.child.child;

    }

    public class FlattenMultilevelLinkedList {

        // Método para aplanar la lista doblemente enlazada con múltiples niveles

        public Node flatten(Node head) {
            if (head == null) return null;

            Node current = head;
            while (current != null) {
                if (current.child != null) {
                    Node nextNode = current.next;
                    Node childTail = flatten(current.child);
                    current.next = current.child;
                    current.child.prev = current;
                    current.child = null;

                    if (nextNode != null) {
                        childTail.next = nextNode;
                        nextNode.prev = childTail;
                    }
                }
                current = current.next;
            }
            return head;
        }



        // Método para imprimir la lista aplanada
        public static void printList(Node head) {
            Node current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                if (current.child != null) {
                    printList(current.child); // Imprimir sublistas
                }
                current = current.next;
            }
        }

        // Método main y otros métodos si es necesario
    }
}


