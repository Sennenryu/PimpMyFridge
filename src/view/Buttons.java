package view;

import model.ModelMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JPanel {
    Font font2 = new Font("Helvetica", Font.BOLD, 18);
    Font font1 = new Font("Helvetica", Font.BOLD, 15);
    Font font = new Font("Helvetica", Font.BOLD, 200);
    private ModelMain model;

    Frame frame3 = new Frame();

    JButton plus = new JButton("+");

    JButton moins = new JButton("-");

    JLabel rose = new JLabel("POINT DE ROSE");

    JTextArea infos = new JTextArea();


    public Buttons() {
        frame3.setLocation(966, 498);

        plus.setFont(font);
        plus.setPreferredSize(new Dimension(200, 200));
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.addConsigneJ();
                model.addConsigneJ();
            }

        });
        moins.setFont(font);
        moins.setPreferredSize(new Dimension(200, 200));
        moins.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.removeConsigneJ();
            }
        });

        rose.setFont(font2);
        rose.setHorizontalAlignment(JLabel.CENTER);
        rose.setVerticalAlignment(JLabel.CENTER);
        rose.setPreferredSize(new Dimension(966, 200));
        rose.setOpaque(true);

        infos.setFont(font1);
        infos.setPreferredSize(new Dimension(500, 200));
        infos.setEditable(false);
        infos.setLineWrap(true);
        infos.setWrapStyleWord(true);


        frame3.setLayout(new BorderLayout());
        frame3.add(plus, BorderLayout.LINE_START);
        frame3.add(moins, BorderLayout.LINE_END);
        frame3.add(rose, BorderLayout.PAGE_START);
        frame3.add(infos, BorderLayout.CENTER);

        frame3.setVisible(true);
        infos.setVisible(true);
        plus.setVisible(true);
        moins.setVisible(true);
        rose.setVisible(true);
        autoRepaint();
    }

    public void autoRepaint() {
        if (model != null) {
            if (model.getSavedPoint(model.getSize() - 1).getRosee()) {
                rose.setBackground(Color.RED);
            } else {
                rose.setBackground(Color.GREEN);
            }
            rose.setText("POINT DE ROSE = " + model.getSavedPoint(model.getSize() - 1).getPtderosee() + "°C");
            infos.setText("Température intérieure = " + model.getSavedPoint(model.getSize() - 1).getTemperatureInt() + "°C \n\nTempérature extérieure = " + model.getSavedPoint(model.getSize() - 1).getTemperatureExt() + "°C\n\nHumidité =" + model.getSavedPoint(model.getSize() - 1).getHumidite() + "%\n\nConsigne = " + model.getSavedPoint(model.getSize() - 1).getConsigne() + "°C\n\nPoint de rosée = " + model.getSavedPoint(model.getSize() - 1).getPtderosee());
            frame3.repaint();
        }
    }

    public void updateModel(ModelMain model) {
        this.model = model;
    }
}