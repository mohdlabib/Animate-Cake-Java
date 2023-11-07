package labib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cake extends JPanel implements ActionListener {

    Image planCircle, circleCream1c, circleCream2s, table, gorden, bgImage;
    int frame = 0, timeLalu = 0, kelipatan = 0;
    int cakeX, cake2x;
    boolean isMove = false;
    Timer timer;
    Image[] cakesImage;

    Cake() {
        setPreferredSize(new Dimension(Frame.LEBAR,Frame.TINGGI));
        table = new ImageIcon("resources/table3.png").getImage();
        table = table.getScaledInstance(750, 400, Image.SCALE_DEFAULT);
        gorden = new ImageIcon("resources/rooftop.png").getImage();
        gorden = gorden.getScaledInstance(750, 128, Image.SCALE_DEFAULT);

        bgImage = new ImageIcon("resources/bg1.jpg").getImage();
        // bgImage = bgImage.getScaledInstance(750, 750, Image.SCALE_DEFAULT);

        cakesImage = new Image[] {
            new ImageIcon("resources/plan-circle.png").getImage(),
            new ImageIcon("resources/circle-cream1-c.png").getImage(),
            new ImageIcon("resources/circle-top1-c.png").getImage(),
            new ImageIcon("resources/plan-circle.png").getImage(),
            new ImageIcon("resources/circle-cream1-s.png").getImage(),
            new ImageIcon("resources/circle-top1-s.png").getImage(),
            new ImageIcon("resources/plan-circle.png").getImage(),
            new ImageIcon("resources/circle-cream2-c.png").getImage(),
            new ImageIcon("resources/circle-top2-c.png").getImage(),
            new ImageIcon("resources/plan-circle.png").getImage(),
            new ImageIcon("resources/circle-cream2-s.png").getImage(),
            new ImageIcon("resources/circle-top2-s.png").getImage(),
            new ImageIcon("resources/plan-circle.png").getImage(),
            new ImageIcon("resources/circle-cream3-c.png").getImage(),
            new ImageIcon("resources/circle-top3-c.png").getImage(),
            new ImageIcon("resources/plan-circle.png").getImage(),
            new ImageIcon("resources/circle-cream3-s.png").getImage(),
            new ImageIcon("resources/circle-top3-s.png").getImage(),
            new ImageIcon("resources/plan-love.png").getImage(),
            new ImageIcon("resources/love-cream1-c.png").getImage(),
            new ImageIcon("resources/love-top1-c.png").getImage(),
            new ImageIcon("resources/plan-love.png").getImage(),
            new ImageIcon("resources/love-cream1-s.png").getImage(),
            new ImageIcon("resources/love-top1-s.png").getImage(),
            new ImageIcon("resources/plan-love.png").getImage(),
            new ImageIcon("resources/love-cream2-c.png").getImage(),
            new ImageIcon("resources/love-top2-c.png").getImage(),
            new ImageIcon("resources/plan-love.png").getImage(),
            new ImageIcon("resources/love-cream2-s.png").getImage(),
            new ImageIcon("resources/love-top2-s.png").getImage(),
            new ImageIcon("resources/plan-love.png").getImage(),
            new ImageIcon("resources/love-cream3-c.png").getImage(),
            new ImageIcon("resources/love-top3-c.png").getImage(),
            new ImageIcon("resources/plan-love.png").getImage(),
            new ImageIcon("resources/love-cream3-s.png").getImage(),
            new ImageIcon("resources/love-top3-s.png").getImage(),
            new ImageIcon("resources/plan-star.png").getImage(),
            new ImageIcon("resources/star-cream1-c.png").getImage(),
            new ImageIcon("resources/star-top1-c.png").getImage(),
            new ImageIcon("resources/plan-star.png").getImage(),
            new ImageIcon("resources/star-cream1-s.png").getImage(),
            new ImageIcon("resources/star-top1-s.png").getImage(),
            new ImageIcon("resources/plan-star.png").getImage(),
            new ImageIcon("resources/star-cream2-c.png").getImage(),
            new ImageIcon("resources/star-top2-c.png").getImage(),
            new ImageIcon("resources/plan-star.png").getImage(),
            new ImageIcon("resources/star-cream2-s.png").getImage(),
            new ImageIcon("resources/star-top2-s.png").getImage(),
            new ImageIcon("resources/plan-star.png").getImage(),
            new ImageIcon("resources/star-cream3-c.png").getImage(),
            new ImageIcon("resources/star-top3-c.png").getImage(),
            new ImageIcon("resources/plan-star.png").getImage(),
            new ImageIcon("resources/star-cream3-s.png").getImage(),
            new ImageIcon("resources/star-top3-s.png").getImage()
        };

        timer = new Timer(1000 / 20,this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(bgImage, Frame.LEBAR / 2 - bgImage.getWidth(null) + 600, 0, null);

        g2.drawImage(table, -75, Frame.TINGGI - table.getHeight(null) + 120, null);

        int imgWidth = cakesImage[frame].getWidth(null);
        int imgHeight = cakesImage[frame].getHeight(null);

        if(!isMove) cakeX = 300 - imgWidth / 2;

        cake2x = cakeX + Frame.LEBAR;

        g2.drawImage(cakesImage[frame], cakeX, Frame.TINGGI - imgHeight - 100, null);
        
        if(isMove && frame < cakesImage.length - 1) g2.drawImage(cakesImage[frame + 1], cake2x, Frame.TINGGI - imgHeight - 100, null);
        if(isMove && frame == cakesImage.length - 1) g2.drawImage(cakesImage[0], cake2x, Frame.TINGGI - imgHeight - 100, null);
        // g2.drawImage(gorden, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timeLalu += 1000 / 20;

        if(!isMove && timeLalu%1000 == 0) {
            frame++;
            ++kelipatan;

            if(kelipatan >= 2) {
                isMove = true;
                kelipatan = 0;
            }
        }

        if(timeLalu%10 == 0 && isMove) {
            cakeX -= 10;
            // if(cakeX < Frame.WIDTH - cakesImage[frame].getWidth(null) / 2) {
            if(cakeX < Frame.WIDTH - cakesImage[frame].getWidth(null) - 100) {
                isMove = false;
                int imgWidth = cakesImage[frame].getWidth(null);
                cakeX = 300 - imgWidth / 2;
                frame++;
            }
        }

        if (frame >= cakesImage.length) {
            frame = 0;
        }

        if (timeLalu % 1000 == 0) {
            timeLalu = 0;
        }

        repaint();
    }    
}
