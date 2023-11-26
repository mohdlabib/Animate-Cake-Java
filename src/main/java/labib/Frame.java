package labib;

import java.awt.Image;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Frame extends JFrame {

    public static int LEBAR = 600, TINGGI = 750;
    Image[] animateCutImages;
    
    public Frame() {
        super();
        setSize(LEBAR,TINGGI);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        animateCutImages = new Image[289];

        for(int i=0; i< animateCutImages.length;i++) {
            animateCutImages[i] = new ImageIcon("resources/animasi/animasi"+i+".jpg").getImage();
            // animateCutImages[i] = animateCutImages[i].getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        }

        add(new Cake(animateCutImages));

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
