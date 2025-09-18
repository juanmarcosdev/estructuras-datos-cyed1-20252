package ui;

import model.Pila;
import model.Cola;

public class Main {
    public static void main(String[] args) {

        System.out.println("Prueba de Pila ");
        Pila pila = new Pila(5);
        try {
            pila.Push(5);
            pila.Push(10);
            pila.Push(15);
            pila.Push(20);
            pila.Push(25);
            try {
                pila.Push(30);
            } catch (StackOverflowError e) {
                System.out.println("StackOverflowError al intentar Push extra en la pila.");
            }
            int elementosActuales = pila.getTop();
            for (int i = 0; i < elementosActuales; i++) {
                int valor = pila.Pop();
                System.out.println("Pop de pila: " + valor);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException al hacer Pop en pila vacía.");
        }

        System.out.println("\n Prueba de Cola ");
        Cola cola = new Cola(3);
        try {
            cola.enqueue(10);
            cola.enqueue(20);
            cola.enqueue(30);

            try {
                cola.enqueue(40);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException al intentar enqueue extra en la cola.");
            }
            for (int i = 0; i < 3; i++) {
                int valor = cola.dequeue();
                System.out.println("Dequeue de cola: " + valor);
            }

            cola.dequeue();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException al hacer dequeue en cola vacía.");
        }
    }
}
