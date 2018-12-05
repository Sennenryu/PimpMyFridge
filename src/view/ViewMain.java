package view;

import model.ModelMain;

import java.awt.*;

public class ViewMain {

    private ModelMain model;

    Frame frame = new Frame();
    Frame frame1 = new Frame();
    Frame frame2 = new Frame();

    TempInt tempInt = new TempInt();
    Humid humid = new Humid();
    TempExt tempExt = new TempExt();
    Buttons buttons = new Buttons();

    public ViewMain(ModelMain model){

        this.model = model;
        frame.setLocation(120,50);
        frame.setLayout(new BorderLayout());
        frame.add(tempInt,BorderLayout.CENTER);
        tempInt.setVisible(true);
        frame.setVisible(true);

        frame1.setLocation(120,498);
        frame1.setLayout(new BorderLayout());
        frame1.add(humid,BorderLayout.CENTER);
        humid.setVisible(true);
        frame1.setVisible(true);

        frame2.setLocation(966,50);
        frame2.setLayout(new BorderLayout());
        frame2.add(tempExt,BorderLayout.CENTER);
        tempExt.setVisible(true);
        frame2.setVisible(true);
    }

    public void viewRefresher() {
        this.tempExt.updateModel(model);
        this.tempInt.updateModel(model);
        this.humid.updateModel(model);
        this.buttons.updateModel(model);
        frame.repaint();
        frame1.repaint();
        frame2.repaint();
        buttons.autoRepaint();
    }
}
