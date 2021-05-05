
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author felix_5bh1a4y
 */
public class Comprobacion {

    public Codigo codigo;
    String comparacion;
    HashSet<String> pasados;
    public int intentos;
    public int correctos;
    public int casi;
    public boolean siSePuede;

    public Comprobacion(Codigo codigo, int a) {
        this.codigo = codigo;
        this.pasados = new HashSet<String>();
        this.intentos = 0;
        casi = 0;

    }

    public int[] commprobar(String respuesta, int a, String noRepetidos) {
        int[] respuestas = new int[2];
        respuesta = respuesta.replaceAll("\\s", ",");
        noRepetidos = noRepetidos.replaceAll("\\s", ",");
        String[] respuesta1 = respuesta.split(",");
        String[] clave = codigo.getClave().split(",");
        int[] colores = new int[6];
        int[] respuesta2 = new int[6];
        for (int i = 0; i < 6; i++) {
            colores[i] = 0;
            respuesta2[i] = 0;
        }
        // for (int i = 0; i < clave.length; i++) {
        //   System.out.print(clave[i] + ",");
        //  }
        if (this.pasados.contains(respuesta) == false) {
            this.pasados.add(respuesta);
            this.siSePuede = true;
            System.out.println("Cadenas ya utilizadas: " + this.pasados + "\t");
            for (int i = 0; i < clave.length; i++) {
                switch (clave[i]) {
                    case "NA":
                        colores[0]++;
                        break;
                    case "AZ":
                        colores[1]++;
                        break;
                    case "MO":
                        colores[2]++;
                        break;
                    case "RO":
                        colores[3]++;
                        break;
                    case "NE":
                        colores[4]++;
                        break;
                    case "VE":
                        colores[5]++;
                        break;

                }
            }
            for (int i = 0; i < clave.length; i++) {
                boolean igual = respuesta1[i].equals(clave[i]);
                if (igual == true) {
                    respuestas[0]++;
                    switch (clave[i]) {
                        case "NA":
                            if(respuesta2[0]>=colores[0])
                                respuestas[1]--;
                            respuesta2[0]++;
                            break;
                        case "AZ":
                            if(respuesta2[1]>=colores[1])
                                respuestas[1]--;
                            respuesta2[1]++;
                            break;
                        case "MO":
                            if(respuesta2[2]>=colores[2])
                                respuestas[1]--;
                            respuesta2[2]++;
                            break;
                        case "RO":
                            if(respuesta2[3]>=colores[3])
                                respuestas[1]--;
                            respuesta2[3]++;
                            break;
                        case "NE":
                            if(respuesta2[4]>=colores[4])
                                respuestas[1]--;
                            respuesta2[4]++;
                            break;
                        case "VE":
                            if(respuesta2[5]>=colores[5])
                                respuestas[1]--;
                            respuesta2[5]++;
                            break;

                    }
                } else if (codigo.getClave().contains(respuesta1[i])) {
                    switch (respuesta1[i]) {
                        case "NA":
                            if (respuesta2[0] < colores[0]) {
                                respuesta2[0]++;
                                respuestas[1]++;
                            }
                            break;
                        case "AZ":
                            if (respuesta2[1] < colores[1]) {
                                respuesta2[1]++;
                                respuestas[1]++;
                            }
                            break;
                        case "MO":
                            if (respuesta2[2] < colores[2]) {
                                respuesta2[2]++;
                                respuestas[1]++;
                            }
                            break;
                        case "RO":
                            if (respuesta2[3] < colores[3]) {
                                respuesta2[3]++;
                                respuestas[1]++;
                            }
                            break;
                        case "NE":
                            if (respuesta2[4] < colores[4]) {
                                respuesta2[4]++;
                                respuestas[1]++;
                            }
                            break;
                        case "VE":
                            if (respuesta2[5] < colores[5]) {
                                respuesta2[5]++;
                                respuestas[1]++;
                            }
                            break;
                    }
                }
            }
            this.intentos++;
                System.out.println("Respuestas bien " + respuestas[0]);
                System.out.println("Respuestas casi bien " + respuestas[1]);

        } else {
            this.siSePuede = false;
            System.out.println("La cadena ya ha sido ingresada, pruebe de nuevo");
        }
        return respuestas;
    }

    public int getIntentos() {
        return intentos;
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public boolean respuestas() {
        return this.siSePuede;
    }
}
