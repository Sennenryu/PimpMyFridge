package view;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {
        this.setTitle("Interface du frigo");
        this.setSize(850, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}