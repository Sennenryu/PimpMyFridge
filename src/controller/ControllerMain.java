package controller;

import model.ModelMain;
import view.ViewMain;

public class ControllerMain {

    public ControllerMain(){
    ModelMain model = new ModelMain();
    ViewMain viewMain = new ViewMain(model);
        while (true) {
        model.ReadData();
        viewMain.viewRefresher();
    }

}
}
