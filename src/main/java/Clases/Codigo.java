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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

public class Codigo {

    public String clave;
    public String noRepetidos;

    public Codigo(int a) {
        String[] Color = {"RO,", "NA,", "AZ,", "NE,", "VE,","MO,"};
        this.noRepetidos = "";
        Random numero = new Random();
        int b;
        this.clave = "";
        
        for (int i = 0; i < a; i++) {
            b = numero.nextInt(a);
            if(this.noRepetidos.contains(Color[b])==false){
            this.noRepetidos=this.noRepetidos+Color[b];
            }
            else i--;
        }
        String[] opcion = noRepetidos.split(",");
        for (int i = 0; i < a; i++) {
            b = numero.nextInt(a);
            this.clave = this.clave + opcion[b]+",";
        }
        System.out.println("clave="+this.clave);
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getOpciones() {
        return noRepetidos;
    }
   
}
