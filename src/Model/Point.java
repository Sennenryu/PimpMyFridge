package Model;

import java.lang.*;

public class Point {

    private float temperatureExt;
    private float temperatureInt;
    private float humidite;


    public float getTemperatureExt() {
        return temperatureExt;
    }


    public float getTemperatureInt() {
        return temperatureInt;
    }


    public float getHumidite() {
        return humidite;
    }


    public Point(){
        this.temperatureInt=0;
        this.temperatureExt=0;
        this.humidite=0;
    }

    public void SavePoint(String data){
        int i = 0;
        for (String value : data.split(";")){
            switch(i) {
                case 0:
                    this.temperatureExt = Float.parseFloat(value);
                    break;
                case 1:
                    this.temperatureInt = Float.parseFloat(value);
                    break;
                case 2:
                    this.humidite = Float.parseFloat(value);
                    break;
            }
            i++;
        }
    }
}