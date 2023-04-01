package proyectotowerdefense;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Ryan Morales. 
 */
public class Sonido {
    private void reproducirSonido(String archivo) {
    try {
        URL url = getClass().getResource(archivo);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch (UnsupportedAudioFileException | IOException 
            | LineUnavailableException e) {
        e.printStackTrace();
        
    }
    
    }
}
