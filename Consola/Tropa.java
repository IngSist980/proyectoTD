/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoluise;

/**
 *
 * @author Luis
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Tropa {
    String tipo;
    double puntosDeDanio;

    Tropa(String tipo) {
        this.tipo = tipo;
        switch (tipo) {
            case "Mago":
                this.puntosDeDanio = 1.5;
                break;
            case "Caballero":
                this.puntosDeDanio = 2.0;
                break;
            case "Arquero":
                this.puntosDeDanio = 1.0;
                break;
        }
    }
    
    boolean ganarEnCombate(Tropa enemigo) {
        if ((this.tipo.equals("Mago") && enemigo.tipo.equals
        ("Caballero")) ||
                (this.tipo.equals("Caballero") 
                && enemigo.tipo.equals("Arquero")) ||
                (this.tipo.equals("Arquero")
                && enemigo.tipo.equals("Mago"))) {
            return true;
        }
        return false;
    }
}
