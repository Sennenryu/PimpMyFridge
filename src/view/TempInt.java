package view;

import model.ModelMain;

import javax.swing.*;
import java.awt.*;


public class TempInt extends JPanel {
    private ModelMain model;


    public void paintComponent(Graphics g) {
            paintGraphInt(g);
            addpointsInt(g);

    }
    public void paintGraphInt(Graphics g) {

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
        g.drawString("Température T en °C",10,25);
        g2D.setFont(font);
        g2D.drawString("Température intérieure", 250,50);
        g.setFont(font2);
        g.drawString("0",85,370);
        g2D.setStroke(new BasicStroke(3));
        int x = 5;
        for (int i=300; i > 50; i-=50) {
            g2D.drawLine(100, i, 90, i);
            g.drawString("" + x,65,i + 6);
            x= x + 5;
        }
    }

    public void addpointsInt(Graphics g) {
        Graphics2D g2D = (Graphics2D) g.create();
        g2D.setStroke(new BasicStroke(2));
        g2D.setColor(Color.GREEN);
        if (model != null) {
            for (int k = 0; k < model.getSize(); k++) {
                int y = 350 - (int) (model.getSavedPoint(k).getTemperatureInt() * ((350 - 50) / 30));
                if (y != 350) {
                    g.fillOval(100 + k * 6, y, 5, 5);
                    if (k > 0) {
                        if (k - 1 < 0) {

                        }
                        g2D.drawLine(100 + k * 6 + 3, y + 3, 100 + (k - 1) * 6 + 3, (350 - (int) (model.getSavedPoint(k - 1).getTemperatureInt() * ((350 - 50) / 30)) + 3));
                    }

                }
                g2D.setColor(Color.RED);
                g2D.drawLine(105, 350 - (int) (model.getSavedPoint(model.getSize() - 1).getConsigne() * ((350 - 50) / 30)), 700, 350 - (int) (model.getSavedPoint(model.getSize() - 1).getConsigne() * ((350 - 50) / 30)));
                String string = Float.toString(model.getSavedPoint(model.getSize() - 1).getConsigne());
                g2D.drawString(string + "°C", 702, 355 - (int) (model.getSavedPoint(model.getSize() - 1).getConsigne() * ((350 - 50) / 30)));
                g2D.setColor(Color.BLUE);
                g2D.drawLine(105, 350 - (int) (model.getSavedPoint(model.getSize() - 1).getPtderosee() * ((350 - 50) / 30)), 700, 350 - (int) (model.getSavedPoint(model.getSize() - 1).getPtderosee() * ((350 - 50) / 30)));
                String string2 = Double.toString(model.getSavedPoint(model.getSize() - 1).getPtderosee());
                g2D.drawString(string2 + "°C", 702, 355 - (int) (model.getSavedPoint(model.getSize() - 1).getPtderosee() * ((350 - 50) / 30)));
                g2D.setColor(Color.GREEN);
            }
        }
    }

    public void updateModel(ModelMain model) {
        this.model = model;
    }


}
