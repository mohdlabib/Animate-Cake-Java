package labib;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Frame extends JFrame {

    public static int LEBAR = 600, TINGGI = 750;
    
    public Frame() {
        super();
        setSize(LEBAR,TINGGI);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        add(new Cake());

        pack();

        playMusic("resources/sound.wav");
    }

    public void playMusic(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
    
            clip.loop(Clip.LOOP_CONTINUOUSLY);
    
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
