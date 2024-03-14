package org.example;

import java.util.Stack;

public class FlattenMultilevelLinkedList {

    // Clase Node anidada
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    // Método para aplanar la lista doblemente enlazada con múltiples niveles
    public Node flatten(Node head) {
        if (head == null) return null;

        Node dummy = new Node(0); // Nodo ficticio para facilitar la manipulación
        Node tail = dummy; // Puntero al último nodo

        Stack<Node> stack = new Stack<>(); // Usamos una pila para mantener el orden correcto de los nodos
        stack.push(head); // Comenzamos con el nodo principal

        while (!stack.isEmpty()) {
            Node current = stack.pop(); // Tomamos el nodo superior de la pila

            if (current.next != null) {
                stack.push(current.next); // Si hay un nodo siguiente, lo agregamos a la pila
            }

            if (current.child != null) {
                stack.push(current.child); // Si hay un hijo, lo agregamos a la pila
                current.child = null; // Eliminamos el hijo, ya que lo hemos agregado a la pila
            }

            tail.next = current; // Conectamos el nodo actual al final de la lista aplanada
            current.prev = tail; // Establecemos el puntero previo del nodo actual
            tail = current; // Actualizamos el puntero de la cola al nodo actual
        }

        dummy.next.prev = null; // Eliminamos el nodo ficticio del inicio
        return dummy.next; // Devolvemos el primer nodo de la lista aplanada
    }


    // Método para imprimir la lista aplanada
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Agregamos un salto de línea para mayor claridad
    }

    public static void main(String[] args) {
        // Crear y configurar la lista doblemente enlazada con múltiples niveles
        FlattenMultilevelLinkedList solution = new FlattenMultilevelLinkedList();
        Node head = solution.new Node(1);
        head.next = solution.new Node(2);
        head.next.prev = head;
        head.next.next = solution.new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = solution.new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = solution.new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = solution.new Node(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.child = solution.new Node(7);
        head.next.next.child.next = solution.new Node(8);
        head.next.next.child.next.prev = head.next.next.child;
        head.next.next.child.next.next = solution.new Node(9);
        head.next.next.child.next.next.prev = head.next.next.child.next;
        head.next.next.child.next.next.next = solution.new Node(10);
        head.next.next.child.next.next.next.prev = head.next.next.child.next.next;
        head.next.next.child.child = solution.new Node(11);
        head.next.next.child.child.next = solution.new Node(12);
        head.next.next.child.child.next.prev = head.next.next.child.child;

        // Llamar al método flatten para aplanar la lista
        Node flattenedList = solution.flatten(head);

        // Imprimir la lista aplanada
        printList(flattenedList);
    }
}
