package labib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cake extends JPanel implements ActionListener {

    Image planCircle, circleCream1c, circleCream2s, table, gorden, bgImage, bg2Image;
    int frame = 0, timeLalu = 0, kelipatan = 0;
    int cakeX, cake2x = 0;
    int state = 0, frameCut = 0;
    boolean isMove = true;
    Timer timer;
    Image[] cakesImage;
    Image[] animateCutImages;

    Cake(Image[] ranimImgs) {
        setPreferredSize(new Dimension(Frame.LEBAR,Frame.TINGGI));
        table = new ImageIcon("resources/table3.png").getImage();
        table = table.getScaledInstance(750, 400, Image.SCALE_DEFAULT);
        gorden = new ImageIcon("resources/rooftop.png").getImage();
        gorden = gorden.getScaledInstance(750, 128, Image.SCALE_DEFAULT);

        bgImage = new ImageIcon("resources/bg1.jpg").getImage();
        bg2Image = new ImageIcon("resources/bg4.jpg").getImage();
        cakeX = Frame.LEBAR;

        cakesImage = new Image[] {
            new ImageIcon("resources/plan-circle.png").getImage(),
            new ImageIcon("resources/circle-cream1-c.png").getImage(),
            new ImageIcon("resources/circle-top1-c.png").getImage(),
        };

        animateCutImages = ranimImgs;

        timer = new Timer(1000 / 60, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        if(state == 0) {
            g2.drawImage(bgImage, Frame.LEBAR / 2 - bgImage.getWidth(null) + 510, 0, null);
            g2.drawImage(table, -75, Frame.TINGGI - table.getHeight(null) + 120, null);

            int imgHeight = cakesImage[frame].getHeight(null);
            g2.drawImage(cakesImage[frame], cakeX, Frame.TINGGI - imgHeight - 100, null);
        }

        if(state == 1) {
            g2.drawImage(bg2Image, 0, 0, null);    

            int imgWidth = animateCutImages[frameCut].getWidth(null);
            int imgHeight = animateCutImages[frameCut].getHeight(null);    

            g2.drawImage(animateCutImages[frameCut], Frame.LEBAR / 2 - imgWidth / 2, Frame.TINGGI / 2 - imgHeight / 2, null);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timeLalu += 1000 / 20;

        if(state == 0) {

            if(!isMove && timeLalu%2000 == 0) {

                if (frame >= cakesImage.length - 1) {
                    isMove = true;
                } else frame++;
            }

            if(timeLalu%100 == 0 && isMove) {
                cakeX -= 10;

                if(cakeX <= Frame.LEBAR / 2 - cakesImage[frame].getWidth(null) / 2 && cake2x == 0) {
                    isMove = false;
                    cake2x = 1;
                }

                if(cakeX < 0 - cakesImage[frame].getWidth(null)) {
                    isMove = true;
                    cakeX = Frame.LEBAR;
                    state = 1;
                    cake2x = 0;
                    frame = 0;
                }
            }
        }

        if(state == 1) {
            frameCut++;

            if (frameCut >= animateCutImages.length) {
                state = 0;
                frameCut = 0;
            }
        }

        if (timeLalu >= 5000) {
            timeLalu = 0;
        }

        repaint();
    }    
}