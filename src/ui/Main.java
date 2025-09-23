package ui;

import structures.Pila;
import structures.Cola;
import structures.TablasHash;
import structures.ListaEnlazadaGenerica;
import structures.PilaGenerica;
import structures.Caja;
import structures.PilaCajaGenerica;
import structures.PilaCajaGenericaWildcard;

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
            System.out.println("IndexOutOfBoundsException al hacer Pop en pila vacia.");
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
            System.out.println("IndexOutOfBoundsException al hacer dequeue en cola vacia.");
        }

        System.out.println("\nPrueba de TablasHash ");
        try {
            TablasHash tabla = new TablasHash(5);

            tabla.insert(1, 10);
            tabla.insert(6, 20); //colision
            tabla.insert(2, 30);

            System.out.println("Busqueda 10 en key 1: " + tabla.search(1, 10));
            System.out.println("Busqueda 20 en key 6: " + tabla.search(6, 20));
            System.out.println("Busqueda 50 en key 2: " + tabla.search(2, 50));

            tabla.delete(1, 10);
            System.out.println("Buscar 10 en key 1 despues de eliminacion: " + tabla.search(1, 10));
        } catch (Exception e) {
            System.out.println("Error con TablasHash: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("\nPrueba de ListaEnlazadaGenerica");
        try {

            ListaEnlazadaGenerica<String> listaStrings = new ListaEnlazadaGenerica<>();
            listaStrings.agregar("Hola");
            listaStrings.agregar("CyED1");
            System.out.println("Primer elemento listaStrings: " + listaStrings.obtener(0)); 
            System.out.println("Segundo elemento listaStrings: " + listaStrings.obtener(1)); 
            System.out.println("Tamaño listaStrings: " + listaStrings.size());
            listaStrings.eliminar(0);
            System.out.println("Primer elemento luego de eliminar: " + listaStrings.obtener(0)); 

            ListaEnlazadaGenerica<Integer> listaEnteros = new ListaEnlazadaGenerica<>();
            listaEnteros.agregar(10);
            listaEnteros.agregar(20);
            listaEnteros.agregar(30);
            System.out.println("Tamaño listaEnteros: " + listaEnteros.size());
            System.out.println("Elementos listaEnteros:");
            for (int i = 0; i < listaEnteros.size(); i++) {
                System.out.println(listaEnteros.obtener(i));
            }
        } catch (Exception e) {
            System.out.println("Error con Lista enlazada generica: " + e.getMessage());
            e.printStackTrace();
        }

        //Segunda sesion
        System.out.println("\nPrueba de PilaGenerica<Integer>");
        PilaGenerica<Integer> pilaGen = new PilaGenerica<>(5);
        try {
            pilaGen.Push(100);
            pilaGen.Push(200);
            pilaGen.Push(300);
            pilaGen.Push(400);
            pilaGen.Push(500);
            try {
                pilaGen.Push(600);
            } catch (StackOverflowError e) {
                System.out.println("StackOverflowError en PilaGenerica al intentar hacer push de mas.");
            }
            int elementosActuales = pilaGen.getTop();
            for (int i = 0; i < elementosActuales; i++) {
                Integer valor = pilaGen.Pop();
                System.out.println("Pop PilaGenerica: " + valor);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException en PilaGenerica al hacer pop invalido.");
        }

        System.out.println("\nPrueba de PilaCajaGenerica con mismo tipo (String)");
        PilaCajaGenerica<String> pilaCajaGen = new PilaCajaGenerica<>(5);
        try {
            Caja<String> c1 = new Caja<>();
            c1.setContenido("Caja1 String");
            Caja<String> c2 = new Caja<>();
            c2.setContenido("Caja2 String");
            pilaCajaGen.Push(c1);
            pilaCajaGen.Push(c2);
            int elementos = pilaCajaGen.getTop();
            for (int i = 0; i < elementos; i++) {
                Caja<String> c = pilaCajaGen.Pop();
                System.out.println("Pop PilaCajaGenerica: " + c.getContenido());
            }
        } catch (Exception e) {
            System.out.println("Error en PilaCajaGenerica: " + e.getMessage());
        }

        System.out.println("\nPrueba de PilaCajaGenericaWildcard");
        PilaCajaGenericaWildcard pilaCajaGenW = new PilaCajaGenericaWildcard(5);
        try {
            Caja<Double> c3 = new Caja<>();
            c3.setContenido(45.67);
            Caja<String> c4 = new Caja<>();
            c4.setContenido("Caja wildcard");
            pilaCajaGenW.Push(c3);
            pilaCajaGenW.Push(c4);
            int elementos = pilaCajaGenW.getTop();
            for (int i = 0; i < elementos; i++) {
                Caja<?> c = pilaCajaGenW.Pop();
                System.out.println("Pop PilaCajaGenericaWildcard: " + c.getContenido());
            }
        } catch (Exception e) {
            System.out.println("Error en PilaCajaGenericaWildcard: " + e.getMessage());
        }
    }
}
