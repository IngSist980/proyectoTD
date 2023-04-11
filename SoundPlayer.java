package proyectoluise;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Ryan Morales
 */
public class SoundPlayer {
    private Clip clip;

    public void reproducirEfectoDeSonido(String nombreDelArchivo) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
        (new File(nombreDelArchivo).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error al reproducir el efecto de sonido: " + ex.getMessage());
        }
    }

    public void detenerEfectoDeSonido() {
        clip.stop();
    }
    
}
