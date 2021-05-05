/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author felix_5bh1a4y
 */
public class Tablero {

    public Circulo[][] circulos;
    public Circulo circulo;
    public Circulo[][] fin;
    public int[] respuestas;
    boolean finalizar;

    public Tablero(int intentos, int colores) {
        this.circulos = new Circulo[intentos][colores];
        this.fin = new Circulo[intentos][colores];
        this.finalizar = false;
    }

    public void linea(String respuesta, int[] resultados, int intento) {
        respuesta = respuesta.replaceAll("\\s", ",");
        String[] respuesta1 = respuesta.split(",");
        intento = intento - 1;
        for (int i = 0; i < respuesta1.length; i++) {
            switch (respuesta1[i]) {
                case "AZ":
                    circulos[intento][i] = new Circulo(30, "blue");
                    circulos[intento][i].setY(intento * 35 );
                    circulos[intento][i].setX(i * 50);
                    circulos[intento][i].makeVisible();
                    break;
                case "MO":
                    circulos[intento][i] = new Circulo(30, "purple");
                    circulos[intento][i].setY(intento * 35 );
                    circulos[intento][i].setX(i * 50);
                    circulos[intento][i].makeVisible();
                    break;
                case "NE":
                    circulos[intento][i] = new Circulo(30, "black");
                    circulos[intento][i].setY(intento * 35 );
                    circulos[intento][i].setX(i * 50);
                    circulos[intento][i].makeVisible();
                    break;
                case "RO":
                    circulos[intento][i] = new Circulo(30, "red");
                    circulos[intento][i].setY(intento * 35 );
                    circulos[intento][i].setX(i * 50);
                    circulos[intento][i].makeVisible();
                    break;
                case "VE":
                    circulos[intento][i] = new Circulo(30, "green");
                    circulos[intento][i].setY(intento * 35);
                    circulos[intento][i].setX(i * 50);
                    circulos[intento][i].makeVisible();
                    break;
                case "NA":
                    circulos[intento][i] = new Circulo(30, "orange");
                    circulos[intento][i].setY(intento * 35 );
                    circulos[intento][i].setX(i * 50);
                    circulos[intento][i].makeVisible();
                    break;
            }
            this.respuestas = resultados;
        }
    }

    public void showResults(String clave, int intento) {
        clave = clave.replaceAll("\\s", ",");
        String[] claves = clave.split(",");
        intento=intento-1;
        for (int i = 0; i < claves.length; i++) {
            switch (claves[i]) {
                case "AZ":
                    claves[i] = "blue";
                    break;
                case "RO":
                    claves[i] = "red";
                    break;
                case "NE":
                    claves[i] = "black";
                    break;
                case "MO":
                    claves[i] = "purple";
                    break;
                case "VE":
                    claves[i] = "green";
                    break;
                case "NA":
                    claves[i] = "orange";
                    break;

            }

        }
        if (this.finalizar == false) {
            for (int i = 0; i < claves.length; i++) {
                fin[intento][i] = new Circulo(30, "gray");
                fin[intento][i].setX(i * 50);
                fin[intento][i].setY(620);
                fin[intento][i].makeVisible();
            }
        } else {
            for (int i = 0; i < claves.length; i++) {
                fin[intento][i].changeColor(claves[i]);
            }
        }
    }

    public void setFinalizar(boolean fin) {
        this.finalizar = fin;
    }

    public void respuestasDerecha( int intento) {
        int c=0;
        intento--;
        for (int i = 0; i < respuestas[0]; i++) {
            Circulo azucar = new Circulo(20, "black");
            azucar.setX(350 + i * 20);
            azucar.setY(intento * 35);
            azucar.makeVisible();
            c=i+1;
            }
                for (int i = 0; i < respuestas[1]; i++) {
                    Circulo azucar1 = new Circulo(20, "gris");
                    azucar1.setX(350 + c * 20);
                    azucar1.setY(intento * 35 );
                    azucar1.makeVisible();
                    c++;
                }
        

    }
}
