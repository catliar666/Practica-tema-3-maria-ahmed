package utils;

import java.util.Scanner;

public class Utils {

    public static void pulsaParaContinuar(){
        var s = new Scanner(System.in);
        System.out.print("Por favor, pulse cualquier tecla para continuar:");
        s.nextLine();
    }
    public static void cerrarSesion(){
        System.out.print("Cerrando sesión");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
    }
    public static void saliendoPrograma(){
        System.out.print("Saliendo del programa");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
    }
    public static void salirOpcion(){
        System.out.print("Volviendo al menú");
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
        System.out.println(". \n");
    }
    public static void limpiarPantalla(){
        for (int i = 0; i < 400; i++) {
            System.out.println();
        }
    }
}
