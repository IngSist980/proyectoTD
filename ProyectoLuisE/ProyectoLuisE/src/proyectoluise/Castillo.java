/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoluise;

/**
 *
 * @author Luis
 */
class Castillo {
    double puntosDeVida = 10;
    boolean destruido = false;

    void recibirDanio(double danio) {
        this.puntosDeVida -= danio;
        if (this.puntosDeVida <= 0) {
            this.destruido = true;
        }
    }
}
