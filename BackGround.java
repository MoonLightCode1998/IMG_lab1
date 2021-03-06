package GIK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.GeneralPath;
import java.util.LinkedList;
import java.util.Random;

public class BackGround extends JPanel implements ActionListener {
    private final int time = 15;
    LinkedList<platek> platek = new LinkedList<>();
    LinkedList<platek> platek2 = new LinkedList<>();
    RectOne a;


    Random rand = new Random();

    public BackGround() {
        for (int x = 0; x < 200; x++) {
            platek.add(new platek(rand.nextInt(1500), rand.nextInt(800)));

        }
        for (int x = 0; x < 4000; x++) {
            platek2.add(new platek(rand.nextInt(1500), rand.nextInt(16000)));

        }

        setBackground(Color.gray);
        Timer timer = new Timer(time, this);
        timer.start();


    }

    public void lancuchy(Graphics g, int przesuniecie){
        //rysujemy łancuchy
        Graphics g2d = (Graphics2D) g;

        int skraj1 = 785+przesuniecie;
        int skraj2 = 786+przesuniecie;

        for (int y = 200; y < 900; y += 50) {
            for (int x = skraj2; x < skraj1; x++) {

                g2d.setColor(Color.red);
                g2d.drawOval(x, y, 1, 1);


            }
            skraj2 -= 17;
            skraj1 += 17;

        }
        skraj1 = 785+przesuniecie;
        skraj2 = 786+przesuniecie;

        for (int y = 200; y < 900; y += 50) {
            for (int x = skraj2; x < skraj1; x += 50) {
                g2d.setColor(Color.yellow);

                Lampki.bombki.add(new Rectangle(x, y, 2, 2));


            }
            skraj2 -= 17;
            skraj1 += 17;
        }

    }
    public void drzewko(Graphics g,int przesuniecie){
        Graphics2D g2d = (Graphics2D) g;
        //rysujemy drzewko
        g2d.setColor(new Color(128, 64, 0));
        g2d.fillRect(770+przesuniecie, 820, 30, 30);

        GeneralPath triangle = new GeneralPath();
        g2d.setColor(new Color(52, 94, 23));
        triangle.moveTo(570+przesuniecie, 820);
        triangle.lineTo(1000+przesuniecie, 820);
        triangle.lineTo(785+przesuniecie, 200);

        g2d.fill(triangle);
        triangle.closePath();
    }


    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(40, 97, 52));
        g2d.fillRect(0, 820, 1600, 20);




        //rysujemy drzewko
        drzewko(g,0);
        drzewko(g,500);
        drzewko(g,-500);

        //rysujemy lancuchy
        lancuchy(g,0);
        lancuchy(g,500);
        lancuchy(g,-500);


        for (Rectangle x : Lampki.bombki) {
            g2d.fill(x);

        }
        for (platek x : platek) {
            g2d.setColor(Color.white);
            g2d.drawOval(x.x, x.y, 2, 2);



        }

        for (platek x : platek2) {
            g2d.setColor(Color.white);
            g2d.drawOval(x.x, x.y+20, 3, 3);


        }


    }







    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (platek x : platek) {
            x.y+=2;
            if(x.y>800){

                x.y-=800;

            }


        }
        for (platek x : platek2) {
            if(x.y<800)
            x.y+=2;


        }

        repaint();

    }
}
