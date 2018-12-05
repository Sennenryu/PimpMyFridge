package view;

import model.ModelMain;

import javax.swing.*;
import java.awt.*;

public class Humid extends JPanel {
    private ModelMain model;


    public void paintComponent(Graphics g) {
        paintGraph(g);
        addpoints(g);

    }
    public void paintGraph(Graphics g) {

        Graphics2D g2D = (Graphics2D) g.create();
        Font font = new Font("Helvetica", Font.BOLD, 30);
        Font font2 = new Font("Helvetica", Font.BOLD, 18);
        g.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(100, 52, 100, 350);
        g2D.drawLine(100, 50, 75, 75);
        g2D.drawLine(100, 50, 125, 75);
        g2D.drawLine(100, 350, 698, 350);
        g2D.drawLine(700, 350,675,325);
        g2D.drawLine(700, 350, 675, 375);
        g.drawString("Temps t en min",700,375);
        g.drawString("Pourcentage d'humidité",10,25);
        g2D.setFont(font);
        g2D.drawString("Humidité à l'interieur du frigo", 220,50);
        g.setFont(font2);
        g.drawString("0",85,370);
        g2D.setStroke(new BasicStroke(3));
        int x = 10;
        for (int i=330; i > 60; i-=30) {
            g2D.drawLine(100, i, 90, i);
            g.drawString("" + x,65,i + 6);
            x= x + 10;
        }
    }

    public void addpoints(Graphics g) {
        Graphics2D g2D = (Graphics2D) g.create();
        g2D.setStroke(new BasicStroke(2));
        g2D.setColor(Color.BLUE);
        if (model != null) {
            for (int k = 0; k < model.getSize(); k++) {
                int y = 350 - (int) (model.getSavedPoint(k).getHumidite() * ((350 - 50) / 100));
                if (y != 350) {
                    g.fillOval(100 + k * 6, y, 5, 5);
                    if (k > 0) {
                        if (k - 1 < 0) {

                        }
                        g2D.drawLine((100 + k * 6) + 3, y + 3, 100 + (k - 1) * 6 + 3, (350 - (int) (model.getSavedPoint(k - 1).getHumidite() * ((350 - 50) / 100)) + 3));
                    }

                }
            }
        }
    }

    public void updateModel(ModelMain model) {
        this.model = model;
    }
}