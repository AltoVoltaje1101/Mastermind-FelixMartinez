/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.Scanner;

public class Mastermind {

    public static void main(String[] args) {
        boolean winner=false;
        Scanner lectura = new Scanner(System.in);
        System.out.println("Instrucciones\nIngresa los colores utilizando un espacio para separarlos entre si"
                + "\n Una vez ingresada la clave, presionar enter\n Los circulos negros a la derecha"
                + "\n indican el numero de colores cuya posicion adivinaste"
                + "\n Y los circulos grises, representan el numero de colores que \ningresaste correctamente"
                + " pero  en una posicion erronea");
        int[] c = new int[2];
        System.out.println("Ingrese un valor del 4 al 6");
        int a = lectura.nextInt();
        lectura.nextLine();
        int b;
        
        do{
            System.out.println("Ingrese el numero de intentos que desea tener,"
                    + " este numero puede oscilar entre 10 y 15");
            b = lectura.nextInt();
            if (b>15||b<10) System.out.println("El valor ingresado no es "
                    + "permitido, ingrese otro");
        }while (b>15 || b<10);
        lectura.nextLine();
        
        Codigo codigo = new Codigo(a);
        String opciones = codigo.getOpciones();
        Comprobacion comprobacion = new Comprobacion(codigo, a);
        Tablero tablero = new Tablero(b, a);
        int i = 0;
        do {
            System.out.println("\nIngresa una clave separando cada "
                    + "color con un espacio en blanco");
            System.out.println("NA= naranja\tNE = negro\tRO = rojo\tVE = verde\t"
                    + "MO = morado\tAZ = azul");
            String respuesta = lectura.nextLine();
            respuesta = respuesta.toUpperCase();
            String si1 = respuesta.replaceAll("\\s", ",");
            String[] si = si1.split(",");
            if (si.length == a) {
                
                c = comprobacion.commprobar(respuesta, a, codigo.getOpciones());
                System.out.println(comprobacion.getCodigo().getClave());
                
                if (comprobacion.respuestas() == true) {
                    tablero.linea(respuesta, c, comprobacion.getIntentos());
                }
           
                i++;
                tablero.setFinalizar(false);
                tablero.showResults(respuesta,comprobacion.getIntentos());
                tablero.respuestasDerecha(comprobacion.getIntentos());
            } else {
                System.out.println("La cadena no cumple con los requisitos" + si.length);
            }
            if (c[0] >= a) {
                System.out.println("Felicidades, has ganado!");
                tablero.setFinalizar(true);
                tablero.showResults(respuesta,comprobacion.getIntentos());
                winner=true;
                
            } else if (comprobacion.getIntentos() >= b) {
                System.out.println("Mejor suerte para la proxima");
            }
        } while (comprobacion.getIntentos()< b && winner ==false);

        // TODO code application logic here
    }

}
